package horstmann8chapter.tokens;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Tokens {

    static public int avgLength(Stream<String> stream) {
        if (stream == null) return 0;
        return stream.count() == 0 ? 0: (int)(stream.mapToInt(String::length).sum()/stream.count());
    }

    static public String[] maxLengthWords(Stream<String> stream) {
        if (stream == null) return null;
        int maxLength;

        Optional<String> largest = stream.max(String::compareTo);
        maxLength = largest.get().length();
        return (stream.filter(word -> word.length() == maxLength)).toArray(String[]::new);
    }

    static public Stream<String> getWordFile(String name) throws IOException {
        if(!(new File(name).exists())) return null;
        String contents = new String(Files.readAllBytes(Paths.get(name)), StandardCharsets.UTF_8);
        Stream<String> words = (Arrays.asList(contents.split("\\PL+"))).stream()
                .filter(w -> isWord(w) );
        return words.limit(100);
    }

    static public String[] getArrayWords(String name) throws IOException {
        if(!(new File(name).exists())) return null;
        String contents = new String(Files.readAllBytes(Paths.get(name)), StandardCharsets.UTF_8);
        Stream<String> words = (Arrays.asList(contents.split("\\PL+"))).stream()
                .filter(w -> isContains5vowels(w) );
        return words.toArray(String[]::new);
    }

    private static boolean isContains5vowels(String word) {
        word = word.toLowerCase();
        int count = 0;
        if(word.contains("a")) count++;
        if(word.contains("e")) count++;
        if(word.contains("i")) count++;
        if(word.contains("o")) count++;
        if(word.contains("u")) count++;
        if(word.contains("y")) count++;

        if (count >=5) return true;
        return false;

    }

    private static boolean isWord(String word) {
        char[] symbols = word.toCharArray();
        for (char symbol : symbols){
            if (Character.isAlphabetic(symbol)) { return false; }
        }
        return true;
    }
}