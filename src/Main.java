/**
 * Created by SuryaRajasekaran on 4/11/17.
 */
public class Main {

    public static void main(String[] args){

        for (String detailFilePath : args) {
            System.out.println("======================================================================");
            System.out.format("Processing Input File : %s", detailFilePath);
            System.out.println();
            FileCheck fileCheck = new FileCheck(detailFilePath);
            if (fileCheck.isFile(detailFilePath) == true) {
                if ((fileCheck.checkInnerFiles() == true) && (fileCheck.getInnerFiles() != null)) {
                    System.out.println("-----------------------------------");
                    System.out.println("Input File Mapping");
                    for (int i=0; i<fileCheck.getInnerFiles().length; i++){
                         System.out.println("D" + i + " : " + fileCheck.getInnerFiles()[i]);
                    }
                    DocumentsProcessor documentsProcessor = new DocumentsProcessor(fileCheck.getInnerFiles());
                    documentsProcessor.processDocuments();
                }
                else {
                    System.out.println("-----------------------------------");
                    System.out.format("ERROR : input file %s inner data files are invalid", detailFilePath);
                }
            } else {
                System.out.println("-----------------------------------");
                System.out.format("ERROR : input file %s is invalid OR does not exist OR is not readable", detailFilePath);
            }
        }
    }
}
