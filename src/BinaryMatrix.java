import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by SuryaRajasekaran on 4/12/17.
 */
public class BinaryMatrix {

    public List[] shingles;
    public HashMap<String, int[]> binaryMatrix;

    public BinaryMatrix(List[] shingles){
        this.shingles = shingles;
        this.binaryMatrix = new HashMap<String, int[]>();
    }

    public HashMap<String, int[]> getBinaryMatrix(){
        for (int i=0; i<this.shingles.length; i++){
            for(int j=0; j<this.shingles[i].size(); j++){
                if (this.binaryMatrix.get(this.shingles[i].get(j).toString()) != null) {
                    int[] shingleRow = this.binaryMatrix.get(this.shingles[i].get(j).toString());
                    shingleRow[i] = 1;
                    this.binaryMatrix.put(this.shingles[i].get(j).toString(), shingleRow);
                } else {
                    int[] shingleRow = new int[this.shingles.length];
                    shingleRow[i] = 1;
                    this.binaryMatrix.put(this.shingles[i].get(j).toString(), shingleRow);
                }
            }
        }
        return this.binaryMatrix;
    }

    public void printBinaryMatrix(){
        this.getBinaryMatrix();
        System.out.println("-----------------------------------");
        System.out.println("Binary Matrix");
        System.out.print("\t\t\t");
        for (int i=0; i<shingles.length; i++) {
            System.out.format("%8s", "D" + i);
        }
        System.out.println();
        for (Map.Entry<String,int[]> item : this.binaryMatrix.entrySet()) {
            String key = item.getKey();
            int[] value = item.getValue();
            System.out.format("%12s", key);
            for (int data : value){
                System.out.format("%8d", data);
            }
            System.out.println();
        }
    }


}

