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

	public WebpageReader(String url) {
		urls = new HashSet<String>();
		emails = new HashSet<String>();
		UrlReader(url);
		

	}


	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return null;
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
//				link(inputLine, url);
				email(inputLine);
			in.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void link(String line, String hostUrl) {		
//		System.out.println(line);
		String aTag = "<a href=\"";
		String aTagend = "\"";

		if(line.contains(aTag)) {
			int aTagIndex = line.indexOf(aTag);
			int aTagIndexEnd = line.indexOf(aTagend, aTagIndex + aTag.length() );

			String url = line.substring(aTagIndex + aTag.length() , aTagIndexEnd );

			if(url.charAt(0) == '/') {
				url = hostUrl + url;
			}
			if (url.charAt(0) == 'h') {
				System.out.println(url);
				urls.add(url);
			}

		}
	}
	
	
	private void email(String line) {
		System.out.println(line);
		String at = "@";
		String name = "";
		String domain = "";
		
		if(line.contains(at)) {
			int atIndex = line.indexOf(at);
//			name = line.index
			
			
		} // end line if statement
		
	}

}
