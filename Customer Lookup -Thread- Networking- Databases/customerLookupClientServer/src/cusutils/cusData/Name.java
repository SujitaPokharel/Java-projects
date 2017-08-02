package cusutils.cusData;

import java.io.Serializable;

public class Name implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
        return firstName;
    }


    public String toString() {
        return lastName + ", " + firstName;
    }
    
    @Override
	public boolean equals(Object object) {
		// boolean isEqual = false;

		if (object != null && object instanceof Name) {
			return (this.getFirstName().equalsIgnoreCase(((Name) object).getFirstName()))
					&& (this.getLastName()).equalsIgnoreCase(((Name) object).getLastName());
					

		}

		return false;
	}
}