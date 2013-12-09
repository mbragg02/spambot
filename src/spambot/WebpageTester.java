package spambot;

public class WebpageTester {

	public static void main(String[] args) {
		
		WebpageLinks dataStore = new WebpageLinks();
		
		Webpage reader = new WebpageReader("http://www.oracle.com");
		
		dataStore.setUrls(reader.getLinks());
		
	}

}
