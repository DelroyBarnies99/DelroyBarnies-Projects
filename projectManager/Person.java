<<<<<<< HEAD
// person class initializes project objects  

=======
>>>>>>> 5e30e72 (Final project manager with javadoc)
package projectManager;

import java.util.ArrayList;
import java.util.Scanner;

<<<<<<< HEAD
=======
/**
 * Person class initializes objects to be used by the clients assigned to the project.
 * 
 * @author  Delroy Barnies
 * @see Person
 * @version 4.0 2022/06/02
 */
>>>>>>> 5e30e72 (Final project manager with javadoc)
public class Person{
	
	// attribute variables
	String projectName;
	String position;
	String name;
	String telephoneNum;
	String email;
	String physicalAddress;
	
<<<<<<< HEAD
	// constructor initializes person objects
=======
	/**
	 * Sole constructor.
	 * 
	 * @param projectName      The name of the project will be used to identify which clients belong to a project.
	 * @param position         Only 3 positions exist for each project: architect, contractor and customer.
	 * @param name             Name and surname of the person.
	 * @param telephoneNum     Contact details of the person.
	 * @param email            Email address.
	 * @param physicalAddress  Their residential address, where they live.
	 * @since version 1.0
	 */
>>>>>>> 5e30e72 (Final project manager with javadoc)
	public Person(String projectName, String position, String name, String telephoneNum
			, String email, String physicalAddress) {
		
		// attributes
		this.projectName = projectName;
		this.position = position;
		this.name = name;
		this.telephoneNum = telephoneNum;
		this.email = email;
		this.physicalAddress = physicalAddress;
	}
<<<<<<< HEAD
	// method creates new person with architect position
=======
	/**
	 *  method creates new person with architect position.
	 *  
	 * @param name   The name of the project.
	 * @return       Person with architect position.
	 * @since        version 1.0       
	 */
>>>>>>> 5e30e72 (Final project manager with javadoc)
	public static Person newArchitect(String name) {	
			
			System.out.println("Please enter the employees and clients details");
			
			System.out.print("\nEnter the architects name:");
			Scanner input12 = new Scanner(System.in);
			String architectName = input12.nextLine();
			
			System.out.print("\nEnter the architects telephone number:");
			Scanner input13 = new Scanner(System.in);
			String architectNum = input13.nextLine();
			
			System.out.print("\nEnter the architects email:");
			Scanner input14 = new Scanner(System.in);
			String architectEmail = input14.nextLine();
			
			System.out.print("\nEnter the architects physical address:");
			Scanner input15 = new Scanner(System.in);
			String architectAddress = input15.nextLine();
		    
			// takes user input and creates new person object with architect position
			Person architect = new Person(name, "architect", architectName, architectNum, architectEmail, architectAddress);
			
			// returns person
			return architect;
			
	}	
<<<<<<< HEAD
	// method creates new person with contractor position
=======
	/**
	 * Method creates new person with contractor position.
	 *  
	 * @param  name  The name of the project.
	 * @return       Person with contractor position.
	 * @since        version 1.0
	 */
>>>>>>> 5e30e72 (Final project manager with javadoc)
	public static Person newContractor(String name) {	
			
			System.out.print("\nEnter the contractors name:");
			Scanner input12 = new Scanner(System.in);
			String contractorName = input12.nextLine();
			
			System.out.print("\nEnter the contractors telephone number:");
			Scanner input13 = new Scanner(System.in);
			String contractorNum = input13.nextLine();
			
			System.out.print("\nEnter the contractors email:");
			Scanner input14 = new Scanner(System.in);
			String contractorEmail = input14.nextLine();
			
			System.out.print("\nEnter the contractors physical address:");
			Scanner input15 = new Scanner(System.in);
			String contractorAddress = input15.nextLine();
		    
			// takes user input and creates new person object with contractor position
			Person contractor = new Person(name, "contractor", contractorName, contractorNum, contractorEmail, contractorAddress);
			
			// returns person
			return contractor;
			
	}
<<<<<<< HEAD
	// method creates new person with customer position
=======
	/**
	 *  Method creates new person with customer position.
	 *  
	 * @param name   The name of the project.
	 * @return       Person with customer position.
	 * @since        version 1.0
	 */
>>>>>>> 5e30e72 (Final project manager with javadoc)
	public static Person newCustomer(String name) {	
			
			System.out.print("\nEnter the customers name:");
			Scanner input12 = new Scanner(System.in);
			String customerName = input12.nextLine();
			
			System.out.print("\nEnter the customers telephone number:");
			Scanner input13 = new Scanner(System.in);
			String customerNum = input13.nextLine();
			
			System.out.print("\nEnter the customers email:");
			Scanner input14 = new Scanner(System.in);
			String customerEmail = input14.nextLine();
			
			System.out.print("\nEnter the customers physical address:");
			Scanner input15 = new Scanner(System.in);
			String customerAddress = input15.nextLine();
		    
			// takes user input and creates new person object with customer position
			Person customer = new Person(name, "customer", customerName, customerNum, customerEmail, customerAddress);
			
			// returns person
			return customer;
			
	}	
<<<<<<< HEAD
	// method updates contractors details
=======
	/**
	 * Method updates contractors details.
	 *  
	 * @param person  Person object with the contractor position.
	 * @return        Contractor with the updated details.
	 * @since         version 1.0
	 */
>>>>>>> 5e30e72 (Final project manager with javadoc)
	public static Person contractorsDetails(Person person) {
	    	
	    	System.out.print("Enter the contractors new telephone number:");
			Scanner input10 = new Scanner(System.in);
			String newTelNum = input10.nextLine();
			
			System.out.print("Enter the contractors new email:");
			Scanner input11 = new Scanner(System.in);
			String newEmail = input11.nextLine();
			
			// updates contractors telephone number and email based on user input
			person.telephoneNum = newTelNum;
			person.email = newEmail;
			
			System.out.println("\nContractors contact details have been updated");
			
			// returns person
			return person;
			
	}
<<<<<<< HEAD
	// allows user to update any person objects details in an ArrayList 
=======
	/**
	 * Allows user to update any person objects details in an ArrayList. 
	 *  
	 * @param people  ArrayList containing person objects to be updated.
	 * @return        null
	 * @since         version 3.0
	 */
>>>>>>> 5e30e72 (Final project manager with javadoc)
	public static String updateClients(ArrayList<Person> people) {
		
		String client = "";
			
	    System.out.println("Enter the name of the Client:\n");
		Scanner input10 = new Scanner(System.in);
		client = input10.nextLine();
		
		// iterates through every person in the ArrayList until the person.name matches the input name 
		for (Person person : people) {
			String option = "";
			
			if (person.name.equals(client)){
				
				System.out.println("You have chosen "+person.name+" in position: "+person.position+" for project: "+person.projectName);
				
				// displays options, user inputs "e" to return to the main menu
				while (!(option.equals("e"))){
			
					Scanner input19 = new Scanner(System.in);
					System.out.print(  "\n\nWhat would you like to change? "
							         + "\nname                :n"
							         + "\ntelephoneNum        :no"
							         + "\nemail               :em"
							         + "\naddress             :a"
							         + "\nexit                :e"
							         + "\nEnter your option here:");
					
					option = input19.next();
					option = option.toLowerCase();
					
					// loops for each time the user enters incorrectly
					while (!(option.equals("n") || option.equals("e")|| option.equals("no") || option.equals("em") || option.equals("a"))){ 
						
						input19 = new Scanner(System.in);
						System.out.print(  "\n\nWhat would you like to change? "
						                 + "\nname                :n"
						                 + "\ntelephoneNum        :no"
						                 + "\nemail               :em"
						                 + "\naddress             :a"
						                 + "\nexit                :e"
						                 + "\nEnter your option here:");
						option = input19.next();
						option = option.toLowerCase();
					}
					// updates the person.name 
                    if (option.equals("n")) {
						
						System.out.print("\nEnter the new name:");
						Scanner input2 = new Scanner(System.in);
						String name = input2.nextLine();
						
						person.name = name;
					}
                    // updates the person.telephoneNum
					if (option.equals("no")) {
						
						System.out.print("\nChoose a new telephone number");
						Scanner input3 = new Scanner(System.in);
						String number = input3.nextLine();
						
						person.telephoneNum = number;
						
					}
					// updates the person.email
                    if (option.equals("em")) {
						
						System.out.print("\nEnter the new email:");
						Scanner input2 = new Scanner(System.in);
						String email = input2.nextLine();
						
						person.email = email;
					}
                    // updates the person.address
					if (option.equals("a")) {
						
						System.out.print("\nChoose a new address");
						Scanner input3 = new Scanner(System.in);
						String address = input3.nextLine();
						
						person.physicalAddress = address;
						
					}
				}			
			}
		}
		// returns back to the main menu
		System.out.println("\nBack to main menu");
		return null;
	}
<<<<<<< HEAD
	// returns a person objects details in an easily readable manner as a string
=======
	/**
	 * Returns a person objects details in an easily readable manner as a string.
	 * 
	 * @param people  ArrayList of person objects.
	 * @return        Details of the selected person object from the ArrayList as a string.
	 * @since         version 3.0
	 */
>>>>>>> 5e30e72 (Final project manager with javadoc)
    public static String displayPerson(ArrayList<Person> people) {
    	
    	System.out.print("\nEnter the clients name:");
		Scanner input18 = new Scanner(System.in);
		String name = input18.nextLine();
		
		String details = "";
		
		// iterates through every person in the ArrayList until the person.name matches the input name 
		for (Person person : people) {
			if (person.name.equals(name)) {
				
<<<<<<< HEAD
				      details = ("\n\nproject:               "+ person.projectName
=======
				      details = ("\n\nproject:               "+person.projectName
>>>>>>> 5e30e72 (Final project manager with javadoc)
						         + "\nname:                  "+person.name 
						         + "\nposition:              "+person.position  
						         + "\ntelephone number:      "+person.telephoneNum 
						         + "\nemail:                 "+person.email
						         + "\naddress:               "+person.physicalAddress);		
			}
		}
        return details; 
    }
<<<<<<< HEAD
	// returns person details as a string to be stored in a text file for easy extraction
    public static String personToString(Person person) {
    	
		return person.projectName+", "+person.position+", "+person.name+", "+person.telephoneNum+", "+person.email+", "+
				person.physicalAddress;
    }
=======
>>>>>>> 5e30e72 (Final project manager with javadoc)
}