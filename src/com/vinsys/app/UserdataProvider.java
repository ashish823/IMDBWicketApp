package com.vinsys.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class UserdataProvider extends SortableDataProvider<User> {
	List<User> userData = new ArrayList<>();
	public UserdataProvider(){
		
		for(int i =0; i < 100; i++){
			User user = new User();
			user.setUsername("user"+i);
			user.setPassword("pass"+i);
			userData.add(user);
		}
	}

	@Override
	public Iterator<? extends User> iterator(int first, int count) {
		List<User> newList = new ArrayList<User>(userData);
		return newList.subList(first, first + count).iterator();
	}

	@Override
	public int size() {
		return userData.size();
	}

	@Override
	public IModel<User> model(User object) {
		return new LoadableDetachableModel<User>() {
			@Override
			protected User load() {
				// TODO Auto-generated method stub
				return object;
			}
			
		};
	}
	
	
	
	
}
