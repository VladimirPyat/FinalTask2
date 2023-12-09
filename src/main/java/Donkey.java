public class Donkey extends PackAnimal{
    public Donkey(String type, String birthDate, String name) {
        super(0, type, birthDate, name);
        this.addCommands();
    }
    public Donkey(int id, String birthDate, String name) {
        super(id, "horse", birthDate, name);
        this.addCommands();
    }

    private void addCommands() {
        this.commandOn("start");
        this.commandOn("stop");
        activeCommands = setActiveCommands();
    }
}
