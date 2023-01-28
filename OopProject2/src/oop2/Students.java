package oop2;



public class Students {

	//Students  information  variables
	private final String nationalIdentity;
	private String name;
	private int startYear;
	private String type; // "undergraduate" ,  "master" , "doctorate" are our student types
	private double lastGrade;

	//Students all taken course array
	private Course[] takenCourses = new Course[50];
	//Students taken courses's grades array
	private int gradesCourse[] = new int[50] ;
	//Array that keep the credits of graded courses
	private int gradedCourseCredits[] = new int[50];
	
	
	//Constructor for master and doctorate students registration
	public Students(String nationalIdentity, String name, int startYear, String type,double lastGrade) {
		super();
		this.nationalIdentity = nationalIdentity;
		this.name = name;
		this.startYear = startYear;
		this.type = type;
		this.lastGrade = lastGrade;
	}

	//Constructor for undergraduate students registration
	public Students(String nationalIdentity, String name, int startYear) {
		super();
		this.nationalIdentity = nationalIdentity;
		this.name = name;
		this.startYear = startYear;
		this.type ="undergraduate";
	}

	//Getters and setters of variables
	public String getNationalIdentity() {
		return nationalIdentity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getLastGrade() {
		return lastGrade;
	}

	public void setLastGrade(double lastGrade) {
		this.lastGrade = lastGrade;
	}


	public Course[] getTakenCourses() {
		return takenCourses;
	}

	public void setTakenCourses(Course[] takenCourses) {
		this.takenCourses = takenCourses;
	}


	//Function that print all taken courses
	public void getAllTakenCourses() {
		System.out.println(this.name + "'s taken courses ; ");
		System.out.print("[");
		for (int i = 0; i < takenCourses.length; i++) {
			if(takenCourses[i]!=null) {
				System.out.print(takenCourses[i].getName() + " , ");

			}

		}
		System.out.println("]");
	}

	//Function that print taken courses's credits
	public void getGradedCourseCredit() {
		System.out.println(this.name + "'s credits ; ");
		System.out.print("[");
		for(int i=0;i<gradedCourseCredits.length;i++) {
			if (gradedCourseCredits[i]!= 0) {
				System.out.print(takenCourses[i].getName()+" 's credit : "+gradedCourseCredits[i]+" , ");
			}
		}
		System.out.println("]");
	}

	//Function that print taken courses's grades
	public void getGradesCourse() {
		System.out.println(this.name + "'s grades ; ");
		System.out.print("[");
		for(int i=0;i<gradesCourse.length;i++) {
			if (gradesCourse[i]!= 0) {
				System.out.print(gradesCourse[i]+" , ");
			}
		}
		System.out.println("]");
	}

	public void setGradesCourse(int[] gradesCourse) {
		this.gradesCourse = gradesCourse;
	}

	//Function that add course to takenCourse array, also this method use by StudentAffairs
	public void addCourse(Course course) {
		 for(int i = 0 ; i < takenCourses.length; i++){

			 //Program check is match student type and course type
			 if(this.getType() == course.getCourseType()) {
				 
				 if ( takenCourses[i] !=  null  ){
					 	//Is this Course  already exist
		                if(takenCourses[i].getName() == course.getName()) {
		                	System.out.println("This Course already exists");
		                	return;
		                }
		        
		            }
		            else if(takenCourses[i] == null){
		            	
		                takenCourses[i] = course;
		                return;
		                
		            }
				 
			 }
			 else
			 {
				 System.out.println("Student can't take this course");
				 return;
			 }          
	     }
	}

	//Function that add point and credit of the selected course  to  arrays
	public void givePoint(Course course, int point) {

		for (int i = 0; i < takenCourses.length; i++) {

			if ( takenCourses[i] !=  null  ){

                if(takenCourses[i].getName() == course.getName()) {
                	gradesCourse[i] = point;
                	gradedCourseCredits[i] =course.getCredit();
                	return;
                }
                
			}
			
		}
			System.out.printf("Stundent %s  does not take this course can't get a grade \n",course.getName());	
	}
	

	//Function that counts course numbers and this method use for GPA calculations
	public int takenCourseNumber()
	{
		int counter = 0;
		for (int i = 0; i < takenCourses.length; i++) {
			if (takenCourses[i]!=null) {
				counter++;
			}
		}
		System.out.println(this.name +"'s course count :" +counter);
		return counter;
		
	}
	
	
	//Function that calculate GPA of students
	public double calculateGPA() {
		
		double GPA = 0 ;
		double total=0;
		double totalCredits = 0 ;
		
		for (int i = 0; i < gradedCourseCredits.length; i++) {
			totalCredits += gradedCourseCredits[i];
		}
		
		for(int i=0;i<gradesCourse.length;i++) {
			
			if (gradesCourse[i]!= 0) {
				if(gradesCourse[i]>89) {
					total += (4 * gradedCourseCredits[i] );
				}
				else if(gradesCourse[i]>79) 
				{
					total += (3.5 * gradedCourseCredits[i] );
				}
				else if(gradesCourse[i]>69) 
				{
					total += (3 * gradedCourseCredits[i] );
				}
				else if(gradesCourse[i]>59) 
				{
					total += (2.5 * gradedCourseCredits[i] );
				}
				else if(gradesCourse[i]>49) 
				{
					total += (2 * gradedCourseCredits[i] );
				}
				else
				{
					total += (0 * gradedCourseCredits[i] );
				}
			}
		}
		
		GPA = total/totalCredits;
		System.out.println(this.name + "'s total credit " +totalCredits);
		System.out.println(this.name + "'s GPA : " + GPA);
		
		return GPA;
		
		
	}
	
	
	//Method that use for check student can graduate or not, this method use by Lecturer class
	public String isStudentCanGraduate() {
		
		boolean isGraduate = false;
		
		if(this.type == "undergraduate")
		{
			
			if (calculateGPA() >= 2.0 && takenCourseNumber() >= 40) { // DENEME ICIN 2 YAPTIM NORMALDE 40
				
				isGraduate = true;
				System.out.println("GRADUATED");
				
				
			}else {
				
				System.out.println("STUDENT DOES NOT MEET THE REQUIREMENTS TO GRADUATE");
				
			}
			
		}
		else if(this.type == "master")
		{
			if (calculateGPA() >= 2.5 && takenCourseNumber() >= 7) {
				
				System.out.println("GRADUATED");
				isGraduate = true;
			}
			else {
				System.out.println("STUDENT DOES NOT MEET THE REQUIREMENTS TO GRADUATE");		
			}		
		}
		else if (this.type == "doctoral") 
		{
			if (calculateGPA() >= 3.0 && takenCourseNumber() >= 8) {
				
				System.out.println("GRADUATED");
				isGraduate = true;
			}
			else {
				
				System.out.println("STUDENT DOES NOT MEET THE REQUIREMENTS TO GRADUATE");	
			}
		}	
		return (isGraduate) ? "GRADUATED" : "CAN'T GRADUATE";	
	}
}
