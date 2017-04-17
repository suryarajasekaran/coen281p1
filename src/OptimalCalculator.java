import java.util.ArrayList;
import java.util.List;

/**
 * Created by SuryaRajasekaran on 4/16/17.
 */
public class OptimalCalculator {

    /*float d1;
    float d2;
    float p1;
    float p2;

    public OptimalCalculator(float d1, float d2, float p1, float p2) {
        this.d1 = d1;
        this.d2 = d2;
        this.p1 = p1;
        this.p2 = p2;
    }*/

    /*
    public getBands() {

    }

    public getRows() {

    }*/

    public static int calculateOptimalPermutations(int shingles){
        return (int) Math.round(Math.sqrt((float) shingles));
    }

    public static List<int[]> calculateOptimalBandRowPairs(int permutations){
        List<int[]> possibleBandRowPairs = new ArrayList<int[]>();
        for(int i=2; i<=permutations; i++){
            for(int j=2; j<=permutations; j++){
                if (i*j == permutations){
                    int[] combination = new int[2];
                    combination[0] = i;
                    combination[1] = j;
                    possibleBandRowPairs.add(combination);
                }
            }
        }
        return possibleBandRowPairs;
    }

    public static void printOptimalBandRowPairs(List<int[]> possibleBandRowPairs){
        System.out.println("-----------------------------------");
        System.out.println("LSH : Band/Row possible pairs, abs(root(N)), where N=>#of shingles");
        for (int i=0; i<possibleBandRowPairs.size(); i++){
            System.out.println("Combination"+i + " : " + possibleBandRowPairs.get(i)[0] + "," + possibleBandRowPairs.get(i)[1]);
        }
    }

    public static int[] calculateOptimalBandRow(double d1, double d2, double p1, double p2, List<int[]> possibleBandRowPairs){
        double[] minDiffCalculator = new double[possibleBandRowPairs.size()];
        for (int i=0; i<possibleBandRowPairs.size(); i++){
            double r = (double) possibleBandRowPairs.get(i)[0];
            double b = (double) possibleBandRowPairs.get(i)[1];
            double p1_compute = (1 - Math.pow((1 - Math.pow(d1,r)),b));
            double p2_compute = (1 - Math.pow((1 - Math.pow(d1,r)),b));
            minDiffCalculator[i] = Math.abs(p1_compute - p1) + Math.abs(p2_compute - p2);
        }
        return possibleBandRowPairs.get(minDiffCalculator.length/2 - 1);
    }
}
