package horstmann1chapter.lottery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

//ex. 1.13
public class Lottery {


    static public void printLotteryCombination() {
        ArrayList<Integer> lotteryCombination = new ArrayList<Integer>();
        lotteryCombination = calculationCombination(lotteryCombination);
        Collections.sort(lotteryCombination);
        for(int i = 0; i<lotteryCombination.size();i++){
            System.out.print(lotteryCombination.get(i)+" ");
        }
    }

    static private ArrayList<Integer> calculationCombination(ArrayList<Integer>  lotteryCombination){
        int min = 1;
        int max = 49;
        for(int i = 0; i<49;i++){
            lotteryCombination.add(min + (int)(Math.random()*max));
        }
        for(int i = 0; i<6;i++){
            lotteryCombination.remove(min + (int)(Math.random()*lotteryCombination.size()));
        }
        return lotteryCombination;
    }
}
