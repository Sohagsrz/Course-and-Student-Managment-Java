class Courses{
	private int courseId, totalCredit, totalUsed , leftCredit, perCourseCredit;
	private String courseName;

	public void setCourseId(int i){
		this.courseId = i;
	}
	public int getCourseId(){
		return courseId;
	}

	public void setPerCourseCredit(int i){
		this.perCourseCredit = i;
	}
	
	public int getPerCourseCredit(){
		return perCourseCredit;
	}


	public void setTotalCredit(int i){
		this.totalCredit = i;
	}
	public int getTotalCredit(){
		return totalCredit;
	}


	public void setTotalUsed(int i){
		this.totalUsed = i;
	}

	public int getTotalUsed(){
		return totalUsed;
	}

	public void setLeftCredit(int i){
		this.leftCredit = i;
	}

	public int getLeftCredit(){
		return leftCredit;
	}


	public void setCourseName(String n){
		this.courseName = n;
	}

	public int getTotalCreditTook(){
		return this.perCourseCredit ;
	}

	public void setTotalCreditTook(int n){
		this.perCourseCredit = n;
	}

	 

	public String getCourseName(){
		return courseName;
	}
	public void show(){
		System.out.println("Course Name: "+ courseName);
		System.out.println("Course Total Credit: "+ totalCredit);
		System.out.println("Credit Used : "+ totalUsed);
		System.out.println("Credit left : "+ leftCredit);
	}


}