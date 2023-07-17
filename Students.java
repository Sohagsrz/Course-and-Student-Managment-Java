class Students{
	private int id, totalCreditTook, totalNeed;
	private String name;
	int courses[];

	public void setId(int i){
		this.id = i;
	}
	public int getId(){
		return id;
	}

	public void setTotalCreditTook(int i){
		this.totalCreditTook = i;
	}
	public int getTotalCreditTook(){
		return totalCreditTook;
	}


	public void setTotalNeed(int i){
		this.totalNeed = i;
	}

	public int getTotalNeed(){
		return totalNeed;
	}
 

	public void setName(String n){
		this.name = n;
	}

	public String getName(){
		return name;
	}


	public void setCourses(int[] c){
		this.courses = c;
	}

	public int[] getCourses(){
		return courses;
	}


}