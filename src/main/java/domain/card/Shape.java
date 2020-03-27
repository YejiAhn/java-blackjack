package domain.card;

public enum Shape {
	DIAMOND("다이아몬드"),
	SPADE("스페이드"),
	HEART("하트"),
	CLOVER("클로버");

	private String name;

	Shape(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
