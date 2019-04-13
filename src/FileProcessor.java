import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class FileProcessor {
    private static ArrayList<String> readFile(String fileName ){
        FileInputStream fin= null;
        int i;
        StringBuilder word = new StringBuilder();
        ArrayList<String> words = new ArrayList<String>();
        try {
            fin = new FileInputStream(fileName);
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try{
            do {
                i = fin.read();
                if ( i != -1 ) {

                    char reader = (char)(i);
                    if (Character.isLetter(reader)){
                     word.append(reader);

                    }
                   /* if (reader=='\'') {
                        i =(char)fin.read();
                        if (Character.isLetter(i)) {
                            word.append('\'');
                           // word.append(temp);
                        }
                    }*/
                    if ((Character.isSpaceChar(reader))||!(Character.isLetter(reader))) {
                        if (reader == '\'') {
                            char temp = (char) fin.read();
                            if (Character.isLetter(temp)) {
                                word.append(reader);
                                word.append(temp);
                            }
                        } else {
                            // System.out.println(word.toString());
                            if ((words.indexOf(word.toString().toLowerCase())) == -1) {
                                words.add(word.toString().toLowerCase());
                                word.delete(0, word.length());
                            }
                        }
                    }
                }
            } while ( i != - 1 );
            words.add(word.toString().toLowerCase());
            } catch (IOException e) {
            System.out.println(e.getMessage());
        } try{
        fin.close();} catch (IOException e) {
            System.out.println(e.getMessage());
        }
      return words;
    }



    private static void writeFile (String [] ar, String name) {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(name);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {

       Arrays.sort(readFile(args[0]).toArray());
    }
}
