
public class Cat
{
    private double originWeight;
    private double weight;
    private Colours colour;
    private double foodAmount;

    private static int count;

    public static final int EYES_COUNT = 2;
    private static final double MIN_WEIGHT = 1000.0;
    private static final double MAX_WEIGHT = 9000.0;

    public Cat (double originWeight, double weight, double foodAmount, Colours colour) {
        this.originWeight = originWeight;
        this.weight = weight;
        this.foodAmount = foodAmount;
        this.colour = colour;
        addCountIfAlive();
    }

    public Cat (double weight) {
        this.weight = weight;
        originWeight = weight;
        addCountIfAlive();
    }

    public Cat() {
        this(1500.0 + 3000.0 * Math.random());
    }

    public void meow() {
        boolean wasAlive = isAlive();
        weight = weight - 1;
        System.out.println("Meow");
        if (wasAlive && !isAlive()) {
            count--;
        }
    }

    public void feed(Double amount) {
        boolean wasAlive = isAlive();
        weight = weight + amount;
        foodAmount += amount;
        if (wasAlive && !isAlive()) {
            count--;
        }
    }

    public void drink(Double amount) {
        boolean wasAlive = isAlive();
        weight = weight + amount;
        if (wasAlive && !isAlive()) {
            count--;
        }
    }

    public void toilet() {
        boolean wasAlive = isAlive();
        weight -= 10;
        System.out.println("Sorry, please clean...");
        if (wasAlive && !isAlive()) {
            count--;
        }
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if(weight < MIN_WEIGHT) {
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

    public double getFoodAmount() {
        return foodAmount;
    }

    public static int getCount() {
        return count;
    }

    public void setColour(Colours colour) {
        this.colour = colour;
    }

    public int addCountIfAlive() {
        if (isAlive()) {
            count++;
        } else {
            System.out.println("This cat is " + getStatus());
        }
        return count;
    }

    public Colours getColour() {
        return colour;
    }

    public static Cat createClone(Cat cat) {
        return new Cat(cat.originWeight, cat.weight, cat.foodAmount, cat.colour);
    }

    private boolean isAlive() {
        if (!(getStatus().equals("Dead") || getStatus().equals("Exploded"))) {
            return true;
        } else {
            return false;
        }
    }
}