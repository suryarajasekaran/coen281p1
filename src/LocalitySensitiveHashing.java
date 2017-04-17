import java.security.KeyException;
import java.util.*;

/**
 * Created by SuryaRajasekaran on 4/15/17.
 */
public class LocalitySensitiveHashing {

    int[][] signatureMatrix;
    int[][][] bandSignatureMatrix;
    int bands;
    int rows;
    int hashFunctions;
    int totalDocuments;
    int hashLimitPermutations;

    public LocalitySensitiveHashing( int[][] signatureMatrix, int bands, int rows, int hashLimitPermutations){
        this.hashLimitPermutations = hashLimitPermutations;
        this.signatureMatrix = signatureMatrix;
        this.bands = bands;
        this.hashFunctions = this.hashLimitPermutations;
        this.rows = rows;
        this.totalDocuments = this.signatureMatrix[0].length;
        this.bandSignatureMatrix = new int[this.bands][this.rows][this.totalDocuments];
        this.getBandSignatureMatrix();
    }

    public int[][] getLocalitySensitiveHashingMatrix(){
        int[][] localitySensitiveHashingMatrix = new int[this.bands][this.rows];
        return localitySensitiveHashingMatrix;
    }

    public int[][][] getBandSignatureMatrix() {
        for (int i =0; i<this.bands; i++ ){
            for (int j=0; j<this.rows; j++){
                for (int k=0; k<this.totalDocuments; k++){
                    try{
                        this.bandSignatureMatrix[i][j][k] = this.signatureMatrix[j+(i*this.rows)][k];
                    }
                    catch (ArrayIndexOutOfBoundsException aioob){
                        continue;
                    }
                }
            }
        }
        return this.bandSignatureMatrix;
    }

    public HashMap<Integer, List<String>>[] getLSHBandBuckets(){
        HashMap<Integer, List<String>>[] lshBandBuckets = new HashMap[this.bands];
        for (int i =0; i<this.bands; i++ ){
            lshBandBuckets[i] = new HashMap<Integer, List<String>>();
            for (int k=0; k<this.totalDocuments; k++){
                int[] documentBandColumn = new int[this.rows];
                for (int j=0; j<this.rows; j++){
                    documentBandColumn[j] = this.bandSignatureMatrix[i][j][k];
                }
                if (lshBandBuckets[i].get(Arrays.hashCode(documentBandColumn)) != null){
                    List<String> lshBucketDocumentList = lshBandBuckets[i].get(Arrays.hashCode(documentBandColumn));
                    lshBucketDocumentList.add("D"+k);
                    lshBandBuckets[i].put(Arrays.hashCode(documentBandColumn), lshBucketDocumentList);
                } else {
                    List<String> lshBucketDocumentList = new ArrayList();
                    lshBucketDocumentList.add("D"+k);
                    lshBandBuckets[i].put(Arrays.hashCode(documentBandColumn), lshBucketDocumentList);
                }
            }
        }
        return lshBandBuckets;
    }

    public void printBandSignatureMatrix() {
        for (int i =0; i<this.bands; i++ ) {
            System.out.println("Band"+i);
            for (int j = 0; j < this.rows; j++) {
                for (int k = 0; k < this.totalDocuments; k++) {
                    System.out.print(this.bandSignatureMatrix[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void printLSHBandBuckets() {
        HashMap<Integer, List<String>>[] lshBandBuckets = this.getLSHBandBuckets();
        for (int i =0; i<this.bands; i++ ){
            System.out.println("Band"+i);
            for (Map.Entry<Integer,List<String>> item : lshBandBuckets[i].entrySet()) {
                Integer key = item.getKey();
                List<String> value = item.getValue();
                System.out.format("%12s", key);
                System.out.print(value);
                System.out.println();
            }
        }
    }


}


