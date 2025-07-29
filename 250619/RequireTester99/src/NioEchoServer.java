import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class NioEchoServer {

//	private static volatile boolean _xx = false;
//	private static volatile Object _xx2 = null;

    private static final int PORT = 12345;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        Selector selector = null;
        ServerSocketChannel serverSocketChannel = null;



        try {
            // 1. Selector 생성
            selector = Selector.open();

            // 2. ServerSocketChannel 열기 (논블로킹 모드)
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false); // 논블로킹 모드 설정
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT)); // 포트 바인딩

            // 3. ServerSocketChannel을 Selector에 등록 (연결 수락 이벤트 OP_ACCEPT)
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("NioEchoServer is running on port " + PORT);

            while (true) {
                // 4. 이벤트 대기 (블로킹)
                // selector.select()는 이벤트가 발생할 때까지 블록됩니다.
                // selector.selectNow()는 즉시 반환됩니다.
                // selector.select(timeout)은 지정된 시간만큼 블록됩니다.
                selector.select();

                // 5. 발생한 이벤트(SelectionKey) 가져오기
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove(); // 처리된 키는 반드시 제거

                    if (key.isAcceptable()) {
                        // 6. 연결 수락 이벤트 처리 (OP_ACCEPT)
                        handleAccept(selector, key);
                    } else if (key.isReadable()) {
                        // 7. 데이터 읽기 이벤트 처리 (OP_READ)
                        handleRead(key);
                    } else if (key.isWritable()) {
                        // 8. 데이터 쓰기 이벤트 처리 (OP_WRITE)
                        // 이 예제에서는 read 처리 후 바로 write하므로 OP_WRITE는 거의 사용되지 않음
                        // 대량의 데이터를 비동기적으로 쓸 때 주로 사용
                        // handleWrite(key);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (selector != null) {
                try {
                    selector.close();
                } catch (IOException e) {
                    System.err.println("Error closing selector: " + e.getMessage());
                }
            }
            if (serverSocketChannel != null) {
                try {
                    serverSocketChannel.close();
                } catch (IOException e) {
                    System.err.println("Error closing server socket channel: " + e.getMessage());
                }
            }
            System.out.println("NioEchoServer stopped.");
        }
    }

    private static void handleAccept(Selector selector, SelectionKey key) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel clientChannel = serverChannel.accept(); // 클라이언트 연결 수락
        clientChannel.configureBlocking(false); // 클라이언트 채널도 논블로킹 모드 설정

        // 클라이언트 채널을 Selector에 등록 (데이터 읽기 이벤트 OP_READ)
        clientChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(BUFFER_SIZE)); // 버퍼를 Attachment로 연결
        System.out.println("Client connected: " + clientChannel.getRemoteAddress());
    }

    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment(); // Attachment로 연결된 버퍼 가져오기
        buffer.clear(); // 버퍼 준비 (쓰기 모드 전환)

        int bytesRead;
        try {
            bytesRead = clientChannel.read(buffer); // 클라이언트로부터 데이터 읽기
        } catch (IOException e) {
            // 클라이언트가 연결을 강제로 끊은 경우 예외 발생
            System.out.println("Client disconnected unexpectedly: " + clientChannel.getRemoteAddress());
            key.cancel(); // Selector에서 키 제거
            clientChannel.close(); // 채널 닫기
            return;
        }

        if (bytesRead == -1) { // 클라이언트가 정상적으로 연결을 닫은 경우
            System.out.println("Client disconnected gracefully: " + clientChannel.getRemoteAddress());
            key.cancel(); // Selector에서 키 제거
            clientChannel.close(); // 채널 닫기
        } else if (bytesRead > 0) {
            buffer.flip(); // 버퍼 준비 (읽기 모드 전환)
            byte[] data = new byte[bytesRead];
            buffer.get(data, 0, bytesRead);
            String message = new String(data).trim(); // 메시지 추출 (공백 제거)

            System.out.println("Received from client " + clientChannel.getRemoteAddress() + ": " + message);

            // 에코 메시지 전송
            ByteBuffer echoBuffer = ByteBuffer.wrap(("Echo: " + message).getBytes());
            clientChannel.write(echoBuffer); // 클라이언트에게 데이터 쓰기 (논블로킹)

            if ("bye".equalsIgnoreCase(message)) {
                System.out.println("Client " + clientChannel.getRemoteAddress() + " disconnected by 'bye'.");
                key.cancel();
                clientChannel.close();
            }
        }
    }

    // handleWrite는 이 예제에서 직접적으로 호출되지는 않지만, 대량의 데이터를 비동기적으로 보낼 때 필요
    // private static void handleWrite(SelectionKey key) throws IOException {
    //     SocketChannel clientChannel = (SocketChannel) key.channel();
    //     ByteBuffer buffer = (ByteBuffer) key.attachment();
    //     buffer.flip(); // 읽기 모드 전환
    //
    //     while(buffer.hasRemaining()) {
    //         clientChannel.write(buffer); // 남은 데이터 쓰기
    //     }
    //
    //     buffer.clear(); // 버퍼 초기화
    //     key.interestOps(SelectionKey.OP_READ); // 쓰기 완료 후 다시 읽기 이벤트만 관심
    // }
}