package spambot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class WebpageReader implements Webpage {

	private Set<String> urls;
	private Set<String> emails;
	private String url;

	public WebpageReader(String url) {
		urls = new HashSet<String>();
		emails = new HashSet<String>();
		this.url = url;
		UrlReader(url);
	}


	@Override
	public String getUrl() {
		return this.url;
	}

	@Override
	public Set<String> getLinks() {
		return urls;
	}

	@Override
	public Set<String> getEmails() {
		return emails;
	}


	private void UrlReader(String url) {
		try {
			URL urlAddress = new URL(url);
			InputStream urlStream = urlAddress.openStream();
			InputStreamReader reader = new InputStreamReader(urlStream);
			BufferedReader in = new BufferedReader(reader);

			String inputLine;
			while ((inputLine = in.readLine()) != null)
				link(inputLine, url);
			

				
			in.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void link(String line, String hostUrl) {
		String inputLine = line;
//		System.out.println(line);
//		String line = 
		String aTag = "<a href=\"";
		String aTagend = "\"";

		if(inputLine.contains(aTag)) {
			int aTagIndex = inputLine.indexOf(aTag);
			int aTagIndexEnd = inputLine.indexOf(aTagend, aTagIndex + aTag.length() );

			String url = inputLine.substring(aTagIndex + aTag.length() , aTagIndexEnd );

			if(url.charAt(0) == '/') {
				url = hostUrl + url;
			}
			if (url.charAt(0) == 'h') {
//				System.out.println(url);
				urls.add(url);
			}

		}
		email(line);
	}
	
	
	private void email(String inputLine) {
		String line = inputLine;
		String at = "href=\"mailto:";
		String quote = "\"";
//		System.out.println(line);
		
		if(line.contains(at)) {
			int atIndex = line.indexOf(at);
			int endIndex = line.indexOf(quote, atIndex + at.length() );

			String mailAddress = line.substring(at.length() + atIndex, endIndex);

//			System.out.println(mailAddress);
			emails.add(mailAddress);
			
		} // end line if statement
//		
	}

}
