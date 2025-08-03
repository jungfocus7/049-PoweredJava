import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public final class TesterRoom32 extends JFrame {
    private JTextField _textField;
    private JButton _buttonOne;
    private JButton _buttonTwo;

    public TesterRoom32() {
        // 프레임 설정
        setTitle("간단한 Swing UI"); // 창 제목 설정
        setSize(400, 200); // 창 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫을 때 프로그램 종료
        setLocationRelativeTo(null); // 창을 화면 중앙에 배치

        // 컴포넌트 생성
        _textField = new JTextField("여기에 텍스트가 표시됩니다."); // 텍스트 상자 생성 및 초기 텍스트 설정
        _textField.setEditable(true); // 텍스트 상자를 편집 불가능하게 설정 (선택 사항)
        _buttonOne = new JButton("버튼 1"); // 첫 번째 버튼 생성
        _buttonTwo = new JButton("버튼 2"); // 두 번째 버튼 생성

        // 레이아웃 설정 (BorderLayout 사용)
        setLayout(new BorderLayout()); // 프레임에 BorderLayout 설정

        // 컴포넌트 추가
        add(_textField, BorderLayout.CENTER); // 텍스트 상자를 중앙에 배치

        JPanel buttonPanel = new JPanel(); // 버튼들을 담을 패널 생성
        buttonPanel.add(_buttonOne); // 버튼 1을 패널에 추가
        buttonPanel.add(_buttonTwo); // 버튼 2를 패널에 추가
        add(buttonPanel, BorderLayout.SOUTH); // 버튼 패널을 하단에 배치

        // 이벤트 리스너 추가
        _buttonOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _textField.setText("버튼 1이 클릭되었습니다!"); // 버튼 1 클릭 시 텍스트 변경
            }
        });

        _buttonTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _textField.setText("버튼 2가 클릭되었습니다!"); // 버튼 2 클릭 시 텍스트 변경
            }
        });
    }




	private static void println(String txt) {
		System.out.println(txt);
	}


	private static TesterRoom32 _inst;
	public static void main(String[] args) {
		println("경계대상 1호");

	       // GUI는 Event Dispatch Thread (EDT)에서 실행되어야 합니다.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	_inst = new TesterRoom32();
            	// UI를 생성하고 보이게 함
                _inst.setVisible(true);
            }
        });
	}

}
