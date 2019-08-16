package core;

public class Car
{
    public String number; // Переменная типа String
    public int height; // Переменная типа int
    public double weight; // Переменная типа double
    public boolean hasVehicle; // Переменная типа boolean
    public boolean isSpecial; // Переменная типа boolean

    public String getNumber() {
        return number;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isHasVehicle() {
        return hasVehicle;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHasVehicle(boolean hasVehicle) {
        this.hasVehicle = hasVehicle;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : ""; // Переменная типа String
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}