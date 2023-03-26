import java.util.*;
import java.util.stream.Stream;

public class DataAnalyzer {

    public void analyzeData(String inputFile,String outputFile) {
        ReadFromFile readFromFile = new ReadFromFile();
        WriteToFile writeToFile = new WriteToFile();
        List<DataObject> inputData = readFromFile.readFromFile(inputFile);
        List<DataObject> errorsList = new ArrayList<>();
        List<DataObject> trimmedList = new ArrayList<>();
        int sessionId = 0;
        inputData.sort(Comparator.comparingInt(DataObject::getTimestamp)); // Sorting input data by timestamp.
        for (DataObject item : inputData) {
            if (checkActionConditions(
                    item.getAction().toUpperCase(),
                    item.getDealersHand().toUpperCase(),
                    item.getPlayersHand().toUpperCase()
            )) {
                errorsList.add(item);
            }
        }
        errorsList.sort(Comparator.comparingInt(DataObject::getSessionId));
        for (DataObject item : errorsList) {
            if (!item.getSessionId().equals(sessionId)) {
                sessionId = item.getSessionId();
                trimmedList.add(item);
            }
        }
        writeToFile.writeToFile(trimmedList,outputFile);
    }

    private boolean checkActionConditions(String action, String dealerHand, String playerHand) {
        switch (action) {
            case "P JOINED", "D REDEAL" -> {
                if (
                        !checkCardCount(dealerHand, playerHand, action)
                                || !areHandsValid(dealerHand, playerHand)
                ) {
                    return true;
                }
            }
            case "P HIT" -> {
                if (
                        !areHandsValid(dealerHand, playerHand)
                                || !canPlayerHit(dealerHand, playerHand)
                ) {
                    return true;
                }
            }
            case "D HIT" -> {
                if (
                        !areHandsValid(dealerHand, playerHand)
                                || !(getHandValue(dealerHand) <= 17)
                ) {
                    return true;
                }
            }
            case "P STAND" -> {
                if (
                        !areHandsValid(dealerHand, playerHand)
                ) {
                    return true;
                }
            }
            case "D STAND" -> {
                if (
                        !areHandsValid(dealerHand, playerHand)
                                || !(getHandValue(dealerHand) > 17)
                ) {
                    return true;
                }
            }
            case "P WIN" -> {
                if (
                        !areHandsValid(dealerHand, playerHand)
                                || !doesPlayerWin(dealerHand, playerHand)
                ) {
                    return true;
                }
            }
            case "P LOSE" -> {
                if (
                        !areHandsValid(dealerHand, playerHand)
                                || !doesPlayerLose(dealerHand, playerHand)
                ) {
                    return true;
                }
            }
            case "D SHOW" -> {
                if (
                        !areHandsValid(dealerHand, playerHand)
                                || !Arrays.asList(getHandArray(dealerHand)).contains("?")
                ) {
                    return true;
                }
            }
            default -> {
                return false;
            }
        }
        return false;
    }

    // If hand contains error return false.
    private boolean areHandsValid(String dealerHand, String playerHand) {
        String[] dHand = getHandArray(dealerHand);
        String[] pHand = getHandArray(playerHand);
        String[] joinedHands = Stream.concat(Arrays.stream(dHand), Arrays.stream(pHand)).toArray(String[]::new);
        // Check if cards in hands are valid
        if (!validateCards(dHand) || !validateCards(pHand)) {
            return false;
        }
        // Check if there are repetitive cards in hands
        Set<String> set = new HashSet<>();
        for (String item : joinedHands) {
            if (!set.add(item)) {
                return false;
            }
        }
        // Check hand values
        if (getHandValue(dealerHand) == 0 || getHandValue(playerHand) < 4) {
            return false;
        }
        return true;
    }

    // If player winning are conditions true, return true.
    private boolean doesPlayerWin(String dealerHand, String playerHand) {
        if (getHandValue(dealerHand) > 21) {
            return true;
        } else if (getHandValue(playerHand) <= 21
                && getHandValue(dealerHand) >= 17
                && getHandValue(playerHand) >= getHandValue(dealerHand)) {
            return true;
        } else return false;
    }

    // If player losing are conditions true, return true.
    private boolean doesPlayerLose(String dealerHand, String playerHand) {
        if (getHandValue(playerHand) > 21) {
            return true;
        } else if (getHandValue(dealerHand) <= 21
                && getHandValue(dealerHand) >= 17
                && getHandValue(dealerHand) > getHandValue(playerHand)) {
            return true;
        } else return false;
    }

    // If player hand is equal or above 21 then return false.
    private boolean canPlayerHit(String dealersHand, String playersHand) {
        if (getHandValue(playersHand) >= 21 || !Arrays.asList(getHandArray(dealersHand)).contains("?")) {
            return false;
        }
        return true;
    }

    // If number of cards in hand is not 2 at joining, then return false.
    private boolean checkCardCount(String dealersHand, String playersHand, String action) {
        String[] dhand = getHandArray(dealersHand);
        String[] phand = getHandArray(playersHand);
        if (Objects.equals(action, "P JOINED") && dhand.length != 2
                || Objects.equals(action, "P JOINED") && phand.length != 2
        ) {
            return false;
        }
        return true;
    }

    // Get hand value.
    private Integer getHandValue(String hand) {
        Deck deck = new Deck();
        int value = 0;
        for (String card : getHandArray(hand)
        ) {
            value += deck.getCardValue(card);
        }
        return value;
    }

    // Convert hand into array.
    private String[] getHandArray(String hand) {
        return hand.split("-");
    }

    // Check if cards in hand are valid. If not valid return false.
    private boolean validateCards(String[] hand) {
        Deck deck = new Deck();
        String[] validCards = deck.getCardDeck();
        for (String card : hand) {
            if (!Arrays.asList(validCards).contains(card)) {
                return false;
            }
        }
        return true;
    }

}
