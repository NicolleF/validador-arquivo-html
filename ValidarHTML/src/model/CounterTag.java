package model;

public class CounterTag {

    private String name;
    private int count;

    public CounterTag(String name) {
        this.name = name.toLowerCase();
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
