package horstmann3chapter.sequence;

public interface IntSequence {
    default boolean hasNext() {
        return true;
    };
    int next();

    public static IntSequence of(int...sequence) {
        return new IntSequence() {
            private int i=-1;
            public boolean hasNext() {
                if(i >= sequence.length-1) {
                    return false;
                }
                else {
                    return true;
                }
            }

            public int next() {
                i++;
                return sequence[i];
            }
        };
    };

    public static IntSequence constant(int number) {
        return new IntSequence() {
                public int next() {
                    return number;
                }
        };
    };


    public static IntSequence constantWithLambda(int number) {
        return () -> number;
    }
}

    // реализация с помощью лмбда-выражения, используется в main
    //int x=0;
    //IntSequence constant;
    //    constant = () -> x;