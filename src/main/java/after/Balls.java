package after;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> ballList;

    public Balls(List<Integer> randomList) {
        List<Ball> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new Ball(i + 1, randomList.get(i)));
        }
        this.ballList = list;
    }

    public PlayResult play(Balls userBalls) {
        PlayResult result = new PlayResult();
        for (Ball ball : ballList) {
            BallStatus status = userBalls.play(ball);
            result.record(status);
        }
        return result;
    }

    public BallStatus play(Ball ball) {
        return ballList.stream()
                .map(random -> random.play(ball))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
