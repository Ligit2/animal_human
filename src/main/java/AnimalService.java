import java.util.List;

public class AnimalService {
    private  DAO dao ;

    public  void getAnimalResponse(Animal animal) {
        dao.addAnimal(animal);
    }

    public  List<Animal> getAllAnimals() {
        List<Animal> allAnimals = dao.getAllAnimals();
        return allAnimals;
    }

    public  void updateAnimalByName(String name, Long id) {
        dao.updateAnimalByName(name, id);
    }

    public  void updateAnimalByAge(int age, long id) {
        dao.updateAnimalByAge(age, id);
    }

    public  void updateAnimalByHuman(long id, long humanId) {
        Animal animalById = dao.getAnimalById(id);
        removeAnimalFromHuman(animalById.getHuman(), animalById);
        Human human = dao.updateAnimalByHuman(id, humanId);
        addAnimalToHuman(human, animalById);
    }

    public  void deleteAnimal(long id) {
        Animal animalById = dao.getAnimalById(id);
        removeAnimalFromHuman(animalById.getHuman(), animalById);
        dao.deleteAnimal(id);
    }
    public  void removeAnimalFromHuman(Human human, Animal animal) {
        human.getAnimals().remove(animal);
    }

    public  void deleteAnimalFromDb(Animal animal) {
        dao.deleteAnimal(animal);
    }

    public  Animal getAnimalById(long id) {
        return dao.getAnimalById(id);
    }
    public  void addAnimalToHuman(Human human, Animal animal) {
        human.getAnimals().add(animal);
    }
    public  Human getHumanById(Long humanId) {
        return dao.getHumanById(humanId);
    }

    public void setDAO(DAO dao) {
        this.dao = dao;
    }
}
