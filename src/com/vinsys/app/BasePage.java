package com.vinsys.app;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

public abstract class BasePage extends WebPage {
	
	 BasePage(){
	// all the component 
		 
	 
		Link moviesLink = new Link("movies"){
			
			public void onClick(){
				setResponsePage(MoviesPage.class);
			}
		};
		
		Link tvLink = new Link("television"){
			
			public void onClick(){
				setResponsePage(TeleVisionPage.class);
			}
		};
		
		Link eventLink = new Link("events"){
			public void onClick(){
				setResponsePage(EventPage.class);
			}
		};
		
		Link loginLink = new Link("login"){
			public void onClick(){
				setResponsePage(LoginPage.class);
			}
		};
		
		

		add(moviesLink);
		add(tvLink);
		add(eventLink);
		add(loginLink);
		
	}
	
	

}
