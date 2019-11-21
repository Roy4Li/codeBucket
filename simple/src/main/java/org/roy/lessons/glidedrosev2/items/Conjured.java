package org.roy.lessons.glidedrosev2.items;

import org.roy.lessons.glidedrosev2.Item;

public class Conjured extends Item {

    @Override
    protected void updateQuality() {
        decreaseQualityByOne();
        decreaseQualityByOne();
    }

    public Conjured(Integer sellIn, Integer quality) {
        super("Conjured", sellIn, quality);
    }

    @Override
    protected void updateQualityAfterExpired() {
        decreaseQualityByOne();
        decreaseQualityByOne();
    }
}
