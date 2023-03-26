import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadFromFile readFromFile = new ReadFromFile();
        WriteToFile writeToFile = new WriteToFile();
        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        String inputFile = "game_data_2.txt";
        String outputFile = "analyzer_output.txt";
        List<DataObject> dataObjects;
        dataObjects = readFromFile.readFromFile(inputFile);

        // Sorteerimine timestampi järgi.
        dataObjects.sort(Comparator.comparingInt(DataObject::getTimestamp));
//        System.out.println(dataAnalyzer.checkStuff("P LOSE", "KH-KH", "2D-2H-KH-2C-3D"));
        List<DataObject> errorsList = new ArrayList<>();
        for (DataObject item :
                dataObjects) {
            if (dataAnalyzer.checkStuff(item.getAction(), item.getDealersHand(), item.getPlayersHand())) {
                errorsList.add(item);
            }
        }
        errorsList.sort(Comparator.comparingInt(DataObject::getSessionId));
        errorsList.forEach(System.out::println);

        List<DataObject> trimmedList = new ArrayList<>();
        int sessionId = 0;
        for (DataObject item :
                errorsList) {
            if (!item.getSessionId().equals(sessionId)) {
                sessionId = item.getSessionId();
                trimmedList.add(item);
            }
        }
        System.out.println("---------------------");
        trimmedList.forEach(System.out::println);


//        TODO: kommenteeri write to file tagasi
//        writeToFile.writeToFile(dataObjects,outputFile);


//        AnalyzeData analyzeData = new AnalyzeData();
//        analyzeData.getHandValue("KH-?");
//        System.out.println(analyzeData.checkCardError("KH-8F-?"));
//        analyzeData.checkJoinedCardCount("KH-?","KH-8H","P Joined");
//        analyzeData.canDealerHit("KH-?");

//        analyzeData.checkStuff("P JOINED","KH-?","KH-8H");
//        analyzeData.checkStuff("P HIT","KH-?","KH-8H");
//        analyzeData.checkStuff("D HIT","KH-?","KH-8H");
//        analyzeData.checkStuff("P LOSE","KH-6D-8S","2D-2H-2S-2C-3D");
//        analyzeData.checkStuff("D HIT","KH-KD","KH-8H");
    }
}