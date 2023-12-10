public class Parrot extends PetAnimal{
    public Parrot(String type, String birthDate, String name) {
        super(0, type, birthDate, name);
        this.addCommands();
    }
    public Parrot(int id, String birthDate, String name) {
        super(id, "parrot", birthDate, name);
        this.addCommands();
    }

    private void addCommands() {
        this.commandOn("voice");
        activeCommands = setActiveCommands();
    }
}
