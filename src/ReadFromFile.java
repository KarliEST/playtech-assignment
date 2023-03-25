import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile {

    public List readFromFile(String fileName) {

        var array = new ArrayList<>();
        String filePath = "./resources/";
        try {
            File dataFile = new File(filePath+fileName);
            Scanner myReader = new Scanner(dataFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                List<String> line = Arrays.asList(data.split("\\s*,\\s*"));
                if (line.size() == 6) {
                    DataObject dataObject = new DataObject(
                            Integer.parseInt(line.get(0)),
                            Integer.parseInt(line.get(1)),
                            Integer.parseInt(line.get(2)),
                            line.get(3).toUpperCase(),
                            line.get(4).toUpperCase(),
                            line.get(5).toUpperCase()
                    );
                    array.add(dataObject);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return array;
    }


}