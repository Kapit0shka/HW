package horstmann7chapter.swap;

import java.util.List;
import java.util.RandomAccess;

public class Swap {

    public static void swap(List<? extends RandomAccess> list, int i, int j) {

        if ( list == null && list.size()<i && list.size()<j) { return; }

        List list1 = list;
        Object temp = list.get(j);
        list1.set(j,list1.get(i));
        list1.set(i,temp);
    }
}
