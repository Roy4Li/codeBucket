package org.roy.lessons.glidedrose;

public class Item {

    public String name;
    public int sellIn;
    public int quality;

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }


    public void passOneDay() {
        updateQuality();
        updateSellInDays();

        if (isExpired()) {
            updateQualityAfterExpired();
        }
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    protected void updateSellInDays() {
        sellIn = sellIn - 1;
    }

    protected void updateQualityAfterExpired() {
        decreaseQuality();
    }

    private void decreaseQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    protected void increaseQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    private boolean isExpired() {
        return sellIn < 0;
    }
}
