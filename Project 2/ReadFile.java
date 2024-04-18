import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static CustomHashTable readResponsesFromFile(String filePath) {
        CustomHashTable hashTable = new CustomHashTable();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length < 31) {
                    System.err.println("Incomplete data for entry: " + line);
                    continue;
                }
                int id = Integer.parseInt(parts[0]);
                // Parse other fields and create a Response object
                Response response = new Response(id, parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
                        Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), Integer.parseInt(parts[8]), parts[9],
                        Integer.parseInt(parts[10]), Integer.parseInt(parts[11]), Integer.parseInt(parts[12]), Integer.parseInt(parts[13]),
                        Integer.parseInt(parts[14]), Integer.parseInt(parts[15]), parts[16], Integer.parseInt(parts[17]), Integer.parseInt(parts[18]),
                        Integer.parseInt(parts[19]), Integer.parseInt(parts[20]), Integer.parseInt(parts[21]), Integer.parseInt(parts[22]),
                        parts[23], Integer.parseInt(parts[24]), Integer.parseInt(parts[25]), Integer.parseInt(parts[26]), Integer.parseInt(parts[27]),
                        Integer.parseInt(parts[28]), Integer.parseInt(parts[29]), Integer.parseInt(parts[30]));
                hashTable.insert(id, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hashTable;
    }
}
