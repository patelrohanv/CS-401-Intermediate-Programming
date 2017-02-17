import java.util.Scanner;
public class Mastermind{
	//serves as view for user input and output
	public static void main (String[] args){
		System.out.println("Welcome to mastermind!\nWould you like to play? (yes/no)");
		Scanner key = new Scanner(System.in);
		String play = key.next();
		play = play.toLowerCase();
		int i = 1;
		while(play.equals("yes")){
			MastermindController mc = new MastermindController(new MastermindModel());
			//makes a new model every time you start a new game
			System.out.println("Colors are: Red, Orange, Yellow, Green, Blue, Purple");
			boolean game = false;
			while(! game){
				System.out.println("Enter guess #" + (i));
				String guess = key.next();
				System.out.println("Colors in the correct place: " + mc.getRightColorRightPlace(guess));
				System.out.println("Colors correct but in wrong place: " + mc.getRightColorWrongPlace(guess));
				if (mc.isCorrect(guess)){
					System.out.println("You Win");
					break;
				}
				if((i++) == 10){
					System.out.println("You Lose");
					i = 1; //resets the count
					System.out.print("Actual is: ");
					mc.printController();
					break;
				}
			}
			System.out.println("Do you want to play again? (yes/no)");
			play = key.next();
		}

	}
}