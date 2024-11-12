import java.util.Random;

public class UnoGame {
	//Variables + constructor
	private Card head;
	public int size;
	
	public UnoGame() {
		this.head=null;
		this.size = 0;
	}
	
	//Constructor utility
	public int getSize() {
		return size;
	}
	
	public Card getHead() {
		return this.head;
	}
	
	//Adds 1 card to top of hand
	public void increaseHand(Card newCard){
		newCard.setPrevious(head);
		this.size++;
		this.head=newCard;
	}
	
	//Removes card at specific position
	public void remove(int n) {
		int x = size-n;
		//removes head node
		if(x==0) {
			head=head.getPrevious();
		}else {
			//removes specific node
			Card current = head;
			for(int i=0; i>x-1; i++) {
				current=current.getPrevious();
			}
			
			current.setPrevious(current.getPrevious().getPrevious());
		}
		this.size--;
	}
	
	//Draws a new random card
	public Card getNewCard(){
		String[] val= {"0", "1", "2", "3", "4", "5", "6", "Bottom", "Remove", "Wild",};
		String color = "RBY";
		
    	Random random = new Random();
		int j = random.nextInt(val.length);
		int k = random.nextInt(color.length());
		
		String val2=val[j];
		color=color.substring(k,k+1);
		
		Card draw = new Card(val2,color);
		return draw;
	}
	
	//This method determines what moves to make
	public void makeMove(CardStack in, int n){
		if(n==0) {
			//Draw a new card
			increaseHand(getNewCard());
		}else if(n>this.size){
			//No card in hand
			System.out.println("Invalid move.");
			return;
		}else if((getN(n).getValue()).equals("Remove")){
			//Needs to remove top card
			if(in.getSize()<=1) {
				System.out.println("Invalid move.");
				return;
			}
			remove(n);
			in.pop();
		}else if(getN(n).getValue().equals("Bottom")) {
			//Deck needs to be bottomed out
			remove(n);
			in.bottom();
		}else {
			//Card needs to be placed
			checkMove(in,n);
		}
	}	

	//If the card needs to be placed, this checks if it can be placed
	public boolean checkMove(CardStack in, int n){
			Card top=in.getTop();
			Card play =new Card(this.getN(n).getValue(), this.getN(n).getColor());
			//Plays if color equal, value equal, or its wildcard
			if(top.getColor().equals(play.getColor()) || top.getValue().equals(play.getValue()) || play.getValue().equals("Wild") || (top.getValue().equals("Wild"))) {
				
				in.push(play);
				this.remove(n);  //this messes up linkage
				return true;
			}else {
				System.out.println("Invalid move.");
				return false;
			}
	}

	//Returns card in the nth position (bottom to top)
	public Card getN(int n) {
		Card temp= this.head;
		for(int i=0; i<(this.size-n); i++) {
			temp=temp.getPrevious();
		}
		return temp;
	}

	//Print out cards in bottom to top order
	public void printHand() {
		Card[] hand= new Card[this.size];
		Card temp=this.head;
		//Loops through and reverses the order of the stack into an array
		for(int i=this.size-1; i>=0; i--) {
			hand[i]=temp;
			temp=temp.getPrevious();
		}
		//Prints the array
		if(size!=0) {
			System.out.print("[");
			for(int j=0; j<this.size; j++){
				hand[j].printCard();
				if(j+1!=this.size) {
				System.out.print(" ");
				}
			}
			System.out.print("]");
		}
	}
}
