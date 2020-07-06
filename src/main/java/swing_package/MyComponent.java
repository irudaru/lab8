package swing_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Line2D;

class MyComponent extends JComponent {
    int setX = 250;
    int setY = 250;
    int dX = setX;
    int dY = setY;
    double scaleCount = 1.0;
    double scale = 1.0;
    MyComponent() {
        MyMouseListener listener = new MyMouseListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
        addMouseWheelListener(listener);
    }
    class MyMouseListener extends MouseAdapter implements MouseWheelListener {
        int oldX = 0;
        int oldY = 0;

        public void mousePressed(MouseEvent e) {
            oldX = e.getX();
            oldY = e.getY();
        }

        public void mouseDragged(MouseEvent e) {
            dX = setX + e.getX()-oldX;
            dY = setY +e.getY()-oldY;
            repaint();
        }

        public void mouseReleased(MouseEvent e) {
            setX = dX;
            setY = dY;
            repaint();
        }
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            scale += -e.getPreciseWheelRotation()*Math.abs(scale)/50;
            if (scale < 0.5 ) {
                scale = 1.0;
                scaleCount*=2;
            } else if (scale > 2.0) {
                scale = 1.0;
                scaleCount/=2;
            }
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke b1 = new BasicStroke(1);
        BasicStroke b2 = new BasicStroke(2);

        for (int i =  - 20*((int)(dY/scale)/20); i*scale <= (500 - 20*(dY/20)); i+=20) {
            if (i % 100 == 0) {
                g2d.setStroke(b2);
                g2d.setPaint(Color.GRAY);
                Shape l = new Line2D.Double(0, i*scale+dY, 500, i*scale+dY);
                g2d.draw(l);
            } else {
                g2d.setStroke(b1);
                g2d.setPaint(Color.GRAY);
                Shape l = new Line2D.Double(0, i*scale+dY, 500, i*scale+dY);
                g2d.draw(l);
            }
        }
        for (int i = - 20*((int)(dX/scale)/20); i*scale <= (500 - 20*(dX/20)); i+=20) {
            if (i % 100 == 0) {
                g2d.setStroke(b2);
                g2d.setPaint(Color.GRAY);
                Shape l = new Line2D.Double(i*scale + dX, 0, i*scale + dX, 500);
                g2d.draw(l);
            } else {
                g2d.setStroke(b1);
                g2d.setPaint(Color.GRAY);
                Shape l = new Line2D.Double(i*scale + dX, 0, i*scale + dX, 500);
                g2d.draw(l);
            }
        }
        g2d.setStroke(b2);
        g2d.setPaint(Color.BLACK);
        g2d.setFont(new Font("Arial",Font.BOLD, 15));
        g2d.drawString("0",(float)(dX + 5), (float)(dY-5));
        Shape axX = new Line2D.Double(Math.max(Math.min(dX,495),5), 0, Math.max(Math.min(dX,495),5), 500);
        Shape axY = new Line2D.Double(0, Math.max(Math.min(dY,495),5), 500,Math.max(Math.min(dY,495),5));
        g2d.draw(axX);
        g2d.draw(axY);
        for (int i =  - 20*((int)(dY/scale)/20); i*scale <= (500 - 20*(dY/20)); i+=20) {
            if (i % 100 == 0 && i!=0) {
                g2d.drawString(fmt(-i*scaleCount/100), Math.max(Math.min((dX + 5),480),10), (int)(i*scale+dY));
            }
        }
        for (int i = - 20*((int)(dX/scale)/20); i*scale <= (500 - 20*(dX/20)); i+=20) {
            if (i % 100 == 0 && i!=0) {
                g2d.drawString(fmt(i*scaleCount/100), (int)(i*scale+dX), Math.max(Math.min((dY - 5),490),20));
            }
        }
    }
    public static String fmt(double d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }

}
