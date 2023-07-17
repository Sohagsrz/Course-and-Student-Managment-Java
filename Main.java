import java.util.Scanner;

public class Main{

	public static int coursesSize, studentSize;
	public static Courses[] courses;
	public static Students[] students;
	public static Scanner input;
	public static void showCourses() {

		System.out.println("\n--- Course List Are below --- \n");
		for(int i=0; i < courses.length ;i++){ 
			System.out.println((i+1) + ". "+ courses[i].getCourseName() + " [ID: "+courses[i].getCourseId() + "] "  + " [credit: "+courses[i].getTotalCredit() + "] ");
		}

		System.out.println("\n");


		showOptionsForCourseManage();
	}

	public static void modifyCourse() {

		System.out.println("\n --- Courses  ---\n ");
		for(int i=0; i < courses.length ;i++){ 
			System.out.println((i+1) + ". "+ courses[i].getCourseName() + " [ID: "+courses[i].getCourseId() + "] "  + " [credit: "+courses[i].getTotalCredit() + "] ");
		}


		System.out.print("Enter The Number to edit that Course: ");
		int courseIndex= input.nextInt();
		courseIndex = courseIndex -1;
		if(courses.length < courseIndex ||  courses[courseIndex] == null){
			System.out.println("!!!You entered a wrong number! please use correct position to modify!!!");
			modifyCourse();
		}

		// exists 
		 input.nextLine();
			System.out.print("New Name The Course (" + courses[courseIndex].getCourseName() +") : ");

			String courseName = input.nextLine();
			courses[courseIndex].setCourseName(courseName);


			System.out.print("Enter The New Course ID (" + courses[courseIndex].getCourseName() +"): ");

			int courseId = input.nextInt();
			courses[courseIndex].setCourseId(courseId);

			System.out.print("Enter Total Available Credit of \""+ courses[courseIndex].getCourseName() +"\" course : ");

			int totalCredit = input.nextInt();
			courses[courseIndex].setTotalCredit(totalCredit);

			System.out.print("Enter Per Student Credit 3/2: ");
			int perCredit = input.nextInt();
			courses[courseIndex].setTotalCreditTook(perCredit);


			System.out.print("Successfully Updated! New datas are below! ");
			courses[courseIndex].show();

			// fix issue for auto new line
			input.nextLine();
			showOptionsForCourseManage();
	}


	public static int totalCreditLeft() {
			if(courses.length <=0 ){
				return 0;
			}
			// the looop
			int dTotal =0;

			for(int i=0; i < courses.length ;i++){ 
				dTotal +=  courses[i].getLeftCredit();
			}
			return dTotal;

		}

	public static int totalCreditTook() {
		if(courses.length <=0 ){
			return 0;
		}
		// the looop
		int dTotal =0;

		for(int i=0; i < courses.length ;i++){ 
			dTotal +=  courses[i].getTotalUsed();
		}
		return dTotal;

	}

 


