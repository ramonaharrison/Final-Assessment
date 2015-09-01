package nyc.c4q;

/**
 * Created by Ramona Harrison
 * on 9/1/15.
 */
public class Member {

    public String ID;
    public String name;
    public String dobMonth;
    public String dobDay;
    public String dobYear;
    public String city;
    public String state;

    public Member(String ID, String name, String dobMonth, String dobDay, String dobYear, String city, String state) {
        this.ID = ID;
        this.name = name;
        this.dobMonth = dobMonth;
        this.dobDay = dobDay;
        this.dobYear = dobYear;
        this.city = city;
        this.state = state;
    }

    public Member() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDobMonth() {
        return dobMonth;
    }

    public void setDobMonth(String dobMonth) {
        this.dobMonth = dobMonth;
    }

    public String getDobDay() {
        return dobDay;
    }

    public void setDobDay(String dobDay) {
        this.dobDay = dobDay;
    }

    public String getDobYear() {
        return dobYear;
    }

    public void setDobYear(String dobYear) {
        this.dobYear = dobYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
