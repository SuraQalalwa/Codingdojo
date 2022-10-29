public class Gorilla extends Mammal {

    public void throwSomething() {
        System.out.println("the gorilla has thrown something");
        energyLevel -=5;
    }

    public void eatBananas() {
        System.out.println("the gorilla's satisfaction");
        System.out.println(energyLevel +=10);
    }

    public void climb() {
        System.out.println("the gorilla has climbed a tree");
        System.out.println(energyLevel -=10);
    }
}
