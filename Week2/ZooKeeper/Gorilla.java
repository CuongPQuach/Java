public class Gorilla extends Mamal {
    // atrrible
    private String name;

    // Constructor
    public Gorilla ( String name) {
        this.name = name;
    }


    // Getter 
    public String getName(){
        return name;
    }

    // Setter 
    public void throwSomething (){
        System.out.printf("%s Throw A Rock", name);
        System.out.println("\n");
        this.minusEnergy(5);
    }
    public void eatBananas () {
        System.out.printf("%s Eat Bannas and He Statisfine",name );
        System.out.println("\n");
        this.incEnergy(10);
    }

    public void climd() {
        System.out.printf("%s Climd The Tree",name);
        System.out.println('\n');
        this.minusEnergy(10);
    }
}