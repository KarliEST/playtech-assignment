public class TestDTO {
    private Integer timestamp;
    private Integer sessionId;
    private Integer playerId;
    private String action;
    private String dealersHand;
    private String playersHand;

    public TestDTO() {
    }

    public TestDTO(Integer timestamp, Integer sessionId, Integer playerId, String action, String dealersHand, String playersHand) {
        this.timestamp = timestamp;
        this.sessionId = sessionId;
        this.playerId = playerId;
        this.action = action;
        this.dealersHand = dealersHand;
        this.playersHand = playersHand;
    }

    @Override
    public String toString() {
        return "Test{" +
                "timestamp=" + timestamp +
                ", sessionId=" + sessionId +
                ", playerId=" + playerId +
                ", action='" + action + '\'' +
                ", dealersHand='" + dealersHand + '\'' +
                ", playersHand='" + playersHand + '\'' +
                '}';
    }

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
