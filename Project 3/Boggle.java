import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.io.PrintWriter;

class Boggle{
	public static void main (String[] args){
		ArrayList<String> dict = new ArrayList<> ();
		String[] hiScores = new String[20];
		//read in dictionary and high scores
		try{
			//File dictionary = new File("dict.txt");
			Scanner inFile  = new Scanner (new File ("dict.txt")); //new Scanner(dictionary);
			//Scanner inFile  = new Scanner (new File (args[0]));
			while (inFile.hasNext()){
				String word = inFile.next();
				dict.add(word);
			}
			//inFile.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File Not Found");
			e.printStackTrace();
			System.exit(1);
		}
		try{
			Scanner scoresFile = new Scanner (new File ("boggleScores.txt"));
			//Scanner scoresFile  = new Scanner (new File (args[1]));
			while(scoresFile.hasNext()){
				for(int i = 0; i < hiScores.length; i++){
					hiScores[i] = scoresFile.next();
				}
			}
			//scoresFile.close();
		}
		catch(FileNotFoundException f){
			System.out.println("Scores file not found");
			f.printStackTrace();
			System.exit(1);
		}
		//To check if files were read in properly
		// for(int i = 0; i < dict.size();i++){
		// 	System.out.println(dict.get(i));
		// }
		// for(int i = 0; i < hiScores.length; i++){
		// 	System.out.println(hiScores[i]);
		// }
		String[] dictArr = new String [dict.size()];
		dictArr = dict.toArray(dictArr);
		Scanner kbd = new Scanner(System.in);
		BoggleModel board = new BoggleModel();
		//board.print();
		System.out.println(board);
		String guess = " ";
		int score = 0;
		ArrayList<String> guessedWords = new ArrayList<> ();
		//play the game
		while(! guess.equals("q")){
			System.out.println("Enter your word");
			guess = kbd.next().toLowerCase();
			if(guess.equals("q")){
				break;
			}

			//if(dict.contains(guess)){
			if(Arrays.binarySearch(dictArr, guess, String.CASE_INSENSITIVE_ORDER) >= 0){
				if(! guessedWords.contains(guess)){
					guessedWords.add(guess);
					if(board.legalWord(guess)){
							score += board.scoreWord(guess);
							System.out.println(guess + " earned: " + board.scoreWord(guess) + " points");
					}
					else{
						System.out.println("Please enter legal word");
					}
				}
				else{
					System.out.println("Please enter a word you have not used or \"q\" to quit");
				}
			}
			else{
				System.out.println("Please enter a real word or \"q\" to quit");
			}
		}
		//output file
		if (score > findMinValue(hiScores)){
			int minIndex = findMinIndex(hiScores);
			hiScores[minIndex] = Integer.toString(score);
			System.out.println("Please enter a three letter name for your new high score");
			hiScores[minIndex-1] = kbd.next();
			try{
				PrintWriter outputFile = new PrintWriter("boggleScores.txt");
				for(String s: hiScores){
					outputFile.println(s);
				}
				outputFile.close();
			}
			catch(FileNotFoundException e){
				System.out.println("Could not write to file");
			}
		}
	}
	public static int findMinValue (String[] scores){
		int min = Integer.parseInt(scores[1]);
		for(int i = 0; i < scores.length; i++){
			if(i%2 != 0){
				int temp = Integer.parseInt(scores[i]);
				if (temp < min){
					min = temp;
				}
			}
		}
		return min;
	}
	public static int findMinIndex (String[] scores){
		int minIndex = 1;
		int min = Integer.parseInt(scores[1]);
		for(int i = 0; i < scores.length; i++){
			if(i%2 != 0){
				int temp = Integer.parseInt(scores[i]);
				if (temp < min){
					min = temp;
					minIndex = i;
				}
			}
		}
		return minIndex;
	}
	
}