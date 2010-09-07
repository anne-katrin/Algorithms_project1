import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Knapsack {
	
	private String fulltext = null;
	private int size;
	private int value;
	private ArrayList<Tuple> list; 
	
	/**
	 * Constructor
	 */
	public Knapsack(){
		Tuple t = new Tuple(size, value);
		list = new ArrayList<Tuple>();
	}
	
	/**
	 * Main function 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Knapsack knap = new Knapsack();
		knap.readingTheFile();
		String fulltext = null;
	}
	
	/**
	 * is reading the contents of a file
	 * @throws IOException
	 */
	public void readingTheFile() throws IOException{
		FileReader file = new FileReader("firstexample.txt");
		BufferedReader reading = new BufferedReader(file); 
		
	
		fulltext = new String();
		char[] current;
	current = new char[100];
		char f;
		try{
			while((fulltext = reading.readLine()) != null){
				if(fulltext.startsWith("capacity")){
					StringTokenizer equaltock = new StringTokenizer(fulltext, "=");
					while(equaltock.hasMoreTokens()){
						System.out.println(equaltock.nextToken());
					}
				}
				else{
				String t = removePar(fulltext);
				StringTokenizer tock = new StringTokenizer(t, ",");
			//	lägg in i size
				while(tock.hasMoreTokens()){
					
					System.out.println(tock.nextToken());
					//lägg in i values
				}
								
			}
		}
		}
			catch(IOException e){
			System.out.println("epic fail");
			}
		}
	
	
	/**
	 * is for removing the paranteses from the input 
	 * 
	 */
	public String removePar(String input){
		char opening = '(';
		char closing = ')';
		String result = "";
		
		for (int i = 0; i < input.length(); i++){
			if(input.charAt(i) != opening && input.charAt(i) != closing){
				result += input.charAt(i);	
			}
		}
		return result;		
	}
}
