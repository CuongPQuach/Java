public class MamalTester {
    public static void main(String [] args) {
        Gorilla gorilla1 = new Gorilla("Fung");
        Gorilla gorilla2 = new Gorilla("Lionel");
        Gorilla gorilla3 = new Gorilla("EEE");
        System.out.println(gorilla1.getName());
        gorilla1.throwSomething();
        gorilla1.displayEnergy();
        System.out.println('\n');
        gorilla1.eatBananas();
        gorilla1.displayEnergy();
        System.out.println('\n');
        gorilla1.climd();
        gorilla1.displayEnergy();
        gorilla2.displayEnergy();

        Bat bat1 = new Bat("BatMan");
        Bat bat2 = new Bat ("Dracula");
        bat1.displayEnergy();
        bat1.fly();
        bat1.displayEnergy();
    }
}