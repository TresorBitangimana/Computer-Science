package Assignment6;

public abstract class Person<ID> implements Identifiable<Object> {

    protected ID id;
    protected String name;

    public Person(ID id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public ID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract void displayInfo();

}