	public static void addStudents() {


		// Courses
		System.out.print("How Many Students Do You want to add? :  ");
		studentSize= input.nextInt();
		// fix issue for auto new line
		input.nextLine();
		students = new Students[studentSize];
		int[] courseForThisStudent= new int[coursesSize];

		for (int i=0; i < studentSize; i++) {

			students[i] = new Students();
			System.out.print("Enter The Student Name: ");

			String name = input.nextLine();
			students[i].setName(name);

			System.out.print("Enter The Student ID: ");

			int studentId = input.nextInt();

			students[i].setId(studentId); 
			input.nextLine();

			System.out.println("\n ---Take Courses  ---\n ");
		for(int j=0; j < courses.length ;j++){
			System.out.print("Want to add \""+courses[j].getCourseName()+"\" this course ? y/n: ");
			char option= input.nextLine().charAt(0); 
			if(option =='y'){
				courseForThisStudent[j]= courses[j].getCourseId();
				// update total used
				courses[j].setTotalUsed(courses[j].getTotalUsed() +  courses[j].getPerCourseCredit());


				// update left
				courses[j].setTotalUsed(courses[j].getTotalCredit() -  courses[j].getTotalUsed());

			}else{
				continue;
			}

		}
		students[i].setCourses(courseForThisStudent); 
  
		}

			input.nextLine();

		studentSummary();
	}
	public static void modifyStudent() {


		System.out.println("\n --- Students  ---\n ");
		for(int i=0; i < students.length ;i++){ 
			System.out.println((i+1) + ". "+ students[i].getName() + " [ID: "+students[i].getId() + "] " );
		}

		System.out.print("Enter The Number to edit that student: ");
		int courseIndex= input.nextInt();
		courseIndex = courseIndex -1;
		if(students.length < courseIndex ||  students[courseIndex] == null){
			System.out.println("!!!You entered a wrong number! please use correct position to modify!!!");
			modifyCourse();
		}

		System.out.print("Enter The New Student Name "+ students[courseIndex].getName()  +": ");

			String name = input.nextLine();
			students[courseIndex].setName(name);

			System.out.print("Enter The New Student ID: ");

			int studentId = input.nextInt();

			students[courseIndex].setId(studentId); 
			input.nextLine();

		int[] courseForThisStudent= new int[coursesSize];

			System.out.println("\n ---Take Courses  ---\n ");
		for(int j=0; j < courses.length ;j++){
			System.out.print("Want to add \""+courses[j].getCourseName()+"\" this course ? y/n: ");
			char option= input.nextLine().charAt(0); 
			if(option =='y'){
				courseForThisStudent[j]= courses[j].getCourseId();
				// update total used
				courses[j].setTotalUsed(courses[j].getTotalUsed() +  courses[j].getPerCourseCredit());


				// update left
				courses[j].setTotalUsed(courses[j].getTotalCredit() -  courses[j].getTotalUsed());

			}else{
				continue;
			}

		}
		students[courseIndex].setCourses(courseForThisStudent); 

   
			System.out.print("Successfully Updated! New datas are below! ");

			studentSummary();

	}
	public static void studentSummary() {

		System.out.println("1. Modify a Student");
		System.out.println("2. Statistics");
		System.out.println("3. Course Page");
		System.out.print("Enter Your Option(1,2,3): ");

		int userSelectedOption= input.nextInt();

		switch(userSelectedOption){
		case 1:
			modifyStudent();
			break;
		case 2: 

				if(students ==null || students.length <= 0 ){
					System.out.println("There is no students, Please register students first!");
					addStudents(); break;
				}

				System.out.println("\n\nThere is " + students.length+" Students, \nTotal Credit took: "+ totalCreditTook());
				System.out.println("Total Credit Left: "+ totalCreditLeft()+" \n");


			break;

		case 3:
			showOptionsForCourseManage();
			break;

		default:
			System.out.println("!!!Please Enter the right option!!!");
			studentSummary();
		} 



	}
	public static void showOptionsForCourseManage() {

		System.out.println("1. Check The Courses");
		System.out.println("2. Modify A Course");
		System.out.println("3. Students Summary");
		System.out.print("Enter Your Option(1,2,3): ");
		int userSelectedOption= input.nextInt();

		switch(userSelectedOption){
		case 1:
			showCourses();
			break;
		case 2: 
			modifyCourse();
			break;
		case 3:

				if(students ==null || students.length <= 0 ){
					System.out.println("There is no students, Please register students first!");
					addStudents(); break;
				}

				System.out.println("\n\nThere is " + students.length+" Students, \nTotal Credit took: "+ totalCreditTook());
				System.out.println("Total Credit Left: "+ totalCreditLeft()+" \n");


			studentSummary();

			break;
		default:
			System.out.println("!!!Please Enter the right option!!!");
			showOptionsForCourseManage();
		} 
	}
	public static void main(String[] args) {
		  input = new Scanner(System.in);
		
		// Courses
		System.out.print("How Many Courses You want to add? :  ");
		coursesSize= input.nextInt();
		// fix issue for auto new line
		input.nextLine();
		courses = new Courses[coursesSize];
		for (int i=0; i < coursesSize; i++) {

			courses[i] = new Courses();

			System.out.print("Enter The Course Name: ");

			String courseName = input.nextLine();
			courses[i].setCourseName(courseName);


			System.out.print("Enter The Course ID: ");

			int courseId = input.nextInt();
			courses[i].setCourseId(courseId);

			System.out.print("Enter Total Available Credit of \""+ courseName +"\" course : ");

			int totalCredit = input.nextInt();
			courses[i].setTotalCredit(totalCredit);


			System.out.print("Enter Per Student Credit 3/2: ");
			int perCredit = input.nextInt();
			courses[i].setTotalCreditTook(perCredit);
 
			courses[i].show();
			// fix issue for auto new line
			input.nextLine();
		}

		showOptionsForCourseManage();

 
	}

}