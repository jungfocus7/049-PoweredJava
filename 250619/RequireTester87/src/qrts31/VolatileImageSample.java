package qrts31;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Transparency;
import java.awt.image.VolatileImage;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public final class VolatileImageSample extends JPanel implements Runnable {

    private VolatileImage vImage;
    private int circleX = 50;
    private int circleY = 50;
    private int dx = 1; // X축 이동 속도
    private Color currentColor = Color.BLUE;

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    public VolatileImageSample() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // 애니메이션을 시작할 스레드 생성 및 시작
        new Thread(this).start();
    }

    // 1. VolatileImage를 생성하거나 유효하지 않을 때 재생성하는 메서드
    private void createVolatileImage() {
        // 이미 생성된 이미지가 있다면, 유효하지 않을 경우를 대비하여 null로 설정 (필수 아님)
        if (vImage != null) {
            vImage.flush();
        }

        // 현재 그래픽 환경에서 호환되는 VolatileImage를 생성
        GraphicsConfiguration gc = getGraphicsConfiguration();
        if (gc != null) {
             vImage = gc.createCompatibleVolatileImage(WIDTH, HEIGHT, Transparency.OPAQUE);
        } else {
             // GraphicsConfiguration을 얻을 수 없는 경우 BufferedImage 대체 (저성능)
             System.err.println("VolatileImage 생성 실패. BufferedImage로 대체합니다.");
             // vImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
             // 실제 코드에서는 BufferedImage로 fallback 로직을 구현해야 함.
        }
    }

    // 2. VolatileImage에 실제로 그림을 그리는 메서드 (Off-Screen 렌더링)
    private void drawToVolatileImage() {
        if (vImage == null) {
			return;
		}

        Graphics2D g2d = vImage.createGraphics();
        Object obj = g2d;
//        SunGraphics2D sg2 = g2d;
//        System.out.println(">>> " + sg2.toString());

        // 배경을 지웁니다 (매번 다시 그려야 함)
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        // 움직이는 원 그리기
        g2d.setColor(currentColor);
        g2d.fillOval(circleX, circleY, 50, 50);

        g2d.dispose();
    }

    // 3. 화면에 최종 이미지를 복사하는 메서드 (On-Screen 렌더링)
    @Override
    protected void paintComponent(Graphics g) {
        // VolatileImage를 생성하고 유효성을 검사하는 루프 시작
        do {
            // A. 이미지가 생성되지 않았거나, 내용이 손실된 경우 (GC에 의해 해제되거나, OS에 의해 덮어씌워진 경우)
            if (vImage == null || vImage.contentsLost()) {
                createVolatileImage(); // 이미지 재생성
            }

            // B. 이미지에 그림을 그립니다.
            drawToVolatileImage();

            // C. 화면에 복사합니다.
            // g.drawImage()가 호출된 후에도 이미지가 손실될 수 있으므로,
            // V.contentsLost()가 false를 반환할 때까지 루프를 반복해야 합니다.
            g.drawImage(vImage, 0, 0, this);

        } while (vImage.contentsLost()); // 손실되면 다시 시도!
    }

    // 4. 애니메이션 업데이트 로직
    private void updateAnimation() {
        // 원 위치 업데이트
        circleX += dx;
        if (circleX > WIDTH - 50 || circleX < 0) {
            dx = -dx;

            // 색상 랜덤 변경
            currentColor = new Color(
                (int)(Math.random() * 256),
                (int)(Math.random() * 256),
                (int)(Math.random() * 256)
            );
        }
    }

    // 5. 애니메이션 루프
    @Override
    public void run() {
        while (true) {
            updateAnimation(); // 위치와 색상 업데이트
            repaint(); // paintComponent 호출 -> VolatileImage에 그리고 화면에 복사

            try {
                // 부드러운 애니메이션을 위해 잠시 대기 (예: 60 FPS)
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VolatileImage Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new VolatileImageSample());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
