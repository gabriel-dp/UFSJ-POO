package view;

import model.*;
import data.Data;
import factory.Factory;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppFrame extends JFrame {

    private JPanel appPanel = new JPanel(new BorderLayout());
    private JPanel navPanel = new JPanel(new GridLayout(1, 3));
    private CardLayout mainLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(mainLayout);

    public AppFrame(Data data) {
        // Default settings
        setTitle("JAVAutomotivo 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Add main panels
        appPanel.add(navPanel, BorderLayout.PAGE_START);
        appPanel.add(mainPanel, BorderLayout.CENTER);
        this.add(appPanel);

        // Define entity panels
        final EntityPanel[] panels = {
                Factory.getInstance(Vehicle.class).createPanel(),
                Factory.getInstance(Procedure.class).createPanel(),
                Factory.getInstance(Maintenance.class).createPanel(),
        };

        // Add all entity panels
        for (EntityPanel panel : panels) {
            navPanel.add(createMainButton(panel.getTitle()));
            mainPanel.add(panel, panel.getTitle());
        }

        setVisible(true);
    }

    // Creates a main button with the event to redirects to the given panel
    private JButton createMainButton(String title) {
        JButton button = new JButton(title);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainLayout.show(mainPanel, title);
            }
        });

        return button;
    }
}
