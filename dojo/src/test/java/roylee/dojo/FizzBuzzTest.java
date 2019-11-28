package roylee.dojo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzBuzzTest {
    FizzBuzz instance;

    @Before
    public void setUp() throws Exception {
        instance = new FizzBuzz();
    }

    @Test
    public void when7xThenWhizz() {
        assertThat(instance.sayTheNumber(7), is("Whizz"));
        assertThat(instance.sayTheNumber(14), is("Whizz"));
    }

    @Test
    public void when15xThenFizzBuzz() {
        assertThat(instance.sayTheNumber(15), is("FizzBuzz"));
        assertThat(instance.sayTheNumber(45), is("FizzBuzz"));
    }

    @Test
    public void when3xThenFizz() {
        assertThat(instance.sayTheNumber(3), is("Fizz"));
        assertThat(instance.sayTheNumber(9), is("Fizz"));

    }

    @Test
    public void when5xThenBuzz() {
        assertThat(instance.sayTheNumber(5), is("Buzz"));
        assertThat(instance.sayTheNumber(10), is("Buzz"));
    }

    @Test
    public void whenContains3ThenFizz() {
        assertThat(instance.sayTheNumber(31), is("Fizz"));
        assertThat(instance.sayTheNumber(73), is("Fizz"));
    }

    @Test
    public void whenOthersThenItself() {
        assertThat(instance.sayTheNumber(4), is("4"));
        assertThat(instance.sayTheNumber(17), is("17"));
    }





}