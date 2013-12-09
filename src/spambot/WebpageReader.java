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

	public WebpageReader(String url) {
		urls = new HashSet<String>();
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
		// TODO Auto-generated method stub
		return null;
	}


	private void UrlReader(String url) {
		try {
			URL urlAddress = new URL(url);
			InputStream urlStream = urlAddress.openStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlStream));

			String inputLine;
			while ((inputLine = in.readLine()) != null)
				webLink(inputLine, url);
			in.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void webLink(String line, String hostUrl) {
		
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

}
