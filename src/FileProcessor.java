/**
 * EXC 7.6.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class FileProcessor {
    private static ArrayList<String> readFile(String fileName) {
        FileInputStream fin = null;
        int i;
        StringBuilder word = new StringBuilder();
        ArrayList<String> words = new ArrayList<>();

        try {
            fin = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            do {
                i = fin.read();
                if (i != -1) {
                    char reader = (char) (i);
                    if (Character.isLetter(reader)) {
                        word.append(reader);
                    }

                    if ((Character.isSpaceChar(reader)) || !(Character.isLetter(reader))) {
                        if (reader == '\'') {
                            char temp = (char) fin.read();
                            if (Character.isLetter(temp)) {
                                word.append(reader);
                                word.append(temp);
                            }
                        } else {

                            if (((words.indexOf(word.toString().toLowerCase())) == -1) && (word.length() > 0)) {
                                words.add(word.toString().toLowerCase());
                            }
                            word.delete(0, word.length());
                        }
                    }
                }
            } while (i != -1);
            if ((words.contains(word.toString().toLowerCase()))) {
                words.add(word.toString().toLowerCase());
            }
            word.delete(0, word.length());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            fin.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return words;
    }


    private static void writeFile(ArrayList<String> ar, String name) {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(name);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        for (String row : ar
        ) {
            byte[] buf = row.getBytes();
            try {
                fout.write(buf);
                fout.write('\n');
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    public static void main(String[] args) {
        ArrayList<String> list = readFile(args[0]);
        Collections.sort(list);
        for (String coun : list
        ) {
            System.out.println(coun);

        }
        writeFile(list, "OUTPUT.TXT");
    }
}
