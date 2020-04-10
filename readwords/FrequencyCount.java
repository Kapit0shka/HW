package horstmann7chapter.readwords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;


public class FrequencyCount {

    public static void printFrequencyWords(String name) throws IOException {

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        String contents = new String(Files.readAllBytes(Paths.get(name)));
        String[] strings = contents.split(" ");


        for (String word:strings){
            if (treeMap.containsKey(word.toLowerCase())) {
                treeMap.put(word.toLowerCase(),treeMap.get(word)+1);
            }
            else {
                treeMap.put(word,1);
            }
        }

        Set<String> keys = treeMap.keySet();

        keys.forEach(key -> System.out.println(key + " with frequency " + treeMap.get(key)) );
    }

    public static void printLineWithWord(String name) throws IOException{
        String contents = new String(Files.readAllBytes(Paths.get(name)));
        String[] strings = contents.split(" ");
        Set<String> words = new HashSet<>();

        for (String word : strings) {
            words.add(word);
        }


        for(String word : words) {
            if(!contents.contains(word)){
                System.out.println("Line contains no all words!");
                break;
            }
            System.out.println(contents);
        }
    }
}