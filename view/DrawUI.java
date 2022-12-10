package view;


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

import dao.Dao;
import entity.detail;
import entity.user;

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

public class DrawUI extends AnchorPane {

	private String mainid;
	public String getMainid() {
		return mainid;
	}
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	Dao<user> userdao = new Dao(new user());
	Dao<detail> jydao = new Dao(new detail());
	public DrawUI(String param) {
		this.mainid=param;
		this.setStyle("-fx-background-size: 600 600;-fx-background-image: url('ATM.png');-fx-font-family: 'Arial';");
		Label withdrawLabel=new Label("withdraw amount");
		withdrawLabel.setFont(new Font("Times New Roman", 24));
		withdrawLabel.setPrefWidth(Double.valueOf(150));
		withdrawLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(withdrawLabel, Double.valueOf(135));
		this.setTopAnchor(withdrawLabel, Double.valueOf(462));
		this.getChildren().add(withdrawLabel);
		TextField txtField1 = new TextField();
		txtField1.setFont(new Font("Times New Roman", 14));
		txtField1.setPrefWidth(Double.valueOf(120));
		txtField1.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(txtField1, Double.valueOf(273));
		this.setTopAnchor(txtField1, Double.valueOf(456));
		this.getChildren().add(txtField1);
		PasswordField passwordField1=new PasswordField();
		passwordField1.setPromptText("");
		passwordField1.setFont(new Font("Times New Roman", 26));
		passwordField1.setPrefWidth(Double.valueOf(200));
		passwordField1.setPrefHeight(Double.valueOf(30));
		this.setLeftAnchor(passwordField1, Double.valueOf(236));
		this.setTopAnchor(passwordField1, Double.valueOf(124));
		this.getChildren().add(passwordField1);
		Label passwordLabel=new Label("password");
		passwordLabel.setFont(new Font("Times New Roman", 24));
		passwordLabel.setPrefWidth(Double.valueOf(150));
		passwordLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(passwordLabel, Double.valueOf(141));
		this.setTopAnchor(passwordLabel, Double.valueOf(128));
		this.getChildren().add(passwordLabel);
		Button button1=new Button("300");
		button1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				txtField1.setText("300");
			}
		});
		button1.setFont(new Font("Times New Roman", 24));
		button1.setPrefWidth(Double.valueOf(100));
		button1.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(button1, Double.valueOf(243));
		this.setTopAnchor(button1, Double.valueOf(309));
		this.getChildren().add(button1);
		Button button2=new Button("500");
		button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				txtField1.setText("500");
			}
		});
		button2.setFont(new Font("Times New Roman", 24));
		button2.setPrefWidth(Double.valueOf(100));
		button2.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(button2, Double.valueOf(408));
		this.setTopAnchor(button2, Double.valueOf(311));
		this.getChildren().add(button2);
		Button button3=new Button("5000");
		button3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				txtField1.setText("5000");
			}
		});
		button3.setFont(new Font("Times New Roman", 24));
		button3.setPrefWidth(Double.valueOf(100));
		button3.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(button3, Double.valueOf(408));
		this.setTopAnchor(button3, Double.valueOf(382));
		this.getChildren().add(button3);
		Button button4=new Button("100");
		button4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				txtField1.setText("100");
			}
		});
		button4.setFont(new Font("Times New Roman", 24));
		button4.setPrefWidth(Double.valueOf(100));
		button4.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(button4, Double.valueOf(88));
		this.setTopAnchor(button4, Double.valueOf(309));
		this.getChildren().add(button4);
		Button button5=new Button("2000");
		button5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				txtField1.setText("2000");
			}
		});
		button5.setFont(new Font("Times New Roman", 24));
		button5.setPrefWidth(Double.valueOf(100));
		button5.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(button5, Double.valueOf(243));
		this.setTopAnchor(button5, Double.valueOf(385));
		this.getChildren().add(button5);
		Button button6=new Button("1000");
		button6.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				txtField1.setText("1000");
			}
		});
		button6.setFont(new Font("Times New Roman", 24));
		button6.setPrefWidth(Double.valueOf(100));
		button6.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(button6, Double.valueOf(88));
		this.setTopAnchor(button6, Double.valueOf(386));
		this.getChildren().add(button6);
		Button button7=new Button("withdraw");
		button7.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				user user1 = userdao.queryByKey("username", param).get(0);
				if(txtField1.getText().equals("")){
					showMsg("enter withdraw amount");
					return;
				}
				if(user1.getCardpassword().equals(passwordField1.getText())){
					if(Integer.valueOf(user1.getBalance())<Integer.valueOf(txtField1.getText())){
						showMsg("Insufficient balance");
						return;
					}
					user1.setBalance(String.valueOf(Integer.valueOf(user1.getBalance())-Integer.valueOf(txtField1.getText())));
					userdao.update(user1);
					detail jy=new detail();
					jy.setDetails("withdraw amount: $"+txtField1.getText());
					jy.setAmount(txtField1.getText());
					jy.setNote("withdraw");
					jy.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					jy.setUser(param);
					jydao.add(jy);
					showMsg("success");
					((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
				}else{
					showMsg("password error");
				}
			}
		});
		button7.setFont(new Font("Times New Roman", 24));
		button7.setPrefWidth(Double.valueOf(100));
		button7.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(button7, Double.valueOf(408));
		this.setTopAnchor(button7, Double.valueOf(534));
		this.getChildren().add(button7);
		Button cid19aa0d73f5=new Button("cancel");
		cid19aa0d73f5.setFont(new Font("Times New Roman", 24));
		cid19aa0d73f5.setPrefWidth(Double.valueOf(100));
		cid19aa0d73f5.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(cid19aa0d73f5, Double.valueOf(255));
		this.setTopAnchor(cid19aa0d73f5, Double.valueOf(533));
		cid19aa0d73f5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    ((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
			}
		});
		this.getChildren().add(cid19aa0d73f5);
		
	}
 	public void showMsg(String msg){
   	 Alert alert = new Alert(AlertType.INFORMATION);
        alert.titleProperty().set("hint");
        alert.headerTextProperty().set(msg);
        alert.showAndWait();
   }
}
