public class Horse extends PackAnimal{
    public Horse(String type, String birthDate, String name) {
        super(0, type, birthDate, name);
        this.addCommands();
    }
    public Horse(int id, String birthDate, String name) {
        super(id, "horse", birthDate, name);
        this.addCommands();
    }

    private void addCommands() {
        this.commandOn("start");
        this.commandOn("stop");
        this.commandOn("run");
        this.commandOn("walk");
        activeCommands = setActiveCommands();
    }
}
