import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Lab 1: an exhaustive search for the knapsack problem.
 * 
 * @author Anne-Katrin Krolovitsch 
 * @author Linda Nilsson
 *
 */
public class Knapsack {	
	private String fileName = "second.txt";
	private String fulltext = null;
	private int capacity = 0;
	private int bestValue = 0;
	private int bestSet = 0;
	private ArrayList<Tuple> inputList; 
	private ArrayList<ArrayList<Tuple>> subSetList;
	
	/**
	 * Constructor
	 */
	public Knapsack(){
		inputList = new ArrayList<Tuple>();
		subSetList = new ArrayList<ArrayList<Tuple>>();
	}
	
	/**
	 * Main function 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Knapsack knap = new Knapsack();
		knap.readFile();
		knap.createPowerset();
		knap.printSubsets();
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
//							System.out.println(capacity);
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
	 * this function removes the paranteses from the input lines 
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
	 * 
	 *
	 */
	public void createPowerset(){
		int inputSize = inputList.size();
		long subSetsSize = (long) Math.pow(2, inputSize); //the number of possible subsets 2^n
		
		for(long i = 0; i < subSetsSize; i++){ 
			long elementToInclude = 1;
			ArrayList<Tuple> tempList = new ArrayList<Tuple>(); 
			
			for(int j = 0; j < inputSize; j++){ // as long as j is less than the number of tuples in the list
				long b = i & elementToInclude;
//				System.out.println("elem = " + elementToInclude);
//				System.out.println("i = " + i);
//				System.out.println("i & elem " + b); 
				if((i & elementToInclude) != 0){//Bit masking: performs logical "bitwise-and" operation 
					tempList.add(inputList.get(j));
//					System.out.println("loop add " + inputList.get(j));
				}
				elementToInclude = elementToInclude << 1; //Bit shifting to the left by 1
			}
			subSetList.add(tempList);
		}
	}
	
	public void printSubsets(){
		Iterator itr = subSetList.iterator(); 
		int count = 0;
		while(itr.hasNext()) {
			System.out.println("set " + count);
			count++;
			ArrayList temp = (ArrayList) itr.next();
			Iterator itTemp = temp.iterator();
			while(itTemp.hasNext()){
				Tuple hej = (Tuple) itTemp.next();
				System.out.println("\t" + hej.getSize() + " " + hej.getValue());
			}
		}
	}
	
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
					//System.out.println("changing from "+ bestValue);
					bestValue = sumValue;
					//System.out.println("to "+ bestValue);
					bestSet = i;
				}
			}
		}
		printBestSet();
	}

	public void printBestSet(){
		
		if(subSetList.get(bestSet).size() == 0){
			System.out.print("Chosen: ");
			//System.out.println("Value: 0");
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
