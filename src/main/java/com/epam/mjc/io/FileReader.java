package com.epam.mjc.io;

import java.io.*;
import java.io.IOException;
import java.util.Arrays;




public class FileReader {

    public Profile getDataFromFile(File file) {
        if (file == null) {
            return new Profile();
        }
        String def = "";
        try (java.io.FileReader fr = new java.io.FileReader(file))
        {
            int content;
            while ((content = fr.read()) != -1) {
                if (content != 13) {
                    def += (char) content;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        def = def.replace("Name: ", "");
        def = def.replace("Age: ", "");
        def = def.replace("Email: ", "");
        def = def.replace("Phone: ", "");
        String[] result = def.split("\n");
        return new Profile(result[0], Integer.valueOf(result[1]), result[2], Long.valueOf(result[3]));
    }

    public static void main(String[] args) {
        FileReader f = new FileReader();
        f.getDataFromFile(new File("src/main/resources/Profile.txt"));
    }
}
