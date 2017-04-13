import java.util.ArrayList;
import java.util.List;

/**
 * Created by SuryaRajasekaran on 4/12/17.
 */
public class Shingling {

    public int k = 9;

    public String fileContent;

    public Shingling(String fileContent){
        this.fileContent = fileContent;
    }


    public List getShingles(){
        List shingles = new ArrayList();
        //generate array
        for (int i=0;i<this.fileContent.length()-(k-1);i++)
            shingles.add(this.fileContent.substring(i,i+k));
        return shingles;
    }
}

