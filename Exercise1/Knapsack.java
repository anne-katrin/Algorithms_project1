import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Knapsack {
	
	private String fulltext = null;
	private int capacity = 0;
	private ArrayList<Tuple> list; 
	
	/**
	 * Constructor
	 */
	public Knapsack(){
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
						if(equaltock.countTokens() == 1){ //after comma
							capacity = Integer.parseInt(equaltock.nextToken());
							System.out.println(capacity);
						}
						else{
							equaltock.nextToken(); //not interested in this one
						}
					}
				}
				else{
				String t = removePar(fulltext);
				
				StringTokenizer tock = new StringTokenizer(t, ",");
				int size = 0;
				int value = 0;
	
				while(tock.hasMoreTokens()){
					if(tock.countTokens() == 2){ //before comma, size
						size = Integer.parseInt(tock.nextToken());
					}
					else{ //value
						value = Integer.parseInt(tock.nextToken());
					}
				}
				Tuple tuple = new Tuple(size, value);
				System.out.println(tuple.getSize() + " " + tuple.getValue());
				
				list.add(tuple);
								
			}
		}
			file.close();
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
