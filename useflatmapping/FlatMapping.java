package horstmann8chapter.useflatmapping;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FlatMapping {

    static public void useFlatMapping(Stream<String[]> stream) {
       Optional<String> largest = stream.flatMap(x-> Arrays.stream(x)).max(String::compareToIgnoreCase);
        System.out.println("Largest: " + largest.get());
    }
}
