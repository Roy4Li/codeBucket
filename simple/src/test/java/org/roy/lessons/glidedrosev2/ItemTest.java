package org.roy.lessons.glidedrosev2;

import org.junit.Test;
import org.roy.lessons.glidedrosev2.items.BackstagePass;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void backstagePassSholeIncreaseDouble() {
        Item backstagePass = new BackstagePass(11, 20);
        backstagePass.passOneDay();
        assertThat(backstagePass.quality,is(21));
        backstagePass.passOneDay();
        assertThat(backstagePass.quality,is(23));
    }
}