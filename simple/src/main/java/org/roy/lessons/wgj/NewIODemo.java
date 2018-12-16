package org.roy.lessons.wgj;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by lilei on 2017/9/15.
 */
public class NewIODemo {

    public static void main(String[] args) {

    }

    private void copyFile(String sourcePath, String destPath) {
        Path source = Paths.get(sourcePath);
        Path target = Paths.get(destPath);
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
