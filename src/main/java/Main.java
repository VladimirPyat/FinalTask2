public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        //для упрощения тестирования создаем сразу несколько животных в афтоматическом режиме
        //при необходимости строки можно раскомментировать

        //int animalId = animalRepo.getIdCounter();
        //animalRepo.addAnimal(petFactory.createAnimal(animalId, "dog", "11.02.2010", "Шарик"))
        //animalRepo.addAnimal(petFactory.createAnimal(animalId, "dog", "13.06.20111", "Тузик"))
        //animalRepo.addAnimal(petFactory.createAnimal(animalId, "cat", "01.05.2014", "Маркиз"))
        //animalRepo.addAnimal(petFactory.createAnimal(animalId, "parrot", "14.12.2020", "Кеша"))
        //animalRepo.addAnimal(petFactory.createAnimal(animalId, "horse", "24.08.2022", "Ветерок"))
        //animalRepo.addAnimal(petFactory.createAnimal(animalId, "donkey", "01.01.2001", "Росинант"))

        controller.mainMenu();



    }
}
