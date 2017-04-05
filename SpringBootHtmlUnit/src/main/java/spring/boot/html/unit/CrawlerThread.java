package spring.boot.html.unit;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import spring.boot.html.unit.domain.Band;
import spring.boot.html.unit.respository.MongoDBRepository;

public class CrawlerThread extends Thread {
	private String url;
	private MongoDBRepository mr;
	
	public CrawlerThread(String url,MongoDBRepository mr ) {
		this.url = url;
		this.mr = mr;
	}
	
	@Override
	public void run() {
		System.out.println(url + " is starting");
		
		//initializing HtmlUnitDriver and disable javascript to make it faster
		HtmlUnitDriver driver = new HtmlUnitDriver(false);
		
		//Creating LinkedHashSet as it does not allow duplicate information
		Set<Band> bands = new LinkedHashSet<>();
		
		driver.get(url);
		
		//Getting all the elements with class field-content
		List<WebElement> bandElements = driver.findElements(By.className("field-content"));
		bandElements.forEach(be -> bands.add(new Band(be.getText())));
		mr.save(bands);
		driver.close();
		System.out.println(url + " has finished");
		
	}
}
