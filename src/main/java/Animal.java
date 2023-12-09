/**
*Класс содержит стандартный набор параметров животного - id, тип, дата рождения, имя
*Также содержит геттеры/сеттеры и короткую форму листинга в одну строку
 */

public abstract class Animal {
    private int id;
    private String type;
    private String birthDate;
    private String name;

    public Animal(int id, String type, String birthDate, String name) {
        this.id = id;
        this.type = type;
        this.birthDate = birthDate;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String shortList() {
        return ("Животное id="+id+ " типа "+type+ " по имени "+name+", рожд "+birthDate);

    }


}
