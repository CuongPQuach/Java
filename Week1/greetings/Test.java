public class Test {
    public static void main(String[] args) {
        System.out.println(greeting());
        System.out.println(greeting("Jonathan"));

    }
    public static String greeting() {
        return "Hello";
    }
    public static String greeting(String name) {
        return "Hello, " + name;
    }
}
