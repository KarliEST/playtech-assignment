public class Main {
    public static void main(String[] args) {

//        Integer sessionId = 1;
//
//        ReadFromFile readFromFile = new ReadFromFile();
//
//        List<TestDTO> allData = new ArrayList<>();
//        allData = readFromFile.readFromFile();
//
//        // Sorteerimata väljad.
//        System.out.println("Prindib kõik väljad originaal kujul");
//        for (var line : allData
//        ) {
//            System.out.println(line);
//        }
//
//        // Sorteerimine timestamp järgi.
//        allData.sort((t0, t1) -> t0.getTimestamp() - t1.getTimestamp());
//
//        // Prindi sorteeritud väljad.
//        System.out.println("Prindib kõik väljad timestamp-i järgi sorteeritult");
//        for (var line : allData
//        ) {
//            System.out.println(line);
//        }
//
//        // Prindi sessionId väljad.
//        System.out.println("Prindib väljad sessionId-ga: " + sessionId);
//        for (var line : allData
//        ) {
//            if (line.getSessionId().equals(sessionId)) {
//                System.out.println(line);
//            }
//        }


        AnalyzeData analyzeData = new AnalyzeData();
        analyzeData.getHandValue("KH-?");
        System.out.println(analyzeData.checkCards("KH-8F-?"));
        analyzeData.checkJoinedCardCount("KH-?","KH-8H","P Joined");

    }
}