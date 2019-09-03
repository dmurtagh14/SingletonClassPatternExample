package com.singletonclasspatternexample;

public class ScrabbleTestThreads {
	
	public static void main(String[] args) {
		Runnable getTile = new GetTheTiles();
		
		Runnable getTilesAgain = new GetTheTiles();
		
		new Thread(getTile).start();
		new Thread(getTilesAgain).start();

		
	}	

}
