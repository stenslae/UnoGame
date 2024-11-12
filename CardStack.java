public class CardStack {
	//Instance Fields
	private Card top;
	private Card bottom;
	private int size;


	//Constructor
	public CardStack() {
		this.top=null;
		this.bottom=null;
		size=0;
	}
	
	public void bottom() {
		top=bottom;
		size=1;
	}

	public void push(Card newCard) {
		if(size == 0) {
			top=newCard;
			this.bottom=newCard;
			size++;
			return;
		}else {
			newCard.setPrevious(top);
			this.top=newCard;
			size++;	
		}
	}
	
	public Card pop(){
		Card removed = top;
		top=top.getPrevious();
		size--;
		return removed;
	}
	
	public Card peek() {
		if(size != 0) {
			return top;
		}
		else {
			return null;
		}
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public Card getTop() {
		return top;
	}
}
