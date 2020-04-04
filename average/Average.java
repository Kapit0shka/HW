package horstmann3chapter.average;

import horstmann3chapter.measurable.Measurable;

public class Average {
    public static double average(Measurable [] objects) {
        double result = 0.0;
        for(Measurable object : objects) {
            result += object.getMeasurable();
        }
        return result == 0 ? 0 : result/objects.length;
    }
}
