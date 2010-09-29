import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Lab 2: an Dynamic programming for the knapsack problem.
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
	private int W = 0;
	private int[][] Mem;
	private ArrayList<Tuple> inputList; 

	
	/**
	 * Constructor
	 */
	public Knapsack(String fileName){
		this.fileName = fileName;
		inputList = new ArrayList<Tuple>();
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
		knap.Mem = knap.findBestValue();
//		knap.printmem(knap.Mem);
		knap.printBestSet();
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
							W = Integer.parseInt(equaltock.nextToken());
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
	 * fills a matrix to find the highest possible value that can be obtained for the knapsack
	 * 
	 * 
	 * @return a filled memory matrix
	 */
	public int[][] findBestValue(){
		int n = inputList.size()+1;
		int[][] M = new int[n][W+1];
		
		for(int w = 0; w <= W; w++){
			M[0][w] = 0;
		}
		for(int j = 1; j < n; j++){ 
			M[j][0] = 0;
		}
		
		for(int i =1; i < n; i++) {
			for(int w=1; w <= W; w++){
				if(inputList.get(i-1).getWeight() > w){
					M[i][w] = M[i-1][w];
				}
				else{
					if(M[i-1][w] > inputList.get(i-1).getValue() + M[i-1][w-inputList.get(i-1).getWeight()]){
						M[i][w] = M[i-1][w];
					}
					else{
						M[i][w] = inputList.get(i-1).getValue() + M[i-1][w-inputList.get(i-1).getWeight()];
					}
				}
			}
		}
		return M;
	}
	
	/**
	 * Prints the best highest value that can be selected and which items to select to get this value
	 * 
	 */
	public void printBestSet(){
		int n = inputList.size();
		int w = W;
		System.out.print("Chosen: ");
		for(int i =n; i >= 1; i--) {
				if(Mem[i][w] == Mem[i-1][w]){
				}
				else{
					w =w - inputList.get(i-1).getWeight();
					System.out.print("(" +inputList.get(i-1).getWeight() + "," +  inputList.get(i-1).getValue() + "), "); 
				}
		}
		System.out.println("\nHighest Value:" + Mem[n][W]);
	}
	
	/**
	 * For printing the Memory matrix after it has been filled 
	 * 
	 * @param Mem a filled memory matrix
	 */
//	public void printmem(int[][] Mem){
//		for(int j = 0; j < inputList.size()+1 ;j++){
//			for(int i = 0; i <= W; i++){
//				System.out.print(Mem[j][i] + "\t");
//			}
//			System.out.println("");
//		}
//	}
	
	/**
	 * Tuple object consisting of its size and value
	 *
	 */
	static class Tuple {

		private int weight;
		private int value;
		
		public  Tuple(int weight, int value){
			this.weight = weight;
			this.value = value; 
		}
		
		public int getWeight(){
			return weight;
		}
		public int getValue(){
			return value;
		}
	}
}
