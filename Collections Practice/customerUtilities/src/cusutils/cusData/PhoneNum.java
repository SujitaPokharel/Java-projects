package cusutils.cusData;

public class PhoneNum {
    private int areaCode;
    private String localNum;

    public PhoneNum(int newAreaCode, String newLocalNum) {
        areaCode = newAreaCode;
        localNum = newLocalNum;
    }
    
    public int getAreaCode() {
		return areaCode;
	}

	public String getLocalNum() {
		return localNum;
	}


    public String toString() {
        return "(" + areaCode + ")" + localNum;
    }
}