import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        Collections.sort(allData, new Comparator<TestDTO>() {
            @Override
            public int compare(TestDTO t0, TestDTO t1) {
                return t0.getTimestamp()- t1.getTimestamp();
            }
        });

        // Prindi sorteeritud väljad.
        System.out.println("Prindib kõik väljad timestamp-i järgi sorteeritult");
        for (var line : allData
        ) {
            System.out.println(line);
        }

        // Prindi sessionId väljad.
        System.out.println("Prindib väljad sessionId-ga: "+sessionId);
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