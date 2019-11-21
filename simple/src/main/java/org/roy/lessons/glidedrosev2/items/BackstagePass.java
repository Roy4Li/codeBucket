package org.roy.lessons.glidedrosev2.items;

import org.roy.lessons.glidedrosev2.Item;

public class BackstagePass extends Item {
    public BackstagePass(Integer sellIn, Integer quality) {
        super("Backstage passes to a TAFKAL80ETC concert",sellIn,quality);
    }

    @Override
    protected void updateQuality() {

        if (quality < 50) {
            quality = quality + 1;

            if (sellIn < 10) {
                increaseQualityByOne();
            }

            if (sellIn < 5) {
                increaseQualityByOne();
            }
        }
    }

    @Override
    protected void updateQualityAfterExpired() {
        quality = 0;
    }
}

