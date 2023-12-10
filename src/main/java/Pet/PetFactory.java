import java.util.ArrayList;
import java.util.List;

/**
 * данный класс предназначен для создания подклассов Pet по текстовому аргументу
 * список возможных вариантов задан вручную
 */

public class PetFactory <T extends PetAnimal> {
    private ArrayList<String> animalList;

    public PetFactory () {
        this.animalList = new ArrayList<>(List.of("dog", "cat", "parrot"));
    }

    public ArrayList<String> getAnimalList () {
        return this.animalList;
    }

    public Animal createAnimal(int animalId, String animalType, String animalBirth, String animalName) {
        switch (animalType) {
            case "dog":
                Dog dog = new Dog(animalId, animalBirth, animalName);
                return dog;

            case "cat":
                Cat cat = new Cat(animalId, animalBirth, animalName);
                return cat;

            case "parrot":
                Parrot parrot = new Parrot(animalId, animalBirth, animalName);
                return parrot;

            default:
                System.out.println("Неизвестный тип");
                return null;


        }
    }
}
