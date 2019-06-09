package org.roy.lessons.xjtdd;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lilei on 2019/6/9.
 */
public class GameNumberTest {

    @Test
    public void speakNormal() {
        Assert.assertTrue(GameNumber.say(1).equals("1"));
        Assert.assertTrue(GameNumber.say(2).equals("2"));
        Assert.assertTrue(GameNumber.say(3).equals("Fizz"));
        Assert.assertTrue(GameNumber.say(5).equals("Buzz"));
        Assert.assertTrue(GameNumber.say(15).equals("FizzBuzz"));
        // contains
        Assert.assertTrue(GameNumber.say(13).equals("Fizz"));
        Assert.assertTrue(GameNumber.say(52).equals("Buzz"));
        Assert.assertTrue(GameNumber.say(53).equals("FizzBuzz"));

    }
}