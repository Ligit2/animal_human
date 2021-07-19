import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DAO {
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Animal.class)
                .addAnnotatedClass(Human.class)
                .buildSessionFactory();
    }

    public  void addHuman(Human human) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(human);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public  Human getHumanById(Long humanId) {
        sessionFactory.getCurrentSession().beginTransaction();
        Human human = sessionFactory.getCurrentSession().get(Human.class, humanId);
        sessionFactory.getCurrentSession().getTransaction().commit();
        return human;
    }

    public  void addAnimal(Animal animal) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(animal);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public  Animal getAnimalById(Long id) {
        sessionFactory.getCurrentSession().beginTransaction();
        Animal animal = sessionFactory.getCurrentSession().find(Animal.class, id);
        sessionFactory.getCurrentSession().getTransaction().commit();
        ;
        return animal;
    }

    public  List<Human> getAllHumans() {
        sessionFactory.getCurrentSession().beginTransaction();
        List<Human> from_human_h = sessionFactory.getCurrentSession().createQuery("from Human h").list();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return from_human_h;
    }

    public  List<Animal> getAllAnimals() {
        sessionFactory.getCurrentSession().beginTransaction();
        List<Animal> from_animal_h = sessionFactory.getCurrentSession().createQuery("from Animal h").list();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return from_animal_h;
    }

    public static void updateAnimalByName(String name, Long id) {
        sessionFactory.getCurrentSession().beginTransaction();
        Animal animal = sessionFactory.getCurrentSession().find(Animal.class, id);
        animal.setName(name);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public  void updateAnimalByAge(int age, Long id) {
        sessionFactory.getCurrentSession().beginTransaction();
        Animal animal = sessionFactory.getCurrentSession().find(Animal.class, id);
        animal.setAge(age);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public  Human updateAnimalByHuman(long id, long humanId) {
        Human humanById = getHumanById(humanId);
        sessionFactory.getCurrentSession().beginTransaction();
        Animal animal = sessionFactory.getCurrentSession().find(Animal.class, id);
        animal.setHuman(humanById);
        sessionFactory.getCurrentSession().getTransaction().commit();
        return humanById;
    }

    public  void updateHumanByName(long id, String name) {
        sessionFactory.getCurrentSession().beginTransaction();
        Human human = sessionFactory.getCurrentSession().find(Human.class, id);
        human.setName(name);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public  void updateHumanByAge(long id, int age) {
        sessionFactory.getCurrentSession().beginTransaction();
        Human human = sessionFactory.getCurrentSession().find(Human.class, id);
        human.setAge(age);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public  void deleteHuman(long id) {
        Human humanById = getHumanById(id);
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().delete(humanById);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public  void deleteAnimal(long id) {
        Animal animalById = getAnimalById(id);
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().delete(animalById);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public  void deleteAnimal(Animal animal) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().delete(animal);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

}
