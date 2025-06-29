package model;

public class CounterTag {

    private String name;
    private int count;

    public CounterTag(String nome) {
        this.name = nome.toLowerCase();
        this.count = 1;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }
}
