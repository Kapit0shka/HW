package horstmann8chapter.avgdouble;

import jdk.dynalink.Operation;

import java.util.Optional;
import java.util.stream.Stream;

public class AvgDouble {

    static public double avg(Stream<Double> stream) {
        if (stream == null) return 0;
        Optional<Double> result = stream.reduce((x,y)->x+y);
        return result.get() == 0 ? 0 : result.get()/(double)stream.count();
    }
}
