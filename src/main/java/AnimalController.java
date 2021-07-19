import java.util.List;
import java.util.Scanner;

public class AnimalController {
    private  AnimalService animalService;

    public  void createAnimalFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter animal's name");
        String name = scanner.nextLine();
        System.out.println("Enter animal's age");
        int age = scanner.nextInt();
        System.out.println("Enter id of human");
        Long humanId = scanner.nextLong();
        createAnimal(name, age, humanId);
    }

    private  void createAnimal(String name, int age, Long humanId) {
        Human humanById = animalService.getHumanById(humanId);
        Animal animal = new Animal(name, age, humanById);
        animalService.addAnimalToHuman(humanById, animal);
        animalService.getAnimalResponse(animal);
    }

    public  void readAllAnimals() {
        List<Animal> allAnimals = animalService.getAllAnimals();
        allAnimals.forEach(Animal::AnimalProperties);
    }

    public  void updateAnimal() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of the animal");
        long id = scanner.nextLong();
        System.out.println("Enter 1 to update name");
        System.out.println("Enter 2 to update age");
        System.out.println("Enter 3 to update human of animal");
        int choice = scanner.nextInt();
        if (choice == 1) {
            updateName(id);
        } else if (choice == 2) {
            updateAge(scanner, id);
        } else {
            updateHumanOfAnimal(scanner, id);
        }
    }

    private  void updateHumanOfAnimal(Scanner scanner, long id) {
        System.out.println("Enter id of the human");
        long humanId = scanner.nextLong();
        animalService.updateAnimalByHuman(id, humanId);
    }

    private  void updateAge(Scanner scanner, long id) {
        System.out.println("Enter age");
        int age = scanner.nextInt();
        animalService.updateAnimalByAge(age, id);
    }

    private  void updateName(long id) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter name");
        String name = scanner1.nextLine();
        animalService.updateAnimalByName(name, id);
    }

    public  void deleteAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of the animal");
        long id = scanner.nextLong();
        animalService.deleteAnimal(id);
    }

    public  void createAnimalWithoutIdFromConsole(Human human) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter animal's name");
        String name = scanner.nextLine();
        System.out.println("Enter animal's age");
        int age = scanner.nextInt();
        Animal animal = new Animal(name, age, human);
        animalService.addAnimalToHuman(human, animal);
        animalService.getAnimalResponse(animal);
    }

    public  void updateOwnerOfAnimal(Long humanId, Long animalId) {
        animalService.updateAnimalByHuman(animalId, humanId);
    }

    public  void readAnimalById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of the animal");
        long id = scanner.nextLong();
        Animal animalById = animalService.getAnimalById(id);
        animalById.AnimalProperties();
    }

    public void setAnimalService(AnimalService animalService) {
        this.animalService = animalService;
    }
}
