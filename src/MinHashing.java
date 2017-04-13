import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by SuryaRajasekaran on 4/12/17.
 */
public class MinHashing {

    public List shingles;
    public int HASH_LIMIT = 200;

    public MinHashing(List shingles){
        this.shingles = shingles;
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
        for (int i = 0; i < this.shingles.size(); i++) {
            outHash.add(this.shingles.get(i).hashCode()^randomNumber);
        }
        return outHash;
    }

    public int getMinHash(List<Integer> hashList){
        return Collections.min(hashList);
    }

    public List getMinHashSet(){
        List outMinHashSet = new ArrayList();
        for (int i=0; i<this.getRandomNumbers().size(); i++) {
            outMinHashSet.add(this.getMinHash(this.getHash(this.getRandomNumbers().indexOf(i))));
        }
        return outMinHashSet;
    }

}
