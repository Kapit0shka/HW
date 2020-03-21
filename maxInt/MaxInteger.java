package horstmann1chapter.maxInt;

//ex. 1.3
public class MaxInteger {
    static public void printMaxInteger(int num1,int num2,int num3){
        if (num1 > num2){
            System.out.println((num1 > num3)? num1:num3);
        }
        else {
            System.out.println((num2 > num3)? num2:num3);
        }
    }

    static public void printMaxIntegerWithMathMax(int num1,int num2,int num3) {
        System.out.println(Math.max(Math.max(num1,num2),num3));
    }
}
