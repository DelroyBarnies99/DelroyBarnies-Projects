// CompletedLevel1 subclass extends the Level superclass
package students;

public class CompletedLevel1 extends Bootcamp {
	
	// Registers a student to the currant level
	public CompletedLevel1(Student level) {
		
		// super invokes the immediate parent class constructor
		super(level);
    }
	// overriding the describe method of the parent student interface 
    @Override
    public String describe() {
    	return super.describe() + placeThisLevel();
    }
    // returns the registered Level
    private String placeThisLevel() {
    	return "- Completed Level 1\n";
    }
}
