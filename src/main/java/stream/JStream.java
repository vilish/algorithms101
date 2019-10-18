package stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;


public class JStream {

    public static void main(String args[]) {
        List<String> words = Arrays.asList("Hello", "World");

        //list all unique characters for a list of words
        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList()).forEach(System.out::println);

//        uniqueCharactersWords.forEach(x -> System.out::println);

    }
}
