package spambot;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;



public class SpamBootImplementation implements SpamBoot{
	
	private String seedURL;
	private Set<String> emails;
	private WebpageLinks dataStore;
	private Executor executor;
	
	public SpamBootImplementation() {
		this.emails = new HashSet<>();
		dataStore = new WebpageLinks();
		executor = Executors.newSingleThreadExecutor();
	}
	
	
	@Override
	public void setSeed(String seedUrl) throws MalformedURLException {
		this.seedURL = seedUrl;
	}

	@Override
	public String getSeed() {
		return seedURL;
	}

	@Override
	public void scanSite() {
		Runnable worker = new Crawler(this.seedURL, dataStore );
		executor.execute(worker);
	}

	@Override
	public Set<String> getEMails() {
		return this.emails;
	}
	



	public void launcher(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter the URL where to start the spamboot");
		String url = keyboard.next();
		try{
			setSeed(url);
		}catch(Exception ex){

			System.out.println("something got wrong in the launcher");
		}

	}

	public static void main(String[] args){
		// to know the number of processor
//		System.out.println(Runtime.getRuntime().availableProcessors());

		// Starting the spamboot
		SpamBootImplementation spamBoot = new SpamBootImplementation();
		
		//		spamBoot.launcher();
		
		spamBoot.scanSite();
	}

}
