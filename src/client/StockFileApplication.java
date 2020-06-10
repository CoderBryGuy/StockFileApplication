package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {

    public static void main(String args[]) throws IOException {
        StockFileReader fr = new StockFileReader("table.csv");

        List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
        StockFileData fileData = new StockFileData();
        fileData.addData(dataResult);
        fileData.printData();
        System.out.println(dataResult.size());
    }

    /**
     * Complete the method body so that it returns the given structure needed to
     * populate the data field in the StockFileData class.
     *
     * @param headers
     * @param lines
     * @return List
     */
    public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines) {
        List<HashMap<String, Double>> dataResult = new ArrayList<>();
        String line;

        Iterator<String> iter = lines.iterator();

        while (iter.hasNext()) {
            line = iter.next();
            String[] dataCells = line.split(",");
            HashMap<String, Double> dataLine = new HashMap<>();

            for (int i = 0; i < dataCells.length; i++) {
                dataLine.put(headers.get(i), Double.parseDouble(dataCells[i]));
            }

            dataResult.add(dataLine);
        }

        return dataResult;
    }


}
