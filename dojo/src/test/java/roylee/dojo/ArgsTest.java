package roylee.dojo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArgsTest {

    @Test
    public void whenBooleanFlagThenOutputBoolean() {
        assertThat(new Args("l", new String[]{"-l"}).getBoolean("l"), is(true));
        assertThat(new Args("l", new String[]{""}).getBoolean("l"), is(false));
    }
}
