public class Cat extends PetAnimal{
    public Cat(String type, String birthDate, String name) {
        super(0, type, birthDate, name);
        this.addCommands();
    }
    public Cat(int id, String birthDate, String name) {
        super(id, "cat", birthDate, name);
        this.addCommands();
    }

    private void addCommands() {
        activeCommands = setActiveCommands();
    }
}
