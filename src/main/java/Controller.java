import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Controller {
    private  HumanController humanController ;
    private   AnimalController animalController;

    public void setHumanController(HumanController humanController) {
        this.humanController = humanController;
    }

    public void setAnimalController(AnimalController animalController) {
        this.animalController = animalController;
    }

    public void start() {
        Scanner scanner1 = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 to work with humans");
            System.out.println("Enter 2 to work with animals");
            System.out.println("Enter 0 to exit");
            int mainChoice = scanner1.nextInt();
            if (mainChoice == 1) {
                getChoiceForHumans();
            } else if (mainChoice == 2) {
                getChoiceForAnimal();
            } else {
                break;
            }
        }
    }

    private  void getChoiceForAnimal() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 to create animal");
            System.out.println("Enter 2 to read animals");
            System.out.println("Enter 3 to update animal");
            System.out.println("Enter 4 to delete animal");
            System.out.println("Enter 5 to read animal by id");
            System.out.println("Enter 0 to exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                animalController.createAnimalFromConsole();
            } else if (choice == 2) {
                animalController.readAllAnimals();
            } else if (choice == 3) {
                animalController.updateAnimal();
            } else if (choice == 4) {
                animalController.deleteAnimal();
            } else if (choice == 5) {
                animalController.readAnimalById();
            } else {
                return;
            }
        }

    }

    private  void getChoiceForHumans() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 to create human");
            System.out.println("Enter 2 to read humans");
            System.out.println("Enter 3 to update human");
            System.out.println("Enter 4 to delete human");
            System.out.println("Enter 5 to read human by id");
            System.out.println("Enter 0 to exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                humanController.createHumanFromConsole();
            } else if (choice == 2) {
                humanController.readAllHumans();
            } else if (choice == 3) {
                humanController.updateHuman();
            } else if (choice == 4) {
                humanController.deleteHuman();
            } else if (choice == 5) {
                humanController.readHumanById();
            } else {
                return;
            }
        }
    }
}
