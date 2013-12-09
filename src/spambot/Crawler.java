package spambot;

import java.util.Iterator;
import java.util.Set;

public class Crawler implements Runnable  {
	
	
	public Crawler(String url, WebpageLinks dataStore) {
		
	}

	
	
	
	@Override
	public void run() {
		
		
		Webpage reader = new WebpageReader(url);
		// Add the URLs and email address to the data store 
		dataStore.setUrls(reader.getLinks());
		dataStore.setEmails(reader.getEmails());
		
		Set<String> s = dataStore.getUrls();
		Iterator<String> it = s.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
//			System.out.println(dataStore.getEmails().size());
//			scanSite(it.next());
		}

		
	}
	

} 


