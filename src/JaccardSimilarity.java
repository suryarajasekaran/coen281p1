import java.util.HashMap;
import java.util.Map;

/**
 * Created by SuryaRajasekaran on 4/14/17.
 */
public class JaccardSimilarity {

    HashMap<String, int[]> binaryMatrix;
    int[][] intersectionArray;
    int[][] unionArray;
    float[][] documentSimilarityArray;
    boolean[][] documentSimilarityThresholdArray;

    public JaccardSimilarity(HashMap<String, int[]> binaryMatrix){
        this.binaryMatrix = binaryMatrix;
        this.intersectionArray = new int[this.getTotalDocumentsCount()][this.getTotalDocumentsCount()];
        this.unionArray = new int[this.getTotalDocumentsCount()][this.getTotalDocumentsCount()];
        this.documentSimilarityArray = new float[this.getTotalDocumentsCount()][this.getTotalDocumentsCount()];
        this.documentSimilarityThresholdArray = new boolean[this.getTotalDocumentsCount()][this.getTotalDocumentsCount()];
        this.getDocumentSimilarityMatrix();
        this.getDocumentSimilarityThresholdMatrix();
    }

    public int getTotalDocumentsCount(){
        return 3;//this.binaryMatrix.get(this.binaryMatrix.get(this.binaryMatrix.keySet().toArray()[0])).length;
    }

    public float[][] getDocumentSimilarityMatrix() {
        for (Map.Entry<String,int[]> item : this.binaryMatrix.entrySet()) {
            String key = item.getKey();
            int[] value = item.getValue();
            for (int i=0; i<value.length; i++) {
                for (int j=0; j<value.length; j++){
                    if ((value[i] == 0) && (value[j] == 0)){
                        continue;
                    }
                    else {
                        if (value[i] == value[j]) {
                            this.intersectionArray[i][j] +=1;
                            this.unionArray[i][j] +=1;
                        } else {
                            this.intersectionArray[i][j] +=0;
                            this.unionArray[i][j] +=1;
                        }
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

    public boolean[][] getDocumentSimilarityThresholdMatrix() {
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

        for (int i=0; i<this.getTotalDocumentsCount(); i++) {
            for (int j=0; j<this.getTotalDocumentsCount(); j++){
                System.out.print(this.documentSimilarityThresholdArray[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void printDocumentSimilarityMatrix(){

        for (int i=0; i<this.getTotalDocumentsCount(); i++) {
            for (int j=0; j<this.getTotalDocumentsCount(); j++){
                System.out.print(this.documentSimilarityArray[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void printIntersectionArray(){

        for (int i=0; i<this.getTotalDocumentsCount(); i++) {
            for (int j=0; j<this.getTotalDocumentsCount(); j++){
                System.out.print(this.intersectionArray[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void printUnionArray(){

        for (int i=0; i<this.getTotalDocumentsCount(); i++) {
            for (int j=0; j<this.getTotalDocumentsCount(); j++){
                System.out.print(this.intersectionArray[i][j] + "\t");
            }
            System.out.println();
        }
    }



}
