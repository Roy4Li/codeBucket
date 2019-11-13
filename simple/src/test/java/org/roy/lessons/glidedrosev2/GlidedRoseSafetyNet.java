package org.roy.lessons.glidedrosev2;

import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GlidedRoseSafetyNet {

    @Test
    public void equalToBaseLine() throws IOException {
        String output = TextTestFixture.outputBaseLine();
        String baseLine = Files.toString(new File("src/test/resources/baselinev2.txt"), UTF_8);
        assertThat(output,is(baseLine));
    }
}
