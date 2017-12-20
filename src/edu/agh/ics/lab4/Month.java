package edu.agh.ics.lab4;

public enum Month {

    JAN("Styczeń", 31),
    FEB("Luty", 28),
    MAR("Marzec", 31),
    APR("Kwiecień", 30),
    MAY("Maj", 31),
    JUN("Czerwiec", 30),
    JUL("Lipiec", 31),
    AUG("Sierpień", 31),
    SEP("Wrzesień", 30),
    OCT("Październik", 31),
    NOV("Listopad", 30),
    DEC("Grudzień", 31);

    private final String name;

    private final int number;

    private final int numberOfDays;

    private Month(String name, int numberOfDays) {
        this.name = name;
        this.number = ordinal() + 1;
        this.numberOfDays = numberOfDays;
    }

    @Override
    public String toString() {
        return name + " " + number + " " + numberOfDays;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public Month getNext(Month m) {
        switch (m) {
            case JAN:
                return FEB;
            case FEB:
                return MAR;
            default:
                return DEC;
        }
    }
}
