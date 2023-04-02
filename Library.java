import java.util.Hashtable;

public class Library extends Building{
  /**
   *  Has information extended from the Building class. Stores information about the library's details, collection of books, and abilities to check out and have books returned.
   * @param args The program's arguments
   */
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;
  private boolean hasCafe;
  private boolean hasChildrensCorner;

  public Library(String name, String address, int nFloors) {
    /**
     * Stores information about the library's name, address, and number of floors.
     * @param(String) name The name of the library.
     * @param(String) address The address of the library.
     * @param(int) nFloors The number of floors in the library.
     */
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = true;
  }
  
  //Overloaded Constructor with Cafe
  public Library(String name, String address, int nFloors, boolean hasCafe) {
    /**
     * Constructs the library and assigns the name, number of floor and if it has a cafe
     * @param(String) name The name of the library.
     * @param(String) address The address of the library.
     * @param(int) nFloors The number of floors in the library.
     * @param(bool) hasCafe If the library has a cafe or not
     */
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = true;
    this.hasCafe = hasCafe;
  }

  //Overloaded Constructor with children's corner/playground and cafe
  public Library(String name, String address, int nFloors, boolean hasCafe, boolean hasChildrensCorner) {
    /**
     * Constructs the library and assigns the name, number of floor, if it has a cafe and if it has a children's playround. 
     * @param(String) name The name of the library.
     * @param(String) address The address of the library.
     * @param(int) nFloors The number of floors in the library.
     * @param(bool) hasCafe If the library has a cafe or not
     * @param(bool) hasChildrensCorner If it has a playground.
     */
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = true;
    this.hasCafe = hasCafe;
    this.hasChildrensCorner = hasChildrensCorner;
  }

  public void addTitle(String title) {
    /**
     * Adds the title of a book to the library's collection.
     * @param(String) title The title of the book being added.
     */
    this.collection.put(title, true);
    }
    
  public String removeTitle(String title) {
     /**
     * Removes the title of a book from the library's collection.
     * @param(String) title The title of the book being removed.
     * @return The title of the book that was removed.
     */
    this.collection.remove(title);
    return title;
  } // return the title that we removed

//these methods will simply modify the `value` associated with the given `key` - the `title`).
//_Hint: use the functions provided by the [`Hashtable`](https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html) class to make this much easier! Specifically, check out `put(...)`, `remove(...)`, and `replace(...)`._
  public void checkOut(String title) { 
    /**
     * Checks out books from the library by modifying the value of the book's title.
     * @param(String) title The title of the book being checked out.
     */
    this.collection.replace(title, false);
  }

  public void returnBook(String title) {
     /**
     * Returns books from the library by modifying the value of the book's title.
     * @param(String) title The title of the book being returned.
     */
    this.collection.replace(title, true);
  }

  public boolean containsTitle(String title) { // returns true if the title appears as a key in the Library's collection, false otherwise
     /**
      * Checks to see if the title of the book is in the library's collection.
      * @param(String) title The title of the book being checked.
      * @return T/F: true if the title appears as a key in the Library's collection, false if it doesn't.
      */
      return this.collection.containsKey(title);
  } 
  
  public boolean isAvailable(String title) { // returns true if the title is currently available, false otherwise
    /**
     * Checks to see if the book has been checked out from the library.
     * @param(String) title The title of the book being checked.
     * @return T/F: true if the title is currently available to check out, false if not.
     */
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
    
  public void printCollection() { // prints out the entire collection in an easy-to-read way (including checkout status)
    /**
     * Prints out the collection of the library, including whether or not the books are checked out.
     */
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
  
  public void showOptions() {
    /**
      * Shows the user navigational and interactive actions they can take to either get around or do something within a certain building.
      */
    super.showOptions();
    System.out.print(" + checkOut(title)\n + returnBook(title)");
  }

  public boolean hasElevator() {
    /**
     * A boolean about whether or not the library has an elevator.
     * @return T/F: true if the house has an elevator, and false if it doesn't.
     */
    return this.hasElevator;
  }

  public void goToFloor(int n) {
    /**
      * Tells the elevator to go to a certain floor of the building.
      * @param(int) n The floor that the user wants to travel to.
      * @throw(RuntimeException) When the user is not currently inside the building
      * @throw(RuntimeException) When the user attempts to travel to a floor that doesn't exist in the building.
      */
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