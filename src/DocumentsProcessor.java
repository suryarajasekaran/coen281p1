import java.util.List;

/**
 * Created by SuryaRajasekaran on 4/15/17.
 */
public class DocumentsProcessor {

    public String[] documents;

    public DocumentsProcessor(String... documents){
        this.documents = documents;
    }

    public void processDocuments(){
        List[] shinglingResults = new List[this.documents.length];
        for(int i = 0; i < this.documents.length; i++){
            FileRead fileRead = new FileRead(this.documents[i]);
            Shingling shingling = new Shingling(fileRead.getFileContents());
            shinglingResults[i] = shingling.getShingles();
        }
        BinaryMatrix binaryMatrix = new BinaryMatrix(shinglingResults);
        binaryMatrix.printBinaryMatrix();
        JaccardSimilarity jaccardSimilarity = new JaccardSimilarity(binaryMatrix.getBinaryMatrix());
        jaccardSimilarity.printDocumentSimilarityThresholdMatrix();

    }

}
