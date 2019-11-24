package roylee.dojo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzBuzzTest {

    @Test
    public void when3xThenFizz() {
        FizzBuzz instance = new FizzBuzz();
        String output = instance.sayTheNumber(3);
        assertThat(output,is("Fizz"));
    }

    @Test
    public void when5xThenBuzz() {
        FizzBuzz instance = new FizzBuzz();
        String output = instance.sayTheNumber(5);
        assertThat(output,is("Buzz"));
    }

    @Test
    public void when15xThenFizzBuzz() {
        FizzBuzz instance = new FizzBuzz();
        String output = instance.sayTheNumber(15);
        assertThat(output,is("FizzBuzz"));
    }

    @Test
    public void whenOthersThenItself() {
        FizzBuzz instance = new FizzBuzz();
        String output = instance.sayTheNumber(4);
        assertThat(output,is("4"));
    }

    @Test
    public void when7xThenWhizz() {
        FizzBuzz instance = new FizzBuzz();
        String output = instance.sayTheNumber(7);
        assertThat(output,is("Whizz"));
    }

    @Test
    public void whenContains3ThenFizz() {
        FizzBuzz instance = new FizzBuzz();
        String output = instance.sayTheNumber(31);
        assertThat(output,is("Fizz"));
    }
}