import java.util.ArrayList;
import java.util.Arrays;


public class CafeUtil {
    int getStreakGoal (int numberweek) {
        int total = 0;
        for ( int i = 0; i <= numberweek; i++) {
            total = total + i;
        }
        return total;
}

    double getOrderTotal (double[] prices) {
        double total = 0;
        for (int i = 0; i <prices.length; i ++ ) {
            total = total + prices[i];
        }
        return total;
    }

    void displayMenu (ArrayList<String>  menu) {
        for (int i = 0; i <menu.size(); i++) {
            System.out.println(menu.get(i));
        }
    }

    void addCustomer (ArrayList<String> customers) {
        System.out.println("Plz Enter Your Name:");
        String userName = System.console().readLine();
        System.out.printf("There is %s ",customers.size());
        customers.add(userName);
        System.out.println (customers);
    }
}
