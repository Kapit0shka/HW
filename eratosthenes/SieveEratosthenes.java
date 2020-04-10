package horstmann7chapter.eratosthenes;

import java.util.BitSet;
import java.util.HashSet;

public class SieveEratosthenes {


    public static HashSet<Integer> getPrimeNumber (int n) {
        HashSet<Integer> hashSet = new HashSet();

        for (int i = 2; i < n; i++) {
            hashSet.add(i);
        }

        for (int i = 2; i< hashSet.size(); i++) {
            if(hashSet.contains(i)) {
                for (int j = 2; j < hashSet.size(); ++j) {
                    hashSet.remove(i * j);
                }
            }
        }
        return hashSet;
    }
}
