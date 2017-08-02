package cusutilities.cusdata;

public class PhoneNum {
    private int areaCode;
    private String localNum;

    public PhoneNum(int newAreaCode, String newLocalNum) {
        areaCode = newAreaCode;
        localNum = newLocalNum;
    }

    public String toString() {
        return "(" + areaCode + ")" + localNum;
    }

	public int getAreaCode() {
		return areaCode;
	}

	public String getLocalNum() {
		return localNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return this.toString().equals(((PhoneNum)obj).toString());
	}
	
	@Override
	public int hashCode() {
		
		return this.toString().hashCode();
	}
}