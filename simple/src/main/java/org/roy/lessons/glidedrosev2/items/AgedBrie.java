package org.roy.lessons.glidedrosev2.items;

import org.roy.lessons.glidedrosev2.Item;

public class AgedBrie extends Item {
    public AgedBrie(Integer sellIn, Integer quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        increaseQualityByOne();
    }

    @Override
    protected void updateQualityAfterExpired() {
        increaseQualityByOne();
    }
}
