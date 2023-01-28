package oop2;

public class StudentAffairs extends Staff{

	public StudentAffairs(String nationalIdentity, String workingHours, String name,String taskInformation) {
		super(nationalIdentity, workingHours, name,taskInformation);
		
	}

	//Method that add course to student
	public void addCourseToStudent(Students student ,Course course)
	{
		student.addCourse(course);
		course.addStudent(student.getNationalIdentity());
	}

	//Method that check is student can take course
	public void isStudentCanTakeCourse(Students student, Course course) {
		for(int i = 0;i<student.getTakenCourses().length;i++)
		{
			if (course == student.getTakenCourses()[i] && student.getType() == course.getCourseType()) {
				System.out.println("STUDENT ALREADY TAKING THIS COURSE");
			} else {
				System.out.println("STUDENT CAN'T TAKE THIS COURSE");
				return;
			}
		}
	}

}
