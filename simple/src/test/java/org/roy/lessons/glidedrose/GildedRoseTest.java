package org.roy.lessons.glidedrose;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] {new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.passOneDay();
        assertThat(app.items[0].name,is("foo"));
    }

}
