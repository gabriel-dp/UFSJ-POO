package vision;

import control.*;
import vision.entities.*;

public class MenuHome extends Menu {

    private Data data;

    public MenuHome(Data data) {
        super("Initial", new String[] { "Exit", "Vehicles", "Procedures", "Maintenances" });
        this.data = data;
    }

    public void menu() {
        int option;
        do {
            option = this.getOption();
            switch (option) {
                case 0:
                    System.out.println("Finished Program");
                    break;
                case 1:
                    new MenuVehicles(this.data.getVehicles()).menu();
                    break;
                case 2:
                    new MenuProcedures(this.data.getProcedure()).menu();
                    break;
                case 3:
                    new MenuMaintenances(this.data.getMaintenance(), this.data.getVehicles(), this.data.getProcedure())
                            .menu();
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        } while (option != 0);
    }

}
