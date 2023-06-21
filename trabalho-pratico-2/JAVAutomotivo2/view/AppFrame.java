package view;

import model.*;
import factory.EntityFactory;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppFrame extends JFrame {

    // Define entity panels
    private final EntityPanel[] panels = {
            EntityFactory.getFactory(Vehicle.class).createPanel(),
            EntityFactory.getFactory(Procedure.class).createPanel(),
            EntityFactory.getFactory(Maintenance.class).createPanel(),
    };

    private JPanel appPanel = new JPanel(new BorderLayout());
    private JPanel navPanel = new JPanel(new GridLayout(1, 3));
    private CardLayout mainLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(mainLayout);

    public AppFrame() {
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

        // Add all entity panels
        for (EntityPanel panel : panels) {
            navPanel.add(createMainButton(panel.getTitle()));
            mainPanel.add(panel, panel.getTitle());
        }

        // Make the frame visible
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
