package vision;

import controller.Data;
import javax.swing.*;

public class ProceduresPanel extends EntityPanel {

    public ProceduresPanel(String title, Data data) {
        this.title = title;
        add(new JButton("Procedimento"));
    }

}
