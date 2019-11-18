package org.roy.lessons.glidedrosev2;


import org.roy.lessons.glidedrosev2.items.AgedBrie;
import org.roy.lessons.glidedrosev2.items.BackstagePass;
import org.roy.lessons.glidedrosev2.items.Sulfuras;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.roy.lessons.glidedrosev2.Item.*;

public class TextTestFixture {
    public static void main(String[] args) {
        String baseLine = outputBaseLine();
        System.out.print(baseLine);
    }

    public static String outputBaseLine() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        printStream.println("OMGHAI!");

        Item[] items = new Item[] {
                createNormal("+5 Dexterity Vest", 10, 20), //
                new AgedBrie(2, 0),
                createNormal("Elixir of the Mongoose", 5, 7), //
                new Sulfuras(0, 80),
                new Sulfuras(-1, 80),
                new BackstagePass(15, 20),
                new BackstagePass(10, 49),
                new BackstagePass(5, 49),
                // this conjured item does not work properly yet
                createNormal("Conjured Mana Cake", 3, 6) };

        GlidedRose app = new GlidedRose(items);

        int days = 3;

        for (int i = 0; i < days; i++) {
            printStream.println("-------- day " + i + " --------");
            printStream.println("name, sellIn, quality");
            for (Item item : items) {
                printStream.println(item);
            }
            printStream.println();
            app.passOneDay();
        }
        return out.toString();
    }
}
