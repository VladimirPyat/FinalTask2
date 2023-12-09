public class Dog extends PetAnimal{
    public Dog(String type, String birthDate, String name) {
        super(0, type, birthDate, name);
        this.addCommands();
    }
    public Dog(int id, String birthDate, String name) {
        super(id, "dog", birthDate, name);
        this.addCommands();
    }

    private void addCommands() {
        this.commandOn("voice");
        this.commandOn("come");
        this.commandOn("lay");
        this.commandOn("stand");
        activeCommands = setActiveCommands();
    }
}
