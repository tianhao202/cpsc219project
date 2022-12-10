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

public class userManageUI extends AnchorPane {

	private String mainid;
	public String getMainid() {
		return mainid;
	}
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	Dao<user> user1 = new Dao(new user());
	ObservableList<user> userL = FXCollections.observableArrayList();
	public userManageUI(String param) {
		this.mainid=param;
		this.setStyle("-fx-background-size: 1200 730;-fx-background-image: url('bank.png');-fx-font-family: 'Arial';");
		Label cardpasswordLabel=new Label("cardpassword");
		cardpasswordLabel.setFont(new Font("Times New Roman", 14));
		cardpasswordLabel.setPrefWidth(Double.valueOf(100));
		cardpasswordLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(cardpasswordLabel, Double.valueOf(590));
		this.setTopAnchor(cardpasswordLabel, Double.valueOf(60));
		this.getChildren().add(cardpasswordLabel);
		TextField txtField1 = new TextField();
		txtField1.setFont(new Font("Times New Roman", 14));
		txtField1.setPrefWidth(Double.valueOf(93));
		txtField1.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField1, Double.valueOf(880));
		this.setTopAnchor(txtField1, Double.valueOf(30));
		this.getChildren().add(txtField1);
		Label passwordLabel=new Label("password");
		passwordLabel.setFont(new Font("Times New Roman", 14));
		passwordLabel.setPrefWidth(Double.valueOf(100));
		passwordLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(passwordLabel, Double.valueOf(370));
		this.setTopAnchor(passwordLabel, Double.valueOf(30));
		this.getChildren().add(passwordLabel);
		Label balanceLabel=new Label("balance");
		balanceLabel.setFont(new Font("Times New Roman", 14));
		balanceLabel.setPrefWidth(Double.valueOf(100));
		balanceLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(balanceLabel, Double.valueOf(810));
		this.setTopAnchor(balanceLabel, Double.valueOf(60));
		this.getChildren().add(balanceLabel);
		TextField txtField2 = new TextField();
		txtField2.setFont(new Font("Times New Roman", 14));
		txtField2.setPrefWidth(Double.valueOf(93));
		txtField2.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField2, Double.valueOf(880));
		this.setTopAnchor(txtField2, Double.valueOf(60));
		this.getChildren().add(txtField2);
		TextField txtField3 = new TextField();
		txtField3.setFont(new Font("Times New Roman", 14));
		txtField3.setPrefWidth(Double.valueOf(93));
		txtField3.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField3, Double.valueOf(220));
		this.setTopAnchor(txtField3, Double.valueOf(30));
		this.getChildren().add(txtField3);
		TextField txtField4 = new TextField();
		txtField4.setFont(new Font("Times New Roman", 14));
		txtField4.setPrefWidth(Double.valueOf(93));
		txtField4.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField4, Double.valueOf(660));
		this.setTopAnchor(txtField4, Double.valueOf(60));
		this.getChildren().add(txtField4);
		Label genderLabel=new Label("gender");
		genderLabel.setFont(new Font("Times New Roman", 14));
		genderLabel.setPrefWidth(Double.valueOf(100));
		genderLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(genderLabel, Double.valueOf(150));
		this.setTopAnchor(genderLabel, Double.valueOf(60));
		this.getChildren().add(genderLabel);
		ComboBox<String> comboBox1 = new ComboBox<>();
		comboBox1.setPrefWidth(Double.valueOf(93));
		comboBox1.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(comboBox1, Double.valueOf(220));
		this.setTopAnchor(comboBox1, Double.valueOf(60));
		comboBox1.getItems().add("");
		comboBox1.getItems().add("M");
		comboBox1.getItems().add("F");
		this.getChildren().add(comboBox1);
		Label nameLabel=new Label("name");
		nameLabel.setFont(new Font("Times New Roman", 14));
		nameLabel.setPrefWidth(Double.valueOf(100));
		nameLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(nameLabel, Double.valueOf(590));
		this.setTopAnchor(nameLabel, Double.valueOf(30));
		this.getChildren().add(nameLabel);
		Label usernameLabel=new Label("username");
		usernameLabel.setFont(new Font("Times New Roman", 14));
		usernameLabel.setPrefWidth(Double.valueOf(100));
		usernameLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(usernameLabel, Double.valueOf(150));
		this.setTopAnchor(usernameLabel, Double.valueOf(30));
		this.getChildren().add(usernameLabel);
		TextField txtField5 = new TextField();
		txtField5.setFont(new Font("Times New Roman", 14));
		txtField5.setPrefWidth(Double.valueOf(93));
		txtField5.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField5, Double.valueOf(660));
		this.setTopAnchor(txtField5, Double.valueOf(30));
		this.getChildren().add(txtField5);
		TextField txtField6 = new TextField();
		txtField6.setFont(new Font("Times New Roman", 14));
		txtField6.setPrefWidth(Double.valueOf(93));
		txtField6.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField6, Double.valueOf(440));
		this.setTopAnchor(txtField6, Double.valueOf(60));
		this.getChildren().add(txtField6);
		Label ageLabel=new Label("age");
		ageLabel.setFont(new Font("Times New Roman", 14));
		ageLabel.setPrefWidth(Double.valueOf(100));
		ageLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(ageLabel, Double.valueOf(810));
		this.setTopAnchor(ageLabel, Double.valueOf(30));
		this.getChildren().add(ageLabel);
		Label cardNumberLabel=new Label("cardnumber");
		cardNumberLabel.setFont(new Font("Times New Roman", 14));
		cardNumberLabel.setPrefWidth(Double.valueOf(100));
		cardNumberLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(cardNumberLabel, Double.valueOf(370));
		this.setTopAnchor(cardNumberLabel, Double.valueOf(60));
		this.getChildren().add(cardNumberLabel);
		TextField txtField7 = new TextField();
		txtField7.setFont(new Font("Times New Roman", 14));
		txtField7.setPrefWidth(Double.valueOf(93));
		txtField7.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField7, Double.valueOf(440));
		this.setTopAnchor(txtField7, Double.valueOf(30));
		this.getChildren().add(txtField7);
		 TableView tableView1=new TableView();
		tableView1.setPrefWidth(Double.valueOf(800));
		tableView1.setPrefHeight(Double.valueOf(400));
		tableView1.setMaxWidth(Double.valueOf(800));
		tableView1.setMaxHeight(Double.valueOf(400));
		tableView1.setMinWidth(Double.valueOf(800));
		tableView1.setMinHeight(Double.valueOf(400));
		this.setLeftAnchor(tableView1, Double.valueOf(190));
		this.setTopAnchor(tableView1, Double.valueOf(145));
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
		Button deleteButton=new Button("delete");
		deleteButton.setFont(new Font("Times New Roman", 14));
		deleteButton.setPrefWidth(Double.valueOf(93));
		deleteButton.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(deleteButton, Double.valueOf(400));
		this.setTopAnchor(deleteButton, Double.valueOf(100));
		deleteButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int row = tableView1.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					showMsg("choose a line");
					return;
				}
				user bean = (user)tableView1.getSelectionModel().getSelectedItems().get(0);
				user1.delBykey("id", bean.getId().toString());
				showMsg("success");
				userLRefresh();
				
			}
		});
		this.getChildren().add(deleteButton);
		Button resetButton=new Button("reset");
		resetButton.setFont(new Font("Times New Roman", 14));
		resetButton.setPrefWidth(Double.valueOf(93));
		resetButton.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(resetButton, Double.valueOf(600));
		this.setTopAnchor(resetButton, Double.valueOf(100));
		resetButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				txtField1.setText("");
				txtField2.setText("");
				txtField3.setText("");
				txtField4.setText("");
				comboBox1.setValue("");
				txtField5.setText("");
				txtField6.setText("");
				txtField7.setText("");
			}
		});
		this.getChildren().add(resetButton);
		Button addButton=new Button("add");
		addButton.setFont(new Font("Times New Roman", 14));
		addButton.setPrefWidth(Double.valueOf(93));
		addButton.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(addButton, Double.valueOf(200));
		this.setTopAnchor(addButton, Double.valueOf(100));
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("add");
			    stage.setScene(new Scene(new userAddUI(""),600,600));
			    stage.show();
			}
		});
		this.getChildren().add(addButton);
		Button editButton=new Button("edit");
		editButton.setFont(new Font("Times New Roman", 14));
		editButton.setPrefWidth(Double.valueOf(93));
		editButton.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(editButton, Double.valueOf(300));
		this.setTopAnchor(editButton, Double.valueOf(100));
		/**
			edit button mission
		*/
		editButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int row = tableView1.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					showMsg("choose a line");
					return;
				}
			    Stage stage=new Stage();
			    stage.setTitle("edit");
			    stage.setScene(new Scene(new userUpdateUI(String.valueOf(row)),600,600));
			    stage.show();
			}
		});
		this.getChildren().add(editButton);
		Button searchButton=new Button("search");
		searchButton.setFont(new Font("Times New Roman", 14));
		searchButton.setPrefWidth(Double.valueOf(93));
		searchButton.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(searchButton, Double.valueOf(500));
		this.setTopAnchor(searchButton, Double.valueOf(100));
		searchButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				user bean=new user();
				bean.setUsername(txtField3.getText());
				bean.setPassword(txtField7.getText());
				bean.setName(txtField5.getText());
				bean.setAge(txtField1.getText());
				bean.setGender(comboBox1.getSelectionModel().getSelectedItem());
				bean.setCardnumber(txtField6.getText());
				bean.setCardpassword(txtField4.getText());
				bean.setBalance(txtField2.getText());
				userL.clear();
				userL.addAll(user1.query(bean));
				
			}
		});
		this.getChildren().add(searchButton);
		tableView1.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = tableView1.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
		 			user bean = (user)tableView1.getSelectionModel().getSelectedItems().get(0);
				txtField3.setText(bean.getUsername());
				txtField7.setText(bean.getPassword());
				txtField5.setText(bean.getName());
				txtField1.setText(bean.getAge());
				comboBox1.setValue(bean.getGender());
				txtField6.setText(bean.getCardnumber());
				txtField4.setText(bean.getCardpassword());
				txtField2.setText(bean.getBalance());
				
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
