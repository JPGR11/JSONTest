package driver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.json.JSONArray;

public class Driver {
	
	public static void main(String[] args) {
        String filePath = "test.json";
        
        try {
            // Read the content of the JSON file into a String
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Parse the JSON array
            JSONArray peopleArray = new JSONArray(content);

            // Iterate over each person in the array
            for (int i = 0; i < peopleArray.length(); i++) {
                JSONObject person = peopleArray.getJSONObject(i);

                // Extract data from each JSON object (person)
                String name = person.getString("name");
                int age = person.getInt("age");
                String email = person.getString("email");
                boolean isVerified = person.getBoolean("isVerified");
                
                // Extract and print the scores array
                JSONArray scoresArray = person.getJSONArray("scores");
                int[] scores = new int[scoresArray.length()];
                for (int j = 0; j < scoresArray.length(); j++) {
                    scores[j] = scoresArray.getInt(j);
                }

                // Print person data
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Email: " + email);
                System.out.println("Is Verified: " + isVerified);
                System.out.print("Scores: ");
                for (int score : scores) {
                    System.out.print(score + " ");
                }
                System.out.println("\n------------------------");
            }

        } catch (IOException e) {
            System.out.println("Error reading the JSON file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error parsing JSON data: " + e.getMessage());
        }
    }

}
