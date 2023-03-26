public class DataObject {
    private Integer timestamp;
    private Integer sessionId;
    private Integer playerId;
    private String action;
    private String dealersHand;
    private String playersHand;

    public DataObject() {
    }

    public DataObject(Integer timestamp, Integer sessionId, Integer playerId, String action, String dealersHand, String playersHand) {
        this.timestamp = timestamp;
        this.sessionId = sessionId;
        this.playerId = playerId;
        this.action = action;
        this.dealersHand = dealersHand;
        this.playersHand = playersHand;
    }

    @Override
    public String toString() {
        return timestamp + "," + sessionId + "," + playerId + "," + action + "," + dealersHand + "," + playersHand;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public String getAction() {
        return action;
    }

    public String getDealersHand() {
        return dealersHand;
    }

    public String getPlayersHand() {
        return playersHand;
    }

}
