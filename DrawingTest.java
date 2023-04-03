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
    frame1.update();
    // frame1.moveTo(frame1.ovalShape, 200, 400);
    // frame1.moveTo(frame1.ovalShape, 1200, 100);

    frame1.drawPattern(frame1.frameY, frame1.frameX);
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

  public void update() {
    if (frame.getGraphics() != null) {
      paint(frame.getGraphics());
      // System.out.println("update");
    } else {
      System.out.println("Graphics is null");
    }
  }

  public void paint(Graphics g) {

    g.fillOval(300, 910, 10, 10);

    g.setColor(Color.red);

    if (ovalShape != null) {
      // System.out.println("OvalShape is not null");
      g.drawOval(ovalShape.getX(), ovalShape.getY(), 100, 100);
      g.fillOval(ovalShape.getX(), ovalShape.getY(), 100, 100);
    } else {
      // System.out.println("OvalShape is null");
    }

    // System.out.println("Painted");

  }

  public void moveTo(Item item, int i, int j) {

    if (i == 0 || j == 0) {
      System.out.println("i or j is 0");
      return;
    }

    if (item == null) {
      System.out.println("Item is null");
      return;
    }

    System.out.println(item + " is Moving..");
    int differenceInX = i - item.getX();
    int differenceInY = j - item.getY();

    boolean positiveX = true;
    boolean positiveY = true;

    int stepX = (int) Math.abs(differenceInX);
    int stepY = (int) Math.abs(differenceInY);

    int steps = 100;

    if (differenceInX < 0) {
      positiveX = false;
    }

    if (differenceInY < 0) {
      positiveY = false;
    }

    differenceInX = (int) Math.abs(differenceInX);
    differenceInY = (int) Math.abs(differenceInY);

    if (differenceInX >= differenceInY) {
      while (steps >= stepX) { // >= or just > ?
        steps--;
      }
      while (steps >= stepY) {
        steps--;
      }

      stepX /= steps;
      stepY /= steps;

    } else {
      while (steps >= stepY) {
        steps--;
      }
      while (steps >= stepX) {
        steps--;
      }

      stepX /= steps;
      stepY /= steps;
    }
    System.out.println("stepX: " + stepX);
    System.out.println("stepY: " + stepY);
    System.out.println(steps);

    for (int k = 0; k < steps; k++) {

      if (positiveX) {
        item.addX(stepX);
      } else {
        item.addX(-stepX);
      }

      if (positiveY) {
        item.addY(stepY);
      } else {
        item.addY(-stepY);
      }

      update();
    }

  }
}
