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

public class TransferUI extends AnchorPane {

	private String mainid;
	public String getMainid() {
		return mainid;
	}
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	Dao<user> userdao = new Dao(new user());
	Dao<detail> jydao = new Dao(new detail());
	public TransferUI(String param) {
		this.mainid=param;
		this.setStyle("-fx-background-size: 600 600;-fx-background-image: url('ATM.png');-fx-font-family: 'Arial';");
		Label transferAmounLabel=new Label("tranfer amount");
		transferAmounLabel.setFont(new Font("Times New Roman", 24));
		transferAmounLabel.setPrefWidth(Double.valueOf(150));
		transferAmounLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(transferAmounLabel, Double.valueOf(38));
		this.setTopAnchor(transferAmounLabel, Double.valueOf(455));
		this.getChildren().add(transferAmounLabel);
		TextField txtField1 = new TextField();
		txtField1.setFont(new Font("Times New Roman", 14));
		txtField1.setPrefWidth(Double.valueOf(120));
		txtField1.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(txtField1, Double.valueOf(148));
		this.setTopAnchor(txtField1, Double.valueOf(450));
		this.getChildren().add(txtField1);
		Label tranferToLabel=new Label("acount transfer to");
		tranferToLabel.setFont(new Font("Times New Roman", 24));
		tranferToLabel.setPrefWidth(Double.valueOf(150));
		tranferToLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(tranferToLabel, Double.valueOf(292));
		this.setTopAnchor(tranferToLabel, Double.valueOf(459));
		this.getChildren().add(tranferToLabel);
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
		TextField txtField2 = new TextField();
		txtField2.setFont(new Font("Times New Roman", 14));
		txtField2.setPrefWidth(Double.valueOf(170));
		txtField2.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(txtField2, Double.valueOf(407));
		this.setTopAnchor(txtField2, Double.valueOf(448));
		this.getChildren().add(txtField2);
		Button Button1=new Button("300");
		Button1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				txtField1.setText("300");
			}
		});
		Button1.setFont(new Font("Times New Roman", 24));
		Button1.setPrefWidth(Double.valueOf(100));
		Button1.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(Button1, Double.valueOf(243));
		this.setTopAnchor(Button1, Double.valueOf(309));
		this.getChildren().add(Button1);
		Button Button2=new Button("500");
		Button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				txtField1.setText("500");
			}
		});
		Button2.setFont(new Font("Times New Roman", 24));
		Button2.setPrefWidth(Double.valueOf(100));
		Button2.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(Button2, Double.valueOf(408));
		this.setTopAnchor(Button2, Double.valueOf(311));
		this.getChildren().add(Button2);
		Button Button3=new Button("5000");
		Button3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				txtField1.setText("5000");
			}
		});
		Button3.setFont(new Font("Times New Roman", 24));
		Button3.setPrefWidth(Double.valueOf(100));
		Button3.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(Button3, Double.valueOf(408));
		this.setTopAnchor(Button3, Double.valueOf(382));
		this.getChildren().add(Button3);
		Button Button4=new Button("100");
		Button4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				txtField1.setText("100");
			}
		});
		Button4.setFont(new Font("Times New Roman", 24));
		Button4.setPrefWidth(Double.valueOf(100));
		Button4.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(Button4, Double.valueOf(88));
		this.setTopAnchor(Button4, Double.valueOf(309));
		this.getChildren().add(Button4);
		Button Button5=new Button("2000");
		Button5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				txtField1.setText("2000");
			}
		});
		Button5.setFont(new Font("Times New Roman", 24));
		Button5.setPrefWidth(Double.valueOf(100));
		Button5.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(Button5, Double.valueOf(243));
		this.setTopAnchor(Button5, Double.valueOf(385));
		this.getChildren().add(Button5);
		Button Button6=new Button("1000");
		Button6.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				txtField1.setText("1000");
			}
		});
		Button6.setFont(new Font("Times New Roman", 24));
		Button6.setPrefWidth(Double.valueOf(100));
		Button6.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(Button6, Double.valueOf(88));
		this.setTopAnchor(Button6, Double.valueOf(386));
		this.getChildren().add(Button6);
		Button transferButton=new Button("transfer");
		transferButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				user user = userdao.queryByKey("username", param).get(0);
				if(txtField1.getText().equals("")){
					showMsg("enter transfer amount");
					return;
				}
				if(txtField2.getText().equals("")){
					showMsg("enter his/her card number");
					return;
				}
				List<user> zzlist=userdao.queryByKey("cardnumber", txtField2.getText());
				if(zzlist.size()==0){
					showMsg("can't find that account");
					return;
				}
				if(user.getCardpassword().equals(passwordField1.getText())){
					if(Integer.valueOf(user.getBalance())<Integer.valueOf(txtField1.getText())){
						showMsg("Insufficient balance");
						return;
					}
					user.setBalance(String.valueOf(Integer.valueOf(user.getBalance())-Integer.valueOf(txtField1.getText())));
					userdao.update(user);
					user zzuser=zzlist.get(0);
					zzuser.setBalance(String.valueOf(Integer.valueOf(zzuser.getBalance())+Integer.valueOf(txtField1.getText())));
					userdao.update(zzuser);
					detail jy=new detail();
					jy.setNote("transfer from" + user.getName()+"to"+zzuser.getName()+": $"+txtField1.getText());
					jy.setAmount(txtField1.getText());
					jy.setDetails("transfer");
					jy.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					jy.setUser(param);
					jydao.add(jy);
					jy.setUser(zzuser.getUsername());
					jydao.add(jy);
					showMsg("success");
					((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
				}else{
					showMsg("password error");
				}
			}
		});
		transferButton.setFont(new Font("Times New Roman", 24));
		transferButton.setPrefWidth(Double.valueOf(100));
		transferButton.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(transferButton, Double.valueOf(408));
		this.setTopAnchor(transferButton, Double.valueOf(534));
		this.getChildren().add(transferButton);
		Button cancelButton=new Button("cancel");
		cancelButton.setFont(new Font("Times New Roman", 24));
		cancelButton.setPrefWidth(Double.valueOf(100));
		cancelButton.setPrefHeight(Double.valueOf(35));
		this.setLeftAnchor(cancelButton, Double.valueOf(255));
		this.setTopAnchor(cancelButton, Double.valueOf(533));
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    ((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
			}
		});
		this.getChildren().add(cancelButton);
		
	}
 	public void showMsg(String msg){
   	 Alert alert = new Alert(AlertType.INFORMATION);
        alert.titleProperty().set("hint");
        alert.headerTextProperty().set(msg);
        alert.showAndWait();
   }
}
