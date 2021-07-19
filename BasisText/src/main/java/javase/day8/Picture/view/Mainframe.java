package javase.day8.Picture.view;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/15 14:39
 */
public class Mainframe extends Frame {
    Point startPoint;
    Point endPoint;
    Image bufferImage;
    public Mainframe(){
        this.setBounds(700,300,300,300);
        this.setVisible(true);
        bufferImage = this.createImage(this.getWidth(),this.getHeight());
        this.addMouseListener(new MainfameListener());
        this.addMouseMotionListener(new MainfameListener2());
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawImage(bufferImage,0,0,null);

    }

    class MainfameListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            startPoint=e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            endPoint= e.getPoint();
            Graphics graphics = Mainframe.this.getGraphics();
            //清屏
            graphics.drawImage(Mainframe.this.bufferImage,0,0,null);
            graphics.drawLine((int)startPoint.getX(),(int)startPoint.getY(),(int)endPoint.getX(),(int)endPoint.getY());

            Graphics bufferGraphics = Mainframe.this.bufferImage.getGraphics();
            bufferGraphics.drawLine((int)startPoint.getX(),(int)startPoint.getY(),(int)endPoint.getX(),(int)endPoint.getY());
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    class MainfameListener2 implements MouseMotionListener{
        @Override
        public void mouseDragged(MouseEvent e) {

            Point cPoint = e.getPoint();
            Graphics graphics = Mainframe.this.getGraphics();
            graphics.drawImage(Mainframe.this.bufferImage,0,0,null);
            graphics.drawLine((int)startPoint.getX(),(int)startPoint.getY(),(int)cPoint.getX(),(int)cPoint.getY());

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
