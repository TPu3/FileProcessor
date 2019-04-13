import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class FileProcessor {
    private static String readWord(String fileName ){
        FileInputStream fin= null;
        int i;
        StringBuilder word = new StringBuilder();

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


                    if (!(Character.isLetter(reader))||(Character.isWhitespace(reader))){
                        if (reader=='\'') {
                            char temp =(char)fin.read();
                            if (Character.isLetter(temp)) {
                                word.append('\'');
                                word.append(temp);
                            }
                        } else break;
                    }

                }
            } while ( i != - 1 );

            } catch (IOException e) {
            System.out.println(e.getMessage());
        } try{
        fin.close();} catch (IOException e) {
            System.out.println(e.getMessage());
        }
      return word.toString();
    }

    private static void writeFile (ArrayList<String> list) {
        //Arrays.sort(list.toArray());
        Collections.sort(list);
        for (String coun: list
             ) {
            System.out.println(coun);
            
        }
    }

    public static void main(String[] args) {
      ArrayList <String> list = new ArrayList<>();

      String word = readWord(args[0]);
        while (true) {
            if (list.indexOf(word) == -1) {
                list.add(word);
            }
        }

     // writeFile(list);

    }
}
