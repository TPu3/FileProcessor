import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class FileProcessor {
    private static ArrayList<String> readFile(String fileName ){
        FileInputStream fin= null;
        int i;
        StringBuilder word = new StringBuilder();
        ArrayList<String> words=null;
        try {
            fin = new FileInputStream(fileName);
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try{
            do {
                i = fin.read();
                if ( i != -1 ) {
                    int count = 0;
                    char reader = (char)(i);
                    if (Character.isLetter(reader)){
                     word.append(reader);
                     count++;
                    }
                    if (reader=='\'') {
                        char temp =(char)fin.read();
                        if (Character.isLetter(temp)) {
                            word.append('\'');
                        }
                    }
                    if ((Character.isSpaceChar(reader))&&(count>0)){
                        words.add(word.toString().toLowerCase());
                    }

                }
            } while ( i != - 1 );
            } catch (IOException e) {
            System.out.println(e.getMessage());
        } try{
        fin.close();} catch (IOException e) {
            System.out.println(e.getMessage());
        }
      return words;
    }

}
