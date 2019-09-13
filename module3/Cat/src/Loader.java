
public class Loader
{
    public static void main(String[] args) {
        System.out.println("Урок 1_____________________________");

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();

        System.out.println(cat1.getWeight());
        System.out.println(cat2.getWeight());
        System.out.println(cat3.getWeight());
        System.out.println(cat4.getWeight());
        System.out.println(cat5.getWeight());

        System.out.println(Cat.getCount());

        cat1.feed(1000.0);
        System.out.println(cat1.getWeight());
        cat2.drink(500.0);
        System.out.println(cat2.getWeight());

        System.out.println();

        cat3.feed(cat3.getWeight() * 10);
        System.out.println(cat3.getStatus());

        System.out.println(Cat.getCount());

        for (int i = 0; i < 10000; ++i) {
            cat4.meow();
        }
        System.out.println(cat4.getStatus());

        System.out.println();
        System.out.println("Урок 2_____________________________");

        System.out.println(cat1.getFoodAmount());
        cat5.toilet();

        System.out.println();
        System.out.println("Урок 3_____________________________");

        System.out.println(Cat.getCount());

        System.out.println();
        System.out.println("Урок 5_____________________________");

        Cat cat6 = new Cat(5000.0);
        System.out.println(cat6.getWeight());
        Cat cat7 = createCat(2500.0);
        System.out.println(cat7.getWeight());
        System.out.println(Cat.getCount());

        System.out.println();
        System.out.println("Урок 6_____________________________");

        cat1.setColour(Colours.WHITE);
        System.out.println(cat1.getColour());

        System.out.println();
        System.out.println("Урок 7_____________________________");

        Cat cloneCat1 = Cat.createClone(cat1);
        System.out.println(cloneCat1.getWeight());
        System.out.println(cloneCat1.getFoodAmount());
        System.out.println(cloneCat1.getColour());
        System.out.println(Cat.getCount());

        System.out.println("___________________________________");

        Cat cat8 = new Cat(800);
        System.out.println(Cat.getCount());
        Cat cloneCat8 = Cat.createClone(cat8);
        System.out.println(Cat.getCount());
    }

    public static Cat createCat(double weight) {
        Cat cat = new Cat(weight);
        return cat;
    }
}