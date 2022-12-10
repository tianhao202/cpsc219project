package view;


import dao.*;
import entity.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import java.util.List;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Alert.AlertType;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.event.EventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class userLoginUI extends AnchorPane {

	public static String username;
	public static String role;
	private String mainid;
	public String getMainid() {
		return mainid;
	}
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	Dao<user> user1 = new Dao(new user());
	ObservableList<user> userL = FXCollections.observableArrayList();
	public userLoginUI(String param) {
		this.mainid=param;
		this.setStyle("-fx-background-size: 600 600;-fx-background-image: url('bank.png');-fx-font-family: 'Arial';");
		PasswordField passwordField1=new PasswordField();
		passwordField1.setPromptText("");
		passwordField1.setFont(new Font("Times New Roman", 14));
		passwordField1.setPrefWidth(Double.valueOf(227));
		passwordField1.setPrefHeight(Double.valueOf(38));
		this.setLeftAnchor(passwordField1, Double.valueOf(224));
		this.setTopAnchor(passwordField1, Double.valueOf(210));
		this.getChildren().add(passwordField1);
		Label usernameLabel=new Label("username");
		usernameLabel.setFont(new Font("Times New Roman", 20));
		usernameLabel.setPrefWidth(Double.valueOf(110));
		usernameLabel.setPrefHeight(Double.valueOf(32));
		this.setLeftAnchor(usernameLabel, Double.valueOf(104));
		this.setTopAnchor(usernameLabel, Double.valueOf(125));
		this.getChildren().add(usernameLabel);
		Label atmLabel=new Label("ATM machine");
		atmLabel.setFont(new Font("Times New Roman", 25));
		atmLabel.setPrefWidth(Double.valueOf(410));
		atmLabel.setPrefHeight(Double.valueOf(62));
		this.setLeftAnchor(atmLabel, Double.valueOf(184));
		this.setTopAnchor(atmLabel, Double.valueOf(25));
		this.getChildren().add(atmLabel);
		Label passwordLabel=new Label("password");
		passwordLabel.setFont(new Font("Times New Roman", 20));
		passwordLabel.setPrefWidth(Double.valueOf(110));
		passwordLabel.setPrefHeight(Double.valueOf(32));
		this.setLeftAnchor(passwordLabel, Double.valueOf(104));
		this.setTopAnchor(passwordLabel, Double.valueOf(210));
		this.getChildren().add(passwordLabel);
		TextField txtField1 = new TextField();
		txtField1.setFont(new Font("Times New Roman", 14));
		txtField1.setPrefWidth(Double.valueOf(227));
		txtField1.setPrefHeight(Double.valueOf(38));
		this.setLeftAnchor(txtField1, Double.valueOf(224));
		this.setTopAnchor(txtField1, Double.valueOf(119));
		this.getChildren().add(txtField1);
		 TableView tableView1=new TableView();
		tableView1.setPrefWidth(Double.valueOf(0));
		tableView1.setPrefHeight(Double.valueOf(0));
		tableView1.setMaxWidth(Double.valueOf(0));
		tableView1.setMaxHeight(Double.valueOf(0));
		tableView1.setMinWidth(Double.valueOf(0));
		tableView1.setMinHeight(Double.valueOf(0));
		this.setLeftAnchor(tableView1, Double.valueOf(0));
		this.setTopAnchor(tableView1, Double.valueOf(0));
		 TableColumn tableColumn1=new TableColumn("id");
		 tableColumn1.setCellValueFactory(new PropertyValueFactory<>("id"));
		 tableView1.getColumns().add(tableColumn1);
		 TableColumn tableColumn2=new TableColumn("username");
		 tableColumn2.setCellValueFactory(new PropertyValueFactory<>("username"));
		 tableView1.getColumns().add(tableColumn2);
		 TableColumn tableColumn3=new TableColumn("password");
		 tableColumn3.setCellValueFactory(new PropertyValueFactory<>("password"));
		 tableView1.getColumns().add(tableColumn3);
		 TableColumn tableColumn4=new TableColumn("name");
		 tableColumn4.setCellValueFactory(new PropertyValueFactory<>("name"));
		 tableView1.getColumns().add(tableColumn4);
		 TableColumn tableColumn5=new TableColumn("age");
		 tableColumn5.setCellValueFactory(new PropertyValueFactory<>("age"));
		 tableView1.getColumns().add(tableColumn5);
		 TableColumn tableColumn6=new TableColumn("gender");
		 tableColumn6.setCellValueFactory(new PropertyValueFactory<>("gender"));
		 tableView1.getColumns().add(tableColumn6);
		 TableColumn tableColumn7=new TableColumn("cardnumber");
		 tableColumn7.setCellValueFactory(new PropertyValueFactory<>("cardnumber"));
		 tableView1.getColumns().add(tableColumn7);
		 TableColumn tableColumn8=new TableColumn("cardpassword");
		 tableColumn8.setCellValueFactory(new PropertyValueFactory<>("cardpassword"));
		 tableView1.getColumns().add(tableColumn8);
		 TableColumn tableColumn9=new TableColumn("balance");
		 tableColumn9.setCellValueFactory(new PropertyValueFactory<>("balance"));
		 tableView1.getColumns().add(tableColumn9);
		tableView1.setItems(userL);
		this.getChildren().add(tableView1);
		userLRefresh();
		Button loginButton=new Button("login");
		loginButton.setFont(new Font("Times New Roman", 20));
		loginButton.setPrefWidth(Double.valueOf(105));
		loginButton.setPrefHeight(Double.valueOf(38));
		this.setLeftAnchor(loginButton, Double.valueOf(341));
		this.setTopAnchor(loginButton, Double.valueOf(306));
		/**
			login button mission
		*/
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				List<user> list = user1.queryByKey("username", txtField1.getText());
				if(list.size()>0){
					if(list.get(0).getPassword().equals(passwordField1.getText())){
						username=list.get(0).getUsername();
						showMsg("success");
			    		Stage stage=new Stage();
			    		stage.setTitle("Function");
			    		userMainUI mainui = new userMainUI("");
						mainui.setUsername(username);
			    		stage.setScene(new Scene(mainui,600,600));
			    		stage.show();
			    		((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
						return;
					}
				}

							showMsg("username or password error");
			}
		});
		this.getChildren().add(loginButton);
		tableView1.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = tableView1.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
		 			user bean = (user)tableView1.getSelectionModel().getSelectedItems().get(0);
				txtField1.setText(bean.getUsername());
				passwordField1.setText(bean.getPassword());
				
			};
		});
		userLRefresh();
		
	}
	public void userLRefresh(){
		userL.clear();
    	userL.addAll(user1.getAll());
	}
 	public void showMsg(String msg){
   	 Alert alert = new Alert(AlertType.INFORMATION);
        alert.titleProperty().set("hint");
        alert.headerTextProperty().set(msg);
        alert.showAndWait();
   }
}
