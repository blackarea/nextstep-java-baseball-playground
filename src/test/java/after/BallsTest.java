package after;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    void play_3strike() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = balls.play(new Balls(Arrays.asList(1, 2, 3)));
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.isGameOver()).isTrue();
    }

    @Test
    void play_1ball_1strike() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = balls.play(new Balls(Arrays.asList(1, 4, 2)));
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(1);
    }

    @Test
    void strike() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = balls.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = balls.play(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = balls.play(new Ball(1, 5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
