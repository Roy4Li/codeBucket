package org.roy.lessons.glidedrose;

public class Item {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public boolean isBackStagePass() {
        return this.name.equals(BACKSTAGE_PASS);
    }

    public boolean isAgedBrie() {
        return this.name.equals(AGED_BRIE);
    }

    public boolean isSulfuras() {
        return this.name.equals(SULFURAS);
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

    private void updateQuality() {
        if (!isAgedBrie()
                && !isBackStagePass()) {
            if (quality > 0) {
                if (!isSulfuras()) {
                    quality = quality - 1;
                }
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (isBackStagePass()) {
                    if (sellIn < 11) {
                        if (quality < 50) quality = quality + 1;
                    }

                    if (sellIn < 6) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }
                }
            }
        }
    }

    private void updateSellInDays() {
        if (!isSulfuras()) {
            sellIn = sellIn - 1;
        }
    }

    private void updateQualityAfterExpired() {
        if (!isAgedBrie()) {
            if (!isBackStagePass()) {
                if (quality > 0) {
                    if (!isSulfuras()) {
                        quality = quality - 1;
                    }
                }
            } else {
                quality = quality - quality;
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }

    private boolean isExpired() {
        return sellIn < 0;
    }
}
