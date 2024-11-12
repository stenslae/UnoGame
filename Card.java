
public class Card {
	//Instance Fields
	private String value;
	private String color;
	private Card previous;
	
	//Constructor
	public Card(String val, String col) {
		this.value = val;
		this.color = col;
		this.previous = null;
	}
	
	//Methods
	public String getValue() {
		return value;
	}
	public String getColor() {
		return color;
	}
	
	public Card getPrevious() {
		return this.previous;
	}
	
	public void setPrevious(Card previousNode) {
		this.previous=previousNode;
	}
	
	public void printCard() {
		System.out.print("(" + color + " " + value + ")");
	}
}
