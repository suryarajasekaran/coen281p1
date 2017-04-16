import java.util.List;

/**
 * Created by SuryaRajasekaran on 4/15/17.
 */
public class SignatureMatrix {

    List[] shingles;
    public int[][] singularMatrix;

    public SignatureMatrix(List[] shingles){
        this.shingles = shingles;
        this.singularMatrix = new int[MinHashing.HASH_LIMIT][this.shingles.length];
        this.getSignatureMatrix();
    }

    public int[][] getSignatureMatrix(){
        for (int i=0; i<this.shingles.length; i++){
            MinHashing minHashing = new MinHashing(this.shingles[i]);
            List minHashingList = minHashing.getMinHashList();
            for (int j=0; j<MinHashing.HASH_LIMIT; j++) {
                this.singularMatrix[j][i] = Integer.parseInt(minHashingList.get(j).toString());
            }
        }
        return this.singularMatrix;
    }

    public void printSignatureMatrix(){
        System.out.println("-----------------------------------");
        System.out.println("Signature Matrix (of hashed shingles)");
        for (int i=0; i<this.shingles.length; i++) {
            System.out.format("%16s", "D" + i);
        }
        System.out.println();
        for (int i=0; i<MinHashing.HASH_LIMIT; i++) {
            for (int j=0; j<this.shingles.length; j++){
                System.out.format("%16d", this.singularMatrix[i][j]);
            }
            System.out.println();
        }
    }
}
