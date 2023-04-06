import java.util.Hashtable;

/**
*  Has information extended from the Building class. Stores information about the library's details, collection of books, and abilities to check out and have books returned.
* @param args The program's arguments
*/
public class Library extends Building{
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;
  private boolean hasCafe;
  private boolean hasChildrensCorner;

  /**
   * Stores information about the library's name, address, and number of floors.
   * @param(String) name The name of the library.
   * @param(String) address The address of the library.
   * @param(int) nFloors The number of floors in the library.
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = true;
  }
  
  //Overloaded Constructor with Cafe

  /**
   * Constructs the library and assigns the name, number of floor and if it has a cafe
   * @param(String) name The name of the library.
   * @param(String) address The address of the library.
   * @param(int) nFloors The number of floors in the library.
   * @param(bool) hasCafe If the library has a cafe or not
   */
  public Library(String name, String address, int nFloors, boolean hasCafe) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = true;
    this.hasCafe = hasCafe;
  }

  //Overloaded Constructor with children's corner/playground and cafe
  
  /**
   * Constructs the library and assigns the name, number of floor, if it has a cafe and if it has a children's playround. 
   * @param(String) name The name of the library.
   * @param(String) address The address of the library.
   * @param(int) nFloors The number of floors in the library.
   * @param(bool) hasCafe If the library has a cafe or not
   * @param(bool) hasChildrensCorner If it has a playground.
   */
  public Library(String name, String address, int nFloors, boolean hasCafe, boolean hasChildrensCorner) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = true;
    this.hasCafe = hasCafe;
    this.hasChildrensCorner = hasChildrensCorner;
  }

  /**
   * Adds the title of a book to the library's collection.
   * @param(String) title The title of the book being added.
   */
  public void addTitle(String title) {
    this.collection.put(title, true);
    }
    
  /**
   * Removes the title of a book from the library's collection.
   * @param(String) title The title of the book being removed.
   * @return The title of the book that was removed.
   */
  public String removeTitle(String title) {
    this.collection.remove(title);
    return title;
  } // return the title that we removed

  /**
   * Checks out books from the library by modifying the value of the book's title.
   * @param(String) title The title of the book being checked out.
   */
  public void checkOut(String title) { 
    this.collection.replace(title, false);
  }

   /**
   * Returns books from the library by modifying the value of the book's title.
   * @param(String) title The title of the book being returned.
   */
  public void returnBook(String title) {
    this.collection.replace(title, true);
  }

  /**
  * Checks to see if the title of the book is in the library's collection.
  * @param(String) title The title of the book being checked.
  * @return T/F: true if the title appears as a key in the Library's collection, false if it doesn't.
  */
  public boolean containsTitle(String title) { // returns true if the title appears as a key in the Library's collection, false otherwise
      return this.collection.containsKey(title);
  } 
  
   /**
   * Checks to see if the book has been checked out from the library.
   * @param(String) title The title of the book being checked.
   * @return T/F: true if the title is currently available to check out, false if not.
   */
  public boolean isAvailable(String title) { // returns true if the title is currently available, false otherwise
    if (this.containsTitle(title) == true) {
      if (this.collection.get(title) == true) {
        return true;
      }
      else {
        return false;
      }
    }
    else {
      return false;
    }
  }
  
  /**
   * Prints out the collection of the library, including whether or not the books are checked out.
   */
  public void printCollection() { // prints out the entire collection in an easy-to-read way (including checkout status)
    if (this.collection.isEmpty()) {
      System.out.println("There is nothing in the collection.");
    }
    else {
      for (String key:this.collection.keySet()){
        if (this.collection.get(key)) {
          System.out.println(key + ", Available to borrow.");
        }
        else {
          System.out.println(key + ", Checked out.");
        }
      }
    }
  } 
  
  /**
  * Shows the user navigational and interactive actions they can take to either get around or do something within a certain building.
  */
  public void showOptions() {
    //little comment for later: implement this the same way in each class, in cafe you probably don't have to use super at all. check if you have elevator before showing option about going to floors, and you can choose what methods to include in each class based on your design choices. like probs not gonna print out collection here but u can check out a book). 
    super.showOptions();
    System.out.print(" + checkOut(title)\n + returnBook(title)\n + isAvailable(title)");
  }

  /**
   * A boolean about whether or not the library has an elevator.
   * @return T/F: true if the house has an elevator, and false if it doesn't.
   */
  public boolean hasElevator() {
    return this.hasElevator;
  }

  /**
  * Tells the elevator to go to a certain floor of the building.
  * @param(int) n The floor that the user wants to travel to.
  * @throw(RuntimeException) When the user is not currently inside the building
  * @throw(RuntimeException) When the user attempts to travel to a floor that doesn't exist in the building.
  */
  public void goToFloor(int n) {
    super.goToFloor(n);
  }

  public static void main(String[] args) {
    Library forbes = new Library("Forbes", "10 Elm St", 3);
    Library barnesandnobles = new Library("Forbes", "10 Elm St", 3, true, true);
    System.out.println(barnesandnobles.hasCafe);
    System.out.println(barnesandnobles.hasChildrensCorner);

    forbes.addTitle("If You Give A Mouse A Cookie");
    forbes.addTitle("Chicka Chicka Boom Boom");
    forbes.checkOut("Chicka Chicka Boom Boom");
    forbes.printCollection();
    System.out.println(" ");
    forbes.removeTitle("If You Give A Mouse A Cookie");
    forbes.printCollection();
    System.out.println(" ");
    forbes.returnBook("Chicka Chicka Boom Boom");
    forbes.addTitle("Poppy");
    forbes.checkOut("Poppy");
    forbes.printCollection();
    System.out.println(" ");
    System.out.println(forbes.isAvailable("Poppy"));
  } 
}