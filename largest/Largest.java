package horstmann3chapter.largest;

import horstmann3chapter.measurable.Measurable;

import java.security.MessageDigest;

public class Largest {
    public static Measurable largest(Measurable [] objects) {
        Measurable maxResult = objects[0];

        for(Measurable object : objects) {
            if ((maxResult.getMeasurable() - object.getMeasurable()) < 0.000001) {
                maxResult = object;
            }
        }
        return maxResult;
    }
}
