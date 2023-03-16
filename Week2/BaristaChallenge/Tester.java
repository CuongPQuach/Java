public class Tester {
    public static void main(String [] args) {
        Item dripcoffe = new Item("DripCoffe",3.5);
        Item capuchino = new Item("Capuchino",5.5);
        Item latte = new Item ("latte",2.4);
        // System.out.println(dripcoffe.getName());
        // System.out.println(dripcoffe.getPrice());

            Order order1 = new Order ();
            System.out.println (order1.getGuestName());
            order1.getStatusMessage();
            order1.addItem(dripcoffe);
            order1.addItem(capuchino);
            order1.display();


            Order order2 = new Order ("Rozen");
            System.out.println (order2.getGuestName());
            order2.setStatus(true);
            order2.addItem(latte);
            order2.getStatusMessage();
            order2.addItem(dripcoffe);
            order2.addItem(capuchino);
            order2.display();







    }
}