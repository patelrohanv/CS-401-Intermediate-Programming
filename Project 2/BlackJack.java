import java.util.Scanner;

public class BlackJack{
	public static void main (String [] args){
		Scanner kbd = new Scanner (System.in);
		System.out.print("Hello, welcome to the casino.\nWhat is your name: ");
		String name = kbd.next();
		int dealerOne = card();
		int dealerTwo = card();
		int dealerAceCount = 0;
		if ((dealerOne == 1) && (dealerAceCount == 0)){
			dealerOne = 11;
			dealerAceCount++;
		}
		if((dealerTwo == 1) && (dealerAceCount == 0)){
			dealerTwo = 11;
			dealerAceCount++;
			//System.out.println("Ace changed to 11");
		}
		System.out.println("Dealer hand is: ? + "+ dealerTwo);
		int player = player();
		System.out.println();
		int dealer = dealer(dealerOne, dealerTwo);
		System.out.println("\n? is: " + dealerOne);
		System.out.println("Dealer has: " + dealer +"\n");
		score(player, dealer);
	}
	public static int card (){
			//*(13-1+1)+1
			//need to include 11-13 because 10 is statistically more likely in blackjack
			int card = (int)(Math.random()*13)+1;
			if (card > 10){
				card = 10;
			}
			return card;
	}
	public static int player (){
		Scanner kbd = new Scanner (System.in);
		int cardOne = card();
		int cardTwo = card();
		int aceEleven = 0; //ace counter
		if(cardOne == 1){
			cardOne = 11;
			aceEleven++;
		}
		if(cardTwo == 1){
			cardTwo = 11;
			aceEleven++;
		}
		int total = cardOne + cardTwo;
		//prevents two aces making 22 in the original hand
		if (cardTwo == 11 && total > 21){
				aceEleven--;
				cardTwo = 1;
				System.out.println("Ace changed to one");
		}
		total = cardOne + cardTwo; //adjust for if two aces
		System.out.println("Your hand is: " + cardOne + " + " + cardTwo + "\n");
		System.out.println("Do you want to hit? (hit or stand)");
		String input = kbd.next();
		input = input.toLowerCase(); //lets you use capitals or lowercase
		while(input.equals("hit")){
			int deal = card();
			if(deal == 1){
				deal = 11;
				aceEleven++; //aceEleven should never be greater than 1
			}
			int newPlayer = total + deal;//lets you print the original total later
			if(deal == 11 && newPlayer > 21){
				System.out.println("Ace changed to one");
				deal = 1;
				newPlayer = total + deal;
			}
			System.out.println("You: " + total + " + " + deal + " = " + newPlayer);
			total = newPlayer;
			if(total == 21){ //no need to hit if over 21
				return 21;
			}
			if(total > 21 && aceEleven > 0){ //greater than 0 not 1
				total -= 10;
				aceEleven--;
				System.out.println("Earlier Ace changed to one, new total is: " + total);
			}
			if(total > 21){
				break; //forces you to bust
			}
			System.out.println("Do you want to hit? (hit or stand)");
			input = kbd.next();
			input = input.toLowerCase();
		}
		return total;
	}
	public static int dealer (int cardOne, int cardTwo){
		int aceEleven = 0;
		if (cardOne == 11){
			aceEleven++;
		}
		if(cardTwo == 11){
			aceEleven++;
		}
		int total = cardOne + cardTwo;
		while (total < 17){ //must hit if total is less than 17
			int i = card();
			if(i == 1){
				i = 11;
				aceEleven++;
				//System.out.println("Drew an Ace, value will be set to a 11");
			}
			total += i;
			if(i == 11 && total > 21){
				total -= 10;
				i = 1;
				aceEleven--;
				System.out.println("Ace changed to 1");
			}
			System.out.println("Dealer drew: " + i);
			if(total > 21 && aceEleven > 0){
				total -= 10;
				aceEleven--;
				System.out.println("Earlier Ace changed to one");
			}
		}
		return total;
	}
	public static void score(int player, int dealer){
		if (player > dealer && player <= 21){
			System.out.println("\nYou win");
		}
		else if(player > 21){
			System.out.println("\nYou busted, dealer wins");
		}
		else if(player == dealer){
			System.out.println("\nDraw, dealer wins by default");
		}
		else if( dealer > player && dealer <= 21){
			System.out.println("\nYou lose, dealer wins");
		}
		else if(dealer > 21){
			System.out.println("\nDealer busted, you win");
		}
		else if (player > 21 && dealer > 21){
			System.out.println("\nYou both bust, dealer wins by default");
		}
	}
}