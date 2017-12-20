package edu.agh.ics.lab4;

import org.apache.log4j.Logger;

public class Pair<T> {
    private static Logger log = Logger.getLogger(EnumTest.class);

    private T first;

    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public void swap() {
        T tmp = first;
        first = second;
        second = tmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?> pair = (Pair<?>) o;

        if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
        return second != null ? second.equals(pair.second) : pair.second == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public static void main(String[] args) {
        Pair<Integer> pia = new Pair<>(1, 2);
        Pair<Integer> pib = new Pair<>(1, 2);
        log.info("Equals: " + pia.equals(pib));
        log.info("Hash codes: " + pia.hashCode() + ", " + pib.hashCode());
        pib.swap();
        log.info("Equals: " + pia.equals(pib));
        log.info("Hash codes: " + pia.hashCode() + ", " + pib.hashCode());

        Pair<String> psa = new Pair<>("Ala", "Ola");
        log.info(psa);
        psa.swap();
        log.info(psa);
    }
}
