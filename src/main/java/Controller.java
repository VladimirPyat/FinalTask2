import java.util.ArrayList;
import java.util.Scanner;

/**
*класс является связующим для управление отображением View, Репозиториями Repo, и фабриками Factory
 * тут же содержится вся логика работы приложения
 */
public class Controller {

    ConsoleView view = new ConsoleView();
    PetFactory petFactory = new PetFactory();
    PackFactory packFactory = new PackFactory();
    AnimalRepo animalRepo = new AnimalRepo();


    public void mainMenu() {
        Boolean isExit = false;
        ArrayList <String> menuItems = new ArrayList<>();
        String menuHeader = "ГЛАВНОЕ МЕНЮ";
        menuItems.add("1 - создание записей");
        menuItems.add("2 - просмотр/редактирование записей");
        menuItems.add("0 - выход из программы");

        while (!isExit) {
            view.displayMenu(menuHeader, menuItems);
            int menuChoiсe = view.digitInput(menuItems.size());
            switch (menuChoiсe) {
                case 0:
                    System.out.println("Программа завершена.");
                    isExit = true;
                    break;
                case 1:
                    createMenu();
                    break;
                case 2:
                    editListMenu();
                    break;
                default:
                    System.out.println("Вы ввели некорректное значение.");
                    break;
            }
        }
    }

    public void createMenu() {
        Boolean isExit = false;
        ArrayList <String> menuItems = new ArrayList<>();
        String menuHeader = "СОЗДАНИЕ ЖИВОТНОГО";
        menuItems.add("1 - Создать домашнее животное (pet)");
        menuItems.add("2 - Создать вьючное животное (pack)");
        menuItems.add("0 - Возврат в главное меню");

        while (!isExit) {
            view.displayMenu(menuHeader, menuItems);
            int menuChoiсe = view.digitInput(menuItems.size());
            if (menuChoiсe == 0) {
                isExit = true;
            } else {
                createAnimal(menuChoiсe);
            }
        }
    }

    public void createAnimal (int menuChoiсe) {
        ArrayList<String> animalList = new ArrayList<>();
        if (menuChoiсe == 1) {
            animalList = petFactory.getAnimalList();
        } else
        if (menuChoiсe == 2) {
            animalList = packFactory.getAnimalList();
        }
        System.out.println("Список животных доступных для создания: "+animalList);
        System.out.print("Введите название типа животного: ");
        String animalType = view.listInput(animalList);
        System.out.print("Введите имя животного: ");
        Scanner scanner = new Scanner(System.in);
        String animalName = scanner.nextLine();
        System.out.print("Введите дату рождения животного в формате dd.MM.yyyy: ");
        String animalBirth = view.dateInput();
        int animalId = animalRepo.getIdCounter();

        if (menuChoiсe == 1) {
            if (animalRepo.addAnimal(petFactory.createAnimal(animalId, animalType, animalBirth, animalName))) {
                System.out.println(animalRepo.findById(animalId).shortList()+" создано");
            };
        } else
        if (menuChoiсe == 2) {
            if (animalRepo.addAnimal(packFactory.createAnimal(animalId, animalType, animalBirth, animalName))) {
                System.out.println(animalRepo.findById(animalId).shortList()+" создано");
            };

        }

    }



    public void editListMenu() {
        Boolean isExit = false;
        ArrayList <String> menuItems = new ArrayList<>();
        String menuHeader = "ПРОСМОТР/РЕДАКТИРОВАНИЕ ЖИВОТНОГО";
        menuItems.add("1 - Поиск животных по типу");
        menuItems.add("2 - Просмотр животного по id");
        menuItems.add("3 - Удаление животного по id");
        menuItems.add("4 - Редактирование животного по id");
        menuItems.add("5 - Редактирование списка команд животного по id");
        menuItems.add("0 - Возврат в главное меню");

        while (!isExit) {
            view.displayMenu(menuHeader, menuItems);
            int menuChoiсe = view.digitInput(menuItems.size());
            switch (menuChoiсe) {
                case 0:
                    isExit = true;
                    break;
                case 1:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите тип животного для поиска (пустой ввод - весь список): ");
                    String input = scanner.nextLine();
                    ArrayList<Animal> findResult = animalRepo.findByType(input);
                    if (findResult.isEmpty()) {
                        System.out.println("Ничего не найдено");
                    } else {
                        for (Animal animal : findResult) {
                            System.out.println(animal.shortList());
                        }
                    }

                    break;
                case 2:
                    System.out.println("Введите id животного для поиска");
                    menuChoiсe = view.digitInput(999);                       //допустим id может быть от 0 до 999
                    Animal animal = animalRepo.findById(menuChoiсe);
                    if (animal != null)  {
                        System.out.println(animal);
                    } else {
                        System.out.println("Животное id"+menuChoiсe+" не найдено");
                    }

                    break;
                case 3:
                    System.out.println("Введите id животного для удаления");
                    menuChoiсe = view.digitInput(999);                       //допустим id может быть от 0 до 999
                    if (animalRepo.delAnimal(menuChoiсe)) {
                        System.out.println("Животное id"+menuChoiсe+" удалено");
                    } else {
                        System.out.println("Животное id"+menuChoiсe+" не найдено");
                    }
                    break;
                case 4:
                    System.out.println("Введите id животного для редактирования");
                    menuChoiсe = view.digitInput(999);                       //допустим id может быть от 0 до 999
                    Animal animal2 = animalRepo.findById(menuChoiсe);
                    System.out.println(animal2.shortList());
                    if (animal2 != null)  {
                        System.out.print("Введите новое имя животного: ");
                        Scanner scanner2 = new Scanner(System.in);
                        String animalName = scanner2.nextLine();
                        System.out.print("Введите новую дату рождения животного в формате dd.MM.yyyy: ");
                        String animalBirth = view.dateInput();
                        animalRepo.editAnimal(menuChoiсe, animalName, animalBirth);
                        System.out.println(animal2.shortList());
                    } else {
                        System.out.println("Животное id"+menuChoiсe+" не найдено");
                    }
                    break;
                case 5:
                    System.out.println("Команда будет доступна в следующей версии программы");

                    break;
                default:
                    System.out.println("Вы ввели некорректное значение.");
                    break;
            }
        }
    }


}
