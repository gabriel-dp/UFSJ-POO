import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setVisible(true);
        frame.setTitle("gabriel-dp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800, 600);

        ImageIcon image = new ImageIcon("logo.png");

        JLabel label = new JLabel();
        // label.setText("gabriel-dp!");
        label.setIcon(image);

        frame.add(label);
    }
}