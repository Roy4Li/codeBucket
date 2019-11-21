package org.roy.lessons.glidedrosev2;

public class Item {
    public String name;

    public int sellIn;

    public int quality;

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


    static public Item createNormal(String name, Integer sellIn, Integer quality) {
        return new Item(name, sellIn, quality);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void passOneDay() {
        updateSellInDays();
        updateQuality();
        if (isExpired()) {
            updateQualityAfterExpired();
        }
    }

    final protected void increaseQualityByOne() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    final protected void decreaseQualityByOne() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    protected void updateQuality() {
        decreaseQualityByOne();
    }

    protected void updateQualityAfterExpired() {
        decreaseQualityByOne();
        if (quality > 0) {
            quality = quality - 1;
        }
    }


    protected void updateSellInDays() {
        sellIn = sellIn - 1;
    }

    private boolean isExpired() {
        return sellIn < 0;
    }
}
