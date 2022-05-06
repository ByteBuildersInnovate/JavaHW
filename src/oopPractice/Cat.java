package oopPractice;

//Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
//удалось покушать (хватило еды), сытость = true.

public class Cat {
    private String name;
    private int appetite;
    private boolean hungry; //сытость

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true;
    }

    public void info() {
        String isSatiety = !hungry ? "голоден" : "сыт";
        System.out.println(name + ": " + isSatiety);
    }

    public void eat(Plate p) {
       if(hungry && p.decreaseFood(appetite))
           hungry = false;
    }
}
