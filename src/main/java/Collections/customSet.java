package Collections;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class customSet {

	public static void main(String[] args) {
		
		Student student = new Student(1, "amit");
		Student student2 = new Student(1, "amit");
		Student student3 = new Student(2, "newamit");
		
		Set<Student> set = new HashSet<>();
		set.add(student);
		set.add(student2);
		set.add(student3);
		
		for(Student std: set){
			System.out.println(std.getStdId() + std.getStdName());
			
		}
	}
}



class Student{
	
	private int stdId;
	private String stdName;
	
	public Student(int stdId, String stdName) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
	}
	
	public int getStdId() {
		return stdId;
	}
	public String getStdName() {
		return stdName;
	}
	
	public boolean equals(Object obj) {
 		boolean retValue = false;
    	if (obj instanceof Student) {
			Student e  = (Student)obj;
			retValue =  (this.stdName.equals(e.getStdName()) && this.stdId == e.getStdId())?true:false;
			}
		return retValue;
	}
	public int hashCode( ) {
		System.out.println("In hashcode");
		int hashcode = 0;
		hashcode = stdId*20;
		hashcode += stdName.hashCode();
		System.out.println("In hashcode" + hashcode);
		return hashcode;

	}
	
	
	
	
}