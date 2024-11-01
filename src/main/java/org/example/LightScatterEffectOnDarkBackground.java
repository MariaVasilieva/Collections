package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class LightScatterEffectOnDarkBackground extends JPanel {
    private BufferedImage image;
    private int width = 500;
    private int height = 500;
    private int pointCount = 100_000; // Більше точок для густого ефекту світіння
    private int maxRadius = 200;   // Максимальний радіус розсіювання

    public LightScatterEffectOnDarkBackground() {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        scatterLightPoints();
    }

    private void scatterLightPoints() {
        Random random = new Random();
        Graphics2D g2d = image.createGraphics();

        // Установка темного фону
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, width, height);

        // Центр світіння (ліхтаря)
        int centerX = width / 2;
        int centerY = height / 2;

        for (int i = 0; i < pointCount; i++) {
            // Випадковий кут і відстань від центру для розсіювання
            double angle = random.nextDouble() * 2 * Math.PI;
            double distance = Math.sqrt(random.nextDouble()) * maxRadius;

            // Обчислення координат точки
            int x = centerX + (int) (distance * Math.cos(angle));
            int y = centerY + (int) (distance * Math.sin(angle));

            // Прозорість і розмір точок змінюються відповідно до відстані
            float alpha = (float) (1 - distance / maxRadius); // Ближчі точки яскравіші
            int size = (int) (5 * (1 - distance / maxRadius)); // Ближчі точки більші

            // Установка кольору точки з прозорістю
            g2d.setColor(new Color(255, 255, 100, (int) (alpha * 255))); // Жовтуватий відтінок
            g2d.fillOval(x, y, size, size);
        }
        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lantern Light Scatter Effect on Dark Background");
        LightScatterEffectOnDarkBackground scatterEffect = new LightScatterEffectOnDarkBackground();
        frame.add(scatterEffect);
        frame.setSize(scatterEffect.width, scatterEffect.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
