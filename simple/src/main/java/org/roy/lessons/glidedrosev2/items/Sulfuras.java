package org.roy.lessons.glidedrosev2.items;

import org.roy.lessons.glidedrosev2.Item;

public class Sulfuras extends Item {
    public Sulfuras(Integer sellIn, Integer quality) {
        super("Sulfuras, Hand of Ragnaros",sellIn,quality);
    }

    @Override
    protected void updateSellInDays() {
        return;
    }

    @Override
    protected void updateQuality() {
        return;
    }
}
