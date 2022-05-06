package homework6;

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal("CatsCategory");
        Cat cat = new Cat("Муся", 200, false);
        Cat cat1 = new Cat("Барсик", 150, false);
        animal.animalInfo();
        cat.animalInfo();
        cat.catInfo();
        cat1.animalInfo();
        cat1.catInfo();

        Animal danimal = new Animal("Dogs");
        Dog dog = new Dog("Боб", 500, 10);
        Dog dog1 = new Dog("Шарик", 300, 5);
        danimal.animalInfo();
        dog.animalInfo();
        dog.dogInfo();
        dog1.animalInfo();
        dog1.dogInfo();

    }
}
