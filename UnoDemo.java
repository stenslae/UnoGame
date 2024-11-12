import java.util.Scanner;

public class UnoDemo {
	public static void main(String args[]) {
		//Declare
		UnoGame hand= new UnoGame();
		CardStack stack = new CardStack();
		Scanner scan = new Scanner(System.in);
		
		//Initialize
		for(int i=0; i<5;i++) {
		hand.increaseHand(hand.getNewCard());
		}
		stack.push(hand.getNewCard());
		
		//Run the actual stuff
		while(hand.getSize()!=0){
			System.out.print("The top of the stack is: ");
			stack.getTop().printCard() ;
			System.out.println("\nWhat card do you want to play?" + "\nPress 0 to draw new card.");
			hand.printHand();
			System.out.print("\n");
			try{
			int input=scan.nextInt();
			hand.makeMove(stack,input);
			}catch(java.util.InputMismatchException e){
				String input=scan.nextLine();
				System.out.println("Invalid move.");
			}
		}
		System.out.println("Game over.");
		scan.close();
	}
}

