package org.roy.lessons.jcp;

public class VolatileExample {
    private Integer normalInteger = 0;

    private volatile Integer volatileInt = 0;

    public void incrementNormal() {
        normalInteger++;
    }

    public void incrementVolatile() {
        volatileInt++;
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        example.incrementNormal();
        System.out.println("normal=" + example.normalInteger);

        example.incrementVolatile();
        System.out.println("volatile=" + example.volatileInt);
    }
}
