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

    // TODO: kustuta ülearused getterid ja setterid
    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDealersHand() {
        return dealersHand;
    }

    public void setDealersHand(String dealersHand) {
        this.dealersHand = dealersHand;
    }

    public String getPlayersHand() {
        return playersHand;
    }

    public void setPlayersHand(String playersHand) {
        this.playersHand = playersHand;
    }
}