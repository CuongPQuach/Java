import java.util.ArrayList;
    
// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items; // defaults to null
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order(
    ) {
        this.name = "Guest";
        this.ready = false;
        this.items = new ArrayList<Item>(); 
    }
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(
        String name
    ) {
        this.name = name;
        this.ready = false;
        this.items = new ArrayList<Item>();
    }
    
    // ORDER METHODS

    	// Most of your code will go here, 
    	// so implement the getters and setters first!
    
    public void addItem (Item item) {
        this.items.add(item);
    }





    // GETTERS & SETTERS
    // guess manipulate 
        // display
    public String getGuestName (){
        return name;
    }
        // change 
    public void setGuestName (String name) {
        this.name = name;
    }

    // status manipulate 
        // display 
    public void getStatusMessage (){
        if (this.ready == true) {
            System.out.println("Your Order is Ready");
        } else {
            System.out.println ("Thanks You for your waitting");
        }
    }
        // change
    public void setStatus (boolean ready) {
        this.ready = ready;
    }

    // item manipulate 
    public void display () {
        double total = 0;
        for (int i = 0 ; i < items.size() ; i++){
            System.out.println(items.get(i).getName());
            System.out.println(items.get(i).getPrice());
            double currentprice = items.get(i).getPrice();
            total = total + currentprice;
        }
        System.out.printf("The Total is :%s ", total);
        System.out.println("\n");
        // System.out.println(total);
    }
}

