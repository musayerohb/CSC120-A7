public class Building {

    protected String name;
    protected String address;
    protected int nFloors;
    protected int activeFloor = -1; // Default value indicating we are not inside this building

    /* Default constructor */
    /**
     * Builds a new Building object with an unknown name and unknown address with 1 floor.
     */
    public Building() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /* Overloaded constructor with address only */
    /**
     * Builds a new Building object with 1 floor and an unknown name, but with a known address.
     * @param(String) adress Where the building is located.
     */
    public Building(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
    }

    /* Overloaded constructor with name, address */
    /**
     * The method that assigns Buildings their name, adress and amount of floors.
     * @param(String) name Names the building
     * @param(String) adress Where the building is located 
     */
    public Building(String name, String address) {
        this(name, address, 1); // Call full constructor with hard-coded # floors
    }

    /* Full constructor */
    /**
     * Builds a new Building object with a set amount of floors, a name, and an address.
     * @param(String) name Names the building
     * @param(String) adress Where the building is located 
     * @param(int) nFloors Number of floor in the building
     * @throw(RuntimeException) When the nFloors value is less than 1
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /* Accessors */
    /**
     * Getter for Building Name 
     * @return The building name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the building address in the String class.
     * @return The address of the building.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Getter for the number of floors in the building.
     * @return The number of floors in the building.
     */
    public int getFloors() {
        return this.nFloors;
    }

    /* Navigation methods */
    /**
     * Method for entering the building, and checks if the user is already inside the building.
     * @return If they are in the building 
     */
    public Building enter() {
        if (activeFloor != -1) {
            throw new RuntimeException("You are already inside this Building.");
        }
        this.activeFloor = 1;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
        return this; // Return a pointer to the current building
    }

    /**
     * Checks if the user is in a building, and if they are, allows them to exit it. However, if they're trying to exit from a floor above the first, the user will go through a window.
     * @return null Indicates that the user is outside once they've left a building. 
     */
    public Building exit() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
        }
        if (this.activeFloor > 1) {
            throw new RuntimeException("You have fallen out a window from floor #" +this.activeFloor + "!");
        }
        System.out.println("You have left " + this.name + ".");
        this.activeFloor = -1; // We're leaving the building, so we no longer have a valid active floor
        return null; // We're outside now, so the building is null
    }

    /**
     * Tells the elevator to go to a certain floor of the building.
     * @param(int) n The floor that the user wants to travel to.
     * @throw(RuntimeException) When the user is not currently inside the building
     * @throw(RuntimeException) When the user attempts to travel to a floor that doesn't exist in the building.
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /**
     * Allow the user to ascend one floor in a building.
     */
    public void goUp() {
        this.goToFloor(this.activeFloor + 1);
    }

    /**
     * Allows the user to descend one floor in a building.
     */
    public void goDown() {
        this.goToFloor(this.activeFloor - 1);
    }

    /**
     * Shows the user navigational and interactive actions they can take to either get around or do something within a certain building.
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    /**
     * A string that states the attributes of the building in a print statement.
     * @return A print statement stating the name, the number of stories/floors, and the address of the building using the given values of the parameters.
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");
        
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
        fordHall.showOptions();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        fordHall.enter();
        fordHall.goUp();
        fordHall.goDown();
        fordHall.exit();
    }

}
