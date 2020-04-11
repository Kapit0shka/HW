package horstmann8chapter.parser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Parser {

    static public void print500maxWord(String name) throws IOException{
        if(!(new File(name).exists())) return;
        String contents = new String(Files.readAllBytes(Paths.get(name)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[.!?]"));
        Stream<String> longWords = words.parallelStream().sorted((w1,w2)->w2.length() - w1.length()).limit(500);
        longWords.forEach(word -> System.out.println(word));
    }

}
