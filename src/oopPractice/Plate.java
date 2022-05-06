package oopPractice;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }

    //. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
    //(например, в миске 10 еды, а кот пытается покушать 15-20).
    public boolean decreaseFood(int n) {
        int completeness = food - n;
        if (completeness < 0) return false;

        food -= n;
        return true;
    }

    //5. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
    public void addFood(int food) {
        this.food += food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
