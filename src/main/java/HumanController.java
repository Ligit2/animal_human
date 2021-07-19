import java.util.List;
import java.util.Scanner;

public class HumanController {
    private  HumanService humanService ;
    private AnimalController animalController ;

    public  void createHumanFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to create human without animals");
        System.out.println("Enter 2 to create human with animals");
        int choice = scanner.nextInt();

        if (choice == 1) {
            createHuman();
        } else {
            createHumanWithAnimals();
        }
    }

    private  void createHumanWithAnimals() {
        Scanner scanner = new Scanner(System.in);
        Human human = createHuman();
        System.out.println("Enter number of animals");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
           animalController.createAnimalWithoutIdFromConsole(human);
        }
    }

    private  Human createHuman() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Human name ");
        String name = scanner.nextLine();
        System.out.println("enter Human age");
        int age = scanner.nextInt();
        Human human = new Human(name, age);
        humanService.getHumanResponse(human);
        return human;
    }

    public  Human getHumanById(Long humanId) {
        return humanService.getHumanById(humanId);
    }

    public  void addAnimalToHuman(Human human, Animal animal) {
        humanService.addAnimalToHuman(human, animal);
    }

    public  void readAllHumans() {
        List<Human> allHumans = humanService.getAllHumans();
        allHumans.forEach(System.out::println);
    }

    public  void removeAnimalFromHuman(Human human, Animal animal) {
        humanService.removeAnimalFromHuman(human, animal);
    }

    public  void updateHuman() {
        System.out.println("Enter id of the human");
        Scanner scanner = new Scanner(System.in);
        long id = scanner.nextLong();
        System.out.println("Enter 1 to update name");
        System.out.println("Enter 2 to update age");
        System.out.println("Enter 3 to update animals");
        int choice = scanner.nextInt();
        if (choice == 1) {
            updateName(id);
        } else if (choice == 2) {
            updateAge(scanner, id);
        } else {
            updateAnimalsOfHuman(scanner, id);
        }
    }

    private  void updateAnimalsOfHuman(Scanner scanner, long id) {
        Human human = humanService.getHumanById(id);
        humanService.removeAnimalsFromHuman(human);
        System.out.println("Enter number of animals");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Enter id of the animal");
            long animalId = scanner.nextLong();
            animalController.updateOwnerOfAnimal(id, animalId);
        }
    }

    private  void updateAge(Scanner scanner, long id) {
        System.out.println("Enter age");
        int age = scanner.nextInt();
        humanService.updateHumanByAge(id, age);
    }

    private  void updateName(long id) {
        System.out.println("Enter name");
        Scanner scanner1 = new Scanner(System.in);
        String name = scanner1.nextLine();
        humanService.updateHumanByName(id, name);
    }

    public  void deleteHuman() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Id of the human");
        long id = scanner.nextLong();
        humanService.deleteHuman(id);
    }

    public  void readHumanById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of the human");
        long id = scanner.nextLong();
        Human humanById = humanService.getHumanById(id);
        System.out.println(humanById);
    }

    public void setHumanService(HumanService humanService) {
        this.humanService = humanService;
    }

    public void setAnimalController(AnimalController animalController) {
        this.animalController=animalController;
    }
}
