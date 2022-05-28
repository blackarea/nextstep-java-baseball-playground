package after;

public class PlayResult {

    private int strike;
    private int ball;

    public void record(BallStatus status) {
        if(status.isStrike()){
            strike++;
        }
        if(status.isBall()){
            ball++;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isGameOver() {
        return strike == 3;
    }
}
