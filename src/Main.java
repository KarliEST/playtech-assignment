public class Main {
    public static void main(String[] args) {

        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        String inputFile = "game_data_2.txt";
        String outputFile = "analyzer_output.txt";
        dataAnalyzer.analyzeData(inputFile,outputFile);

    }
}