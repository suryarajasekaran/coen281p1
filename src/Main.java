/**
 * Created by SuryaRajasekaran on 4/11/17.
 */
public class Main {

    public static void main(String[] args){

        for (String detailFilePath : args) {
            FileCheck fileCheck = new FileCheck(detailFilePath);
            if (fileCheck.isFile(detailFilePath) == true) {
                if (fileCheck.checkInnerFiles() == true) {
                    if (fileCheck.getInnerFiles() != null) {
                        DocumentsProcessor documentsProcessor = new DocumentsProcessor(fileCheck.getInnerFiles());
                        documentsProcessor.processDocuments();
                    } else {
                        System.out.format("input file %s data inner files are invalid", detailFilePath);
                    }
                }
                else {
                    System.out.format("input file %s data is invalid", detailFilePath);
                }
            } else {
                System.out.format("input file %s is invalid", detailFilePath);
            }


        }
    }
}
