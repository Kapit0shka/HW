package horstmann1chapter.factorial;

import java.math.BigInteger;

//ex. 1.6
public class Factorial {

    static public BigInteger factorial(int n) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
