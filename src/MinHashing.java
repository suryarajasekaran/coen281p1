import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by SuryaRajasekaran on 4/12/17.
 */
public class MinHashing {

    public List shingle;
    public static int HASH_LIMIT = 200;

    public MinHashing(List shingle){
        this.shingle = shingle;
    }

    public List getRandomNumbers(){
        List outRandomNumbers = new ArrayList();
        for (int i=0; i<HASH_LIMIT; i++){
            outRandomNumbers.add(i);
        }
        return outRandomNumbers;
    }

    public List getHash(int randomNumber){
        List outHash = new ArrayList();
        for (int i = 0; i < this.shingle.size(); i++) {
            outHash.add(this.shingle.get(i).hashCode()^randomNumber);
        }
        return outHash;
    }

    public int getMinHash(List<Integer> hashList){
        return Collections.min(hashList);
    }

    public List<Integer> getMinHashList(){
        List<Integer> outMinHashSet = new ArrayList();
        for (int i=0; i<this.getRandomNumbers().size(); i++) {
            outMinHashSet.add(this.getMinHash(this.getHash(this.getRandomNumbers().indexOf(i))));
        }
        return outMinHashSet;
    }
}
