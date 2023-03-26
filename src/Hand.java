public class Hand {
    private Integer handValue;
    private Integer cardCount;
    private String type;

    public Hand() {
    }

    public Hand(Integer handValue, Integer cardCount, String type) {
        this.handValue = handValue;
        this.cardCount = cardCount;
        this.type = type;
    }

    // TODO: eemalda ülearused getterid ja setterid
    public Integer getHandValue() {
        return handValue;
    }

    public void setHandValue(Integer handValue) {
        this.handValue = handValue;
    }

    public Integer getCardCount() {
        return cardCount;
    }

    public void setCardCount(Integer cardCount) {
        this.cardCount = cardCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
