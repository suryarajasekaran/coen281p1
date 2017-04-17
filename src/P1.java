import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by SuryaRajasekaran on 4/11/17.
 */
public class P1 {

    public static void main(String[] args) {

        /*System.out.println();
        System.out.println("======================================================================");
        Scanner scanner = new Scanner(System.in);
        List<String> fileList = new ArrayList<String>();
        while (scanner.hasNext()) {
            String detailFilePath = scanner.next();
            if (detailFilePath.isEmpty() || detailFilePath.equals("") || detailFilePath.equals(" ")) {
                break;
            } else {
                fileList.add("/home/mwang2/test/coen281/" + detailFilePath);
            }
        }*/
        List<String> fileList = new ArrayList<String>();
        fileList.add("/Users/SuryaRajasekaran/scratch/coen281p1/input/f1.txt");
        fileList.add("/Users/SuryaRajasekaran/scratch/coen281p1/input/f1Surya.txt");
        fileList.add("/Users/SuryaRajasekaran/scratch/coen281p1/input/f2.txt");
        fileList.add("/Users/SuryaRajasekaran/scratch/coen281p1/input/f2.txt");
        fileList.add("/Users/SuryaRajasekaran/scratch/coen281p1/input/f4.txt");
        fileList.add("/Users/SuryaRajasekaran/scratch/coen281p1/input/f5.txt");
        fileList.add("/Users/SuryaRajasekaran/scratch/coen281p1/input/f6.txt");

        System.out.println("Entered Files : ");
        System.out.println(fileList);
        boolean fileCheckStatus = true;
        for (int i = 0; i < fileList.size(); i++) {
            if (FileCheck.isFile(fileList.get(i)) == true) {
                continue;
            } else {
                fileCheckStatus = false;
                break;
            }
        }

        if (fileCheckStatus == false || fileList.size() == 0) {
            System.out.println("-----------------------------------");
            System.out.println("ERROR : input file is invalid OR does not exist OR is not readable");
        } else {
            System.out.println("-----------------------------------");
            System.out.println("File Mapper");
            for (int i = 0; i < fileList.size(); i++) {
                System.out.println("D" + i + " : " + fileList.get(i));
            }
            String[] fileArray = new String[fileList.size()];
            fileArray = fileList.toArray(fileArray);
            DocumentsProcessor documentsProcessor = new DocumentsProcessor(fileArray);
            documentsProcessor.processDocuments();
        }
    }
}
