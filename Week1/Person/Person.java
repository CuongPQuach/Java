public class Person {
    public static void main(String[] args) {
        System.out.println(greeting("Coding Dojo"));
        System.out.println(personage(50));
        System.out.println(location("Out Of Space"));
    }

    public static String greeting(String name) {
        return "Hello! My Name is " + name;
    }

    public static String personage(int age) {
        return "I am way " + age +" years old";
    }

    public static String location(String place) {
        return "I am from " + place;
    }
}