package org.roy.lessons.glidedrosev3;

import org.junit.Test;
import org.roy.lessons.glidedrosev3.GlidedRose;
import org.roy.lessons.glidedrosev3.Item;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class GlidedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GlidedRose app = new GlidedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, not("fixme"));
    }

}