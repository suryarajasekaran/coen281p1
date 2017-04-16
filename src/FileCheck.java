import java.io.*;

/**
 * Created by skasabar on 4/16/17.
 */
public class FileCheck {

    String detailFilePath;
    String filePathPrefix;

    public FileCheck(String detailFilePath){
        this.detailFilePath = detailFilePath;
        this.filePathPrefix = detailFilePath.substring(0, detailFilePath.lastIndexOf("/") + 1);
    }

    public static boolean isFile(String filePath){
        File file = new File(filePath);
        if (!file.exists())
            return false;
        if (!file.canRead())
            return false;
        try {
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            fileReader.read();
            fileReader.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String[] getInnerFiles(){
        String fileContents = this.getFileContents();
        String[] splitFileContents = fileContents.split("[\\t\\n\\r ]");
        String[] innerFiles = new String[splitFileContents.length];
        for (int i=0; i<splitFileContents.length; i++){
            innerFiles[i] = this.filePathPrefix + splitFileContents[i];
        }
        return innerFiles;
    }

    public boolean checkInnerFiles(){
        String[] innerFiles = this.getInnerFiles();
        for (int i=0; i<innerFiles.length; i++){
            if (this.isFile(innerFiles[i]) == false){
                return false;
            }
        }
        return true;
    }

    public String getFileContents(){
        String outStr = "";
        try {
            String line = null;
            FileReader fileReader = new FileReader(this.detailFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                outStr += line + "\n";
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + this.detailFilePath + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + this.detailFilePath + "'");
        }
        return outStr;
    }
}
