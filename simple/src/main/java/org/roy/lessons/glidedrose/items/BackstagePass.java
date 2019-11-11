package org.roy.lessons.glidedrose.items;

import org.roy.lessons.glidedrose.Item;

public class BackstagePass extends Item {
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePass(int sellIn, int quality) {
        super(BACKSTAGE_PASS, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
        if (sellIn < 11) {
            increaseQuality();
        }
        if (sellIn < 6) {
            increaseQuality();
        }
    }

    @Override
    protected void updateQualityAfterExpired() {
        quality = 0;
    }

}
