import java.util.ArrayList;

/**
 * содержит методы работы с репозиторием: добавление, удаление, поиск и редактирование записей
 * counter - это общий счетчик элементов
 * id -
 */

public class AnimalRepo {
    private ArrayList<Animal> animalList ;
    int counter;
    int idCounter;

    public AnimalRepo() {
        this.animalList = new ArrayList<>();
        this.idCounter=1;                           //генерация id для следующего элемента - 1
        this.counter=0;                             //счетчик элементов изначально = 0 так как массив создается пустой
    }

    public Animal findById(int id) {
        for (Animal animal : animalList) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    public ArrayList<Animal> findByType(String type) {
        if (type.isEmpty()) {
            return animalList;
        } else {
            ArrayList<Animal> foundAnimals = new ArrayList<>();
            for (Animal animal : animalList) {
                if (animal.getType().equals(type)) {
                    foundAnimals.add(animal);
                }
            }
            return foundAnimals;
        }

    }

    public boolean addAnimal(Animal animal) {
        boolean success = animalList.add(animal);
        if (success) {
            idCounter++;
            counter = animalList.size();
        }
        return success;
    }

    public void editAnimal(int id, String name, String birthDate) {
        Animal animal = findById(id);
        if (animal != null) {
            animal.setName(name);
            animal.setBirthDate(birthDate);
        }

    }

    public boolean delAnimal(int id) {
        Animal animal = findById(id);
        if (animal != null) {
            boolean success = animalList.remove(animal);
            if (success) {
                counter = animalList.size();
            }
            return success;
        }
        return false;
    }

    public int getCounter() {
        return counter;
    }

    public int getIdCounter() {
        return idCounter;
    }
}
