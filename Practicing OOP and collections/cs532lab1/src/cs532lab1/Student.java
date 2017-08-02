package cs532lab1;

public class Student{

	private Name studentName;
	
	private Integer student_id;
	private Integer nosOfCredits;
	private boolean isGraduateStudent;
		
	public Student(Name studentName, Integer student_id){
		this.studentName = studentName;
		this.student_id = student_id;
	}	
	public Name getStudentName() {
		return studentName;
	}		
	public Integer getStudent_id() {
		return student_id;
	}	
	public Integer getNosOfCredits() {
		return nosOfCredits;
	}
	public void setNosOfCredits(Integer nosOfCredits) {
		this.nosOfCredits = nosOfCredits;
	}		
	public boolean isGraduateStudent(){	
		return isGraduateStudent;			
	}	
	public void setGraduateStudent(boolean isGraduateStudent) {
		this.isGraduateStudent = isGraduateStudent;
	}
	
	@Override
	public String toString (){
		
		StringBuffer strBufStd = new StringBuffer();
		if(getStudentName() != null){
		strBufStd.append(getStudentName()+ " "); 
		}
		if(getStudent_id() != null){
			strBufStd.append(getStudent_id() + " ");
		}
		if(getNosOfCredits() != null){
			strBufStd.append(getNosOfCredits()+ " ");
		}
		if(isGraduateStudent == true){
			strBufStd.append(isGraduateStudent());
		}
		return strBufStd.toString();
	}
	
	@Override
	public boolean equals(Object objS){
		
		if(objS == null){
			return false;
		}
		
		if(getClass() != objS.getClass()){
			return false;
		}
		
		Student studentobj = (Student) objS;
		
		if(getStudentName() != null && getStudent_id() != null){
			
			if(getStudentName().equals(studentobj.getStudentName())&& // error if we do not pass first name and last name
				getStudent_id().equals(studentobj.getStudent_id())){				
				return true;
			}
		}
		return false;
	}	
	
}




