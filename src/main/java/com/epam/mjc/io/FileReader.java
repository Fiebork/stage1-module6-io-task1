package com.epam.mjc.io;

import java.io.*;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile p = new Profile();
        int isNext = 0;
        String name = "";
        String age = "";
        String email = "";
        String phone = "";

        try (java.io.FileReader fr = new java.io.FileReader(file))
        {
            int content;
            while ((content = fr.read()) != -1) {
                if ((char) content == ' ' && isNext == 0) {
                    isNext = 1;
                } else if ((char) content == '\n' && isNext == 1) {
                    isNext = 2;
                } else if (isNext == 1) {
                    name += (char) content;
                }

                else if ((char) content == ' ' && isNext == 2) {
                    isNext = 3;
                } else if ((char) content == '\n' && isNext == 3) {
                    isNext = 4;
                } else if (isNext == 3) {
                    age += (char) content;
                }

                else if ((char) content == ' ' && isNext == 4) {
                    isNext = 5;
                } else if ((char) content == '\n' && isNext == 5) {
                    isNext = 6;
                } else if (isNext == 5) {
                    email += (char) content;
                }

                else if ((char) content == ' ' && isNext == 6) {
                    isNext = 7;
                } else if ((char) content == '\n' && isNext == 7) {
                    isNext = 8;
                } else if (isNext == 7) {
                    phone += (char) content;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        p.setName(name.substring(0, name.length() - 1));
        p.setAge(Integer.valueOf(age.substring(0, age.length() - 1)));
        p.setEmail(email.substring(0, email.length() - 1));
        p.setPhone(Long.valueOf(phone.substring(0, phone.length() - 1)));

        return p;
    }

    public static void main(String[] args) {
        FileReader f = new FileReader();
        f.getDataFromFile(new File("src/main/resources/Profile.txt"));
    }
}
