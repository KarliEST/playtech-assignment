import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile {

    public List readFromFile() {

//        List<List> array= new ArrayList<>(5);
        var array = new ArrayList<>(6);

        try {
            File myObj = new File("./resources/game_data_1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                List<String> line = Arrays.asList(data.split("\\s*,\\s*"));
                ArrayList sessionLine = new ArrayList<>();
                if (line.size() == 6) {
                    sessionLine.add(Integer.parseInt(line.get(0)));
                    sessionLine.add(Integer.parseInt(line.get(1)));
                    sessionLine.add(Integer.parseInt(line.get(2)));
                    sessionLine.add(line.get(3).toUpperCase());
                    sessionLine.add(line.get(4).toUpperCase());
                    sessionLine.add(line.get(5).toUpperCase());
                    array.add(sessionLine);
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