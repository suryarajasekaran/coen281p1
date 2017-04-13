/**
 * Created by SuryaRajasekaran on 4/11/17.
 */
public class Main {

    public static void main(String[] args){
        FileRead f = new FileRead("/Users/SuryaRajasekaran/scratch/coen281p1/input/f1Surya.txt");
        System.out.println(f.getFileContents());

        Shingling shingling = new Shingling(f.getFileContents());
        System.out.println(shingling.getShingles());
    }
}
