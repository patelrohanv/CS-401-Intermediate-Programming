class MastermindController { //

	private MastermindModel model;

	public MastermindController(MastermindModel model){
		this.model = model;
	}
	public boolean isCorrect(String guess){
		return getRightColorRightPlace(guess) == model.getLength();
	}
	public int getRightColorRightPlace(String guess){
		int rightCount = 0;
		for(int i =0; i < guess.length(); i++) {
			if(guess.charAt(i) == model.getColor(i)){
				rightCount++;
			}
		}
		return rightCount;
	}
	public int getRightColorWrongPlace(String guess){
		int simColors = 0;
		char[] one = new char[4]; //aux arrays
		char[] two = new char[4];
		char[] three = new char[4];
		char[] four = new char[4];
		one[0] = guess.charAt(0);
		if(guess.charAt(1) != guess.charAt(0)){//brute force moving data into aux arrays
			two[1] = guess.charAt(1);
		}
		if((guess.charAt(2) != guess.charAt(0)) && (guess.charAt(2) != guess.charAt(1))){
			three[2] = guess.charAt(2);
		}
		if((guess.charAt(3) != guess.charAt(0)) && (guess.charAt(3) != guess.charAt(1)) && (guess.charAt(3) != guess.charAt(2))){
			four[3] = guess.charAt(3);
		}
		simColors += checkRightColorWrongPlace(one);
		simColors += checkRightColorWrongPlace(two);
		simColors += checkRightColorWrongPlace(three);
		simColors += checkRightColorWrongPlace(four);
		return simColors - getRightColorRightPlace(guess);
	}
	private int checkRightColorWrongPlace(char[] guess){ //reuses code instead of putting repeatedly in earlier method
		int simColors = 0;
		for(int i = 0; i < guess.length; i++) {
			// if(usedColor(guess, i)){
			// 	continue;
			// }
			for (int j = 0; j < guess.length; j++){
				if(guess[i] == model.getColor(j)){
					simColors++;
				}
			}
		}
		return simColors;
	}
	public void printController (){ //used to print in view
		for(int i = 0; i < model.getLength(); i++){
			System.out.print(model.getColor(i));
		}
		System.out.println();
	}
	// private boolean usedColor(char[] guess , int index) {
	// 	for(int i = 0; i < index; i++){
	// 			if (guess[i] != model.getColor(i)){
	// 				return true;
	// 			}
	// 	}
	// 	return false;
	// }
}