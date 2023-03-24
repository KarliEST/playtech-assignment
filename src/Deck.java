public class Deck {
    private final String[] cardDeck = {
            "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS",
            "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD",
            "AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH",
            "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC"
    };

    public String[] getCardDeck() {
        return cardDeck;
    }

    public int getCardValue(String card) {
        return switch (card) {
            case "AS", "AD", "AH", "AC" -> 11;
            case "2S", "2D", "2H", "2C" -> 2;
            case "3S", "3D", "3H", "3C" -> 3;
            case "4S", "4D", "4H", "4C" -> 4;
            case "5S", "5D", "5H", "5C" -> 5;
            case "6S", "6D", "6H", "6C" -> 6;
            case "7S", "7D", "7H", "7C" -> 7;
            case "8S", "8D", "8H", "8C" -> 8;
            case "9S", "9D", "9H", "9C" -> 9;
            case "10S", "10D", "10H", "10C", "JS", "JD", "JH", ">JC", "QS", "QD", "QH", "QC", "KS", "KD", "KH", "KC" ->
                    10;
            default -> 0;
        };
    }
}
