package domain.card;

import java.util.Objects;

public class Card {
	private final Symbol symbol;
	private final Shape shape;

	public Card(Symbol symbol, Shape shape) {
		this.symbol = symbol;
		this.shape = shape;
	}

	public int getScore() {
		return symbol.getScore();
	}

	@Override
	public String toString() {
		return symbol + shape.getName();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Card card = (Card)o;
		return symbol == card.symbol &&
			shape == card.shape;
	}

	@Override
	public int hashCode() {
		return Objects.hash(symbol, shape);
	}
}
