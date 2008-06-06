package proby;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BufferedImageThread extends JFrame {
  AnimationCanvas canvas;
  AnimationCanvas canvas2;
  JButton startButton, stopButton;

  public BufferedImageThread() {
    super();
    Container container = getContentPane();

    canvas = new AnimationCanvas();
    container.add(canvas);
    canvas = new AnimationCanvas();
    container.add(canvas);
    canvas = new AnimationCanvas();
    container.add(canvas);
    canvas = new AnimationCanvas();
    container.add(canvas);
    canvas = new AnimationCanvas();
    container.add(canvas);

    
    startButton = new JButton("Start Animation");
    startButton.addActionListener(new ButtonListener());
    stopButton = new JButton("Stop Animation");
    stopButton.addActionListener(new ButtonListener());
    JPanel panel = new JPanel();
    panel.add(startButton);
    panel.add(stopButton);
    container.add(BorderLayout.SOUTH, panel);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    setSize(450, 425);
    setVisible(true);
  }

  class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JButton temp = (JButton) e.getSource();

      if (temp.equals(startButton)) {
        canvas.start();
      } else if (temp.equals(stopButton)) {
        canvas.stop();
      }
    }
  }

  public static void main(String arg[]) {
    new BufferedImageThread();
  }
}

           