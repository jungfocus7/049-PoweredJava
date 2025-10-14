package rqtt87;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class SimpleBufferExample extends Canvas implements Runnable {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private boolean running = false;
    private Thread gameThread;

    // 움직일 사각형의 위치
    private int x = 0;
    private int y = 50;
    private int dx = 1; // x축 이동 속도

    // 생성자: 캔버스 설정
    public SimpleBufferExample() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setIgnoreRepaint(true); // AWT의 기본 Repaint 비활성화 (BufferStrategy 사용을 위해 필수)
    }

    // 메인 실행 메서드
    public static void main(String[] args) {
        SimpleBufferExample game = new SimpleBufferExample();
        JFrame frame = new JFrame("BufferStrategy Example");
        frame.add(game);
        frame.pack();
//        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.addComponentListener(new ComponentListener() {
//
//			@Override
//			public void componentShown(ComponentEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void componentResized(ComponentEvent e) {
//				// TODO Auto-generated method stub
//				System.gc();
//			}
//
//			@Override
//			public void componentMoved(ComponentEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void componentHidden(ComponentEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//		});

        game.start(); // 게임 루프 시작
    }

    // 스레드 시작
    public synchronized void start() {
        if (running) {
			return;
		}
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    // 스레드 종료
    public synchronized void stop() {
        if (!running) {
			return;
		}
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 게임 루프
    @Override
    public void run() {
        // BufferStrategy 생성
        // 2: 더블 버퍼링 (가장 일반적)
        // 3: 트리플 버퍼링 (더 부드러울 수 있음)
        this.createBufferStrategy(2);
        BufferStrategy bs = this.getBufferStrategy();

        while (running) {
            update(); // 1. 상태 업데이트 (움직임 계산)
            render(bs); // 2. 화면 그리기 (BufferStrategy 사용)

            // 간단한 프레임 속도 조절 (선택 사항)
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // 1. 게임 상태 업데이트 (객체 위치 변경 등)
    private void update() {
        // x 좌표를 dx만큼 이동
        x += dx;

        // 화면 경계에 닿으면 방향 반전
        if (x < 0 || x > (WIDTH - 50)) {
            dx = -dx; // 방향 변경
        }
    }

    // 2. 화면 렌더링 (그리기)
    private void render(BufferStrategy bs) {
        Graphics g = bs.getDrawGraphics();

        // 1. 전체 화면을 지우기 (배경색)
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // 2. 사각형 그리기
        g.setColor(Color.BLUE);
        // (현재 x, y 좌표에 가로 50, 세로 50인 사각형을 그립니다.)
        g.fillRect(x, y, 50, 50);

        // 3. Graphics 객체 해제
        g.dispose();

        // 4. 버퍼 교체 (실제 화면에 표시)
        // 이 show() 메서드가 다음 프레임을 표시하기 위해 버퍼를 교체합니다.
        bs.show();
    }
}
