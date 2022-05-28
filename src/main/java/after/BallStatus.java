package after;

public enum BallStatus {
    NOTHING, BALL, STRIKE;

    public boolean isNotNothing() {
        return this != NOTHING;
    }

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

}
