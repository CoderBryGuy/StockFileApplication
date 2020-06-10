package fileprocessors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StockFileReader {
	
	String filePath = null;
	
	public StockFileReader(String filePath){
		this.filePath = filePath;
	}
	
	public List<String> getHeaders() throws IOException{
		String line = readFirstLine(filePath);
		String [] header = line.split(",");
		List<String> values = new ArrayList<String>();
		values = Arrays.asList(header);
		return values;
	}
	
	static String readFirstLine(String path) throws IOException {
	    try (BufferedReader br =
	                   new BufferedReader(new FileReader(path))) {
	        return br.readLine();
	    }




	}
	/**
	 * Complete the body of this method.
	 * @return List
	 * @throws IOException
	 */
	public List<String> readFileData() throws IOException{
		List<String> lines = new ArrayList<String>();
		String line;

		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

			br.readLine(); //read past first line

			while(((line = br.readLine()) != null)) {
				lines.add(line);
			}

//testing list
//			Iterator<String> iter = lines.iterator();
//
//			while(iter.hasNext()){
//				System.out.println(iter.next());
//			}

		}catch (IOException e){
			e.printStackTrace();
		}

	    return lines;
	}
	

}
