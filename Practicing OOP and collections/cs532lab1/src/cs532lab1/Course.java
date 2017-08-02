package cs532lab1;

import java.util.ArrayList;

public class Course{
	
	private Name nameOfInstructor;
	private String deptName;
	private Integer courseNum;	
	private Integer maxClassSize;
	ArrayList<Student> listOfStd = new ArrayList<Student>();
	private boolean isOpenToUndergraduate;
	
	public Course(String deptname, Integer courseNum, Integer maxClassSize, boolean isOpenToUndergraduate){
		this.deptName = deptname;
		this.courseNum = courseNum;
		this.maxClassSize = maxClassSize;
		this.isOpenToUndergraduate = isOpenToUndergraduate;
	}
	
	public void setNameOfInstructor(Name nameOfInstructor) {
		this.nameOfInstructor = nameOfInstructor;
	}
	
	public Name getNameOfInstructor() {
		return nameOfInstructor;
	}

	public String getDeptName() {
		return deptName;
	}

	public Integer getMaxClassSize() {
		return maxClassSize;
	}

	public Integer getCourseNum() {
		return courseNum;
	}
	
	public boolean addStudent(Student newStudent){
				
		if(!listOfStd.contains(newStudent)){
			if(listOfStd.size() < maxClassSize)
				if(isOpenToUndergraduate == false)
					listOfStd.add(newStudent);
					//System.out.println(listOfStd);
					return true;
		}
		else
			return false;
		
	}

	public boolean toRemoveStudent(Integer student_id){
		
		for(Student std: listOfStd){
			if(std.getStudent_id().equals(student_id) ){
				listOfStd.remove(std);
				return true;
			}
		}
		return false;
	}	
	
	public Student hasStudent(Name nameOfstd){
		for(Student std: listOfStd){
			if(std.getStudentName().equals(nameOfstd)){
				return std;
			}
		}
		return null;
	}
	public boolean hasStudent(Student stuObj){
		if(listOfStd.contains(stuObj)){
			return true;
		}
		return false;
		
	}
	
	public Integer getTotalnosStudent() {
		return listOfStd.size();
	}
	
	public Student [] copyOfStdList(){
		Student [] copyOfStudentArrayList = new Student[listOfStd.size()];
		for(int i = 0; i<listOfStd.size(); i++){
			copyOfStudentArrayList[i] = listOfStd.get(i);
		}
		return copyOfStudentArrayList;
		
	}
	
			
	@Override
	public String toString (){
		
		StringBuffer strBufcourse = new StringBuffer();
		strBufcourse.append(getCourseNum());
		strBufcourse.append(getDeptName());
		strBufcourse.append(getNameOfInstructor());
		strBufcourse.append(getMaxClassSize());
		for(Student std: listOfStd){
			strBufcourse.append("\n"+std.toString());
		}
		return strBufcourse.toString();
	}
}
