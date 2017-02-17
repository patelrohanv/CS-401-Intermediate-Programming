class MastermindModel{ 
//stores the representation of the computer’s guess and uses a 
//constructor and accessors to create and query the solution 
//the player is trying to guess
	private char[] model = new char[4];
	public MastermindModel(){
		for(int i = 0; i < model.length; i++){
			int color = (int)(Math.random()*6)+1;
			switch (color){ //Red, Orange, Yellow, Green, Blue, Purple
				case 1:
					model[i] = 'r';
					break;
				case 2:
					model[i] = 'o';
					break;
				case 3:
					model[i] = 'y';
					break;
				case 4:
					model[i] = 'g';
					break;
				case 5:
					model[i] = 'b';
					break;
				case 6:
					model[i] = 'p';
					break;
			}
		}
		printModel();
	}

	// public char[] getModel() {
	// 	return model;
	// }

	public char getColor(int i){
		return model[i];
	}

	public int getLength(){
		return model.length;
	}

	public void printModel(){ //used for error checking
		for(char c : model){
			System.out.print(c);
		}
		System.out.println();
	}

}