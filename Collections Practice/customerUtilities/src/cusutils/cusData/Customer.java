package cusutils.cusData;

public class Customer {
    private Name name;
    private PhoneNum phone;

    public Customer(Name cusName, PhoneNum cusPhone) {
        name = cusName;
        phone = cusPhone;
    }

    public Name getName() {
        return name;
    }

    public PhoneNum getPhone() {
        return phone;
    }

    public String toString() {
        return "Customer: " + name + "  " + phone;
    }

    public void print() {
        System.out.println(this);
    }
}