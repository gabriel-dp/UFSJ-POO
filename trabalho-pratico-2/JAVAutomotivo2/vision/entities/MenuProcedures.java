package vision.entities;

import control.*;
import model.*;

public class MenuProcedures extends MenuEntity {

    private Persistent procedures;

    public MenuProcedures(Persistent procedures) {
        super("Procedures");
        this.procedures = procedures;
    }

    private Procedure getProcedure(int id) {
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Value: ");
        Double value = this.getDouble();

        return new Procedure(id, name, value);
    }

    protected void insertEntity() {
        System.out.println("Add Procedure");

        int id = this.getId();
        try {
            procedures.searchId(id);
            System.out.println("\nId already exists");
        } catch (IdException _e) {
            Procedure newProcedure = getProcedure(id);
            this.procedures.insert(newProcedure);
            System.out.println("\nProcedure added successfully");
        }
    }

    protected void modifyEntity() {
        System.out.println("Modify Procedure data");

        int id = this.getId();
        try {
            Entity oldProcedure = procedures.searchId(id);
            Procedure newProcedure = getProcedure(id);
            procedures.modify(oldProcedure, newProcedure);
            System.out.println("\nProcedure modified successfully");
        } catch (IdException error) {
            System.out.println(error.getMessage());
        }
    }

    protected void removeEntity() {
        System.out.println("Remove Procedure");

        int id = this.getId();
        try {
            Entity procedure = procedures.searchId(id);
            procedures.remove(procedure);
            System.out.println("\nProcedure removed successfully");
        } catch (IdException error) {
            System.out.println(error.getMessage());
        }
    }

    protected void searchIdEntity() {
        System.out.println("Search by Id");

        int id = this.getId();
        try {
            Entity procedure = procedures.searchId(id);
            System.out.println(procedure.toString());
        } catch (IdException error) {
            System.out.println(error.getMessage());
        }
    }

    protected void seeAllEntity() {
        System.out.println(this.procedures.toString());
    }

}
