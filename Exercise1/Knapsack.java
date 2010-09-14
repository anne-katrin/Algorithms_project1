import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Lab 1: an exhaustive search for the knapsack problem.
 * 
 * Group: 25
 * 
 * @author Anne-Katrin Krolovitsch 
 * @author Linda Nilsson
 *
 */
public class Knapsack {	
	private String fileName = null;
	private String fulltext = null;
	private int capacity = 0;
	private int bestValue = 0;
	private int bestSet = 0;
	private ArrayList<Tuple> inputList; 
	private ArrayList<ArrayList<Tuple>> subSetList;
	
	/**
	 * Constructor
	 */
	public Knapsack(String fileName){
		this.fileName = fileName;
		inputList = new ArrayList<Tuple>();
		subSetList = new ArrayList<ArrayList<Tuple>>();
	}
	
	/**
	 * Main function 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String file = "third.txt";
		if(args.length > 0){
			file = args[0];
		}
		Knapsack knap = new Knapsack(file.trim());
		knap.readFile();
		knap.createPowerset();
		knap.selectBestSet();
	}
	
	/**
	 * is reading the contents of a file
	 * @throws IOException
	 */
	public void readFile() throws IOException{
		FileReader file = new FileReader(fileName);
		BufferedReader reading = new BufferedReader(file); 
		fulltext = new String();

		try{
			while((fulltext = reading.readLine()) != null){
				if(fulltext.startsWith("capacity")){
					StringTokenizer equaltock = new StringTokenizer(fulltext, "=");
					while(equaltock.hasMoreTokens()){
						if(equaltock.countTokens() == 1){ //after comma
							capacity = Integer.parseInt(equaltock.nextToken());
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
				
				inputList.add(tuple);							
			}
		}
			file.close();
		}
			catch(IOException e){
			System.out.println("Reading the file failed!");
			}
		}
	
	
	/**
	 * this function removes the parenthesis from the input lines 
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
		
	
	/**
	 * Creates all possible subsets from the inputList
	 *
	 */
	public void createPowerset(){
		int inputSize = inputList.size();
		long subSetsSize = (long) Math.pow(2, inputSize); //the number of possible subsets 2^n
		for(long i = 0; i < subSetsSize; i++){ 
			long elementToInclude = 1;
			ArrayList<Tuple> tempList = new ArrayList<Tuple>(); 
			
			for(int j = 0; j < inputSize; j++){ // as long as j is less than the number of tuples in the list
				if((i & elementToInclude) != 0){//Bit masking: performs "bitwise-and" operation 
					tempList.add(inputList.get(j));
				}
				elementToInclude = elementToInclude << 1; //Bit shifting to the left by 1
			}
			subSetList.add(tempList);
		}
	}
	
	/**
	 * Selects the first subset which fits in the knapsack and also gives the highest value.
	 */
	public void selectBestSet(){
		for(int i = 0; i < subSetList.size();i++){
			
			int sumSizes = 0;
			int sumValue = 0;
			
			for(int j = 0; j < subSetList.get(i).size(); j++){
				Tuple tuple = subSetList.get(i).get(j);
				sumSizes += tuple.getSize();
				sumValue += tuple.getValue();
			}
			if(sumSizes <= capacity){
				if(sumValue > bestValue){
					bestValue = sumValue;
					bestSet = i;
				}
			}
		}
		printBestSet();
	}

	/**
	 * prints the selected best subset and the best value
	 */
	public void printBestSet(){
		
		if(subSetList.get(bestSet).size() == 0){
			System.out.print("Chosen: ");
		}
		System.out.print("Chosen: ");
		for(int k = 0; k < subSetList.get(bestSet).size();k++){
			System.out.print("(" + subSetList.get(bestSet).get(k).getSize() + "," + subSetList.get(bestSet).get(k).getValue() + "),");
		}
		System.out.println("\nValue: " + bestValue);
	}
	
	/**
	 * Tuple object consisting of its size and value
	 *
	 */
	static class Tuple {

		private int size;
		private int value;
		
		public  Tuple(int size, int value){
			this.size = size;
			this.value = value; 
		}
		
		public int getSize(){
			return size;
		}
		public int getValue(){
			return value;
		}
	}
}
