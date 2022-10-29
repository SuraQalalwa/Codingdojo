public class Bat extends Mammal{
    int energyLevel = 300;
    public int fly(int fly){
        System.out.println("the sound of a bat taking off");
        return fly*(energyLevel -=50);


    }
    public int eatHumans(int human){
        return human*(energyLevel +=25);

    }
    public int attackTown(int town){
        System.out.println("the sound of a town on fire");
        return town*(energyLevel -=100);

    }
}
