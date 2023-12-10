import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *Класс вьючных животных, помимо стандартных полей, наследуемых от суперкласса, содержит
 *поля
 *command - общий список всех доступных команд для данного типа животных
 *commandStatus - Hashmap в котором  ключами являются названия команд, а значения имеют логический тип.
 *true означает что для данного животного данная команда используется
 *методы
 *commandOn() / commandOff() - позволяют включить или выключить конкретные команды для конкретного животного
 *getActiveCommands - получения списка активных команд конкретного животного

 */
public abstract class PackAnimal extends Animal {
    String activeCommands;
    HashMap<String, Boolean> commandStatus;

    public PackAnimal(int id, String type, String birthDate, String name) {
        super(id, type, birthDate, name);                                                        //id назначается в репозитории
        ArrayList<String> commands = new ArrayList<>(List.of("start", "stop", "run", "walk"));     //список команд для всех животных типа
        commandStatus = new HashMap<>();
        for (String command:commands) {
            commandStatus.put(command, false);                                                       //по умолчанию все команды отключены
        }
        activeCommands = setActiveCommands();                                                       //обновление списка активных команд

    }


    public void commandOn(String command) {
        if (commandStatus.keySet().contains(command.toLowerCase())) {
            commandStatus.put(command, true);
        } else System.out.println("Неизвестная команда");

    }

    public void commandOff(String command) {
        if (commandStatus.keySet().contains(command.toLowerCase())) {
            commandStatus.put(command, false);
        } else System.out.println("Неизвестная команда");
    }

    public String getActiveCommands() {
        return this.activeCommands;
    }

    public String setActiveCommands() {
        ArrayList<String> activeCommandsList = new ArrayList<>();
        for (String command:commandStatus.keySet()) {
            if (commandStatus.get(command)==true) {
                activeCommandsList.add(command);
            }
        }
        return String.join(",", activeCommandsList);
    }

    @Override
    public String toString() {
        return
                "id:" + this.getId() + "\n" +
                        "имя:" + this.getName() + "\n" +
                        "тип:" + this.getType() + "\n" +
                        "дата рождения:" + this.getBirthDate() + "\n" +
                        "список команд:" + this.getActiveCommands() + "\n"
                ;
    }


}
