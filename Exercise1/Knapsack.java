import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Knapsack {	
	private String fileName = "second.txt";
	private String fulltext = null;
	private int capacity = 0;
	private int bestValue = 0;
	private int bestSet = 0;
	private ArrayList<Tuple> list; 
	private ArrayList<ArrayList<Tuple>> subSets;
	
	/**
	 * Constructor
	 */
	public Knapsack(){
		list = new ArrayList<Tuple>();
		subSets = new ArrayList<ArrayList<Tuple>>();
	}
	
	/**
	 * Main function 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Knapsack knap = new Knapsack();
		knap.readingTheFile();
		knap.createPowerset();
		knap.printSubsets();
		knap.dunderhonung();
	}
	
	/**
	 * is reading the contents of a file
	 * @throws IOException
	 */
	public void readingTheFile() throws IOException{
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
				
				list.add(tuple);							
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
		int elements = list.size();
		long noSubSets = (long) Math.pow(2, elements); //saving 2^n elements in noSubSets
		
		for(long i = 0; i < noSubSets; i++){ 
			long elem = 1;
			ArrayList<Tuple> tempList = new ArrayList<Tuple>(); 
			
			for(int j = 0; j < elements; j++){ // as long as j is less than the number of tuples in the list
//				long b = i & elem;
//				System.out.println("elem = " + elem);
//				System.out.println("i = " + i);
//				System.out.println("i & elem " + b);
				if((i & elem) != 0){//Bit masking: performs logical "bitwise-and" operation 
					tempList.add(list.get(j));
					System.out.println("loop add " + list.get(j));
				}
				elem = elem << 1; //Bit shifting to the left by 1
			}
			subSets.add(tempList);
		}
	}
	
	public void printSubsets(){
		Iterator itr = subSets.iterator(); 
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
	
	public void dunderhonung(){
		for(int i = 0; i < subSets.size();i++){
			
			int sumSizes = 0;
			int sumValue = 0;
			
			for(int j = 0; j < subSets.get(i).size(); j++){
				Tuple tuple = subSets.get(i).get(j);
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
		
		if(subSets.get(bestSet).size() == 0){
			System.out.println("chosen , value = 0");
		}
		for(int k = 0; k < subSets.get(bestSet).size();k++){
			System.out.println(subSets.get(bestSet).get(k).getSize() + "/" + subSets.get(bestSet).get(k).getValue());
		}
		System.out.println("Best value " + bestValue);
	}
}
