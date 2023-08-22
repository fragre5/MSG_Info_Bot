package org.example.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

    private static final String fileName = "./src/main/resources/filmName.txt";

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static String readFileFilmName() {
        String name = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            name = reader.readLine();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}
