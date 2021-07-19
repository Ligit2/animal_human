import java.util.List;

public class HumanService {
    private  DAO dao ;

    public  void getHumanResponse(Human human) {
        dao.addHuman(human);
    }

    public  Human getHumanById(Long humanId) {

        return dao.getHumanById(humanId);
    }

    public  void addAnimalToHuman(Human human, Animal animal) {
        human.getAnimals().add(animal);
    }

    public  List<Human> getAllHumans() {
        return dao.getAllHumans();
    }

    public  void removeAnimalFromHuman(Human human, Animal animal) {
        human.getAnimals().remove(animal);
    }

    public  void updateHumanByName(long id, String name) {
        dao.updateHumanByName(id, name);
    }

    public  void updateHumanByAge(long id, int age) {
        dao.updateHumanByAge(id, age);
    }

    public  void deleteHuman(long id) {
        dao.deleteHuman(id);
    }

    public  void removeAnimalsFromHuman(Human human) {
        AnimalService animalService = new AnimalService();
        human.getAnimals().forEach(animal -> animalService.deleteAnimalFromDb(animal));
    }

    public void setDAO(DAO dao) {
        this.dao = dao;
    }
}
