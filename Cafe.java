/**
 * Has information extended from the Building class. Stores the inventory of the cafe and the ability to sell and restock the inventory.
 * @param args The program's arguments
 */
public class Cafe extends Building{
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    private boolean hasElevator;
  
    /**
     * Stores(String) the name, address, floor number, and inventory of the cafe.
     * @param(String) name The name of the cafe.
     * @param(int) address The address of the cafe.
     * @param(int) the number of floors in the cafe.
     * @param(int) nCoffeeOunces The number of coffee the cafe has in its inventory.
     * @param(int) SugarPackets The number of sugar packets the cafe has in its inventory.
     * @param(int) nCreams The number of creams the cafe has in its inventory.
     * @param(int) nCups The number of cups the cafe has in its inventory.
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean hasElevator) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = hasElevator;
    }
    
    /**
     * The method that allows the cafe to sell coffee. Decreases the inventory based on the order.
     * @param(int) size The amount of coffee ordered in ounces.
     * @param(int) nSugarPackets The number of sugar packets used in the order.
     * @param(int) nCreams the number of creams used in the order.
     */    
    public void sellCoffee(int size, int nSugarPackets, int nCreams) { //Each time this method is called, the inventory should decrease in each category according to the given parameters, e.g. calling `myCafe.sellCoffee(12, 2, 3);`should decrease the `myCafe` object's `nCoffeeOunces` by 12, `nSugarPackets` by 2, and `nCreams` by 3 (and of course, `nCups` by 1).
        while (size > this.nCoffeeOunces || nSugarPackets > this.nSugarPackets || nCreams > this.nCreams) {
            this.restock(nCoffeeOunces, nSugarPackets, nCreams, nCups);
        }
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        this.nCups--;
    }

    //Overloaded sellCoffee method to include special flavoring
    /**
     * The method that allows the cafe to sell coffee, with the option of adding a surprise special flavor. Decreases the inventory based on the order.
     * @param(int) size The amount of coffee ordered in ounces.
     * @param(int) nSugarPackets The number of sugar packets used in the order.
     * @param(int) nCreams the number of creams used in the order.
     * @param(bool) specialFlavoring The special flavoring that can be added into the coffee. If true, special flavoring is added. If false, no flavoring is added. 
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams, boolean specialFlavoring){
        while (size > this.nCoffeeOunces || nSugarPackets > this.nSugarPackets || nCreams > this.nCreams) {
            this.restock(nCoffeeOunces, nSugarPackets, nCreams, nCups, specialFlavoring);
        }
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        this.nCups--;
        if (specialFlavoring = true) {
            System.out.println("This coffee has the limited-time sugar cookie flavoring! Enjoy!");
        }
        else {
            System.out.println("This coffee is basic, with no special flavoring (like you :)).");
        }
    }
    
    /**
     * The method that allows the cafe to restock its inventory.
     * @param(int) nCoffeeOunces The number of coffee the cafe has in its inventory.
     * @param(int) SugarPackets The number of sugar packets the cafe has in its inventory.
     * @param(int) nCreams The number of creams the cafe has in its inventory.
     * @param(int) nCups The number of cups the cafe has in its inventory.
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) { //This method will be `private` (since we don't want some random person forcefully restocking the shelves!) - we'll call it from **inside** the `sellCoffee(...)` method, in the event that we don't have enough ingredients in stock to make the requested drink.
        this.nCoffeeOunces = nCoffeeOunces + 500;
        this.nSugarPackets = nSugarPackets + 350;
        this.nCreams = nCreams + 425;
        this.nCups = nCups + 1000;
    }
    
    //Overloaded restock method to include special flavoring
    /**
     * The method that allows the cafe to restock its inventory.
     * @param(int) nCoffeeOunces The number of coffee the cafe has in its inventory.
     * @param(int) SugarPackets The number of sugar packets the cafe has in its inventory.
     * @param(int) nCreams The number of creams the cafe has in its inventory.
     * @param(int) nCups The number of cups the cafe has in its inventory.
     * @param(bool) specialFlavoring Checks to see if the cafe has the special flavoring in its stock. If it doesn't, it restocks it and changes the value to true.
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean specialFlavoring) { //This method will be `private` (since we don't want some random person forcefully restocking the shelves!) - we'll call it from **inside** the `sellCoffee(...)` method, in the event that we don't have enough ingredients in stock to make the requested drink.
        this.nCoffeeOunces = nCoffeeOunces + 500;
        this.nSugarPackets = nSugarPackets + 350;
        this.nCreams = nCreams + 425;
        this.nCups = nCups + 1000;
        if (specialFlavoring = true) {
            System.out.println("The cafe has the special flavoring in stock.");
        }
        else {
            System.out.println("The cafe does not have the special flavoring in stock. Restocking...");
            specialFlavoring = true;
            System.out.println("Restocked!");
        }
    }
    

    /**
     * Shows the user navigational and interactive actions they can take to either get around or do something within a certain building.
     */
    public void showOptions() {
        super.showOptions();
        System.out.print(" + sellCoffee(nCoffeeOunces, nSugarPackets, nCreams, nCups, (extra: boolean specialFlavoring))");
    }

    /**
     * Tells the elevator to go to a certain floor of the building.
     * @param(int) n The floor that the user wants to travel to.
     * @throw(RuntimeException) When the user is not currently inside the building
     * @throw(RuntimeException) When the user attempts to travel to a floor that doesn't exist in the building.
     */
    public void goToFloor(int n) {
        if (this.hasElevator == true && n == 1) {
          super.goToFloor(n);
        }
        else if (this.hasElevator == true && n != 1) {
          throw new RuntimeException("Sorry, any other floors besides the first are for staff only!");
        }
        else {
            throw new RuntimeException("Sorry, this building doesn't have an elevator!");
        }
    }

    public static void main(String[] args) {
        Cafe theroost = new Cafe("The Roost", "10 Main St", 2, 500, 350, 425, 1000, true);
        theroost.sellCoffee(20, 15, 30);
        System.out.print(" " + theroost.nCoffeeOunces);
        System.out.print(" " + theroost.nSugarPackets);
        System.out.print(" " + theroost.nCreams);
        System.out.print(" " + theroost.nCups);
        System.out.println("");
        theroost.sellCoffee(20, 15, 30, true);

    }
    
}
