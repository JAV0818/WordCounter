package wordfreqwithstreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import java.util.stream.Stream;

/**
 * from Bloch, 3rd ed., Item 46 Proper use of streams to initialize a frequency
 * table modified
 *
 */
public class WordFreqWithStreams {

    public static void main(String[] args) throws FileNotFoundException {

        InputStream file = new FileInputStream("GettysburgAddress.txt");
        
        // Dont change anything under
        Map<String, Long> freq;
        try (Stream<String> word = new Scanner(file).tokens()) {
            freq = word.collect(groupingBy(String::toLowerCase, counting()));
        }
        System.out.println(freq);
    }

}
