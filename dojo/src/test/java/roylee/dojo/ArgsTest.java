package roylee.dojo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArgsTest {

    @Test
    public void whenBooleanFlagAndNoArgThenFalse() {
        assertThat(new Args("l", new String[]{""}).getBoolean("l"), is(false));
    }

    @Test
    public void whenBooleanFlagAndHasArgThenArg() {
        assertThat(new Args("l", new String[]{"-l"}).getBoolean("l"), is(true));
    }


    @Test
    public void whenIntFlagAndHasArgThenArg() {
        assertThat(new Args("p#", new String[]{"-p","123"}).getInt('p'), is(123));
    }

    @Test
    public void whenIntFlagAndNoArgThenError() {
        try {
            new Args("p#", new String[]{"-l"}).getInt('p');
        } catch (Exception e) {
            assertThat(e.getMessage(), is("error"));
        }
    }
}
