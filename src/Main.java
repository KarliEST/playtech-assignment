import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Integer sessionId = 80;

        ReadFromFile readFromFile = new ReadFromFile();

        List<TestDTO> allData = new ArrayList<>();
        allData = readFromFile.readFromFile();

        // Sorteerimata väljad.
        System.out.println("Prindib kõik väljad originaal kujul");
        for (var line : allData
        ) {
            System.out.println(line);
        }

        // Sorteerimine timestamp järgi.
        allData.sort((t0, t1) -> t0.getTimestamp() - t1.getTimestamp());

        // Prindi sorteeritud väljad.
        System.out.println("Prindib kõik väljad timestamp-i järgi sorteeritult");
        for (var line : allData
        ) {
            System.out.println(line);
        }

        // Prindi sessionId väljad.
        System.out.println("Prindib väljad sessionId-ga: " + sessionId);
        for (var line : allData
        ) {
            if (line.getSessionId().equals(sessionId)) {
                System.out.println(line);
            }
        }

//        System.out.println(readFromFile.readFromFile());

//        var data = readFromFile.readFromFile();
//        var newArray = new ArrayList<>();


//        for (Object item : data
//        ) {
//            System.out.println(item.toString());
//        }


    }
}