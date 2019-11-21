package org.roy.lessons.glidedrosev2;

import org.junit.Test;
import org.roy.lessons.glidedrosev2.items.Conjured;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ConjuredTest {


    @Test
    public void whenPassOneDayThenDegradeTwice() {
        Item conjuredItem = new Conjured(2,20);
        conjuredItem.passOneDay();
        assertThat(conjuredItem.quality,is(18));

        conjuredItem.passOneDay();
        assertThat(conjuredItem.quality,is(16));

        conjuredItem.passOneDay();
        assertThat(conjuredItem.quality,is(12));
    }
}
