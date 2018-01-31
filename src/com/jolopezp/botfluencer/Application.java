package com.jolopezp.botfluencer;

import java.util.List;

import com.jolopezp.botfluencer.models.InfluencerController;
import com.jolopezp.botfluencer.models.InstaUser;
import com.jolopezp.botfluencer.service.IInfluencerController;

public class Application {
	
	public static IInfluencerController influencerController;
	public static InstaUser instaUser;
	
	public static boolean unfollow;
	public static boolean privatedUsers;
	public static List<String> targets;
	
	public static void setApplication(boolean _unfollow,boolean _privatedUsers, List<String> _targets) {
		unfollow = _unfollow;
		privatedUsers = _privatedUsers;
		targets = _targets;
	}
	
	public Application() {
		influencerController = new InfluencerController();
	}
	
	public static boolean initApplication(String _username, String _password) {
		if(influencerController == null) {
			influencerController = new InfluencerController();
			influencerController.init();
		}
		influencerController.setUser(new InstaUser(_username, _password));
		return influencerController.login();
	}
	
	public static void initWorkflow() {
		influencerController.setTargets(targets);
		influencerController.setUnfollowConfiguration(unfollow);
		influencerController.setPrivatedUsersConfiguration(privatedUsers);
		influencerController.initWorkflow();
	}

}
