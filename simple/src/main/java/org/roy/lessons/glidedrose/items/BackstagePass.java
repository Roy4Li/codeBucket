package org.roy.lessons.glidedrose.items;

import org.roy.lessons.glidedrose.Item;

public class BackstagePass extends Item {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";


    @Override
    protected boolean isBackStagePass() {
        return true;
    }

    public BackstagePass(int sellIn, int quality) {
        super(BACKSTAGE_PASS,sellIn,quality);
    }
}
