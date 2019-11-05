package org.roy.lessons.glidedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void givenBackStagePassWhenClosingToExpirationThenDoubleIncreaseQualityValue() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
        backStagePass.passOneDay();
        assertThat(backStagePass.quality,is(21));
        backStagePass.passOneDay();
        assertThat(backStagePass.quality,is(23));

    }
}