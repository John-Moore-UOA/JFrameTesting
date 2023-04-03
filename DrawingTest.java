import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawingTest {

  private OvalShape ovalShape;
  private JFrame frame;
  private JPanel panel;

  public DrawingTest() {

    frame = new JFrame();
    ovalShape = new OvalShape(10, 40);

    panel = new JPanel();

    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 500, 500));
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

  }

  public void update() {
    if (frame.getGraphics() != null) {
      paint(frame.getGraphics());
      System.out.println("update");
    } else {
      System.out.println("Graphics is null");
    }
  }

  public void paint(Graphics g) {

    g.setColor(Color.red);

    if (ovalShape != null) {
      System.out.println("OvalShape is not null");
      g.drawOval(ovalShape.getX(), ovalShape.getY(), 100, 100);
      g.fillOval(ovalShape.getX(), ovalShape.getY(), 100, 100);
    } else {
      System.out.println("OvalShape is null");
    }

    System.out.println("Painted");

  }
}
