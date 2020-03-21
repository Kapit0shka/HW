package horstmann1chapter.generator;

public class GeneratorString {
    static public String getRandomString(int quantity){
        String result = "";
        long min = -9223372036854775808l;
        long max = 9223372036854775807l;
        for(int i = 0; i<quantity; i++){
            result += Long.toString(Math.abs(min+(long)(Math.random()*max)),36);
        }
        return result;
    }
}
