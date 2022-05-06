package homework6;

public class Cat  extends Animal{

    protected boolean swim;

    public Cat(String name, int run, boolean swim) {
        this.name = name;
        this.run = run;
        this.swim = swim;
    }

    public void catInfo() {
        System.out.println("Cat: " + name + " пробежал(а): " + run+ " метров; " + " проплал(а): " + swim + " (кошачьи не плавают).");
    }
}
