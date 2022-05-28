package after;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    Ball ball;

    @BeforeEach
    void setUp() {
        ball = new Ball(1, 1);
    }

    @Test
    void strike() {
        BallStatus status = ball.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        BallStatus status = ball.play(new Ball(2, 1));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        BallStatus status = ball.play(new Ball(2, 2));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
