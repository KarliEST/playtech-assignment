import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteToFile {
    List<List> array = new ArrayList<>();

    public void writeToFile() {

        try {
//            Writer output;
//            output = new BufferedWriter(new FileWriter("analyzer_output.txt"));
            FileWriter output = new FileWriter("analyzer_output.txt");
//            StringBuilder stringBuilder = new StringBuilder();
            for (List item : array
            ) {
                output.write(item.toString());
            }
//            myWriter.write(array.toString());
            output.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
