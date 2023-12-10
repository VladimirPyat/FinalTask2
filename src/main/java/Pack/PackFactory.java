import java.util.ArrayList;
import java.util.List;

/**
 * данный класс предназначен для создания подклассов Pack по текстовому аргументу
 * список возможных вариантов задан вручную
 */

public class PackFactory <T extends PackAnimal> {
    private ArrayList<String> animalList;

    public PackFactory () {
        this.animalList = new ArrayList<>(List.of("horse", "donkey", "camel"));
    }

    public ArrayList<String> getAnimalList () {
        return this.animalList;
    }

    public Animal createAnimal(int animalId, String animalType, String animalBirth, String animalName) {
        switch (animalType) {
            case "horse":
                Horse horse = new Horse(animalId, animalBirth, animalName);
                return horse;

            case "donkey":
                Donkey donkey = new Donkey(animalId, animalBirth, animalName);
                return donkey;

            case "camel":
                Camel camel = new Camel(animalId, animalBirth, animalName);
                return camel;

            default:
                System.out.println("Неизвестный тип");
                return null;


        }
    }
}

