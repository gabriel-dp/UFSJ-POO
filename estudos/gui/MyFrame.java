import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        this.setVisible(true);
        this.setTitle("gabriel-dp");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800, 600);

        ImageIcon image = new ImageIcon("logo.png", "logo");
        this.setIconImage(image.getImage());

        this.getContentPane().setBackground(new Color(0x003399));
    }

}
