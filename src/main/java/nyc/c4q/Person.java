package nyc.c4q;

public class Person {
    public String firstName;
    public String lastName;
    public House house;

    public Person(String firstName, String lastName, House house) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.house     = house;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getHouse() {
        return this.house.toString();
    }
}
