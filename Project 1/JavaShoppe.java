/*Rohan Patel
RVP3
3827175 */
class JavaShoppe
{
	public static void main(String[] args)
	{
		double cost = 0;
		java.util.Scanner input = new java.util.Scanner(System.in);
		int pick = 0; 
		int mondo = 0; //separate coffee sizes to do the discount
		int muffin = 0;
		int book = 0;
		int smallAmount = 0;
		int mediumAmount = 0;
		int mondoAmount = 0;
		int muffinAmount = 0;
		int teaAmount = 0;
		int hotAmount = 0;
		int waterAmount = 0;
		int organicAmount = 0;
		//give all these an initial value so they can be used in the loop
		
		while(pick != 7){ // !7 otherwise you can't prompt to enter in the range if input is <7 
			System.out.println("The Java Shoppe Menu:"
				+ "\n 1.) Brewed Coffee" 
			 	+ "\n 2.) Chocolate Chip Muffin \t $1.75" 
				+ "\n 3.) Pot of Tea \t \t $2.00" 
				+ "\n 4.) Hot chocolate \t \t $2.50" 
				+ "\n 5.) Water \t \t \t $2.00"
				+ "\n 6.) Organic water \t \t $4.00"
				+ "\n 7.) Check out/Print receipt"
				+ "\nWhich item is being purchased?");
			//inside the loop to prompt and give menu each time
			pick = input.nextInt(); //input after printing the menu, fixed earlier problem
			int size = 0; 
			if(pick  >  7){
				System.out.println("Please enter a number in the range");
				}
			else if(pick == 1){
			System.out.println("What Size?"
				+ "\n 1) Small \t \t $1.50"
				+ "\n 2) Medium \t \t $1.75"
				+ "\n 3) Mondo \t \t $2.50");
			size = input.nextInt();
			if(size == 1){
				System.out.println("How Many?");
				smallAmount = smallAmount + input.nextInt(); 
				//fixed problem of amount not adding if you select it again
				//separate amounts per item to make the bill easier to print
				cost = cost + (smallAmount*1.50);
				}
				else if(size == 2){
				System.out.println("How Many?");
				mediumAmount = mediumAmount + input.nextInt();
				cost = cost + (mediumAmount*1.75);
				}
				else if (size == 3){
				System.out.println("How Many?");
				int count = input.nextInt(); //keeps track of how many mondos per entry
				mondoAmount = mondoAmount + count;
				cost = cost + (mondoAmount*2.50);
				mondo = mondo + count;
				count = 0; //resets the count to fix discount issue
				//lets you keep track of how many times to apply the discount
				}
				else{
				System.out.println("Not a valid option");
				}	
			}
			else if (pick == 2){
			System.out.println("How Many?");
			int count = input.nextInt();
			muffinAmount = muffinAmount + count;
			cost = cost + (muffinAmount*1.75);
			muffin = muffin + count;
			count = 0;	
			}
			else if (pick == 3){
			System.out.println("How Many?");
			teaAmount = teaAmount + input.nextInt();
			cost = cost + (teaAmount*2.0);
			}
			else if (pick == 4){
			System.out.println("How Many?");
			hotAmount = hotAmount + input.nextInt();
			cost = cost + (hotAmount*2.50);
			}
			else if (pick == 5){
			System.out.println("How Many?");
			waterAmount = waterAmount + input.nextInt();
			cost = cost + (waterAmount*2.0);
			}
			else if (pick == 6){
			System.out.println("How Many?");
			organicAmount = organicAmount + input.nextInt();
			cost = cost + (organicAmount*4.0);
			book = 1;
			}
			/*not needed any more, "while(!7)" does this already
			else if (pick == 7) 
			{
				break;
			}*/
		}
		System.out.println("Your Bill:");
		if (smallAmount > 0){
		System.out.print("\n" + smallAmount + "\t Small Coffee \t \t");
		System.out.printf("$%,.2f",(smallAmount*1.50));
		}
		if (mediumAmount > 0){
		System.out.print("\n"+ mediumAmount + "\t Medium Coffee \t \t");
		System.out.printf("$%,.2f",(mediumAmount*1.75));
		}
		if (mondoAmount > 0){
		System.out.print("\n" + mondoAmount + "\t Mondo Coffee \t \t");
		System.out.printf("$%,.2f",(mondoAmount*2.50));
		}
		if (muffinAmount > 0){
		System.out.print("\n" + muffinAmount + "\t Muffin \t \t");
		System.out.printf("$%,.2f",(muffinAmount*1.75));
		}
		if (teaAmount > 0){
		System.out.print("\n" + teaAmount + "\t Pot of Tea \t \t");
		System.out.printf("$%,.2f",(teaAmount*2.00));
		}
		if (hotAmount > 0){
		System.out.print("\n" + hotAmount + "\t Hot Chocolate \t \t");
		System.out.printf("$%,.2f",(hotAmount*2.50));
		}
		if (waterAmount > 0){
		System.out.print("\n" + waterAmount + "\t Water \t \t \t");
		System.out.printf("$%,.2f",(waterAmount*2.00));
		}
		if (organicAmount > 0){
		System.out.print("\n" + organicAmount + "\t Organic Water \t \t");
		System.out.printf("$%,.2f",(organicAmount*4.00));
		}
		
		/*
		if (mondo > 0 && muffin > 0){
			if (mondo < muffin){
			cost = cost - (mondo * 1);
			System.out.print("\n \t Mondo Muffin Discount \t");
			System.out.printf("$%,.2f",(mondo * -1.0));
			}
			else if (mondo > muffin){
			cost = cost - (muffin * 1);
			System.out.print("\n \t Mondo Muffin Discount \t");
			System.out.printf("$%,.2f",(muffin * -1.0)); 
			}
			else if (mondo == muffin){
			cost = cost - (muffin * 1);
			System.out.print("\n \t Mondo Muffin Discount \t");
			System.out.printf("$%,.2f",(muffin * -1.0));
			}
			//three options account for all possibilities
		}
		*/
		
		if(mondo > 0 && muffin > 0){ //no need to make ifs for all three possibilities
			if (mondo <= muffin){
			cost = cost - mondo;
			System.out.print("\n \t Mondo Muffin Discount \t");
			System.out.printf("$%,.2f",(mondo * -1.0));
			}
			else{
			cost = cost - muffin;
			System.out.print("\n \t Mondo Muffin Discount \t");
			System.out.printf("$%,.2f",(muffin * -1.0)); 
			}
		}
		if(book == 1){
		System.out.print("\n \t Free chemistry book \t$0.00");
		}
		System.out.print("\n \t Subtotal: \t \t");
		System.out.printf("$%,.2f", cost);
		double tax = cost * .05;
		System.out.print("\n \t 5% Java Tax: \t \t");
		System.out.printf("$%,.2f", tax);
		double total = cost + tax;
		System.out.print("\n \t Total: \t \t");
		System.out.printf("$%,.2f", total);
		System.out.print("\nHow much are you paying? ");
		double paid = input.nextDouble();
		double change = paid - total;
		System.out.print("\nCustomer paid: \t \t \t");
		System.out.printf("$%,.2f", paid);
		System.out.print("\nTheir change is: \t \t");
		System.out.printf("$%,.2f", change);
	}
}