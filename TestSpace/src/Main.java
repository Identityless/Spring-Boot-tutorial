import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();
        Man man = new Man();

        main.func(man);
    }

    void func(Man human){
        human.setAge(10);
    }
}