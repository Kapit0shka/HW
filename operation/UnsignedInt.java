package horstmann1chapter.operation;

//ex. 1.7
public class UnsignedInt {

    private int num1;
    private int num2;

    public UnsignedInt(long num1, long num2) {
        this.num1 = (int)num1;
        this.num2 = (int)num2;
    }

    public void PrintSum(){
        System.out.println("Sum = " + (Integer.toUnsignedLong(num1) + Integer.toUnsignedLong(num2)));
    }

    public void PrintDifference() {
        System.out.println("Difference = " + (Integer.toUnsignedLong(num1) - Integer.toUnsignedLong(num2)));
    }

    public void PrintMultiply() {
        System.out.println("Multiply = " + (Integer.toUnsignedLong(num1) * Integer.toUnsignedLong(num2)));
    }

    public void PrintDivide() {
        System.out.println("Divide = " + (Integer.toUnsignedLong(num1) / Integer.toUnsignedLong(num2)));
    }

    public void PrintMod() {
        System.out.println("Mod = " + (Integer.toUnsignedLong(num1) % Integer.toUnsignedLong(num2)));
    }
    public void PrintNumbers() {
        System.out.println("Number 1: " + num1 + " Number 2: " + num2);
    }

}
