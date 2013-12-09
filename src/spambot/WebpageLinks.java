package spambot;

import java.util.HashSet;
import java.util.Set;

public class WebpageLinks {
	
	private Set<String> urls;
	private Set<String> emails;
	
	public WebpageLinks() {
		urls = new HashSet<>();
		emails = new HashSet<>();
		
	}

	public Set<String> getUrls() {
		return urls;
	}

	public void setUrls(Set<String> urls) {
		this.urls.addAll(urls);
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails.addAll(emails);
	}



}
