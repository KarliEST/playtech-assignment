import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadFromFile readFromFile = new ReadFromFile();
        WriteToFile writeToFile = new WriteToFile();
        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        String inputFile = "game_data_1.txt";
        String outputFile = "analyzer_output.txt";
        List<DataObject> dataObjects;
        dataObjects = readFromFile.readFromFile(inputFile);

        // Sorteerimine timestampi järgi.
        dataObjects.sort(Comparator.comparingInt(DataObject::getTimestamp));
        dataAnalyzer.checkStuff("D HIT", "KH-8D", "9D-4D-7H");
//        for (DataObject item :
//                dataObjects) {
//            dataAnalyzer.checkStuff(item.getAction(), item.getDealersHand(),item.getPlayersHand());
//        }
//        dataObjects.forEach(System.out::println);
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