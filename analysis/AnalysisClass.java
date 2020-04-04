package horstmann3chapter.analysis;

import horstmann3chapter.employee.Employee;

public class AnalysisClass {
    public static void printSuperClassString(Object o) {
        Class type = o.getClass();
        System.out.println(type.getSuperclass());
    }

}
