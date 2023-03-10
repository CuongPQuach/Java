public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripcoffeePrice = 5.6;
        double lattePrice = 2.1;
        double cappucinoPrice = 3.6;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        int customerid = 3;
        switch(customerid){
            case 1 :
                System.out.println(generalGreeting + customer1);
                double cu1odertype = cappucinoPrice;
                double cus1ordernumber = 2.00;
                double cus1totalmoney = cu1odertype * cus1ordernumber;
                if (isReadyOrder1) {
                    System.out.println(customer1 + readyMessage);
                    System.out.println(displayTotalMessage + cus1totalmoney);
                } else {
                    System.out.println(customer1 + pendingMessage );
                }
                break;
            case 2 :
                System.out.println(generalGreeting + customer2);
                double cu2odertype = mochaPrice;
                double cus2ordernumber = 5.00;
                double cus2totalmoney = cu2odertype * cus2ordernumber;
                if (isReadyOrder2) {
                    System.out.println(customer2 + readyMessage);
                    System.out.println(displayTotalMessage + cus2totalmoney);
                } else {
                    System.out.println(customer2 + pendingMessage );
                }
                break;
            case 3 :
                System.out.println(generalGreeting + customer3);
                double cu3odertype = dripcoffeePrice;
                double cus3ordernumber = 3.00;
                double cus3totalmoney = cu3odertype * cus3ordernumber;
                if (isReadyOrder3) {
                    System.out.println(customer3 + readyMessage);
                    System.out.println(displayTotalMessage + cus3totalmoney);
                } else {
                    System.out.println(customer3 + pendingMessage );
                }
                break;
            case 4 :
                System.out.println(generalGreeting + customer4);
                double cu4odertype = lattePrice;
                double cus4ordernumber = 5.00;
                double cus4totalmoney = cu4odertype * cus4ordernumber;
                if (isReadyOrder4) {
                    System.out.println(customer4 + readyMessage);
                    System.out.println(displayTotalMessage + cus4totalmoney);
                } else {
                    System.out.println(customer4 + pendingMessage );
                }
                break;
            default:
                System.out.println("Waiting For Customer");
        }

    }
}
