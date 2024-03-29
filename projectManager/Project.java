<<<<<<< HEAD
// Project class initializes project objects  

=======
>>>>>>> 5e30e72 (Final project manager with javadoc)
package projectManager;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

<<<<<<< HEAD
=======
/**
 * Project class initializes objects that store information on each project.
 * 
 * @author Delroy Barnies
 * @see Project
 * @version 4.0 2022/06/02
 */
>>>>>>> 5e30e72 (Final project manager with javadoc)
public class Project{
	
	// attribute variables
	String name;
	int number;
	String buildingType;
	String address;
	int erf;
	float fee;
	float amountPaid;
	String deadline;
	
	private boolean finalized = false;
	private boolean completed = false;
	private boolean upToDate = true;
	
<<<<<<< HEAD
	// constructor initializes Project objects
=======
	/**
	 * sole constructor initializes Project objects
	 * 
	 * @param name          Name of the project, clients can be identified with their respective project names.
	 * @param number        The number of this project respective to all other projects. 
	 * @param buildingType  The type of building being made in this project, i.e. House, Flat, etc.
	 * @param address       The street address of the building.
	 * @param erf           ERF number. 
	 * @param fee           The total fee for the project.
	 * @param amountPaid    The total amount paid to date.
	 * @param deadline      The due date of the project.
	 */
>>>>>>> 5e30e72 (Final project manager with javadoc)
	public Project(String name, int number, String buildingType, String address, int erf
			    , float fee, float amountPaid, String deadline) {
		
		// attributes 
		this.name = name;
		this.number = number;
		this.buildingType = buildingType;
		this.address = address;
		this.erf = erf;
		this.fee = fee;
		this.amountPaid = amountPaid;
		this.deadline = deadline;
		
	}
<<<<<<< HEAD
	// method used for creating new project objects
=======
	/**
	 * Method used for creating new project objects
	 * 
	 * @return  A new project.
	 * @since   version 1.0
	 */
>>>>>>> 5e30e72 (Final project manager with javadoc)
    public static Project newProject() {
			
			System.out.print("\nEnter the project name:");
			Scanner input = new Scanner(System.in);
			String name = input.nextLine();
			
			System.out.print("\nEnter the project number:");
			Scanner input1 = new Scanner(System.in);
			
			// handles incorrect string input for int
			while (!(input1.hasNextInt())) {
			System.out.print("\nPlease refrain from using letters and/or symbols in your project number:");
				input1 = new Scanner(System.in);
			}
			int number = input1.nextInt();
			
			System.out.print("\nEnter the building type:");
			Scanner input2 = new Scanner(System.in);
			String buildingType = input2.nextLine();
			
			System.out.print("\nEnter the address:");
			Scanner input3 = new Scanner(System.in);
			String address = input3.nextLine();
			
			System.out.print("\nEnter the ERF number:");
			Scanner input4 = new Scanner(System.in);
			
			// handles incorrect string input for int
			while (!(input4.hasNextInt())) {
				System.out.print("\nPlease refrain from using letters and/or symbols in your ERF number:");
					input4 = new Scanner(System.in);
				}
			int erf = input4.nextInt();
			
			System.out.print("\nEnter the charging fee:");
			Scanner input5 = new Scanner(System.in).useLocale(Locale.US);
			
			// handles incorrect string input for float
			while (!(input5.hasNextFloat())) {
				System.out.print("\nPlease refrain from using letters and/or symbols in your charging fee:");
					input5 = new Scanner(System.in).useLocale(Locale.US);
			}
			float fee = input5.nextFloat();
				
			System.out.print("\nEnter the amount paid:");
			Scanner input6 = new Scanner(System.in).useLocale(Locale.US);
				
			// handles incorrect string input for float
			while (!(input6.hasNextFloat())) {
				System.out.print("\nPlease refrain from using letters and/or symbols in your amount paid:");
					input6 = new Scanner(System.in).useLocale(Locale.US);
			}
			float amountPaid = input6.nextFloat();
				
			System.out.print("\nEnter the deadline:");
			Scanner input7 = new Scanner(System.in);
			String deadline = input7.nextLine();
				
		    // takes user input and creates Project object
			Project thisProject = new Project(name, number, buildingType, address, erf, fee, amountPaid, deadline);
				
			System.out.println("\nNew Project has been added\n");
				
			// returns project
			return thisProject;
			
	}
<<<<<<< HEAD
    // method updates a projects due date
=======
    /**
     * Method updates a projects due date.
     *  
     * @param project  The project whose due date will be updated.
     * @return         The updated project.
     * @since          version 1.0
     */
>>>>>>> 5e30e72 (Final project manager with javadoc)
    public static Project dueDate(Project project) {
		
		System.out.print("Enter the new date:");
		Scanner input8 = new Scanner(System.in);
		String newdate = input8.nextLine();
		
		// updates the deadline based on the input due date
		project.deadline = newdate;
		
		System.out.println("\nDue date has been updated");
		
		// returns project
		return project;
		
	}
<<<<<<< HEAD
    // method updates a projects amount paid to date
=======
    /**
     * Method updates a projects amount paid to date.
     *  
     * @param project  The project whose amount paid to date will be updated.
     * @return         The updated project.
     * @since          version 1.0
     */
>>>>>>> 5e30e72 (Final project manager with javadoc)
    public static Project paidToDate(Project project) {
		
		System.out.print("Enter the new amount paid to date:");
		Scanner input9 = new Scanner(System.in).useLocale(Locale.US);
		
		// handles incorrect string input for float
 		while (!(input9.hasNextFloat())) {
			System.out.print("\nPlease refrain from using letters and/or symbols in your amount paid:");
				input9 = new Scanner(System.in).useLocale(Locale.US);
			}
		float newAmount = input9.nextFloat();
		
		// updates amount paid to date based on user input
		project.amountPaid = newAmount;
		
		System.out.println("\nAmount paid to date has been updated");
		
		// returns project
		return project;
		
	}
<<<<<<< HEAD
    // returns a list of completed projects
=======
    /**
     * Displays a list of completed projects.
     *  
     * @param projects  ArrayList of projects, completed projects in the ArrayList will be printed.
     * @since           version 3.0
     */
>>>>>>> 5e30e72 (Final project manager with javadoc)
    public static void completedList(ArrayList<Project> projects) {
    	
    	System.out.print("\nCompleted Projects: ");
    	
    	// project name is printed if the project.completed boolean is true
    	for (Project project : projects) {
    		if (project.completed == true) {
    			System.out.print(project.name + ", ");	
    		}
    	}
    }
<<<<<<< HEAD
    // returns a list of overdue projects
=======
    /**
     * Returns a list of overdue projects.
     *  
     * @param projects  ArrayList of projects, overdue projects in the ArrayList will be printed.
     * @since version 3.0
     */
>>>>>>> 5e30e72 (Final project manager with javadoc)
    public static void isUpToDate(ArrayList<Project> projects) {
    	
    	System.out.print("\nOverdue Projects: ");
    	
    	// project name is printed if the project.upToDate boolean is false
    	for (Project project : projects) {
    		if (project.upToDate == false) {
    			System.out.print(project.name + ", ");	
    		}
    	}
    }
<<<<<<< HEAD
    // returns a selected projects details in an easily readable manner as a string
=======
    /**
     * Returns a selected projects details in an easily readable manner as a string.
     * 
     * @param projects  ArrayList of project objects.
     * @return          Details of the selected project object from the ArrayList as a string.
	 * @since           version 3.0 
     */
>>>>>>> 5e30e72 (Final project manager with javadoc)
    public static String displayProject(ArrayList<Project> projects) {
    	
    	System.out.print("\nEnter the project name:");
		Scanner input18 = new Scanner(System.in);
		String name = input18.nextLine();
		
		String details = "";
		
		// iterates through every project in the ArrayList until the project.name matches the input name
		for (Project project : projects) {
			if (project.name.equals(name)) {
				
				      details = ("\n\nproject:               "+ project.name
						         + "\nproject number:        "+project.number 
						         + "\nbuildingType:          "+project.buildingType  
						         + "\naddress:               "+project.address 
						         + "\nERF:                   "+project.erf
						         + "\nfee:                   "+project.fee
						         + "\namount paid:           "+project.amountPaid
						         + "\ndue date:              "+project.deadline);				
			}
		}
		// returns string
        return details; 
    }
<<<<<<< HEAD
    // allows user to update any project objects details in an ArrayList 
=======
    /**
     * Allows user to update any project objects details in an ArrayList.
     * 
     * @param projects  ArrayList containing project objects to be updated.
     * @param people    if the project name is changed the project name will be changed for the corresponding client/person objects.  
     * @return          null
     * @since           version 3.0
     */
>>>>>>> 5e30e72 (Final project manager with javadoc)
    public static String updateProjects(ArrayList<Project> projects, ArrayList<Person> people) {
    	
    	System.out.print("\nEnter the project name:");
		Scanner input18 = new Scanner(System.in);
		String name = input18.nextLine();
		
		// iterates through every project in the ArrayList until the project.name matches the input name
		for (Project project : projects) {
			String option = "";
			
			if (name.equals(project.name)) {
	            
				// displays options, user inputs "e" to return to the main menu
				while (!(option.equals("ex"))) {
				
					Scanner input19 = new Scanner(System.in);
					System.out.print(  "\n\nWhat would you like to change? "
							         + "\nproject name        :pn"
							         + "\nproject number      :nu"
							         + "\nbuilding type       :bt"
							         + "\naddress             :a"
							         + "\nerf                 :e"
							         + "\nfee                 :f"
							         + "\namount paid         :ap"
							         + "\ndeadline            :d"
							         + "\nexit                :ex"
							         + "\nEnter your option here:");
					
					option = input19.next();
					option = option.toLowerCase();
					
					// loops for each time the user enters incorrectly
					while (!(option.equals("pn") || option.equals("nu")|| option.equals("bt") || option.equals("a") || option.equals("e") 
							|| option.equals("f") || option.equals("ap") || option.equals("ex") || option.equals("d"))) {
						
						input19 = new Scanner(System.in);
						System.out.print(  "\n\nWhat would you like to change? "
						         + "\nproject name        :pn"
						         + "\nproject number      :nu"
						         + "\nbuilding type       :bt"
						         + "\naddress             :a"
						         + "\nerf                 :e"
						         + "\nfee                 :f"
						         + "\namount paid         :ap"
						         + "\ndeadline            :d"
						         + "\nexit                :ex"
						         + "\nEnter your option here:");
						option = input19.next();
						option = option.toLowerCase();
					}	
					// updates the project.projectName
					if (option.equals("pn")) {
						
						System.out.print("\nEnter the new project name:");
						Scanner input = new Scanner(System.in);
						String name1 = input.nextLine();
						
						// updates the corresponding clients details to match the new project name
						for (Person person : people) {					
							if (person.projectName.equals(project.name)) {
								person.projectName = name1;
							}
						}
						project.name = name1;
					}
					// updates the project.number
					if (option.equals("nu")) {
						
						System.out.print("\nEnter the new project number:");
						Scanner input1 = new Scanner(System.in);
						
						// handles incorrect string input for int
						while (!(input1.hasNextInt())) {
						System.out.print("\nPlease refrain from using letters and/or symbols in your project number:");
							input1 = new Scanner(System.in);
						}
						int number = input1.nextInt();
						
						project.number = number;
						
					}
					// updates the project.buildingType
					if (option.equals("bt")) {
						
						System.out.print("\nEnter the new building type:");
						Scanner input2 = new Scanner(System.in);
						String buildingType = input2.nextLine();
						
						project.buildingType = buildingType;
					}
					// updates the project.address
					if (option.equals("a")) {
						
						System.out.print("\nEnter the new address:");
						Scanner input3 = new Scanner(System.in);
						String address = input3.nextLine();
						
						project.address = address;
						
					}
					// updates the project.erf
					if (option.equals("e")) {
						System.out.print("\nEnter the new ERF number:");
						Scanner input4 = new Scanner(System.in);
						
						// handles incorrect string input for int
						while (!(input4.hasNextInt())) {
							System.out.print("\nPlease refrain from using letters and/or symbols in your ERF number:");
								input4 = new Scanner(System.in);
							}
						int erf = input4.nextInt();
						
						project.erf = erf;
					}
					// updates the project.fee
					if (option.equals("f")) {
						
						System.out.print("\nEnter the new charging fee:");
						Scanner input5 = new Scanner(System.in).useLocale(Locale.US);
						
						// handles incorrect string input for float
						while (!(input5.hasNextFloat())) {
							System.out.print("\nPlease refrain from using letters and/or symbols in your charging fee:");
								input5 = new Scanner(System.in).useLocale(Locale.US);
						}
						float fee = input5.nextFloat();
						
						project.fee = fee;
					}
					// updates the project.amountPaid
					if (option.equals("ap")) {
						
						System.out.print("\nEnter the new amount paid:");
						Scanner input6 = new Scanner(System.in).useLocale(Locale.US);
							
						// handles incorrect string input for float
						while (!(input6.hasNextFloat())) {
							System.out.print("\nPlease refrain from using letters and/or symbols in your amount paid:");
								input6 = new Scanner(System.in).useLocale(Locale.US);
						}
						float amountPaid = input6.nextFloat();
						
						project.amountPaid = amountPaid;
					}
					// updates the project.deadline
					if (option.equals("d")) {
						
						System.out.print("\nEnter the new deadline:");
						Scanner input7 = new Scanner(System.in);
						String deadline = input7.nextLine();
						
						project.deadline = deadline;
					}
				}
			}
		}
		// returns to the main menu
		System.out.println("\nBack to main menu");
		return null;	
    }
<<<<<<< HEAD
    // sets upToDate as false
    public static void setDate(Project project) {
    	project.upToDate = false;
    }
    // sets finalized as true
    public static void setFinal(Project project) {
    	project.finalized = true;
    }
    // sets completed as true
    public static void setComplete(Project project) {
    	project.completed = true;
    }
    // returns project details as a string to be stored in a text file for easy extraction
    public static String projectToString(Project project) {
    	
		String string = project.name+", "+project.number+", "+project.buildingType+", "+project.address+", "+project.erf+", "+
				project.fee+", "+project.amountPaid+", "+project.deadline;
		
		// adds a ", completed" to the string if the project is complete
		if (project.completed == true) {
			string = string + ", " + "completed";
		}
		// adds a ", upToDate" to the string if the project is uptoDate
		if (project.upToDate == true) {
			string = string + ", " + "upToDate";
		}
		// adds a ", finalized" to the string if the project is finalized
		if (project.finalized == true) {
			string = string + ", " + "finalized";
		}
		// returns the string
		return string;
		       
=======
    /**
     * Sets project as overdue.
     *  
     * @param project  Project objects upToDate parameter will be set to false.
     * @since          version 3.0
     */
    public static void setDate(Project project) {
    	project.upToDate = false;
    }
    /**
     * Checks if project is up to date.
     *  
     * @param project  Project object.
     * @since          version 4.0
     */
    public static boolean getDate(Project project) {
    	if (project.upToDate == true) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    /**
     * Sets project as finalized.
     *  
     * @param project  Project objects finalized parameter will be set to true.
     * @since          version 3.0
     */
    public static void setFinal(Project project) {
    	project.finalized = true;
    }
    /**
     * Checks if project has been finalized.
     *  
     * @param project  Project object.
     * @since          version 4.0
     */
    public static boolean getFinal(Project project) {
    	if (project.finalized == true) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    /**
     * Sets project as complete.
     *  
     * @param project  Project objects completed parameter will be set to true.
     * @since          version 3.0
     */
    public static void setComplete(Project project) {
    	project.completed = true;
    }
    /**
     * Checks if project is completed.
     *  
     * @param project  Project object.
     * @since          version 4.0
     */
    public static boolean getComplete(Project project) {
    	if (project.completed == true) {
    		return true;
    	}
    	else {
    		return false;
    	}
>>>>>>> 5e30e72 (Final project manager with javadoc)
    }
}