package horstmann1chapter.magicsquare;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//ex. 1.14
public class MagicSquare {
    private List<ArrayList<Integer>> magicSquare;

    public MagicSquare() {
    }

    public MagicSquare(List<ArrayList<Integer>> magicSquare) {
        this.magicSquare = magicSquare;
    }

    public void setSquare(List<ArrayList<Integer>> magicSquare) {
        this.magicSquare = magicSquare;
    }

    public void MySetSquare(){
        Scanner in = new Scanner(System.in);
        String numberLine;
        magicSquare = new ArrayList();
        for(int i = 0;;i++){
            ArrayList <Integer> lineSquare=new ArrayList<>();
            System.out.println("Input " + (i+1) + " line:");
            while (true){
                numberLine = in.nextLine();
                try{
                    lineSquare.add(Integer.parseInt(numberLine));
                } catch (Exception e){
                    break;
                }
            }
            if(lineSquare.size()==0){
                break;
            }
            magicSquare.add(lineSquare);
        }
    }

    public boolean checkIsMagicSquare() {
        int side = magicSquare.size();
        System.out.println(side);
        int magicNum = 0;
        int sumD = 0;
        for(int x = 0; x < side; x++){
            magicNum += magicSquare.get(0).get(x);
        }
        System.out.println(magicNum);
        for(int x = 0; x < side; x++){
            int sumX = 0;
            int sumY = 0;
            for (int y = 0; y < side; y++){
                sumX += magicSquare.get(x).get(y);
                sumY += magicSquare.get(y).get(x);
            }
            sumD += magicSquare.get(x).get(x);
            System.out.println("X== " + sumX + " Y= " + sumY);
            if(sumX != magicNum  || sumY != magicNum){
                return false;
            }
        }
        System.out.println("d== " + sumD);
        return sumD == magicNum;
    }
}
