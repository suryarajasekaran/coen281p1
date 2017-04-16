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

        /*DocumentsProcessor documentsProcessor = new DocumentsProcessor("/Users/SuryaRajasekaran/scratch/coen281p1/input/f1Surya.txt",
                                                                    "/Users/SuryaRajasekaran/scratch/coen281p1/input/f1.txt",
                                                                    "/Users/SuryaRajasekaran/scratch/coen281p1/input/f2.txt",
                                                                    "/Users/SuryaRajasekaran/scratch/coen281p1/input/f3.txt",
                                                                    "/Users/SuryaRajasekaran/scratch/coen281p1/input/f4.txt",
                                                                    "/Users/SuryaRajasekaran/scratch/coen281p1/input/f5.txt",
                                                                    "/Users/SuryaRajasekaran/scratch/coen281p1/input/f6.txt"
                                                                   );



        documentsProcessor.processDocuments();*/


    }
}
