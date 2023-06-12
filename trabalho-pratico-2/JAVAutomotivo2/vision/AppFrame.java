package vision;

import controller.Data;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

        // Add main panels
        appPanel.add(navPanel, BorderLayout.PAGE_START);
        appPanel.add(mainPanel, BorderLayout.CENTER);
        this.add(appPanel);

        // Define entity panels
        final EntityMenu[] panels = {
                new EntityMenu(new VehiclesPanel(data)),
                new EntityMenu(new ProceduresPanel(data)),
                new EntityMenu(new MaintenancesPanel(data)),
        };

        // Add all entity panels
        for (EntityMenu panel : panels) {
            navPanel.add(createMainButton(panel.getEntityInterface().getTitle()));
            mainPanel.add(panel, panel.getEntityInterface().getTitle());
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
