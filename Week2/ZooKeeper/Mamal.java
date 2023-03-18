public class Mamal {
    // atrrible
    protected int energyLevel = 100;



    // Getter
    public int displayEnergy(){
        System.out.printf("Engery Level is: %s",energyLevel);
        return energyLevel;
    }



    // Setter
    public int minusEnergy (int amout) {
        this.energyLevel = this.energyLevel - amout;
        return energyLevel;
    }

    public int incEnergy (int amout) {
        this.energyLevel = this.energyLevel + amout;
        return energyLevel;
    }
}