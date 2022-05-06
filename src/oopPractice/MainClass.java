package oopPractice;

public class MainClass {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Barsik", 5), new Cat("Snezhok", 25), new Cat("Kuzma", 5),
        new Cat("Bomba", 50), new Cat("Vangog", 40)};
        Plate plate = new Plate(100); //наполнение миски

        for (Cat cat: cats){
            plate.info();
            cat.eat(plate);
            plate.info();
            cat.info();
        }
    }
}
