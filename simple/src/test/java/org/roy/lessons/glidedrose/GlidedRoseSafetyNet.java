package org.roy.lessons.glidedrose;

import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class GlidedRoseSafetyNet {

    @Test
    public void equalToBaseLine() throws IOException {
        String thisResult = TextTestFixture.getBaseLine();
        System.out.println(thisResult);
        String baseLine = Files.toString(new File("src/test/resources/baseline.txt"), UTF_8);
        System.out.println(baseLine);
        Assert.assertTrue(thisResult.equals(baseLine));

    }
}
