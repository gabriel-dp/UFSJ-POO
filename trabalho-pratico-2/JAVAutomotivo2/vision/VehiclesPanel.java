package vision;

import controller.Data;
import javax.swing.*;

public class VehiclesPanel extends EntityPanel {

    public VehiclesPanel(String title, Data data) {
        this.title = title;
        add(new JButton("Veículo"));
    }

    public String getTitle() {
        return this.title;
    }

}
