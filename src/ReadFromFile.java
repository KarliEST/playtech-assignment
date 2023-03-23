import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile {

    public List readFromFile() {

       List<List> array = new ArrayList<>();

        try {
            File myObj = new File("./resources/game_data_1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                List<String> list = Arrays.asList(data.split("\\s*,\\s*"));
                array.add(list);
            }
            myReader.close();
            for (List item : array
            ) {
                System.out.println(item);
            }
//            System.out.println(array);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return array;
    }


}
