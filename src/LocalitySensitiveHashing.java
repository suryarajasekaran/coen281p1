/**
 * Created by SuryaRajasekaran on 4/15/17.
 */
public class LocalitySensitiveHashing {

    int[][] signatureMatrix;
    int bands;
    int rows;

    // pickBands(d1,d2,p1,p2) ->  b,r

    public LocalitySensitiveHashing( int[][] signatureMatrix, int bands, int rows){
        this.signatureMatrix = signatureMatrix;
        this.bands = bands;
        this.rows = rows;
    }

    public int[][] getLocalitySensitiveHashingMatrix(){
        int[][] localitySensitiveHashingMatrix = new int[this.bands][this.rows];
        return localitySensitiveHashingMatrix;
    }

}


