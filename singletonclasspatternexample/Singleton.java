package com.singletonclasspatternexample;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Singleton {

	private static Singleton firstInstance = null;
	
	
	String[] scrabbleLetters = {"a", "a", "a", "a", "a", "a", "a", "a", "a",
			
			            "b", "b", "c", "c", "d", "d", "d", "d", "e", "e", "e", "e", "e",
			
			            "e", "e", "e", "e", "e", "e", "e", "f", "f", "g", "g", "g", "h",
			
			            "h", "i", "i", "i", "i", "i", "i", "i", "i", "i", "j", "k", "l",
			
			            "l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n", "o", "o",
			
			            "o", "o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r",
			
			            "r", "r", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "u",
			
			            "u", "u", "u", "v", "v", "w", "w", "x", "y", "y", "z",};
	
	//create a linked list of objects in an array
	private LinkedList<String> letterList = new LinkedList<String>(Arrays.asList(scrabbleLetters));
	
	
	static boolean firstThread = true;

	
	
	//make it private so there is only one instance of singleton
	private Singleton() {}
			
	//use schronized key word to make threads wait and fix the issue threads 
	//have in singleton pattern
	//however synchronized isnt the best method because it slows things 
	//down tremendously
	public static  Singleton getInstance() {
		if(firstInstance == null) {
			firstInstance = new Singleton(); //only create a signleton if one doesnt exist
			//lazy instanstiation
			
			
			
			if(firstThread) {
				firstThread = false;
				Thread.currentThread();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			//wrap everything in a synchronized object instead
			synchronized(Singleton.class) {
				if(firstThread) {
					firstInstance = new Singleton();
					//randomizes letters
					Collections.shuffle(firstInstance.letterList);

				}
				
			}
				}
		return firstInstance;
	
			}	
			
	
	public LinkedList<String> getLetterList(){
		//how to return fields in a singleton
		return firstInstance.letterList;
	}
	
	public LinkedList<String> getTiles(int howManyTiles){
		LinkedList<String> tilesToSend = new LinkedList<String>();
		
		for(int i = 0; i <= howManyTiles; i++) {
			tilesToSend.add(firstInstance.letterList.remove(0)); //add to tile and remove from letter list
			
			
		}
		
		return tilesToSend;
	}
	
}
