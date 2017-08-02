package cusutils.cusData;

import java.io.Serializable;

public class PhoneNum implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int areaCode;
	private String localNum;

	public PhoneNum(int newAreaCode, String newLocalNum) {
		areaCode = newAreaCode;
		localNum = newLocalNum;
	}

	public String toString() {
		return "(" + areaCode + ")" + localNum;
	}
	
	
	@Override
	public boolean equals(Object obj) {

		return this.toString().equals(((PhoneNum) obj).toString());
	}
	
	 public int getAreaCode() {
		return areaCode;
	}

	public String getLocalNum() {
		return localNum;
	}

	@Override
	public int hashCode() {

		return this.toString().hashCode();
	}
}




/*@Override
public boolean equals(Object object) {
	// boolean isEqual = false;

	if (object != null && object instanceof PhoneNum) {
		System.out.println(this.getLocalNum().replaceAll("-", ""));
		System.out.println(((PhoneNum)object).getLocalNum().replaceAll("-", ""));
		return (
				this.getAreaCode() == (((PhoneNum)object).getAreaCode())
				
				&& (Integer.parseInt(this.getLocalNum().replaceAll("-", "")))== (Integer.parseInt(((PhoneNum)object).getLocalNum().replaceAll("-", "")))
			   );
		
		return (this.getAreaCode().equalsIgnoreCase(((PhoneNum) object).getFirstName()))
				&& (this.getLastName()).equalsIgnoreCase(((PhoneNum) object).getLastName());
		//&& this.Integer.parseInt(getLocalNum()).equals(((PhoneNum)object).Integer.parseInt(getLocalNum()))		

	}

	return false;
}*/
