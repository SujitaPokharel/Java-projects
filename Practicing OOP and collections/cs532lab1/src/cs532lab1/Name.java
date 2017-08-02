package cs532lab1;

public class Name {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(titleEnum title) {
		this.title = title.prefix;
	}

	public enum titleEnum {
		Mr("Mr."), Mrs("Mrs."), Ms("Ms."), Dr("Dr.");
		private final String prefix;

		titleEnum(String prefix) {
			this.prefix = prefix;
		}
	}

	private String first_name;
	private String last_name;
	private char middle_initial;

	public Name(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;

	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public char getMiddle_initial() {
		return middle_initial;
	}

	public void setMiddle_initial(char middle_initial) {
		this.middle_initial = middle_initial;
	}

	public static void main(String[] args) {
		System.out.println(titleEnum.Mr);
	}
	
	@Override
	public String toString() {
		
		StringBuffer stringBufName = new StringBuffer();
		if(getTitle() != null)
			stringBufName.append(getTitle()+ " ");
		stringBufName.append(getFirst_name()+" ");
		if(getMiddle_initial() != ' ' )
			stringBufName.append(getMiddle_initial()+" ");
		stringBufName.append(getLast_name());
		
		return stringBufName.toString();
			
	}
		
	@Override
	public boolean equals(Object objN) {
		
		if(objN == null){ // first checks object is null or not
			return false;
		}
		
		if (getClass() != objN.getClass()){ // secondly checks whether both compared object belongs to same class or not
			return false;
		}
		
		Name nameobj= (Name) objN; // third checks the type cast 
		
		if(getFirst_name() != null && getLast_name() != null){
		
		if(getFirst_name().equals(nameobj.getFirst_name())
				&& getLast_name().equals(nameobj.getLast_name())
				&&  getTitle().equals(nameobj.getTitle()) // title can be null 
				&& (getMiddle_initial() == nameobj.getMiddle_initial()) // middle initial can be null
				)
			return true;		
	}
		return false;
	}	

}
