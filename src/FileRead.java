import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by SuryaRajasekaran on 4/12/17.
 */
public class FileRead {

    public String filePath;

    public FileRead(String filePath){
        this.filePath = filePath;
    }

    public String getFileContents(){
        String outStr = "";
        try {
            String line = null;
            FileReader fileReader = new FileReader(this.filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                outStr += line;
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + this.filePath + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + this.filePath + "'");
        }
        return outStr.trim().replaceAll(" +", " ");
    }


}
