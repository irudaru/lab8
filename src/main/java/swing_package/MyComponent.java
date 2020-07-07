package swing_package;

import commons.Collection;
import commons.Route;
import commons.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;

public class MyComponent extends JComponent {
    int WIDTH = 500;
    int HEIGHT = 500;

    double setX = WIDTH/2;
    double setY = HEIGHT/2;
    double dX = setX;
    double dY = setY;
    double scaleCount = 1.0;
    double scale = 2.0;
    final int GRID_SIZE = 60;
    final int GRID_NUMBER = GRID_SIZE / 4;

    MyComponent() {
        MyMouseListener listener = new MyMouseListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
        addMouseWheelListener(listener);
        addComponentListener(new ResizeListener());
    }

    public static String fmt(double d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke b1 = new BasicStroke(1);
        BasicStroke b2 = new BasicStroke(2);
        Color lightGray = new Color(192, 192, 192);

        for (int i = -GRID_NUMBER * ((int) (dY / scale) / GRID_NUMBER); i * scale <= (HEIGHT - GRID_NUMBER * (dY / GRID_NUMBER)); i += GRID_NUMBER) {
            if (i % GRID_SIZE == 0) {
                g2d.setStroke(b2);
                g2d.setPaint(lightGray);
                Shape l = new Line2D.Double(0, i * scale + dY, WIDTH, i * scale + dY);
                g2d.draw(l);
            } else {
                g2d.setStroke(b1);
                g2d.setPaint(lightGray);
                Shape l = new Line2D.Double(0, i * scale + dY, WIDTH, i * scale + dY);
                g2d.draw(l);
            }
        }
        for (int i = -GRID_NUMBER * ((int) (dX / scale) / GRID_NUMBER); i * scale <= (WIDTH - GRID_NUMBER * (dX / GRID_NUMBER)); i += GRID_NUMBER) {
            if (i % GRID_SIZE == 0) {
                g2d.setStroke(b2);
                g2d.setPaint(lightGray);
                Shape l = new Line2D.Double(i * scale + dX, 0, i * scale + dX, HEIGHT);
                g2d.draw(l);
            } else {
                g2d.setStroke(b1);
                g2d.setPaint(lightGray);
                Shape l = new Line2D.Double(i * scale + dX, 0, i * scale + dX, HEIGHT);
                g2d.draw(l);
            }
        }
        g2d.setStroke(b2);
        g2d.setPaint(Color.BLACK);
        Font f = new Font("Arial", Font.BOLD, 15);
        g2d.setFont(f);
        g2d.drawString("0", (float) (dX + 5), (float) (dY - 5));
        Shape axX = new Line2D.Double(Math.max(Math.min(dX, WIDTH-5), 5), 0, Math.max(Math.min(dX, WIDTH-5), 5), HEIGHT);
        Shape axY = new Line2D.Double(0, Math.max(Math.min(dY, HEIGHT-5), 5), WIDTH, Math.max(Math.min(dY, HEIGHT-5), 5));
        g2d.draw(axX);
        g2d.draw(axY);
        for (int i = -GRID_NUMBER * ((int) (dY / scale) / GRID_NUMBER); i * scale <= (HEIGHT - GRID_NUMBER * (dY / GRID_NUMBER)); i += GRID_NUMBER) {
            if (i % GRID_SIZE == 0 && i != 0) {
                String text = fmt(-i * scaleCount / GRID_SIZE);
                FontMetrics metrics = g2d.getFontMetrics(f);
                int strw = metrics.stringWidth(text);
                float rx = (float) Math.max(Math.min((dX + 5), WIDTH - strw - 10),  10 );
                float ry = (float) (i * scale + dY) - (float) metrics.getHeight() / 2 + metrics.getAscent();
                g2d.setFont(f);
                g2d.drawString(text, rx, ry);
            }
        }
        for (int i = -GRID_NUMBER * ((int) (dX / scale) / GRID_NUMBER); i * scale <= (WIDTH - GRID_NUMBER * (dX / GRID_NUMBER)); i += GRID_NUMBER) {
            if (i % GRID_SIZE == 0 && i != 0) {
                drawCenteredString(g2d,fmt(i * scaleCount / GRID_SIZE), (float) (i * scale + dX), (float) Math.max(Math.min((dY - 10), HEIGHT-15), 15),f);
            }
        }
        drawShapes(g2d);
    }

