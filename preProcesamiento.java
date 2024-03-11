import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class preProcesamiento {

    public static void main(String[] args) {
        String datasetFile = "workingFiles\\datasetCompleto.txt";
        String dictionaryFile = "workingFiles\\Dictionary.txt";
        String outputFile = "workingFiles\\datasetProcesado.txt";
        cleanDataset(datasetFile, dictionaryFile, outputFile);
    }

    private static String removePunctuation(String line) {
        return line = line.replaceAll("&'.*?\\w+;", " ")
                .replaceAll("[^a-zA-Z0-9 ]", " ")
                .replaceAll("\\s+", " ");
    }

    private static ArrayList<String> loadDictionary(String dictionaryFile) {
        ArrayList<String> dictionary = new ArrayList<>();
        try (BufferedReader dictReader = new BufferedReader(new FileReader(dictionaryFile))) {
            String word;
            while ((word = dictReader.readLine()) != null) {
                dictionary.add(word.trim().toLowerCase());
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return dictionary;
    }

    public static void cleanDataset(String datasetFile, String dictionaryFile, String outputFile) {
        try {
            ArrayList<String> dictionary = loadDictionary(dictionaryFile);

            try (BufferedReader br = new BufferedReader(new FileReader(datasetFile));
                    FileWriter fw = new FileWriter(outputFile, true)) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = removePunctuation(line);
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        String cleanedWord = word.toLowerCase();
                        if (!dictionary.contains(cleanedWord)) {
                            fw.write(cleanedWord + " ");
                        }
                    }
                    fw.write("\n");
                }
            }
            System.out.println("Dataset cleaned successfully and saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

}