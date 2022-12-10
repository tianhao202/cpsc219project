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

public class userAddUI extends AnchorPane {

	private String mainid;
	public String getMainid() {
		return mainid;
	}
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	Dao<user> user1 = new Dao(new user());
	ObservableList<user> userL = FXCollections.observableArrayList();
	public userAddUI(String param) {
		this.mainid=param;
		this.setStyle("-fx-background-size: 600 600;-fx-background-image: url('bank.png');-fx-font-family: 'Arial';");
		TextField txtField1 = new TextField();
		txtField1.setFont(new Font("Times New Roman", 14));
		txtField1.setPrefWidth(Double.valueOf(93));
		txtField1.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField1, Double.valueOf(220));
		this.setTopAnchor(txtField1, Double.valueOf(60));
		this.getChildren().add(txtField1);
		Label genderLabel=new Label("gender");
		genderLabel.setFont(new Font("Times New Roman", 14));
		genderLabel.setPrefWidth(Double.valueOf(100));
		genderLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(genderLabel, Double.valueOf(150));
		this.setTopAnchor(genderLabel, Double.valueOf(180));
		this.getChildren().add(genderLabel);
		ComboBox<String> comboBox1 = new ComboBox<>();
		comboBox1.setPrefWidth(Double.valueOf(93));
		comboBox1.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(comboBox1, Double.valueOf(220));
		this.setTopAnchor(comboBox1, Double.valueOf(180));
		comboBox1.getItems().add("");
		comboBox1.getItems().add("M");
		comboBox1.getItems().add("F");
		this.getChildren().add(comboBox1);
		TextField txtField2 = new TextField();
		txtField2.setFont(new Font("Times New Roman", 14));
		txtField2.setPrefWidth(Double.valueOf(93));
		txtField2.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField2, Double.valueOf(440));
		this.setTopAnchor(txtField2, Double.valueOf(60));
		this.getChildren().add(txtField2);
		Label cardPasswordLabel=new Label("cardPassword");
		cardPasswordLabel.setFont(new Font("Times New Roman", 14));
		cardPasswordLabel.setPrefWidth(Double.valueOf(100));
		cardPasswordLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(cardPasswordLabel, Double.valueOf(150));
		this.setTopAnchor(cardPasswordLabel, Double.valueOf(240));
		this.getChildren().add(cardPasswordLabel);
		Label usernameLabel=new Label("username");
		usernameLabel.setFont(new Font("Times New Roman", 14));
		usernameLabel.setPrefWidth(Double.valueOf(100));
		usernameLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(usernameLabel, Double.valueOf(150));
		this.setTopAnchor(usernameLabel, Double.valueOf(60));
		this.getChildren().add(usernameLabel);
		Label cardNumberLabel=new Label("cardNumber");
		cardNumberLabel.setFont(new Font("Times New Roman", 14));
		cardNumberLabel.setPrefWidth(Double.valueOf(100));
		cardNumberLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(cardNumberLabel, Double.valueOf(370));
		this.setTopAnchor(cardNumberLabel, Double.valueOf(180));
		this.getChildren().add(cardNumberLabel);
		Label nameLabel=new Label("name");
		nameLabel.setFont(new Font("Times New Roman", 14));
		nameLabel.setPrefWidth(Double.valueOf(100));
		nameLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(nameLabel, Double.valueOf(150));
		this.setTopAnchor(nameLabel, Double.valueOf(120));
		this.getChildren().add(nameLabel);
		TextField txtField3 = new TextField();
		txtField3.setFont(new Font("Times New Roman", 14));
		txtField3.setPrefWidth(Double.valueOf(93));
		txtField3.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField3, Double.valueOf(440));
		this.setTopAnchor(txtField3, Double.valueOf(120));
		this.getChildren().add(txtField3);
		TextField txtField4 = new TextField();
		txtField4.setFont(new Font("Times New Roman", 14));
		txtField4.setPrefWidth(Double.valueOf(93));
		txtField4.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField4, Double.valueOf(220));
		this.setTopAnchor(txtField4, Double.valueOf(120));
		this.getChildren().add(txtField4);
		TextField txtField5 = new TextField();
		txtField5.setFont(new Font("Times New Roman", 14));
		txtField5.setPrefWidth(Double.valueOf(93));
		txtField5.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField5, Double.valueOf(220));
		this.setTopAnchor(txtField5, Double.valueOf(240));
		this.getChildren().add(txtField5);
		Label balanceLabel=new Label("balance");
		balanceLabel.setFont(new Font("Times New Roman", 14));
		balanceLabel.setPrefWidth(Double.valueOf(100));
		balanceLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(balanceLabel, Double.valueOf(370));
		this.setTopAnchor(balanceLabel, Double.valueOf(240));
		this.getChildren().add(balanceLabel);
		Label ageLabel=new Label("age");
		ageLabel.setFont(new Font("Times New Roman", 14));
		ageLabel.setPrefWidth(Double.valueOf(100));
		ageLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(ageLabel, Double.valueOf(370));
		this.setTopAnchor(ageLabel, Double.valueOf(120));
		this.getChildren().add(ageLabel);
		TextField txtField6 = new TextField();
		txtField6.setFont(new Font("Times New Roman", 14));
		txtField6.setPrefWidth(Double.valueOf(93));
		txtField6.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField6, Double.valueOf(440));
		this.setTopAnchor(txtField6, Double.valueOf(180));
		this.getChildren().add(txtField6);
		Label passwordLabel=new Label("password");
		passwordLabel.setFont(new Font("Times New Roman", 14));
		passwordLabel.setPrefWidth(Double.valueOf(100));
		passwordLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(passwordLabel, Double.valueOf(370));
		this.setTopAnchor(passwordLabel, Double.valueOf(60));
		this.getChildren().add(passwordLabel);
		TextField txtField7 = new TextField();
		txtField7.setFont(new Font("Times New Roman", 14));
		txtField7.setPrefWidth(Double.valueOf(93));
		txtField7.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField7, Double.valueOf(440));
		this.setTopAnchor(txtField7, Double.valueOf(240));
		this.getChildren().add(txtField7);
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
		Button saveButton=new Button("save");
		saveButton.setFont(new Font("Times New Roman", 14));
		saveButton.setPrefWidth(Double.valueOf(93));
		saveButton.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(saveButton, Double.valueOf(200));
		this.setTopAnchor(saveButton, Double.valueOf(350));
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				user bean=new user();
				bean.setUsername(txtField1.getText());
				if(user1.query(bean).size()>0){
					showMsg("user exist");
					return;
				}
				
				bean.setPassword(txtField2.getText());
				bean.setName(txtField4.getText());
				bean.setAge(txtField3.getText());
				bean.setGender(comboBox1.getSelectionModel().getSelectedItem());
				bean.setCardnumber(txtField6.getText());
				bean.setCardpassword(txtField5.getText());
				bean.setBalance(txtField7.getText());
				user1.add(bean);
				showMsg("success");
				userLRefresh();
				
			}
		});
		this.getChildren().add(saveButton);
		Button closeButton=new Button("close");
		closeButton.setFont(new Font("Times New Roman", 14));
		closeButton.setPrefWidth(Double.valueOf(93));
		closeButton.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(closeButton, Double.valueOf(300));
		this.setTopAnchor(closeButton, Double.valueOf(350));
		closeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    ((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
			}
		});
		this.getChildren().add(closeButton);
		tableView1.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = tableView1.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
		 			user bean = (user)tableView1.getSelectionModel().getSelectedItems().get(0);
				txtField1.setText(bean.getUsername());
				txtField2.setText(bean.getPassword());
				txtField4.setText(bean.getName());
				txtField3.setText(bean.getAge());
				comboBox1.setValue(bean.getGender());
				txtField6.setText(bean.getCardnumber());
				txtField5.setText(bean.getCardpassword());
				txtField7.setText(bean.getBalance());
				
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
