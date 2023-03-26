import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile {
    public void writeToFile(List<DataObject> array, String fileName) {
        try {
            FileWriter output = new FileWriter(fileName);
            for (var item : array
            ) {
                output.write(item.toString() + "\n");
            }
            output.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
