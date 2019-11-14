package org.roy.lessons.glidedrosev2;

public class GlidedRose {
    Item[] items;

    public GlidedRose(Item[] items) {
        this.items = items;
    }

    public void passOneDay() {
        for (Item item : items) {
            item.passOneDay();
        }
    }

}
