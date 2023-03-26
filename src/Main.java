public class Main {
    public static void main(String[] args) {

        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        String inputFile = "game_data.txt";
        String outputFile = "analyzer_results.txt";
        dataAnalyzer.analyzeData(inputFile,outputFile);

    }
}