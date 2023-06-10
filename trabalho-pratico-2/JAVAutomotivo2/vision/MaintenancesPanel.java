package vision;

import controller.Data;
import javax.swing.*;

public class MaintenancesPanel extends EntityPanel {

    public MaintenancesPanel(String title, Data data) {
        this.title = title;
        add(new JButton("Manutençao"));
    }

    public String getTitle() {
        return this.title;
    }

}
