/**
 * Created by SuryaRajasekaran on 4/11/17.
 */
public class Main {

    public static void main(String[] args){

        DocumentsProcessor documentsProcessor = new DocumentsProcessor("/Users/SuryaRajasekaran/scratch/coen281p1/input/f1Surya.txt",
                                                                    "/Users/SuryaRajasekaran/scratch/coen281p1/input/f1.txt",
                                                                    "/Users/SuryaRajasekaran/scratch/coen281p1/input/f2.txt",
                                                                    "/Users/SuryaRajasekaran/scratch/coen281p1/input/f2.txt",
                                                                    "/Users/SuryaRajasekaran/scratch/coen281p1/input/f4.txt",
                                                                    "/Users/SuryaRajasekaran/scratch/coen281p1/input/f4.txt"
                                                                   );



        documentsProcessor.processDocuments();
    }
}
