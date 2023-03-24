import java.util.Arrays;
import java.util.Objects;

public class AnalyzeData {

    public Boolean checkJoinedCardCount(String dealersHand, String playersHand, String status) {
        String[] dhand = getHandArray(dealersHand);
        String[] phand = getHandArray(playersHand);
        boolean result = false;
        // TODO: kustuta testimisel kasutatud soutid
        System.out.println("dealers hand: " + Arrays.toString(dhand));
        System.out.println("players hand: " + Arrays.toString(phand));
        if (Objects.equals(status, "P Joined") && dhand.length != 2 ||
                Objects.equals(status, "P Joined") && phand.length != 2) {
            result = true;
            // TODO: kustuta testimise sout
            System.out.println("Error in starting, card count is false at joining!!");
        }
        return result;
    }

    public Integer getHandValue(String hand) {
        int value = 0;
        Deck deck = new Deck();
        // TODO: kustuta sout
        System.out.println("Hand: " + hand);
        for (String card : getHandArray(hand)
        ) {
            value += deck.getCardValue(card);
        }
        // TODO: kustuta sout
        System.out.println("Hand value: " + value);
        return value;
    }

    public Boolean checkCards(String hand) {
        Deck deck = new Deck();
        String[] validCards = deck.getCardDeck();
        // TODO: kustuta sout
        System.out.println("Hand: " + hand);
        boolean result = false;
        for (String card : getHandArray(hand)) {
            if (Arrays.stream(validCards).noneMatch(card::equals)) {
                result = true;
            }
        }
        // TODO: kustuta testimise sout
        if (result) {
            System.out.println("Hand contains card error!!");
        }
        return result;
    }

    private String[] getHandArray(String hand) {
        String[] handArr = hand.split("-");
        return handArr;
    }


}
