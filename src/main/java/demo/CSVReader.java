package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import demo.vo.Merchant;

public class CSVReader {

    public static Map<String, Merchant> read(String csvFile) {
    	if(csvFile == null){
    		csvFile = "src/main/resources/merchants.csv";	
    	}        
        String line = "";
        String cvsSplitBy = ",";
        String[] merchantLine;
        Map<String, Merchant> merchantCharacteristics = new HashMap<>();
        Merchant merchant;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
            	merchantLine = line.split(cvsSplitBy);
            	merchant = new Merchant();
            	merchant.setMerchantId(merchantLine[0]);
            	merchant.setCountryCode(merchantLine[1]);
            	merchant.setLegalName(merchantLine[2]);
            	merchant.setDiscountRate(merchantLine[3]);
            	merchantCharacteristics.put(merchant.getMerchantId(), merchant);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return merchantCharacteristics;
    }

}