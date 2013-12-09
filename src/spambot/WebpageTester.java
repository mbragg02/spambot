package spambot;

import java.util.Iterator;
import java.util.Set;

public class WebpageTester {

	public static void main(String[] args) {
		
		// Create new data store
		WebpageLinks dataStore = new WebpageLinks();
		
		
		// Create new web page reader 
		Webpage reader = new WebpageReader("http://www.bbk.ac.uk/contact-us");
		
		// Add the URLs and email address to the data store 
		dataStore.setUrls(reader.getLinks());
		dataStore.setEmails(reader.getEmails());
		
		
		// Print out from the data store.
		Set<String> s = dataStore.getUrls();
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
