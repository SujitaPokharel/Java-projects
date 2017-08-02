package cusutils.cusData;

import java.io.Serializable;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		// boolean isEqual = false;

		if (object != null && object instanceof Customer) {
			return (this.getName().equals(((Customer) object).getName()))
					&& (this.getName().equals(((Customer) object).getName()) || (this.getPhone().toString()).equals(((Customer) object).getPhone()
							.toString()));

		}

		return false;
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = this.getName().getFirstName().hashCode() + this.getName().getLastName().hashCode() + this.getPhone().toString().hashCode();
		return result;
	}
}