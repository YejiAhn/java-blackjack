package domain.participant;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.Card;
import domain.card.Shape;
import domain.card.Symbol;

class ParticipantTest {
    Participant participant = new Participant(Name.create("참여자"));

    @Test
    @DisplayName("카드를 더하면 제대로 ParticipantCards에 더해지고, 점수 계산이 제대로 되는지")
    void calculateScore() {
        participant.receive(new Card(Symbol.ACE, Shape.CLOVER));
        participant.receive(new Card(Symbol.TWO, Shape.DIAMOND));
        assertThat(participant.calculateScore()).isEqualTo(13);
    }

    @Test
    @DisplayName("버스트 확인이 제대로 되는지")
    void isBust() {
        participant.receive(new Card(Symbol.TEN, Shape.CLOVER));
        participant.receive(new Card(Symbol.NINE, Shape.CLOVER));
        assertThat(participant.isBust()).isEqualTo(false);
        participant.receive(new Card(Symbol.EIGHT, Shape.CLOVER));
        assertThat(participant.isBust()).isEqualTo(true);
    }

    @Test
    @DisplayName("블랙잭 확인이 제대로 되는지")
    void isBlackJack() {
        participant.receive(new Card(Symbol.KING, Shape.SPADE));
        participant.receive(new Card(Symbol.ACE, Shape.DIAMOND));
        participant.setBlackJack(participant.calculateScore());
        assertThat(participant.isBlackJack()).isEqualTo(true);
    }
}
