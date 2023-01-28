package oop2;



public class Secratery extends Staff{

	
	public Secratery(String nationalIdentity, String workingHours, String name,String taskInformation) {
		super(nationalIdentity, workingHours, name,taskInformation);
		
	}


	//Method that add lecturer to the course
	public void addLecturerToTheCourse(Lecturer lecturer,Course course) {
	
			if (course.getLecturerCourse() == null) {
					course.setLecturerCourse(lecturer);
					lecturer.addCourse(course);
			}
			else
			{
				System.out.println("Course already have Lecturer");
			}
		
	}

	//Method that add class to the course
	public void addClassToTheCourse(Course course,Area area) {
		
	
			if (course.getAreaCourse()== null) {
					course.setAreaCourse(area);
					area.addAreaToCourse(course);
			}
			else
			{
				System.out.println("Course already have Class");
			}
			
		
	}

	//Method that change lecturer of the course
	public void changeLecturerOfTheCourses(Lecturer lecturer,Course course) {
		
			if (course.getLecturerCourse()!= null ) {
					course.getLecturerCourse().deleteCourse(course);
					course.setLecturerCourse(lecturer);
					lecturer.addCourse(course);
			}
			else
			{
				System.out.println("Course doesn't have lecturer yet");
			}	
	}
}
