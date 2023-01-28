package oop2;



public class Area {
	
	private String name;
	private String type; //lectureOffice , class , canteen , garden , cafe

	//Array of courses that have area
	private Course[] courseArea = new Course[250];


	public Area(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	//Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

	//Method that check the area is avaliable
	public void isAvaliable() {
		for(int i = 0 ; i < courseArea.length ; i++)
		{
			if(courseArea[i].getAreaCourse() == this)
			{
				System.out.println("A COURSE CANNOT BE ASSIGNED TO THE CLASS, IT HAS BEEN ASSIGNED BEFORE");
				return;
			}
		}
	}

	//Method that add area to course,  and this method use by secretary class
	public void addAreaToCourse(Course course) {
		for (int i = 0; i < courseArea.length; i++) {
			if(courseArea[i]==null) 
			{
				courseArea[i] = course;
				return;
			}
			
			
		}
	}
}


