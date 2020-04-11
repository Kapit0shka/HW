package horstmann8chapter.primenumber;

import java.math.BigInteger;
import java.util.stream.Stream;

public class BigPrimeNumber {

    static public void print500bigPrimeNumber() {
        BigInteger start = new BigInteger("50000000000000000000000000000000000000000000000000");
        Stream<BigInteger> stream = Stream.iterate(start, number -> number.add(BigInteger.ONE));
        Stream<BigInteger> primeNumber = stream.limit(Long.MAX_VALUE).
                filter((BigInteger number)-> number.isProbablePrime(1)).limit(500);

        primeNumber.forEach( w-> System.out.println(w));
    }
}
