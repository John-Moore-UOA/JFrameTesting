import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Panel;
import java.util.concurrent.RejectedExecutionHandler;

import javax.print.StreamPrintService;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawingTest {

  private OvalShape ovalShape;
  // private Item ovalShape;

  private JFrame frame;
  private JPanel panel;

  private int frameY = 500;
  private int frameX = 500;

  public DrawingTest() {

    frame = new JFrame();
    // ovalShape = new OvalShape(10, 40);

    panel = new JPanel();

    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, this.frameY, this.frameX));
    panel.setLayout(new GridLayout(0, 1));

    frame.add(panel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Drawing In JFrames");
    frame.pack();
    frame.setVisible(true);

  }

  public static void main(String args[]) {
    DrawingTest frame1 = new DrawingTest();
    // frame1.paint(frame1.frame.getGraphics());
    // frame1.update();
    // frame1.moveTo(frame1.ovalShape, 200, 400);
    // frame1.moveTo(frame1.ovalShape, 1200, 100);

    // frame1.drawPattern(frame1.frameY, frame1.frameX);

    frame1.drawMandelbrot(frame1.frameY, frame1.frameX);

  }

  public void placePixel(int i, int j, Color color, Graphics g) {
    g.setColor(color);

    // so slow
    g.fillRect(i, j, 1, 1);

  }

  public void drawPattern(int frameHeight, int frameLength) {
    for (int i = 0; i < frameHeight; i++) {
      for (int j = 0; j < frameLength; j++) {
        placePixel(i, j, Color.black, frame.getGraphics());
      }
    }
  }

  byte fractal(int width, int height, int row, int col) {

    double zx = 0, zy = 0;
    double cx, tempx, cy;
    byte count = 0;

    cx = (double) row * 0.0042 - 1.95;
    cy = (double) col * 0.0042 - 1.35;

    while ((zx * zx + zy * zy < 4) && (count < 100)) {

      tempx = zx * zx - zy * zy + cx;
      zy = 2 * zx * zy + cy;
      zx = tempx;

      count++;
    }

    return count;

  }

  public void drawMandelbrot(int frameHeight, int frameLength) {

    byte iterations = 0;

    for (int i = 0; i < frameHeight; i++) {
      for (int j = 0; j < frameLength; j++) {

        iterations = fractal(frameLength, frameHeight, i, j);

        Color colour = new Color(iterations, iterations, iterations);
        placePixel(i, j, colour, frame.getGraphics());

        System.out.println("i: " + i + " j: " + j + " iterations: " + iterations);

      }
    }

  }

}
