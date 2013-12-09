package spambot;

public class WebpageTester {

	public static void main(String[] args) {
		
		WebpageLinks dataStore = new WebpageLinks();
		
		Webpage reader = new WebpageReader("http://www.bbk.ac.uk/contact-us");
		
		dataStore.setUrls(reader.getLinks());
		dataStore.setEmails(reader.getEmails());
		
	}

}
