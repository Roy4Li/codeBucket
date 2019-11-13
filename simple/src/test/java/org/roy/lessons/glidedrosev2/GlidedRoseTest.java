package org.roy.lessons.glidedrosev2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class GlidedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GlidedRose app = new GlidedRose(items);
        app.passOneDay();
        assertThat(app.items[0].name, not("fixme"));
    }

}