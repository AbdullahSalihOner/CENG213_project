package oop2;

//We made abstract because of we don't create object directly from this class
public abstract class Staff {
	
		private String nationalIdentity;
		private String workingHours;	//(Night shift and Regular shift)
		private String name;
		private String taskInformation;
		
		
		public Staff(String nationalIdentity,  String workingHours,String name,String taskInformation) {
			super();
			this.nationalIdentity = nationalIdentity;
			this.workingHours = workingHours;
			this.name = name;
			this.taskInformation = taskInformation;
		}

		//Getter and setters
		public String getNationalIdentity() {
			return nationalIdentity;
		}

		public void setNationalIdentity(String nationalIdentity) {
			this.nationalIdentity = nationalIdentity;
		}


		public String getWorkingHours() {
			return workingHours;
		}

		public void setWorkingHours(String workingHours) {
			this.workingHours = workingHours;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTaskInformation() {
			return taskInformation;
		}

		public void setTaskInformation(String taskInformation) {
			this.taskInformation = taskInformation;
		}

		

	
}
