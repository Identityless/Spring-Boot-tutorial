import zoo.*;

public class Main {
    public static void main(String[] args) {
        ZooKeeper zooKeeper = new ZooKeeper();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();
        Egle egle = new Egle();
        Zebra zebra = new Zebra();
        Dog dog = new Dog();


        zooKeeper.feed(egle);

        zebra.printFood();
        dog.printFood();

    }
}