    private void drawShapes(Graphics2D g2d) {
        Font f = new Font("Arial", Font.BOLD, 10);
        for (User user : Collection.coll.map.keySet()) {
            for (Route route : Collection.coll.map.get(user)) {
                g2d.setPaint(Color.getHSBColor(((float) Math.abs(user.login.hashCode())) / Integer.MAX_VALUE, 1.f, 1.f));
                double x3 = GRID_SIZE * route.getTo().getX() * scale / scaleCount + dX;
                double y3 = -GRID_SIZE * route.getTo().getY() * scale / scaleCount + dY;
                double r2 = GRID_SIZE * route.getTo().getZ() * scale / scaleCount / 10;
                Ellipse2D el2 = new Ellipse2D.Double();
                el2.setFrameFromCenter(x3, y3, x3 + r2, y3 - r2);
                g2d.fill(el2);
                double x2 = GRID_SIZE * route.getCoordinates().getX() * scale / scaleCount + dX;
                double y2 = -GRID_SIZE * route.getCoordinates().getY() * scale / scaleCount + dY;
                if (route.getFrom() != null) {
                    double x1 = GRID_SIZE * route.getFrom().getX() * scale / scaleCount + dX;
                    double y1 = -GRID_SIZE * route.getFrom().getY() * scale / scaleCount + dY;
                    double r1 = GRID_SIZE * route.getFrom().getZ() * scale / scaleCount / 10;
                    QuadCurve2D q = new QuadCurve2D.Double();
                    q.setCurve(x1, y1, x2, y2, x3, y3);
                    g2d.draw(q);
                    Ellipse2D el1 = new Ellipse2D.Double();
                    el1.setFrameFromCenter(x1, y1, x1 + r1, y1 - r1);
                    g2d.fill(el1);
                    g2d.setPaint(Color.BLACK);
                    drawCenteredString(g2d, route.getFrom().getName(), (float) x1, (float) y1, f);
                    drawCenteredString(g2d, route.getName(), (float) (x1 / 4 + x2 / 2 + x3 / 4), (float) (y1 / 4 + y2 / 2 + y3 / 4), f);
                } else {
                    g2d.setPaint(Color.BLACK);
                    drawCenteredString(g2d, route.getName(), (float) x3, (float) (y3 - r2), f);
                }
                drawCenteredString(g2d, route.getTo().getName(), (float) x3, (float) y3, f);
            }
        }
    }

    public void drawCenteredString(Graphics2D g, String text, float x, float y, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        float rx = x - (float) metrics.stringWidth(text) / 2;
        float ry = y - (float) metrics.getHeight() / 2 + metrics.getAscent();
        g.setFont(font);
        g.drawString(text, rx, ry);
    }

    class ResizeListener extends ComponentAdapter {
        public void componentResized(ComponentEvent e) {
            HEIGHT = e.getComponent().getHeight();
            WIDTH = e.getComponent().getWidth();
            setX = WIDTH/2;
            setY = HEIGHT/2;
            dX = setX;
            dY = setY;
            repaint();
        }
    }

    class MyMouseListener extends MouseAdapter implements MouseWheelListener {
        int oldX = 0;
        int oldY = 0;

        public void mousePressed(MouseEvent e) {
            oldX = e.getX();
            oldY = e.getY();
        }

        public void mouseDragged(MouseEvent e) {
            dX = setX + e.getX() - oldX;
            dY = setY + e.getY() - oldY;
            repaint();
        }

        public void mouseReleased(MouseEvent e) {
            setX = dX;
            setY = dY;
            repaint();
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            dX += e.getPreciseWheelRotation() * (e.getX() - setX) / 50;
            dY += e.getPreciseWheelRotation() * (e.getY() - setY) / 50;
            setX = dX;
            setY = dY;
            scale += -e.getPreciseWheelRotation() * scale / 50;
            if (scale < 1.0) {
                scale = 2.0;
                scaleCount *= 2;
            } else if (scale > 2.0) {
                scale = 1;
                scaleCount /= 2;
            }
            repaint();
        }
    }
}