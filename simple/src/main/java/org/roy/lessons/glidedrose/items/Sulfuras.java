package org.roy.lessons.glidedrose.items;

import org.roy.lessons.glidedrose.Item;

public class Sulfuras extends Item {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(int sellIn, int quality) {
        super(SULFURAS,sellIn,quality);
    }

    @Override
    protected boolean isSulfuras() {
        return true;
    }
}
