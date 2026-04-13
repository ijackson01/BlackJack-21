package BlackJack.data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileManager {
    private static final String FILE_NAME = "game_history.txt";

    public static void saveResult(String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(result);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving result.");
        }
    }

    public static void showHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("Game history:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No game history found.");
        }
    }
}
