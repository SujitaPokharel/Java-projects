package cusutilities.cusdata;

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

	@Override
	public boolean equals(Object object) {
		//boolean isEqual = false;

		if (object != null && object instanceof Customer) {
			return (this.getName().getFirstName().equals(((Customer) object).getName().getFirstName()))
					&& (this.getName().getLastName()).equals(((Customer) object).getName().getLastName())
					&& (this.getPhone().toString()).equals(((Customer) object).getPhone().toString());

		}

		return false;
	}

	@Override
	public int hashCode() {
	    int result = 0;
	    result = this.getName().getFirstName().hashCode()
	    		+this.getName().getLastName().hashCode()
	    		+this.getPhone().toString().hashCode();
	    return result;
	  }
}