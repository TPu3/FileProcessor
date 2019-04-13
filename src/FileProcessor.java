import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


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
                            word.append(temp);
                        }
                    }
                    if (!(Character.isLetter(reader))){
                      break;
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

   // private static void writeFile (ArrayList<>)

    public static void main(String[] args) {
        System.out.println(  readWord(args[0]));
    }
}
