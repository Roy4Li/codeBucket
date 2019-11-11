package org.roy.lessons.glidedrose.items;

import org.roy.lessons.glidedrose.Item;

public class AgedBrie extends Item {
    public static final String AGED_BRIE = "Aged Brie";

    public AgedBrie(int sellIn, int quality) {
        super(AGED_BRIE,sellIn,quality);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
    }

    @Override
    protected void updateQualityAfterExpired() {
        increaseQuality();
    }


}
