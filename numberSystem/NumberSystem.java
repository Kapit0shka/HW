package horstmann1chapter.numberSystem;

//ex 1.1
public class NumberSystem {
    static public void PrintBinOctHex(int number) {
        System.out.println("Binary = " + Integer.toBinaryString(number)+ " Octal = " + Integer.toOctalString(number) + " Hexadecimal = " + Integer.toHexString(number));
    }

}
