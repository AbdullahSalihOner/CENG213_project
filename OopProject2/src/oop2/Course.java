package oop2;



public class Course {
	
	private String name;
	private int credit;
	private String courseType;
	private String lecturCode;

	//We have variables type of Area and Lecturer class
	private Area areaCourse;
	private Lecturer lecturerCourse;

	//We keep students that take course on array
	private String students[] = new String[200];
	

	public Course(String name, int credit,  String courseType,String lecturCode) {
		super();
		this.name = name;
		this.credit = credit;
		this.courseType = courseType;
		this.lecturCode = lecturCode;
	}

	//Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getLecturCode() {
		return lecturCode;
	}

	public void setLecturCode(String lecturCode) {
		this.lecturCode = lecturCode;
	}
	
	
	
	public Area getAreaCourse() {
		return areaCourse;
	}

	public void setAreaCourse(Area areaCourse) {
		this.areaCourse = areaCourse;
	}

	public Lecturer getLecturerCourse() {
		return lecturerCourse;
	}

	public void setLecturerCourse(Lecturer lecturerCourse) {
		this.lecturerCourse = lecturerCourse;
	}

	public String[] getStudents() {
		return students;
	}

	public void setStudents(String[] students) {
		this.students = students;
	}



	//Method that print studentIds of taken course
	public void getStudentsId() {
		
		System.out.print("[");
		for (int i = 0; i < students.length; i++) {
			if(students[i]!=null) {
				System.out.print(students[i] + " , ");
	
			}
			
		}
		System.out.println("]");
		
	}



	//Method that add student's Id to course, this method use by StudentAffairs
	public void addStudent(String ID) {
		 for(int i = 0 ; i < students.length; i++){
			 
				 if ( students[i] !=  null  ){
					 
		                if(students[i] == ID) {
		                	System.out.println("This Student already exists");
		                }
		        
		            }
		            else if(students[i] == null){
		            	
		                students[i] = ID;
		                return;
		                
		            }
			 }       
		}	
}
