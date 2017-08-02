package cusutilities.cusdata;

public class Name {
    private String lastName;
    private String firstName;

    public Name(String lName, String fName) {
        lastName = lName;
        firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return lastName;
    }


    public String toString() {
        return lastName + ", " + firstName;
    }
}