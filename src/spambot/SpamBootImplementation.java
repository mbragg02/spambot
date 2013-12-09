package spambot;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.Set;


public class SpamBootImplementation implements SpamBoot{

	@Override
	public void setSeed(String seedUrl) throws MalformedURLException {
			
		
	}

	@Override
	public String getSeed() {
		// call url from datastore
		return null;
	}

	@Override
	public void scanSite() {
		// call method readpage with 
		
	}

	@Override
	public Set<String> getEMails() {
		// call method getEmails
		return null;
	}

	
	public void launcher(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter the URL where to start the spamboot");
		String url = keyboard.next();
		try{
			this.setSeed(url);
		}catch(Exception ex){
				
			System.out.println("something got wrong in the launcher");
		}
		
	}
	
	public static void main(String[] args){
		// to know the number of processor
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		// Starting the spamboot
		SpamBootImplementation spamBoot = new SpamBootImplementation();
		spamBoot.launcher();
	}
	
}
