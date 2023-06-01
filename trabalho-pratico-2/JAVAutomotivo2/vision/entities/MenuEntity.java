package vision.entities;

import java.util.InputMismatchException;

import vision.*;

public abstract class MenuEntity extends Menu {

    public MenuEntity(String title) {
        super(title, new String[] { "Return", "Insert", "Modify", "Remove", "Search Id", "See all" });
    }

    protected int getId() {
        int id;
        do {
            try {
                System.out.print("Id: ");
                id = this.scan.nextInt();
                scan.nextLine();
                return id;
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Invalid Id - try again");
            }
        } while (true);
    }

    abstract protected void insertEntity();

    abstract protected void modifyEntity();

    abstract protected void removeEntity();

    abstract protected void searchIdEntity();

    abstract protected void seeAllEntity();

    public void menu() {
        int option;
        do {
            option = super.getOption();
            switch (option) {
                case 0:
                    System.out.println("Quit enitity menu");
                    break;
                case 1:
                    this.insertEntity();
                    break;
                case 2:
                    this.modifyEntity();
                    break;
                case 3:
                    this.removeEntity();
                    break;
                case 4:
                    this.searchIdEntity();
                    break;
                case 5:
                    this.seeAllEntity();
                    break;
                default:
                    System.out.println("Invalid ption");
                    break;
            }
        } while (option != 0);
    }
}
