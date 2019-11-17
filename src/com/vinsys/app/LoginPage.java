package com.vinsys.app;


import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.DataGridView;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.PropertyPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class LoginPage extends BasePage {
	public LoginPage(){
		
		//Everyform would require a feed back panel
		FeedbackPanel feedback_panel = new FeedbackPanel("error_message");
		add(feedback_panel);
		
		//Create the object of the User
		User user = new User();
		ModalWindow helpwindow = new ModalWindow("help");
		helpwindow.setPageCreator(new ModalWindow.PageCreator() {
			
			@Override
			public Page createPage() {
				return new CopyrightPage();
			}
		});
		 
		 
		 helpwindow.setTitle(new Model("Help"));
		 //if affected rendered using ajax the below line is mandatory. 
		 helpwindow.setOutputMarkupId(true);
			
			AjaxLink helpLink = new AjaxLink("help_link"){
				@Override
				public void onClick(AjaxRequestTarget target) {
					//the window would open from here if user clicks on the help me link.
					helpwindow.show(target);
					
				}
			};
			 
		
		Form loginForm = new Form("loginForm");
		Label userName_label = new Label("username_label","User Name");
		Label password_label = new Label("password_label", "Password");
		
		TextField username_textfield = 
				new TextField("username_textfield", new PropertyModel(user, "username"));;
		username_textfield.setRequired(true);
		
		PasswordTextField password_textfield = 
				new PasswordTextField("password_textfield", new PropertyModel(user, "password"));
		password_textfield.setRequired(true);
		username_textfield.add(new UserNameValidator());
		Button loginButton = new Button("login_button"){
			
			public void onSubmit(){
				System.out.println("Handle all the lgin concern here and redirect to home page");
				getApplication().getSessionStore().setAttribute(getRequest(), "logged_in", "logged_in");
				System.out.println("User name :: "+user.getUsername());
				System.out.println("Password :; "+user.getPassword());
				setResponsePage(HomePage.class);;
			}
		};
		
		loginForm.add(userName_label);
		loginForm.add(password_label);
		loginForm.add(username_textfield);
		loginForm.add(password_textfield);
		loginForm.add(loginButton);
		add(helpwindow);
		add(helpLink);
		add(loginForm);
		
		
		//Pagination
		IColumn[] column2 = new IColumn[2];
		column2[0] = new PropertyColumn(new Model("Username"), "Username", "Username");
		column2[1] = new PropertyColumn(new Model("Password"), "Password", "Password");
		DefaultDataTable table = new DefaultDataTable("datatable", column2, new UserdataProvider(), 10);
		add(table);
		
		// whole data without pagination
		List<ICellPopulator<User>> columns = new ArrayList<>();
		columns.add(new PropertyPopulator<User>("username"));
		columns.add(new PropertyPopulator<User>("Password"));
		
		DataGridView view = new DataGridView<>("rows", columns, new UserdataProvider());
		
		add(view);
		
	}
}
