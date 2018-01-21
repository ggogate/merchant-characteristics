package test;

import java.util.Map;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMetrics;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;

import demo.CSVReader;
import demo.vo.Merchant;

public class App {
	public static void main(String[] args) {
		Map<String, Merchant> data = CSVReader.read(null);
		data.values().stream().forEach(System.out::println);
		IgniteConfiguration cfg = new IgniteConfiguration();
		DataStorageConfiguration storageCfg = new DataStorageConfiguration();
		cfg.setDataStorageConfiguration(storageCfg);		
		Ignite ignite = Ignition.start(cfg);
		final String CACHE_NAME = "merchant-characteristics";
        try (IgniteCache<String, Merchant> cache = ignite.getOrCreateCache(CACHE_NAME)) {
        	for(Merchant merchant: data.values()){
        		cache.put(merchant.getMerchantId(), merchant);
        	}
        	CacheMetrics metrics = cache.metrics();
        	System.out.println("Total cache entries loaded: " + metrics.getSize());
        }
        finally {
            ignite.destroyCache(CACHE_NAME);
            //ignite.close(); // Do not close if you want cache to be kept on...
        }

	}
}
