package vision;

import model.*;

import java.util.ArrayList;

import javax.swing.*;

import controller.Data;
import controller.Persistent;

public class MaintenancesPanel implements EntityPanel {

    public Data data;

    public MaintenancesPanel(Data data) {
        this.data = data;
    }

    public String getTitle() {
        return "Manutenções";
    }

    public String[] getInputs() {
        return new String[] { "Id", "Id Veículo", "Serviços" };
    }

    public Data getData() {
        return this.data;
    }

    public Persistent getPersistent() {
        return this.data.getMaintenances();
    }

    public void validForm(JTextField[] textFields) throws Exception {
        checkEmpty(textFields);
        Integer.parseInt(textFields[0].getText());
        Integer.parseInt(textFields[1].getText());
        if (textFields[2].getText().split(" ").length == 0) {
            throw new Exception("Invalid services");
        }
    }

    public Entity createEntity(JTextField[] textFields) throws Exception {

        ArrayList<Service> services = new ArrayList<>();
        String[] servicesSplited = textFields[2].getText().split(" ");
        for (String s : servicesSplited) {
            String[] args = s.split(",");
            int id = Integer.parseInt(args[0]);
            int quantity = Integer.parseInt(args[1]);
            Service service = new Service((Procedure) data.getProcedures().searchId(id), quantity);
            services.add(service);
        }

        return new Maintenance(
                Integer.parseInt(textFields[0].getText()),
                (Vehicle) data.getVehicles().searchId(Integer.parseInt(textFields[1].getText())),
                services);
    }

}
