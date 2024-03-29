<<<<<<< HEAD
// this program creates,stores and manages structural engineering projects  

package projectManager;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

// defines the class
public class ProjectManager {
	
	// main method mainly deals with the user interface
	public static void main(String[] args) {
=======
/** 
 * This program creates,stores and manages structural engineering project records records from a MYSQL database called PoisePMS 
 * through JDBC.   
 * <p>
 * @author  Delroy Barnies
 * @version 4.0 2022/06/02
*/
package projectManager;

import java.util.Scanner;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *  This class houses the main method 
 *     
 *  @see   ProjectManager
 *  @since version 1.0
 */
public class ProjectManager {
	
	/**
	 * Main method mainly deals with the user options and interface.
	 * 
	 * @param args   User options and interface.
	 * @throws SQLException 
	 * @since        version 1.0
	 */
	public static void main(String[] args) throws SQLException {
>>>>>>> 5e30e72 (Final project manager with javadoc)
		
		// projects ArrayList contains all Project objects
	    ArrayList<Project> projects = new ArrayList<>();
	    
	    // returns all stored project objects
	    projects = getProjects(projects);
	    
	    // people ArrayList contains all Person objects
	    ArrayList<Person> people = new ArrayList<>();
	    
	    // returns all stored person objects
	    people = getPeople(people);
	
	    String option = "";
	    
	    // if user enters the "e" option the program is exited  
		while (!option.equals("e")) {
		   
			// user types the letters dealing with the corresponding option
		    System.out.print("\n\nPlease choose an option below\n"
			    		+ "\nnew projects                        : np"
		    		    + "\ndisplay project                     : dp"
			    		+ "\ndisplay clients                     : dc"
			    		+ "\nupdate due date                     : dd"
			    		+ "\nupdate total amount paid            : ap"
			    		+ "\nupdate contractors contact details  : cd"
			    		+ "\nupdate project details              : up"
			    		+ "\nupdate clients details              : uc"
			    		+ "\ncompleted projects                  : cp"
			    		+ "\noverdue projects                    : op"
			    		+ "\nmark as complete                    : m"
			    		+ "\nfinalize                            : f"
			    		+ "\nexit                                : e"
			    		+ "\n\nEnter your option here:");
			Scanner input1 = new Scanner(System.in);
			option = input1.next();
			option = option.toLowerCase();
			
			// while loop iterates for every time the user enters an invalid option
			while (!(option.equals("np") || option.equals("dd")|| option.equals("ap") || option.equals("cd") || option.equals("f") 
					|| option.equals("e") || option.equals("m") || option.equals("cp") || option.equals("op") || option.equals("up")
					|| option.equals("dp") || option.equals("uc") || option.equals("dc"))) {
				
				input1 = new Scanner(System.in);
				System.out.print("Please enter a valid option!! \n\n"
						+ "\nPlease choose an option below\n"
			    		+ "\nnew projects                        : np"
			    		+ "\ndisplay project                     : dp"
			    		+ "\ndisplay clients                     : dc"
			    		+ "\nupdate due date                     : dd"
			    		+ "\nupdate total amount paid            : ap"
			    		+ "\nupdate contractors contact details  : cd"
			    		+ "\nupdate project details              : up"
			    		+ "\nupdate clients details              : uc"
			    		+ "\ncompleted projects                  : cp"
			    		+ "\noverdue projects                    : op"
			    		+ "\nmark as complete                    : m"
			    		+ "\nfinalize                            : f"
			    		+ "\nexit                                : e"
			    		+ "\n\nEnter your option here:");
				option = input1.next();
				option = option.toLowerCase();
			}
					
		    // creates new projects
		    if (option.equals("np")) {
		    	
		    	// adds the created project to the projects list
		    	projects.add(Project.newProject());
		    	
		    	System.out.print("\nEnter the project name:");
				Scanner input16 = new Scanner(System.in);
				String name = input16.nextLine();
				
				// adds the created people to the people list
		    	people.add(Person.newArchitect(name));
		    	people.add(Person.newContractor(name));
		    	people.add(Person.newCustomer(name));
		    	
		    }
		    // changes the due date of a project
		    if (option.equals("dd")) {
		    	
		    	System.out.print("\nEnter the project name:");
				Scanner input3 = new Scanner(System.in);
				String name = input3.nextLine();
				
				// iterates through every project to find the input project name 
				for (Project project : projects) {
				    if (name.equals(project.name)) {
				    	
				    	// changes the projects g=date
				    	Project.dueDate(project);
				    }
				    else {
				    	System.out.println("This project dosent exist");
				    }
				}
				
		    }
		    // updates the total amount paid to date
		    if (option.equals("ap")) {
		    	
		    	System.out.print("\nEnter the project name:");
				Scanner input3 = new Scanner(System.in);
				String name = input3.nextLine();
				
				// locates the correct project from projects list and changes the amount paid to date
				for (Project project : projects) {
				    if (name.equals(project.name)) {
				    	Project.paidToDate(project);
				    }
				    else {
				    	System.out.println("This project dosent exist");
				    }
				}
		    }
		    // updates contractors contact details
		    if (option.equals("cd")) {
		    	
		    	System.out.print("\nEnter the contractors name in full:");
				Scanner input3 = new Scanner(System.in);
				String name = input3.nextLine();
				
				// locates the correct contractor and updates their details 
				for (Person person : people) {
				    if (name.equals(person.name) && (person.position == "architect")) {
				    	Person.contractorsDetails(person);
				    }
				    else {
				    	System.out.println("This person dosent exist");
				    }
				}	
		    }
		    // finalizes project and exits the program
		    if (option.equals("f")) {
		    	
		    	System.out.print("\nEnter the project name:");
				Scanner input16 = new Scanner(System.in);
		        String projectName = input16.nextLine();
				
		        projectName = projectName.replace("\n", "");
		        
				System.out.print("\nEnter the customers name:");
				Scanner input17 = new Scanner(System.in);
				String customerName = input17.nextLine();
				
				customerName = customerName.replace("\n", "");
				
				// locates the correct project and customer based on user input from the projects and 
				// people lists, finalizes the project
				for (Person person : people) {
				    if (customerName.equals(person.name) && person.position.equals("customer")) {
				    	for (Project project : projects) {
						    if (projectName.equals(project.name)) {
<<<<<<< HEAD
						    	finalise(person, project);
						    	Project.setFinal(project);
=======
						    	finalize(person, project);
						    	Project.setFinal(project);
						    	completeProject(project);
>>>>>>> 5e30e72 (Final project manager with javadoc)
						    }
				        }
				    }
				}
				option = "e";
		    }
		    // mark selected projects as complete and project as up to date or not
		    if (option.equals("m")) {
		    	
		    	System.out.print("\nEnter the project name:");
				Scanner input3 = new Scanner(System.in);
				String name = input3.nextLine();
				
				System.out.print("\nHas this project passed its due date? (yes or no) :");
				Scanner input4 = new Scanner(System.in);
				String dueDate = input3.nextLine();
				
				dueDate.toLowerCase();
				
				// loops each time an invalid string is input
				while (!(dueDate.equals("yes") || dueDate.equals("no"))) {
					
					System.out.print("\nPlease choose a valid option\n");
					
					System.out.print("\nHas this project passed its due date? (yes or no) :");
					Scanner input5 = new Scanner(System.in);
					dueDate = input5.nextLine();
				}
				
				// locates the correct project from projects list and marks it as complete
				for (Project project : projects) {
				    if (name.equals(project.name)) {
<<<<<<< HEAD
				    	Project.setComplete(project);
				    	System.out.println("The project "+project.name+" has been marked as complete.");
				    	
				    	// if project is not up to date
				    	if (dueDate.equals("no")) {
				    		// the projects upToDate value is set to false
				    		Project.setDate(project);
				    	}
				    }	
				    else {
				    	System.out.println("This project dosent exist");
				    }
=======
				    	
				    	Project.setComplete(project);
				    	completeProject(project);
				    	
				    	// if project is not up to date
				        if (dueDate.equals("no")) {
				    	// the projects upToDate value is set to false
				    		Project.setDate(project);
				    	}
				    }	
>>>>>>> 5e30e72 (Final project manager with javadoc)
				}
		    }
		    // displays all completed projects
		    if (option.equals("cp")) {
		    	
		    	Project.completedList(projects);
<<<<<<< HEAD
		    	
=======
>>>>>>> 5e30e72 (Final project manager with javadoc)
		    }
		    // displays all overdue projects
            if (option.equals("op")) {
		    	
<<<<<<< HEAD
		    	Project.isUpToDate(projects);
		    	
=======
		    	Project.isUpToDate(projects);	
>>>>>>> 5e30e72 (Final project manager with javadoc)
		    }
            // allows the user to update any project in the ArrayList
            if (option.equals("up")) {
            	
            	Project.updateProjects(projects, people);
<<<<<<< HEAD
            		
=======
>>>>>>> 5e30e72 (Final project manager with javadoc)
            }
            // displays the selected project details in an easily readable manner
            if (option.equals("dp")) {
            	
            	System.out.print(Project.displayProject(projects));
            }
            // displays the selected persons details in an easily readable manner
            if (option.equals("dc")) {
            	
            	System.out.print(Person.displayPerson(people));
            }
            // allows the user to update any person in the ArrayList
            if (option.equals("uc")) {
            	
            	Person.updateClients(people);
<<<<<<< HEAD
            	
            }
            // updates files and exits the program
		    if (option.equals("e")) {
		    	
		    	// clears both projects.txt and clients.txt files
		    	clearFiles();
		    	
		    	// updates the cleared files with the new projects
=======
            }
            // updates database and exits the program
		    if (option.equals("e")) {
		    	
>>>>>>> 5e30e72 (Final project manager with javadoc)
		    	fileProjects(projects, people);
		    	
		    	System.out.println("Thank you!!!");
		    }	
	   }
	}
<<<<<<< HEAD
    // method finalizes the project and writes its details to the completedProjects.txt file 
    public static void finalise(Person customer, Project project) {
=======
	/**
	 * Method finalizes the project and displays an invoice to the user if need be.
	 *  
	 * @param customer  The person object to be finalized.
	 * @param project   The object to be finalized.
	 * @since           version 4.0
	 */ 
    public static void finalize(Person customer, Project project) {
>>>>>>> 5e30e72 (Final project manager with javadoc)
    	
    	// total unpaid value of the project is calculated
    	float totalUnpaid = project.fee - project.amountPaid;
    	
    	// if total unpaid returns 0 no invoice is created
    	if (totalUnpaid == 0) {
    		System.out.println("full fee has already been paid");
    	}
    	// else invoice is generated
    	else {
    	    System.out.println("\nINVOICE\n"
    			+ "name: " + customer.name + "\n"
    			+ "telephone number: " + customer.telephoneNum + "\n"
    			+ "email: " + customer.email + "\n"
    			+ "physical address: " + customer.physicalAddress + "\n"
    			+ "\n"
    			+ "amount unpaid: R" + totalUnpaid);    
        }
<<<<<<< HEAD
    	
    	// gets the currant date and time
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    	LocalDateTime now = LocalDateTime.now();  
    	
    	// try block writes project details to the completedProjects.txt file
    	try {
			
			String filepath = "C:\\Users\\delro\\eclipse-workspace\\rockPaperScissors\\src\\projectManager\\completedProjects.txt";
			FileWriter fw = new FileWriter(filepath, true);
			fw.write(  "\n\n"+project.name + " :"+"\n"
					 + "\nproject number:        "+project.number 
					 + "\nbuildingType:          "+project.buildingType  
					 + "\naddress:               "+project.address 
					 + "\nERF:                   "+project.erf
					 + "\namount unpaid:         "+totalUnpaid
					 + "\ncompletion date:       "+dtf.format(now));
			fw.close();
		}
		// catch block detects errors
		catch (Exception e) {
			System.out.println("error");
		}			
    			
    }
    // writes all projects and person info to the text files
    private static void fileProjects(ArrayList<Project> projects, ArrayList<Person> people) {
    	
    	for (Project project : projects) {
    		
    		// try block writes every project to the projects.txt file
    		try {
    			
				String filepath = "C:\\Users\\delro\\eclipse-workspace\\rockPaperScissors\\src\\projectManager\\projects.txt";
				FileWriter fw = new FileWriter(filepath, true);
				fw.write(Project.projectToString(project) + "\n");
				fw.close();
			}
			// catch block detects errors
			catch (Exception e) {
				System.out.println("error");
			}		
    	}
        for (Person person : people) {
    		
        	// try block writes every person to the clients.txt file
    		try {
				
				String filepath = "C:\\Users\\delro\\eclipse-workspace\\rockPaperScissors\\src\\projectManager\\clients.txt";
				FileWriter fw = new FileWriter(filepath, true);
				fw.write(Person.personToString(person) + "\n");
				fw.close();
			}
			// catch block detects errors
			catch (Exception e) {
				System.out.println("error");
			}		
    	}
    }
    // returns all projects stored in the projects.txt file as project objects in an ArrayList
    private static ArrayList<Project> getProjects(ArrayList<Project> projects) {
    	
    	try {
			// reads the projects.txt file of its contents
			File x = new File("C:\\Users\\delro\\eclipse-workspace\\rockPaperScissors\\src\\projectManager\\projects.txt");
			Scanner sc = new Scanner(x);
			
			// while loop iterates through each line in the project.txt file, splits the line and creates a project object 
			while (sc.hasNextLine()) {
				
				String project = sc.nextLine();
				String[] projectList;
				projectList = project.split(", ");
				
				String projectName = projectList[0];
				
				int number = Integer.parseInt(projectList[1]);
				
				String buildingType = projectList[2];
				
				String address = projectList[3];
				
				int erf = Integer.parseInt(projectList[4]); 
				
				float fee = Float.parseFloat(projectList[5]);
				
				float amount = Float.parseFloat(projectList[6]);
				
				String deadline = projectList[7];
				
				Project thisProject = new Project(projectName, number, buildingType, address, erf, fee, amount, deadline);
				
				ArrayList<String> checkList = new ArrayList<>(Arrays.asList(projectList));
				
				// checks if the project is upToDate
				if (checkList.contains("upToDate") == false) {
					Project.setDate(thisProject);
				}
				// checks if the project is completed
				if (checkList.contains("completed") == true) {
					Project.setComplete(thisProject);
				}
				// checks if the projects is finalized
				if (checkList.contains("finalized") == true) {
=======
    }
    /**
	 * Method takes a completed project and records its details in the completedProjects table in the database.
	 *  
	 * @param project   The project to be recorded.
	 * @since           version 4.0
	 */ 
    public static void completeProject(Project project) {
    	
    	// total unpaid value of the project is calculated
    	float totalUnpaid = project.fee - project.amountPaid;
    	
    	// gets the currant date and time
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    	LocalDateTime now = LocalDateTime.now(); 
    	String time = dtf.format(now);
    	
    	// try block records the projects details to the completedProjects table
    	try {
    		// Connect to the PoisePMS database, via the jdbc:mysql:
	        // channel on localhost (this PC)
	        // Use username "username", password "password".
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
					"username",
					"password"
			        );
				
			// command records the projects details on the database
			PreparedStatement input = connection.prepareStatement("INSERT INTO completedProjects VALUES (?, ?, ?, ?, ?, ?, ?)");
			
			input.setInt(1, project.number);
			input.setString(2, project.name);
			input.setString(3, project.buildingType);
			input.setString(4, project.address);
			input.setInt(5, project.erf);
			input.setFloat(6, totalUnpaid);
			input.setString(7, time);
			
			// executes the command
			input.executeUpdate();
			
			// closes up the connections
			input.close();
			connection.close();
			
			System.out.println("The project "+project.name+" has been marked as complete.");
		}
		// catch block detects errors
		catch (SQLException e) {
			System.out.println("This project is has already been completed.");
		}			
    }
    /**
     * Writes all projects and person info to the PoisePMS database.
     *  
     * @param projects  The projects ArrayList , contains all project objects.
     * @param people    The people ArrayList , contains all person objects.
     * @since           version 3.0
     */
    public static void fileProjects(ArrayList<Project> projects, ArrayList<Person> people) {
    	
    	
    		
        // try block records every project to the projects table
    	try {
    		// Connect to the PoisePMS database, via the jdbc:mysql:
	        // channel on localhost (this PC)
	        // Use username "username", password "password".
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
					"username",
					"password"
			        );
			
			// command updates the deletes all projects records from the database
			PreparedStatement input = connection.prepareStatement("DELETE FROM projects WHERE number >= 0");
			
			// executes the command
			input.executeUpdate();
			
			for (Project project : projects) {
				
				// command records the projects to the database
				input = connection.prepareStatement("INSERT INTO projects VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
				input.setInt(1, project.number);
				input.setString(2, project.name);
				input.setString(3, project.buildingType);
				input.setString(4, project.address);
				input.setInt(5, project.erf);
				input.setFloat(6, project.fee);
				input.setFloat(7, project.amountPaid);
				input.setString(8, project.deadline);
				input.setBoolean(9, Project.getComplete(project));
				input.setBoolean(10, Project.getDate(project));
				input.setBoolean(11, Project.getFinal(project));
				
				// executes the command
				input.executeUpdate();	
			}
    		
			// command deletes all architects records the database
			input = connection.prepareStatement("TRUNCATE TABLE architects");
			input.executeUpdate();
		
			// command updates all contractors records the database
			input = connection.prepareStatement("TRUNCATE TABLE contractors");
			input.executeUpdate();
			
			// command updates all customers records on the database
			input = connection.prepareStatement("TRUNCATE TABLE customers");
			input.executeUpdate();		
			
			for (Person person : people) {
				
				if (person.position.equals("architect")) {
			
					// command records all architects details to the database
					input = connection.prepareStatement("INSERT INTO architects VALUES (?, ?, ?, ?, ?)");
					
					input.setString(1, person.projectName);
					input.setString(2, person.name);
					input.setString(3, person.telephoneNum);
					input.setString(4, person.email);
					input.setString(5, person.physicalAddress);
					
					// executes the command
					input.executeUpdate();
				}
				if (person.position.equals("contractor")) {
					
					// command records all contractors details to the database
					input = connection.prepareStatement("INSERT INTO contractors VALUES (?, ?, ?, ?, ?)");
					
					input.setString(1, person.projectName);
					input.setString(2, person.name);
					input.setString(3, person.telephoneNum);
					input.setString(4, person.email);
					input.setString(5, person.physicalAddress);
					
					// executes the command
					input.executeUpdate();
				}
                if (person.position.equals("customer")) {
					
					// command records all customers details to the database
					input = connection.prepareStatement("INSERT INTO customers VALUES (?, ?, ?, ?, ?)");
					
					input.setString(1, person.projectName);
					input.setString(2, person.name);
					input.setString(3, person.telephoneNum);
					input.setString(4, person.email);
					input.setString(5, person.physicalAddress);
					
					// executes the command
					input.executeUpdate();
				}
			}
			// closes up connections
			input.close();
			connection.close();
		}
		// catch block detects errors
		catch (SQLException e) {
			e.printStackTrace();
		}		
    }
    /**
     * Returns all projects stored in the PoisePMS as project objects in an ArrayList.
     * 
     * @param projects      An empty ArrayList to store all project objects.
     * @return projects     ArrayList housing all project objects.
     * @throws SQLException 
     * @since               version 3.0
     */
    public static ArrayList<Project> getProjects(ArrayList<Project> projects) throws SQLException {
    	
    	try {
    		// Connect to the ebookstore database, via the jdbc:mysql:
	        // channel on localhost (this PC)
	        // Use username "otheruser", password "swordfish".
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
					"username",
					"password"
			        );
			
			// Create a direct line to the database for running our queries
			Statement statement = connection.createStatement();
			ResultSet results;
		
			// selects all projects records
			results = statement.executeQuery("SELECT * FROM projects");
			
			// while loop iterates through each line in the projects table and creates a project objects with the results 
			while (results.next()) {
				
				Project thisProject = new Project(results.getString("name"), results.getInt("number"), results.getString("buildingType"),
						            results.getString("address"), results.getInt("erf"), results.getFloat("fee"), results.getFloat("amountPaid"), 
						            results.getString("deadline"));
				
				// checks if the project is upToDate
				if (results.getBoolean("uptoDate") == false) {
					Project.setDate(thisProject);
				}
				// checks if the project is completed
				if (results.getBoolean("completed") == true) {
					Project.setComplete(thisProject);
				}
				// checks if the projects is finalized
				if (results.getBoolean("finalized") == true) {
>>>>>>> 5e30e72 (Final project manager with javadoc)
					Project.setFinal(thisProject);
				}
				
				// adds project object to the ArrayList
				projects.add(thisProject);
			}
<<<<<<< HEAD
		}
    	// catches errors
		catch (FileNotFoundException e) {
			System.out.println("Error! : projects.txt file is not found");
=======
			// closes up connections
			results.close();
			connection.close();
		}
    	// catches errors
		catch (SQLException e) {
			e.printStackTrace();
>>>>>>> 5e30e72 (Final project manager with javadoc)
		}
    	// returns ArrayList
		return projects;
    }
<<<<<<< HEAD
    // returns people stored in the clients.txt file as person objects in an ArrayList
    private static ArrayList<Person> getPeople(ArrayList<Person> people) {
    	
    	try {
			// reads the clientss.txt file of its contents
			File x = new File("C:\\Users\\delro\\eclipse-workspace\\rockPaperScissors\\src\\projectManager\\clients.txt");
			Scanner sc = new Scanner(x);
			
			// while loop iterates through each line in the text file, splits the line and creates a person object
			while (sc.hasNextLine()) {
				
				String project = sc.nextLine();
				String[] peopleList;
				peopleList = project.split(", ");
				
				String projectName = peopleList[0];
				
				String position = peopleList[1];
				
				String personName = peopleList[2];
				
				String number = peopleList[3];
				
				String email = peopleList[4];
				
				String address = peopleList[5];
				
				Person thisPerson = new Person(projectName, position, personName, number, email, address);
		
				// adds person object to the people ArrayList 
				people.add(thisPerson);
			}
		}
    	// catches errors
		catch (FileNotFoundException e) {
			System.out.println("Error! : projects.txt file is not found");
=======
    /**
     * Returns people stored in the PoisePMS database as person objects in an ArrayList.
     *  
     * @param people   An empty ArrayList to store all person objects.
     * @return people  ArrayList housing all person objects.
     * @since          version 4.0
     */
    public static ArrayList<Person> getPeople(ArrayList<Person> people) {
    	
    	try {
    		// Connect to the ebookstore database, via the jdbc:mysql:
	        // channel on localhost (this PC)
	        // Use username "otheruser", password "swordfish".
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
					"username",
					"password"
			        );
			
			// Create a direct line to the database for running our queries
			Statement statement = connection.createStatement();
			
			// selects architect records
			ResultSet architectRow = statement.executeQuery("SELECT * FROM architects");
			
			// while loop iterates through each line in the architects table and creates a person object
			while (architectRow.next()) {
				
				Person thisPerson = new Person(architectRow.getString("projectName"), "architect", architectRow.getString("name"), architectRow.getString("telephoneNum"),
						            architectRow.getString("email"), architectRow.getString("physicalAddress"));
				
				// adds person object to the people ArrayList 
				people.add(thisPerson);
				
			}
			// selects contractors records
			ResultSet contractorRow = statement.executeQuery("SELECT * FROM contractors");
			
			// while loop iterates through each line in the contractors table and creates a person object
			while (contractorRow.next()) {
							
				Person thisPerson = new Person(contractorRow.getString("projectName"), "contractor", contractorRow.getString("name"), contractorRow.getString("telephoneNum"),
									 contractorRow.getString("email"), contractorRow.getString("physicalAddress"));
							
				// adds person object to the people ArrayList 
				people.add(thisPerson);
							
			}
			// selects contractors records
			ResultSet customerRow = statement.executeQuery("SELECT * FROM customers");
						
			// while loop iterates through each line in the customers table and creates a person object
			while (customerRow.next()) {
										
				Person thisPerson = new Person(customerRow.getString("projectName"), "customer", customerRow.getString("name"), customerRow.getString("telephoneNum"),
									 customerRow.getString("email"), customerRow.getString("physicalAddress"));
							
				// adds person object to the people ArrayList 
				people.add(thisPerson);
										
			}
			// closes up connections
			connection.close();
		}
    	// catches errors
		catch (SQLException e) {
			e.printStackTrace();
>>>>>>> 5e30e72 (Final project manager with javadoc)
		}
    	// returns the ArrayList 
		return people;
    }
<<<<<<< HEAD
    // clears both projects.txt and clients.txt files
    private static void clearFiles() {
    	
    	try {
			PrintWriter pw = new PrintWriter("C:\\Users\\delro\\eclipse-workspace\\rockPaperScissors\\src\\projectManager\\projects.txt");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PrintWriter pw = new PrintWriter("C:\\Users\\delro\\eclipse-workspace\\rockPaperScissors\\src\\projectManager\\clients.txt");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
=======
>>>>>>> 5e30e72 (Final project manager with javadoc)
}