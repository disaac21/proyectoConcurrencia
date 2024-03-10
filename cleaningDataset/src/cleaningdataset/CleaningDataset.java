package cleaningdataset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CleaningDataset {

    public static void main(String[] args) {
        String datasetFile = "cleaningDataset\\src\\workingFiles\\datasetCompleto.txt";
        String dictionaryFile = "cleaningDataset\\src\\workingFiles\\Dictionary.txt";
        String outputFile = "cleaningDataset\\src\\workingFiles\\datasetPostProcesamientoLowerCaseMoreTestingFixed.txt";
        cleanDataset(datasetFile, dictionaryFile, outputFile);
    }

    private static String removePunctuation(String word) {
        word = word.toLowerCase();
        return word.replaceAll("^[\\p{Punct}_/()*+:;.,<=>?@!#$%&'\"\\-\\[\\]\\{\\}<>\\\\^|~`\\^*]+|[\\p{Punct}_/()*+:;.,<=>?@!#$%&'\"\\-\\[\\]\\{\\}<>\\\\^|~`\\^*]+(?<=\\.{3}|\\.{2}|\\.)$", "");
    }

    public static void cleanDataset(String datasetFile, String dictionaryFile, String outputFile) {
        try {
            // Read the dictionary file
            ArrayList<String> dictionary = new ArrayList<>();
            try (BufferedReader dictReader = new BufferedReader(new FileReader(dictionaryFile))) {
                String word;
                while ((word = dictReader.readLine()) != null) {
                    dictionary.add(word.trim());
                }
            }

            // Open input and output files
            try (BufferedReader datasetReader = new BufferedReader(new FileReader(datasetFile)); FileWriter writer = new FileWriter(outputFile, true)) {
                String line;
                while ((line = datasetReader.readLine()) != null) {
                    // Split the line into words
                    String[] words = line.split("\\s+");
                    // Clean each word
                    for (int i = 0; i < words.length; i++) {
                        // Check if the word is in the dictionary
                        String toCompare = removePunctuation(words[i]);
                        if (dictionary.contains(toCompare)) {
                            words[i] = ""; // Replace with an empty string
                        }
                    }
                    // Write the cleaned line to the output file
                    writer.write(String.join(" ", words) + "\n");
                }
            }

            System.out.println("Dataset cleaned successfully and saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

}
