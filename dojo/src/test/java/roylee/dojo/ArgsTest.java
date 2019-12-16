package roylee.dojo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ArgsTest {

    @Test
    public void whenBooleanFlagAndNoArgThenFalse() {
        assertThat(new Args("l", new String[]{""}).getBoolean("l"), is(false));
    }

    @Test
    public void whenBooleanFlagAndHasArgThenTrue() {
        assertThat(new Args("l", new String[]{"-l"}).getBoolean("l"), is(true));
    }


    @Test
    public void whenIntFlagAndHasArgThenArg() {
        assertThat(new Args("p#", new String[]{"-p", "123"}).getInt('p'), is(123));
    }

    @Test
    public void whenIntFlagAndNoArgThenError() {
        try {
            new Args("p#", new String[]{"-l"}).getInt('p');
            fail("should fail");
        } catch (Exception e) {
            assertThat(e.getMessage(), is("error"));
        }
    }

    @Test
    public void whenStringFlagAndHasArgThenString() {
        assertThat(new Args("p*", new String[]{"-p", "iamstring"}).getString('p'), is("iamstring"));
    }
}
