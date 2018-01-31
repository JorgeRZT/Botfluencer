package com.jolopezp.botfluencer.core;

import java.util.ArrayList;
import java.util.List;

import com.jolopezp.botfluencer.models.InstaUser;
import com.jolopezp.botfluencer.service.IContentRepository;

public class ContentRepository implements IContentRepository{
	
	private List<InstaUser> instagramUsers;
	
	public ContentRepository() {
		instagramUsers = new ArrayList<>();
	}

	@Override
	public void addUser(InstaUser _username) {
		instagramUsers.add(_username);
	}

	@Override
	public void removeUser(String _usernameString) {
		for(InstaUser instagramUser : instagramUsers) {
			if(instagramUser.getUsername().equals(_usernameString)) {
				instagramUsers.remove(instagramUser);
				break;
			}
		}
	}

	@Override
	public int getContentSize() {
		return instagramUsers.size();
	}
	

}
