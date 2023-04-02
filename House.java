import java.util.ArrayList;

public class House extends Building{
  /**
   * Has information extended from the Building class. Stores the information of the house's name, address, number of floors, and whether it has a dining room.
   * @param args The program's arguments
   */
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    /**
     * Stores the building's name, address, and floor number into an ArrayList and sets up the boolean statement for whether or not a house has a dining room.
     * @param(String) name The name of the house.
     * @param(String) address The address of the house.
     * @param(int) nFloors The number of floors the house has.
     * @param(bool) hasDiningRoom Whether or not the house has a dining room.
     */
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }

  public boolean hasDiningRoom() {
    /**
     * A boolean about whether or not a house has a dining hall.
     * @return True if the house has a dining hall, and false if it doesn't.
     */
    return this.hasDiningRoom;
  }
  
  public boolean hasElevator() {
    /**
     * A boolean about whether or not a house has an elevator.
     * @return True if the house has an elevator, and false if it doesn't.
     */
    return this.hasElevator;
  }
  
  public int nResidents() {
    /**
     * Returns the number of residents in the house.
     * @return The number of residents in the house.
     */
    return this.residents.size();
  }

  public void moveIn(String name){
    /**
     * Moves in a new resident into the house, adding their name to the list of residents.
     * @param(String) name The name of the resident being added.
     */
    this.residents.add(name);
  }
  
  //Overloaded moveIn method:
  public void moveIn(String name, String classYear){
    /**
     * Moves in a new resident into the house, adding their name and class year to the list of residents.
     * @param(String) name The name of the resident being added.
     * @param(String) classYear The year of the resident being added.
     */
    //changing classYear to a string so that it can be added to a list expecting only strings.
    String newResident = name + " " + classYear;
    this.residents.add(newResident);
  }

  public String moveOut(String name) {  // return the name of the person who moved out
    /**
     * Moves out the resident from the house, removing their name from the list of residents.
     * @param(String) name The name of the resident moving out.
     * @return The name of the person.
     */
    this.residents.remove(name);
    return name;
  }

  //Overloaded moveOut method:
  public void moveOut(String name, String classYear){
    /**
     * Moves out the resident from the house, removing their name and class year from the list of residents.
     * @param(String) name The name of the resident moving out.
     * @param(String) classYear the year of the resident moving out.
     */
    //changing classYear to a string so that it can be added to a list expecting only strings.
    String newResident = name + " " + classYear;
    this.residents.remove(newResident);
  }

  public boolean isResident(String person) {
    /**
     * Checks to see if someone is a resident in the house by checking if their name is in the list of residents.
     * @param(String) person The person who's being checked.
     * @return True if the list contains the person's name, false if it doesn't.
     */
    return residents.contains(person);
  }

  //Overloaded isResident to match overloaded moveIn
  public boolean isResident(String person, String classYear) {
    /**
     * Checks to see if someone is a resident in the house by checking if their name and class year is in the list of residents.
     * @param(String) person The person who's being checked.
     * @param(String) classYear The year of the person who's being checked.
     * @return True if the list contains the person's name and class year, false if it doesn't.
     */
    String newResident = person + " " + classYear;
    return residents.contains(newResident); 
  }

  public String toString() {
    /**
     * A string that states the attributes of the house in a print statement.
     * @return A description of the house in form of a print statement stating the number of residents, and whether or not it has a dining room.
     */
    String description = super.toString();
    description += ". This house has " + this.residents.size() + " residents.";
    description += "This house ";

    if (this.hasDiningRoom) {
        description += "has";
    } else {
        description += "does not have";
    }
    description += " a dining room. ";
    description += "This house ";
    if (this.hasElevator) {
        description += "has";
    } else {
        description += "does not have";
    }
    description += " an elevator.";
    return description;
    }

    // Navigational methods

    public void showOptions() {
      /**
        * Shows the user navigational and interactive actions they can take to either get around or do something within a certain building.
        */
        super.showOptions();
        System.out.print(" + moveIn()\n + moveOut()");
    }

    public void goToFloor(int n) {
      /**
        * Tells the elevator to go to a certain floor of the building.
        * @param(int) n The floor that the user wants to travel to.
        * @throw(RuntimeException) When the user is not currently inside the building.
        * @throw(RuntimeException) When the user attempts to travel to a floor that doesn't exist in the building.
        */
      if (this.hasElevator == true) {
        super.goToFloor(n);
      }
      else {
        throw new RuntimeException("Sorry, this building does not have an elevator.");
      }
    }


  public static void main(String[] args) {
    House ziskind = new House("Ziskind","1 Henshaw Ave Northampton MA", 4, true, true);
    System.out.println(ziskind);

    ziskind.moveIn("Sally", "1");
    System.out.println(ziskind.isResident("Sally", "1"));

    System.out.println(ziskind.nResidents());

    House capen = new House("Capen", "26 Prospect St Northampton MA", 3, false, false);
    System.out.println(capen);
    //capen.showOptions();

    //capen.
  }

}