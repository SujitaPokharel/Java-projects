package driverClass;

import java.util.ArrayList;

import javax.swing.ListCellRenderer;

import cs532lab1.Course;
import cs532lab1.Name;
import cs532lab1.Student;
import cs532lab1.Name.titleEnum;

public class CourseTest {
	
	public static void main(String[] args) {
		
		subMain();
	}
	
	public static void subMain(){
		
		Course course = new Course("Computer Science", 345, 5, false);
		
		Name name = new Name("Manoj", "Sitaula");
		name.setTitle(titleEnum.Mr);
		
		Student student = new Student(name, 14105);
		student.setNosOfCredits(36);
		student.setGraduateStudent(true);
		
		course.addStudent(student);
		
		Name name1 = new Name("Sujita" , "Pokharel");
		name1.setTitle(titleEnum.Ms);
		name1.setMiddle_initial('M');
		
		Student student1 = new Student(name1, 12345);
		student1.setNosOfCredits(30);
		student1.setGraduateStudent(true);
		
		course.addStudent(student1);
		
		Name name2 = new Name("Suzy" , "Jouben");
		name2.setTitle(titleEnum.Ms);
		name2.setMiddle_initial('K');
		
		Student student2 = new Student(name2, 11356);
		student2.setNosOfCredits(21);
		student2.setGraduateStudent(true);
		
		course.addStudent(student2);
				
		course.toRemoveStudent(student1.getStudent_id());
		
		Name dummyName = new Name("Dummy", "Dummy");
		dummyName.setTitle(Name.titleEnum.Mr);
				
		course.hasStudent(dummyName);
		course.hasStudent(student);
		
		printStudentList(course.copyOfStdList()); //returns a list of all students in the class and prints the results
				
		System.out.println(course.getTotalnosStudent());//returns the number of students in the course and prints the results 

		
	}
	
	public static void printStudentList(Student[] stdList){
		
		for(int i = 0; i<stdList.length; i++){
			System.out.println(stdList[i].toString());
		}
	}

	public static ArrayList<Course> getCancelledCourses(ArrayList<Course> listCourses, Integer minEnrollment){
		
		ArrayList<Course> cancelledCourseList = new ArrayList<Course>();
		
		for(Course course: listCourses){
			course.getTotalnosStudent().compareTo(minEnrollment);
			if(course.getTotalnosStudent().compareTo(minEnrollment)== -1){
				cancelledCourseList.add(course);
			}
		}
		
		return cancelledCourseList;
	}

}
