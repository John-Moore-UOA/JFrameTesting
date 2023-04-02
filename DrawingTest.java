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

    update();
  }

  public static void main(String args[]) {
    new DrawingTest();
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
    // Graphics2D g2 = (Graphics2D) g.create();
    // g2.setColor(OvalShape.getColour());
    g.setColor(Color.red);
    // g2.fillOval(OvalShape.getX(), OvalShape.getY(), 100, 100);
    // g.fillOval(10, 40, 100, 100);

    g.drawRect(30, 40, 100, 200);
    g.fillRect(30, 40, 100, 200);

    System.out.println("Painted");

  }
}
