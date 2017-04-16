import java.util.HashMap;
import java.util.Map;

/**
 * Created by SuryaRajasekaran on 4/14/17.
 */
public class JaccardSimilaritySignatureMatrix {

    int[][] signatureMatrix;
    int[][] intersectionArray;
    int[][] unionArray;
    float[][] documentSimilarityArray;
    Boolean[][] documentSimilarityThresholdArray;

    public JaccardSimilaritySignatureMatrix(int[][] signatureMatrix){
        this.signatureMatrix = signatureMatrix;
        this.intersectionArray = new int[this.getTotalDocumentsCount()][this.getTotalDocumentsCount()];
        this.unionArray = new int[this.getTotalDocumentsCount()][this.getTotalDocumentsCount()];
        this.documentSimilarityArray = new float[this.getTotalDocumentsCount()][this.getTotalDocumentsCount()];
        this.documentSimilarityThresholdArray = new Boolean[this.getTotalDocumentsCount()][this.getTotalDocumentsCount()];
        this.getDocumentSimilarityMatrix();
        this.getDocumentSimilarityThresholdMatrix();
    }

    public int getTotalDocumentsCount(){
        return 7;
    }

    public float[][] getDocumentSimilarityMatrix() {

        for (int i=0; i<MinHashing.HASH_LIMIT;i++){
            for (int j=0; j<this.getTotalDocumentsCount(); j++){
                for (int k=0; k<this.getTotalDocumentsCount(); k++){
                    if (this.signatureMatrix[i][j] == this.signatureMatrix[i][k]) {
                        this.intersectionArray[j][k] += 1;
                        this.unionArray[j][k] +=1;
                    } else {
                        this.intersectionArray[j][k] += 0;
                        this.unionArray[j][k] +=2;
                    }
                }
            }
        }

        for (int i=0; i<this.getTotalDocumentsCount(); i++) {
            for (int j=0; j<this.getTotalDocumentsCount(); j++){
                this.documentSimilarityArray[i][j] = (float) this.intersectionArray[i][j] / (float) this.unionArray[i][j];
            }
        }
        return this.documentSimilarityArray;
    }

    public Boolean[][] getDocumentSimilarityThresholdMatrix() {
        for (int i=0; i<this.getTotalDocumentsCount(); i++) {
            for (int j=0; j<this.getTotalDocumentsCount(); j++){
                if (this.documentSimilarityArray[i][j] > 0.5)
                    this.documentSimilarityThresholdArray[i][j] = true;
                else
                    this.documentSimilarityThresholdArray[i][j] = false;

            }
        }
        return this.documentSimilarityThresholdArray;
    }

    public void printDocumentSimilarityThresholdMatrix(){
        System.out.println("-----------------------------------");
        System.out.println("Document Similarity Threshold Matrix");
        System.out.print("\t\t");
        for (int i=0; i<this.getTotalDocumentsCount(); i++) {
            System.out.format("%10s", "D" + i);
        }
        System.out.println();
        for (int i=0; i<this.getTotalDocumentsCount(); i++) {
            System.out.print("D" + i + "\t\t");
            for (int j=0; j<this.getTotalDocumentsCount(); j++){
                System.out.format("%10s", this.documentSimilarityThresholdArray[i][j].toString());
            }
            System.out.println();
        }
    }

    public void printDocumentSimilarityMatrix(){
        System.out.println("-----------------------------------");
        System.out.println("Document Similarity Matrix");
        System.out.print("\t\t");
        for (int i=0; i<this.getTotalDocumentsCount(); i++) {
            System.out.format("%10s", "D" + i);
        }
        System.out.println();
        for (int i=0; i<this.getTotalDocumentsCount(); i++) {
            System.out.print("D" + i + "\t\t");
            for (int j=0; j<this.getTotalDocumentsCount(); j++){
                System.out.format("%10f", this.documentSimilarityArray[i][j]);
            }
            System.out.println();
        }
    }

    public void printIntersectionArray(){
        System.out.println("-----------------------------------");
        System.out.println("Intersection Array Matrix");
        System.out.print("\t\t");
        for (int i=0; i<this.getTotalDocumentsCount(); i++) {
            System.out.format("%10s", "D" + i);
        }
        System.out.println();
        for (int i=0; i<this.getTotalDocumentsCount(); i++) {
            System.out.print("D" + i + "\t\t");
            for (int j=0; j<this.getTotalDocumentsCount(); j++){
                System.out.format("%10d", this.intersectionArray[i][j]);
            }
            System.out.println();
        }
    }

    public void printUnionArray(){
        System.out.println("-----------------------------------");
        System.out.println("Union Array Matrix");
        System.out.print("\t\t");
        for (int i=0; i<this.getTotalDocumentsCount(); i++) {
            System.out.format("%10s", "D" + i);
        }
        System.out.println();
        for (int i=0; i<this.getTotalDocumentsCount(); i++) {
            System.out.print("D" + i + "\t\t");
            for (int j=0; j<this.getTotalDocumentsCount(); j++){
                System.out.format("%10d", this.unionArray[i][j]);
            }
            System.out.println();
        }
    }

}
