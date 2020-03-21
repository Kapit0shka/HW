package horstmann1chapter.minMaxDouble;

//ex. 1.4
public class MinMaxDouble {
    static public void printMinMaxDouble(double num1, double num2) {

        System.out.println("Max= " + (Math.nextUp(num1) > Math.nextUp(num2)? num1:num2)
                + " Min= " + (Math.nextUp(num2) < Math.nextUp(num1)? num2:num1));
    }
}
