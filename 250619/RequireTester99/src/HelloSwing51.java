import javax.swing.*; // Swing 컴포넌트를 사용하기 위한 임포트

public class HelloSwing51 {
    public static void main(String[] args) {
        // 1. JFrame (창) 생성
        // JFrame은 애플리케이션의 주 창 역할을 합니다.
        JFrame frame = new JFrame("Hello Swing Application"); // 창의 제목 설정

        // 2. JLabel (텍스트) 생성
        // JLabel은 읽기 전용 텍스트나 이미지를 표시하는 데 사용됩니다.
        JLabel label = new JLabel("Hello, Swing! Welcome to GUI Programming!", SwingConstants.CENTER);
        // SwingConstants.CENTER를 사용하여 텍스트를 레이블 중앙에 정렬합니다.

        // 3. 컴포넌트들을 프레임에 추가
        // 프레임의 기본 컨텐트 패인에 레이블을 추가합니다.
        frame.add(label);

        // 4. 프레임 설정
        // 창을 닫을 때 애플리케이션이 종료되도록 설정합니다.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 프레임의 크기를 자동으로 내용에 맞게 조정합니다.
        frame.pack();

        // 프레임을 화면 중앙에 배치합니다.
        frame.setLocationRelativeTo(null);

        // 프레임을 보이게 합니다. 이 코드가 없으면 창이 나타나지 않습니다.
        frame.setVisible(true);

        // --- 중요: UI 업데이트는 Event Dispatch Thread (EDT)에서 실행되어야 합니다. ---
        // 위 코드는 main 스레드에서 실행되지만, Swing 초기화는 내부적으로 EDT를 사용합니다.
        // 복잡한 UI 업데이트나 이벤트 처리는 EDT에서 이루어져야 합니다.
        // 예시: SwingUtilities.invokeLater(() -> { /* UI 관련 코드 */ });
    }
}