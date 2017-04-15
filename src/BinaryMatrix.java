import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by SuryaRajasekaran on 4/12/17.
 */
public class BinaryMatrix {

    public List[] shingles;
    public HashMap<String, int[]> binaryMatrix;
    /*

    array = [1,2,3,4] array[i]
    list = 1->2->3 => [1,2,3,4] => list.get(i)
    hmap : { fruits : [banana, organce], vegetables = [tomato, onion], meat = [chicken, mutton]}
                key : value

           { shingle1 : [D1,D2,...Dn], shingle2 : [D1,D2,...Dn]
     */

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
        
        for (Map.Entry<String,int[]> item : this.binaryMatrix.entrySet()) {
            String key = item.getKey();
            int[] value = item.getValue();
            System.out.print(key + " : ");
            for (int data : value){
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }


}
