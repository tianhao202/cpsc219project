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

public class BalanceUI extends AnchorPane {

	private String mainid;
	public String getMainid() {
		return mainid;
	}
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	Dao<user> user1 = new Dao(new user());
	ObservableList<user> userList = FXCollections.observableArrayList();
	public BalanceUI(String param) {
		this.mainid=param;
		this.setStyle("-fx-background-size: 500 400;-fx-background-image: url('bank.png');-fx-font-family: 'Arial';");
		Label balanceLable=new Label("balance");
		balanceLable.setFont(new Font("Times New Roman", 26));
		balanceLable.setPrefWidth(Double.valueOf(100));
		balanceLable.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(balanceLable, Double.valueOf(111));
		this.setTopAnchor(balanceLable, Double.valueOf(186));
		this.getChildren().add(balanceLable);
		TextField txtField1 = new TextField();
		txtField1.setFont(new Font("Times New Roman", 14));
		txtField1.setPrefWidth(Double.valueOf(200));
		txtField1.setPrefHeight(Double.valueOf(30));
		this.setLeftAnchor(txtField1, Double.valueOf(217));
		this.setTopAnchor(txtField1, Double.valueOf(106));
		this.getChildren().add(txtField1);
		TextField txtField2 = new TextField();
		txtField2.setFont(new Font("Times New Roman", 14));
		txtField2.setPrefWidth(Double.valueOf(200));
		txtField2.setPrefHeight(Double.valueOf(30));
		this.setLeftAnchor(txtField2, Double.valueOf(216));
		this.setTopAnchor(txtField2, Double.valueOf(180));
		this.getChildren().add(txtField2);
		Label cardNumLable=new Label("card number");
		cardNumLable.setFont(new Font("Times New Roman", 26));
		cardNumLable.setPrefWidth(Double.valueOf(140));
		cardNumLable.setPrefHeight(Double.valueOf(30));
		this.setLeftAnchor(cardNumLable, Double.valueOf(85));
		this.setTopAnchor(cardNumLable, Double.valueOf(105));
		this.getChildren().add(cardNumLable);
		 TableView tabView1=new TableView();
		tabView1.setPrefWidth(Double.valueOf(0));
		tabView1.setPrefHeight(Double.valueOf(0));
		tabView1.setMaxWidth(Double.valueOf(0));
		tabView1.setMaxHeight(Double.valueOf(0));
		tabView1.setMinWidth(Double.valueOf(0));
		tabView1.setMinHeight(Double.valueOf(0));
		this.setLeftAnchor(tabView1, Double.valueOf(0));
		this.setTopAnchor(tabView1, Double.valueOf(0));
		 TableColumn tabCol1=new TableColumn("id");
		 tabCol1.setCellValueFactory(new PropertyValueFactory<>("id"));
		 tabView1.getColumns().add(tabCol1);
		 TableColumn tabCol2=new TableColumn("username");
		 tabCol2.setCellValueFactory(new PropertyValueFactory<>("username"));
		 tabView1.getColumns().add(tabCol2);
		 TableColumn tabCol3=new TableColumn("password");
		 tabCol3.setCellValueFactory(new PropertyValueFactory<>("password"));
		 tabView1.getColumns().add(tabCol3);
		 TableColumn tabCol4=new TableColumn("name");
		 tabCol4.setCellValueFactory(new PropertyValueFactory<>("name"));
		 tabView1.getColumns().add(tabCol4);
		 TableColumn cid0595d668b23=new TableColumn("age");
		 cid0595d668b23.setCellValueFactory(new PropertyValueFactory<>("age"));
		 tabView1.getColumns().add(cid0595d668b23);
		 TableColumn tabCol5=new TableColumn("gender");
		 tabCol5.setCellValueFactory(new PropertyValueFactory<>("gender"));
		 tabView1.getColumns().add(tabCol5);
		 TableColumn tabCol6=new TableColumn("cardnumber");
		 tabCol6.setCellValueFactory(new PropertyValueFactory<>("cardnumber"));
		 tabView1.getColumns().add(tabCol6);
		 TableColumn tabCol7=new TableColumn("cardpassword");
		 tabCol7.setCellValueFactory(new PropertyValueFactory<>("cardpassword"));
		 tabView1.getColumns().add(tabCol7);
		 TableColumn tabCol8=new TableColumn("balance");
		 tabCol8.setCellValueFactory(new PropertyValueFactory<>("balance"));
		 tabView1.getColumns().add(tabCol8);
		tabView1.setItems(userList);
		this.getChildren().add(tabView1);
		userListRefresh();
		Button closeButton=new Button("close");
		closeButton.setFont(new Font("Times New Roman", 14));
		closeButton.setPrefWidth(Double.valueOf(100));
		closeButton.setPrefHeight(Double.valueOf(30));
		this.setLeftAnchor(closeButton, Double.valueOf(313));
		this.setTopAnchor(closeButton, Double.valueOf(272));
		closeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    ((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
			}
		});
		this.getChildren().add(closeButton);
		tabView1.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = tabView1.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
		 			user bean = (user)tabView1.getSelectionModel().getSelectedItems().get(0);
				txtField1.setText(bean.getCardnumber());
				txtField2.setText(bean.getBalance());
				
			};
		});
		userListRefresh();
		 		user user2 = user1.queryByKey("username", mainid).get(0);
		txtField1.setText(user2.getCardnumber());
		txtField2.setText(user2.getBalance());
		
	}
	public void userListRefresh(){
		userList.clear();
    	userList.addAll(user1.getAll());
	}
 	public void showMsg(String msg){
   	 Alert alert = new Alert(AlertType.INFORMATION);
        alert.titleProperty().set("hint");
        alert.headerTextProperty().set(msg);
        alert.showAndWait();
   }
}
