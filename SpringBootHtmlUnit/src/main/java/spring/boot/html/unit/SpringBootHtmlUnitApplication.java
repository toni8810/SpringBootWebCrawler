package spring.boot.html.unit;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring.boot.html.unit.respository.MongoDBRepository;


@SpringBootApplication
public class SpringBootHtmlUnitApplication implements CommandLineRunner {
	
	@Autowired
	private MongoDBRepository mr;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootHtmlUnitApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		String url;
		ExecutorService es = Executors.newFixedThreadPool(5);
		for (char letter: alphabet) {
			url = "http://www.billboard.com/artists/"+letter;
			es.execute(new CrawlerThread(url,mr));
		}
		es.shutdown();
		while(!es.isTerminated()) {}
	}
}
