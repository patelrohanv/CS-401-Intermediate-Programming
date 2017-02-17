import java.lang.StringBuilder;

class BoggleModel{
	char[][] board = new char[4][4];
	public BoggleModel(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length;j++){
				int letter = (int) (Math.random()*26)+1; //(hi-lo+1) + lo
				if(letter == 1){
					board[i][j] = 'a';
				}
				else if(letter == 2){
					board[i][j] = 'b';
				}
				else if(letter == 3){
					board[i][j] = 'c';
				}
				else if(letter == 4){
					board[i][j] = 'd';
				}
				else if(letter == 5){
					board[i][j] = 'e';
				}
				else if(letter == 6){
					board[i][j] = 'f';
				}
				else if(letter == 7){
					board[i][j] = 'g';
				}
				else if(letter == 8){
					board[i][j] = 'h';
				}
				else if(letter == 9){
					board[i][j] = 'i';
				}
				else if(letter == 10){
					board[i][j] = 'j';
				}
				else if(letter == 11){
					board[i][j] = 'k';
				}
				else if(letter == 12){
					board[i][j] = 'l';
				}
				else if(letter == 13){
					board[i][j] = 'm';
				}
				else if(letter == 14){
					board[i][j] = 'n';
				}
				else if(letter == 15){
					board[i][j] = 'o';
				}
				else if(letter == 16){
					board[i][j] = 'p';
				}
				else if(letter == 17){
					board[i][j] = 'q';
				}
				else if(letter == 18){
					board[i][j] = 'r';
				}
				else if(letter == 19){
					board[i][j] = 's';
				}
				else if(letter == 20){
					board[i][j] = 't';
				}
				else if(letter == 21){
					board[i][j] = 'u';
				}
				else if(letter == 22){
					board[i][j] = 'v';
				}
				else if(letter == 23){
					board[i][j] = 'w';
				}
				else if(letter == 24){
					board[i][j] = 'x';
				}
				else if(letter == 25){
					board[i][j] = 'y';
				}
				else if(letter == 26){
					board[i][j] = 'z';
				}
			}
		}
	}
	public char getLetter(int i, int j){
		return board[i][j];
	}

	private final static int[][] directions = {{0,1}, {1,0}, {1,1}, {0, -1}, {-1, 0}, {-1, -1}, {-1,1}, {1, -1}};
	//will be used to check adjacent cells

	public boolean legalWord (String guess){
		if(guess.length() < 3){
			return false;//can't use word shorter than 3 letters
		}
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				  if(checkWord(i, j, guess, new int[4][4], 0)){
				  	return true;
				  }
			}
		}
		return false;
	}
	private boolean checkWord( int x, int y, String guess, int[][] checkArr, int ind){
		if(board[x][y] != guess.charAt(ind)){
			return false;
		}
		if(board[x][y] == guess.charAt(ind)){
			return true;
		}
		if(ind == guess.length()-1){
			return true;
		}
		checkArr[x][y] = 1;
		for (int [] d: directions){
			if(!(x+d[0] > checkArr.length || y+d[1] > checkArr[0].length)){
				if(checkArr[x+d[0]][y+d[1]] == 0){
					if(checkWord(x+d[0], y+d[1], guess, checkArr, ind+1)){
						return true;
					}
				}
			}
		}
		return false;
	}

	public int scoreWord (String s){
		if(s.length() < 3){
			return -1;
		}
		int score = 0;
		for(int i = 0; i < s.length(); i++){
			if (s.charAt(i) == 'a'){
				score += 1;
			}
			else if (s.charAt(i) == 'b'){
				score += 3;
			}
			else if (s.charAt(i) == 'c'){
				score += 3;
			}
			else if (s.charAt(i) == 'd'){
				score += 2;
			}
			else if (s.charAt(i) == 'e'){
				score += 1;
			}
			else if (s.charAt(i) == 'f'){
				score += 4;
			}
			else if (s.charAt(i) == 'g'){
				score += 2;
			}
			else if (s.charAt(i) == 'h'){
				score += 4;
			}
			else if (s.charAt(i) == 'i'){
				score += 1;
			}
			else if (s.charAt(i) == 'j'){
				score += 8;
			}
			else if (s.charAt(i) == 'k'){
				score += 5;
			}
			else if (s.charAt(i) == 'l'){
				score += 1;
			}
			else if (s.charAt(i) == 'm'){
				score += 3;
			}
			else if (s.charAt(i) == 'n'){
				score += 1;
			}
			else if (s.charAt(i) == 'o'){
				score += 1;
			}
			else if (s.charAt(i) == 'p'){
				score += 3;
			}
			else if (s.charAt(i) == 'q'){
				score += 10;
			}
			else if (s.charAt(i) == 'r'){
				score += 1;
			}
			else if (s.charAt(i) == 's'){
				score += 1;
			}
			else if (s.charAt(i) == 't'){
				score += 1;
			}
			else if (s.charAt(i) == 'u'){
				score += 1;
			}
			else if (s.charAt(i) == 'v'){
				score += 4;
			}
			else if (s.charAt(i) == 'w'){
				score += 4;
			}
			else if (s.charAt(i) == 'x'){
				score += 8;
			}
			else if (s.charAt(i) == 'y'){
				score += 4;
			}
			else if (s.charAt(i) == 'z'){
				score += 10;
			}
		}
		return score;
	}
	public void print(){
		for (int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public String toString(){
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				s.append(board[i][j]);
				s.append(" ");
			}
			s.append("\n");
		}

		return s.toString();
	}
}