package view;

import model.*;
import controller.*;

import javax.swing.JTextField;
import java.util.ArrayList;

public class MaintenancesPanelSettings implements EntityPanelSettings {

    public String getTitle() {
        return "Manutenções";
    }

    public String[] getInputs() {
        return new String[] { "Id", "Id Veículo", "Serviços" };
    }

    public EntityController getEntityController() {
        return new EntityController(new MaintenancesController());
    }

    public Entity createEntity(JTextField[] textFields) throws NumberFormatException, IdException, InputException {
        int maintenanceId = Integer.parseInt(textFields[0].getText());
        int vehicleId = Integer.parseInt(textFields[1].getText());
        ArrayList<Service> services = new ArrayList<>();

        VehiclesController vehiclesController = new VehiclesController();
        ProceduresController proceduresController = new ProceduresController();
        Vehicle vehicle = (Vehicle) vehiclesController.getPersistent().searchId(vehicleId);

        String[] servicesSplited = textFields[2].getText().split(" ");
        for (String s : servicesSplited) {
            String[] args = s.split(",");
            if (args.length < 2) {
                throw new InputException("Invalid services");
            }

            int procedureId = Integer.parseInt(args[0]);
            int procedureQuantity = Integer.parseInt(args[1]);
            Service service = new Service(
                    (Procedure) proceduresController.getPersistent().searchId(procedureId),
                    procedureQuantity);
            services.add(service);
        }

        return new Maintenance(maintenanceId, vehicle, services);
    }

}
