import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public final class ScrollableTextBox extends JFrame {

    public ScrollableTextBox() {
        setTitle("스크롤 가능한 텍스트 박스");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null); // 화면 중앙에 배치

        // JTextArea 생성
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(false); // 자동 줄 바꿈 비활성화
        textArea.setText("여기에 긴 텍스트를 입력하거나 붙여넣으세요. 이 텍스트는 자동으로 줄바꿈되지 않고 가로로 계속 이어집니다. 따라서 가로 스크롤바가 필요할 것입니다.");

        // JScrollPane에 JTextArea를 담기
        JScrollPane scrollPane = new JScrollPane(textArea);
        // 가로 스크롤바 정책을 항상 보이도록 설정 (필요 없으면 JScrollPane.AS_NEEDED로 변경)
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        // 세로 스크롤바 정책을 항상 보이도록 설정 (필요 없으면 JScrollPane.AS_NEEDED로 변경)
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // 프레임에 스크롤 패널 추가
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // 이벤트 디스패치 스레드에서 GUI를 생성하고 실행
        SwingUtilities.invokeLater(() -> {
            new ScrollableTextBox().setVisible(true);
        });
    }
}