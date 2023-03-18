public class Bat extends Mamal {
    // attribute 
    private String name;

    // contructor 
    public Bat (String name)
    {
        this.name = name;
        this.energyLevel = 300;
    }



        // Getter 
    public String getName(){
        return name;
    }

    // Setter 
    public void fly (){
        System.out.printf("%s Throw A Rock", name);
        System.out.println("\n");
        this.minusEnergy(50);
    }
    public void eatPeople () {
        System.out.printf("%s Eat Bannas and He Statisfine",name );
        System.out.println("\n");
        this.incEnergy(25);
    }

    public void attackTown() {
        System.out.printf("%s Attack People",name);
        System.out.println('\n');
        this.minusEnergy(100);
    }
}