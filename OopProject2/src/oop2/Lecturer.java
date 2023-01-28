package oop2;



public class Lecturer {

	private String nationalIdentity;
	private String name;
	private String status; //We have two type of status : "HeadOfDepartment" and "Normal"

	//Array that have given courses of lecturer
	private Course[] givenCourses ;
	private static final int MAX_COURSES = 10;
	
	
	public Lecturer(String nationalIdentity, String name, String status) {
		super();
		this.nationalIdentity = nationalIdentity;
		this.name = name;
		this.givenCourses = new Course[MAX_COURSES];
		this.status = status;
	
	}

	//Getters and setters
	public String getNationalIdentity() {
		return nationalIdentity;
	}

	public void setNationalIdentity(String nationalIdentity) {
		this.nationalIdentity = nationalIdentity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course[] getGivenCourses() {
		
		
		return givenCourses;
	}

	public void setGivenCourses(Course[] givenCourses) {
		this.givenCourses = givenCourses;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	


	//Method that add course to givenCourses array,this method use by secretary class
	public void addCourse(Course course) {

		for (int i = 0; i < givenCourses.length; i++) {

			if (givenCourses[i]==null) {
				givenCourses[i] = course;
				return;
			}

			else if (givenCourses[i].getName() == course.getName()){
				System.out.println("Course avaliable");
				return;
			}

		}
		System.out.println("Max courses taken");
	}
	

	//Method that delete course from givenCourses array,this method use by secretary class 
	public void deleteCourse(Course course) {
		for (int i = 0; i < givenCourses.length; i++) {
			if (givenCourses[i]!=null && course.getName() == givenCourses[i].getName()) {
				givenCourses[i] = course;
				return;
			}
			else if (givenCourses[i].getName() == course.getName()){
				System.out.println("This course is not avaliable");
				return;
			}
		}
	}

	//Method that print all given courses's name and count of courses
	public void getCourses() {
		System.out.println(name + "Courses that lecturer give ; ");
		System.out.print("[ ");
		int counter = 0;
		for (int i = 0; i < givenCourses.length; i++) {
			
			Course course = givenCourses[i];
			if (givenCourses[i]!=null) {
				counter++;
				System.out.print(course.getName() + " , ");
				
			}
		}
		System.out.println("]");
		System.out.println("Number of courses Given by the Lecturer : " + counter);
	}
	
	
	
	//Method that check graduation status of student and give certificate
	public void giveGraduateCertificate(Students student) {
		
		if (student.isStudentCanGraduate() == "GRADUATED" ) {

			//just HeadOfDepartment can give certificate
			if(this.status == "HeadOfDepartment") 
			{
				System.out.println("Garduate Certificate Given");
			}
			else
			{
				System.out.println("Just Head of Department can give certificate");
			}
		} 	
	}
	
	//Method that add grade to students, also method use givePoint method of student class
	  public void addGrade(Course course ,Students student,int point) throws Exception {
		  
		  	for (int i = 0; i < givenCourses.length; i++) {
				
		  		if (givenCourses[i]  != null) {
					if(givenCourses[i].getName() == course.getName())
					{
						student.givePoint(course, point);
						return;
					}
					
				}
		  		//Throws exception if lecturer is not giving that course
		  		else {
		  			throw new Exception("The lecturer is not giving this course");
		  		}
		  		
			}		
		}
	}
	 
	
	
	

