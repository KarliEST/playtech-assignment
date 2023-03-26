import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class DataAnalyzer {

    public Boolean checkStuff(String status, String dealerHand, String playerHand) {
        boolean result = false;
        switch (status) {
            case "P JOINED", "D REDEAL" -> {
                if (
                        !checkCardCount(dealerHand, playerHand, status)
                                || !areHandsValid(dealerHand, playerHand)
                ) {
                    result = true;
                }
            }
            case "P HIT" -> {
                if (
                        !areHandsValid(dealerHand, playerHand)
                                || !canPlayerHit(dealerHand, playerHand)
                ) {
                    result = true;
                }
            }
            case "D HIT" -> {
                if (
                        !areHandsValid(dealerHand, playerHand)
                                || !(getHandValue(dealerHand) <= 17)
                ) {
                    result = true;
                }
            }
            case "P STAND" -> {
                if (
                        !areHandsValid(dealerHand, playerHand)
                ) {
                    result = true;
                }
            }
            case "D STAND" -> {
                if (
                        !areHandsValid(dealerHand, playerHand)
                                || !(getHandValue(dealerHand) > 17)
                ) {
                    result = true;
                }
            }
            case "P WIN" -> {
                if (
                        !areHandsValid(dealerHand, playerHand)
                                || !doesPlayerWin(dealerHand, playerHand)
                ) {
                    result = true;
                }
            }
            case "P LOSE" -> {
                if (
                        !areHandsValid(dealerHand, playerHand)
                                || !doesPlayerLose(dealerHand, playerHand)
                ) {
                    result = true;
                }
            }
            case "D SHOW" -> {
                if (
                        !areHandsValid(dealerHand, playerHand)
                                || !Arrays.asList(getHandArray(dealerHand)).contains("?")
                ) {
                    result = true;
                }
            }
            default -> result = false;
        }
        return result;
    }

    // If hand contains error result = false.
    public boolean areHandsValid(String dealerHand, String playerHand) {
        boolean result = true;
        String[] dHand = getHandArray(dealerHand);
        String[] pHand = getHandArray(playerHand);
        String[] joinedHands = Stream.concat(Arrays.stream(dHand), Arrays.stream(pHand)).toArray(String[]::new);
        // Check if cards in hands are valid
        if (!validateCards(dHand) || !validateCards(pHand)) {
            result = false;
        }
        // Check if there are repetitive cards in hands
        Set<String> set = new HashSet<>();
        for (String item : joinedHands) {
            if (!set.add(item)) {
                result = false;
                break;
            }
        }
        // Check hand values
        if (getHandValue(dealerHand) == 0 || getHandValue(playerHand) < 4) {
            result = false;
        }
        return result;
    }

    // If player winning are conditions true, return true.
    public boolean doesPlayerWin(String dealerHand, String playerHand) {
        if (getHandValue(dealerHand) > 21) {
            return true;
        } else if (getHandValue(playerHand) <= 21
                && getHandValue(dealerHand) >= 17
                && getHandValue(playerHand) > getHandValue(dealerHand)) {
            return true;
        } else return false;
    }

    // If player losing are conditions true, return true.
    public boolean doesPlayerLose(String dealerHand, String playerHand) {
        if (getHandValue(playerHand) > 21) {
            return true;
        } else if (getHandValue(dealerHand) <= 21
                && getHandValue(dealerHand) >= 17
                && getHandValue(dealerHand) > getHandValue(playerHand)) {
            return true;
        } else return false;
    }

    // If dealers hand is equal or above 17 then result = false.
    public boolean canDealerHit(String dealersHand) {
        boolean result = true;
//        if (getHandValue(dealersHand) >= 17 || Arrays.asList(getHandArray(dealersHand)).contains("?")) {
        if (getHandValue(dealersHand) >= 17) {
            result = false;
        }
        return result;
    }

    // If player hand is equal or above 21 then result = false.
    public boolean canPlayerHit(String dealersHand, String playersHand) {
        boolean result = true;
        if (getHandValue(playersHand) >= 21 || !Arrays.asList(getHandArray(dealersHand)).contains("?")) {
            result = false;
        }
        return result;
    }

    // If number of cards in hand is not 2 at joining, then result = false.
    public boolean checkCardCount(String dealersHand, String playersHand, String status) {
        String[] dhand = getHandArray(dealersHand);
        String[] phand = getHandArray(playersHand);
        boolean result = true;
        if (Objects.equals(status, "P JOINED") && dhand.length != 2
                || Objects.equals(status, "P JOINED") && phand.length != 2
        ) {
            result = false;
        }
        return result;
    }


    public Integer getHandValue(String hand) {
        int value = 0;
        Deck deck = new Deck();
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
        boolean result = true;
        String[] validCards = deck.getCardDeck();
        for (String card : hand) {
            if (!Arrays.asList(validCards).contains(card)) {
                result = false;
                break;
            }
        }
        return result;
    }

}