import java.util.Arrays;
import java.util.Objects;

public class DataAnalyzer {

    public Boolean checkStuff(String status, String dealerHand, String playerHand) {
        boolean result = false;
        switch (status) {
            case "P JOINED" -> {
                if (
                        checkCardError(playerHand)
                                || checkCardError(dealerHand)
                                || checkJoinedCardCount(dealerHand, playerHand, status)
                ) {
                    result = true;
                }
            }
            case "P HIT" -> {
                if (
                        checkCardError(dealerHand)
                                || checkCardError(playerHand)
                                || getHandValue(playerHand) >= 21
                ) {
                    result = true;
                }
            }
            case "D HIT" -> {
                if (
                        checkCardError(dealerHand)
                                || checkCardError(playerHand)
                                || canDealerHit(dealerHand)
                ) {
                    result = true;
                }
            }
            case "P STAND" -> {
                if (
                        checkCardError(dealerHand)
                                || checkCardError(playerHand)
                ) {
                    result = true;
                }
            }
            case "D STAND" -> {
                if (
                        checkCardError(dealerHand)
                                || checkCardError(playerHand)
                                || getHandValue(dealerHand) > 17
                ) {
                    result = true;
                }
            }
            case "P WIN" -> {
                if (
                        checkCardError(dealerHand)
                                || checkCardError(playerHand)
                                || getHandValue(playerHand) > 21
                                || getHandValue(playerHand) < getHandValue(dealerHand) && getHandValue(dealerHand) <= 21
                ) {
                    result = true;
                }
            }
            case "D WIN" -> {
                if (
                        checkCardError(dealerHand)
                                || checkCardError(playerHand)
                                || getHandValue(dealerHand) > 21
                                || getHandValue(dealerHand) <= getHandValue(playerHand) && getHandValue(playerHand) <= 21
                ) {
                    result = true;
                }
            }
            case "P LOSE" -> {
                if (
                        checkCardError(dealerHand)
                                || checkCardError(playerHand)
                                || getHandValue(dealerHand) < getHandValue(playerHand) && getHandValue(playerHand) <= 21
                ) {
                    result = true;
                }
            }
            case "D LOSE" -> {
                if (
                        checkCardError(dealerHand)
                                || checkCardError(playerHand)
                                || getHandValue(dealerHand) <= 21
                                || getHandValue(playerHand) >= getHandValue(dealerHand) && getHandValue(playerHand) > 21
                ) {
                    result = true;
                }
            }
            default -> result = false;
        }
        return result;
    }


    // If dealers hand is equal or above 17 then result = false.
    public Boolean canDealerHit(String dealersHand) {
        boolean result = true;
        if (getHandValue(dealersHand) >= 17 || Arrays.asList(getHandArray(dealersHand)).contains("?")) {
            result = false;
            // TODO: kustuta testimise sout
            System.out.println("Dealer hand value: " + getHandValue(dealersHand));
        }
        // TODO: kustuta testimise sout
        System.out.println("Hand: " + Arrays.toString(getHandArray(dealersHand)));
        System.out.println("Can dealer hit? " + result);
        return result;
    }

    // If number of cards in hand is not 2 at joining, then result = true.
    public Boolean checkJoinedCardCount(String dealersHand, String playersHand, String status) {
        String[] dhand = getHandArray(dealersHand);
        String[] phand = getHandArray(playersHand);
        boolean result = false;
        // TODO: kustuta testimisel kasutatud soutid
//        System.out.println("dealers hand: " + Arrays.toString(dhand));
//        System.out.println("players hand: " + Arrays.toString(phand));
        if (Objects.equals(status, "P Joined") && dhand.length != 2 ||
                Objects.equals(status, "P Joined") && phand.length != 2) {
            result = true;
            // TODO: kustuta testimise sout
//            System.out.println("Error in starting, card count is false at joining!!");
        }
        return result;
    }

    public Integer getHandValue(String hand) {
        int value = 0;
        Deck deck = new Deck();
        // TODO: kustuta sout
//        System.out.println("Hand: " + hand);
        for (String card : getHandArray(hand)
        ) {
            value += deck.getCardValue(card);
        }
        // TODO: kustuta sout
//        System.out.println("Hand value: " + value);
        return value;
    }

    // If hand contains card error result = true.
    public Boolean checkCardError(String hand) {
        Deck deck = new Deck();
        String[] validCards = deck.getCardDeck();
        // TODO: kustuta sout
        System.out.println("Hand: " + hand);
        boolean result = false;
        for (String card : getHandArray(hand)) {
            if (!Arrays.asList(validCards).contains(card)) {
                result = true;
                break;
            }
        }
        // TODO: kustuta testimise sout
        if (result) {
            System.out.println("Hand contains card error!!");
        }
        return result;
    }

    // Convert hand into array.
    private String[] getHandArray(String hand) {
        String[] handArr = hand.split("-");
        return handArr;
    }


}
