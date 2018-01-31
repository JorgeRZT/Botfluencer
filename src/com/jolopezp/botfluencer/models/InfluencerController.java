package com.jolopezp.botfluencer.models;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Soundbank;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.jolopezp.botfluencer.core.ContentRepository;
import com.jolopezp.botfluencer.service.IContentRepository;
import com.jolopezp.botfluencer.service.IInfluencerController;

public class InfluencerController implements IInfluencerController{
	
	private InstaUser user;
	private static final String DRIVER_PATH = "C:\\chromedriver.exe";
	
	//cssSelectors
	private static final String OPEN_FOLLOWERS = "#react-root > section > main > article > header > section > ul > li:nth-child(2) > a";
	private static final String FOLLOW = "button";
	private static final String GET_FOLLOWERS = "._2g7d5.notranslate._o5iw8";
	
	//JS commands
	private static final String SCROLL_DOWN = "document.getElementsByClassName('_gs38e')[0].scrollTop += 1000;";
	
	private List<String> targets ;
	private boolean unfollow;
	private boolean privateUsers;
	
	private List<InstaUser> instaUsers ;
	
	@Deprecated
	private IContentRepository contentRepository;
	
	private WebDriver driver;
	private JavascriptExecutor js;

	@Override
	public void init() {
		//Open Maximized
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		
		//Reference to driver
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		driver = new ChromeDriver(chromeOptions);
		
		//Create Javascript Executor
		js = (JavascriptExecutor) driver;
		
		//Create Content Repository
		contentRepository = new ContentRepository();
	}

	@Override
	public void initWorkflow() {	
		instaUsers = new ArrayList<>();
		
		for(String target : targets) {
			getFollowers(target);
			doJob();
		}
	}
	
	private void doJob() {
		for(InstaUser instaUser : instaUsers) {
			if(!instaUser.getFollowed()) {
				if(followUser(instaUser)) {
					instaUser.setFollowed(true);
					System.out.println(instaUser.getUsername()+ " seguido correctamente");
					waitSeconds(15);
				}
			}
		}
	}
	
	private void getFollowers(String _target) {
		openURL("https://www.instagram.com/" + _target+ "/");
		try {
			clickInput(OPEN_FOLLOWERS);
			for(int i = 0 ; i < 10; i++) {
				js.executeScript(SCROLL_DOWN);
				waitSeconds(2);
			}
			collectInstaUsers();
		}catch(Exception e) {
			System.out.println("Error al obtener usuarios de "+_target);
		}
	}
	
	private void collectInstaUsers() {
		List<WebElement> instaUsersFound = driver.findElements(By.cssSelector(GET_FOLLOWERS));
		for(WebElement instaUserFound : instaUsersFound) {
			InstaUser user = new InstaUser(instaUserFound.getAttribute("title"));
			instaUsers.add(user);
		}
		System.out.println("Añadidos "+instaUsersFound.size()+" a la lista de usuarios");
	}
	
	
	@Override
	public boolean login() {
		openURL("https://www.instagram.com/");
		clickInput("._g9ean > a");
		writeInput(user.getUsername(),"input[name=username]");
		writeInput(user.getPassword(),"input[name=password]");
		clickInput("button");
		
		try {
			driver.findElement(By.cssSelector(".coreSpriteDesktopNavProfile")).click();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		openURL("https://www.instagram.com/");
		return true;
	}

	@Override
	public void logout() {
		//No implementado aun
	}

	@Override
	public boolean followUser(InstaUser _username) {
		try {
			openURL("https://www.instagram.com/" + _username.getUsername()+ "/");
			WebElement followButton = getElement(FOLLOW);
			if(followButton.getText().equals("Seguir")) {
				clickInput(FOLLOW);
				if(!privateUsers && followButton.getText().equals("Solicitado")){
					clickInput(FOLLOW);
				}
			}
			return true;
		}catch(Exception e) {
			System.out.println("Error al seguir al usuario: "+_username.getUsername());
		}
		return false;
	}

	@Override
	public boolean unfollowUser(InstaUser username) {
		try {
			//No implementado aun
			return true;
		}catch(Exception e) {
			
		}
		return false;
	}

	@Override
	public void saveUserInRepository(InstaUser _username) {
		contentRepository.addUser(_username);
	}

	@Override
	public void removeUserFromRepository(String _usernameString) {
		contentRepository.removeUser(_usernameString);
	}

	@Override
	public void waitSeconds(int _seconds) {
		try {
			Thread.sleep(_seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void openURL(String _url) {
		driver.get(_url);
		waitSeconds(5);
	}

	@Override
	public void writeInput(String _keys, String _cssSelector) {
		driver.findElement(By.cssSelector(_cssSelector)).sendKeys(_keys);
		waitSeconds(1);
	}

	@Override
	public void clickInput(String _cssSelector) {
		driver.findElement(By.cssSelector(_cssSelector)).click();
		waitSeconds(3);		
	}

	@Override
	public void setUser(InstaUser _user) {
		user = _user;
	}

	@Override
	public InstaUser getUser() {
		return user;
	}

	@Override
	public void setTargets(List<String> _targets) {
		targets = _targets;
		System.out.println("Establecidos los usuarios principales");
		for(String target : _targets) {
			System.out.println("=> {"+target+"}");
		}
	}

	@Override
	public void setUnfollowConfiguration(boolean _unfollow) {
		unfollow = _unfollow;
		System.out.println("Establecida la configuración de unfollows {"+_unfollow+"}");
	}

	@Override
	public WebElement getElement(String _cssSelector) {
		return driver.findElement(By.cssSelector(_cssSelector));
	}

	@Override
	public void setPrivatedUsersConfiguration(boolean _privateUsers) {
		privateUsers = _privateUsers;
		System.out.println("Establecida la configuración para cuentas privadas {"+_privateUsers+"}");
	}
	
}
