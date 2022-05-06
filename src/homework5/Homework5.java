package homework5;

public class Homework5 {
    //    1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    //    2. Конструктор класса должен заполнять эти поля при создании объекта.
    //    3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    //    4. Создать массив из 5 сотрудников.
    //    5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.


    //класс "Сотрудники"
    public static class Worker {

        private String fullName;
        private String post;
        private String email;
        private String phone;
        private int salary;
        private int age;

        //конструктор
        public Worker(String fullName, String post, String email, String phone, int salary, int age) {
            this.fullName = fullName;
            this.post = post;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;

        }

        //переопределенный метод выводы в консоль
        @Override
        public String toString() {
            return String.format("Имя: %s \t Должность: %s \n Email: %s \t Номер телефона: %s \n Зарплата: %d \t " +
                    "Возраст: %d \n", fullName, post, email, phone, salary, age);
        }

        //метод вывода в клонсоль
        public void inference() {
            System.out.println(this);
        }

        //массив
        public static void main(String[] args) {

            Worker[] workArray = new Worker[5];
            workArray[0] = new Worker("Иванов Иван Иванови", "Фрезеровщик", "www@war.net",
                    "+79998887766", 1200000, 45);
            workArray[1] = new Worker("Игнатов Антон Искандерович", "Менеджер по продажам", "www@war.net",
                    "+79997776655", 100000, 40);
            workArray[2] = new Worker("Медведев Дмитрий Анатольевич", "Охранник", "www@war.net",
                    "+79996665544", 19000, 35);
            workArray[3] = new Worker("Палочкина Маргарита Изабеловна", "Инженер по тестированию", "www@war.net",
                    "+79995554433", 120000, 20);
            workArray[4] = new Worker("Короткая Виктория Сергеевна", "Почтальон",
                    "www@war.net", "+79994443322", 50000, 48);

            //цикл
            for (int i=0; i < workArray.length; i++)
                if (workArray[i].age > 40) workArray[i].inference();
        }
    }

}
