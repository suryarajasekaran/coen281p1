import java.util.List;

/**
 * Created by SuryaRajasekaran on 4/15/17.
 */
public class DocumentsProcessor {

    public String[] documents;

    public DocumentsProcessor(String[] documents){
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
        JaccardSimilarityBinaryMatrix jaccardSimilarityBinaryMatrix = new JaccardSimilarityBinaryMatrix(binaryMatrix.getBinaryMatrix());

        int HASH_LIMIT_PERMUTATIONS = OptimalCalculator.calculateOptimalPermutations(binaryMatrix.getShinglesCount());

        SignatureMatrix signatureMatrix = new SignatureMatrix(shinglingResults, HASH_LIMIT_PERMUTATIONS);
        signatureMatrix.printSignatureMatrix();
        JaccardSimilaritySignatureMatrix jaccardSimilaritySignatureMatrix = new JaccardSimilaritySignatureMatrix(signatureMatrix.getSignatureMatrix(), HASH_LIMIT_PERMUTATIONS);

        double d1 = 0.2;
        double d2 = 0.8;
        double p1 = 0.997;
        double p2 = 0.003;

        int rows = OptimalCalculator.calculateOptimalBandRow(0.2, 0.8, 0.997, 0.003, OptimalCalculator.calculateOptimalBandRowPairs(HASH_LIMIT_PERMUTATIONS))[0];
        int bands = OptimalCalculator.calculateOptimalBandRow(0.2, 0.8, 0.997, 0.003, OptimalCalculator.calculateOptimalBandRowPairs(HASH_LIMIT_PERMUTATIONS))[1];

        LocalitySensitiveHashing localitySensitiveHashing = new LocalitySensitiveHashing(signatureMatrix.getSignatureMatrix(), bands, rows, HASH_LIMIT_PERMUTATIONS);

        //jaccardSimilarityBinaryMatrix.printIntersectionArray();
        //jaccardSimilarityBinaryMatrix.printUnionArray();
        jaccardSimilarityBinaryMatrix.printDocumentSimilarityMatrix();
        jaccardSimilarityBinaryMatrix.printDocumentSimilarityThresholdMatrix();
        //jaccardSimilaritySignatureMatrix.printIntersectionArray();
        //jaccardSimilaritySignatureMatrix.printUnionArray();
        jaccardSimilaritySignatureMatrix.printDocumentSimilarityMatrix();
        jaccardSimilaritySignatureMatrix.printDocumentSimilarityThresholdMatrix();
        OptimalCalculator.printOptimalBandRowPairs(OptimalCalculator.calculateOptimalBandRowPairs(HASH_LIMIT_PERMUTATIONS));
        localitySensitiveHashing.printBandSignatureMatrix();
        localitySensitiveHashing.printLSHBandBuckets();
        localitySensitiveHashing.printDocumentSimilarityThresholdMatrix();
        jaccardSimilarityBinaryMatrix.printDocumentSimilarityThresholdMatrix();
    }
}
