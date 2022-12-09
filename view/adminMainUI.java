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

public class adminMainUI extends AnchorPane {

	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String mainid;
	public String getMainid() {
		return mainid;
	}
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	public adminMainUI(String param) {
		this.mainid=param;
		this.setStyle("-fx-background-size: 600 600;-fx-background-image: url('bank.png');-fx-font-family: 'Arial';");
		Button adminMButton=new Button("admin manage");
		adminMButton.setFont(new Font("Times New Roman", 20));
		adminMButton.setPrefWidth(Double.valueOf(180));
		adminMButton.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(adminMButton, Double.valueOf(200));
		this.setTopAnchor(adminMButton, Double.valueOf(10));
		adminMButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("admin manage");
			    stage.setScene(new Scene(new adminManageUI(""),1200,730));
			    stage.show();
			}
		});
		this.getChildren().add(adminMButton);
		Button exitButton=new Button("exit");
		exitButton.setFont(new Font("Times New Roman", 20));
		exitButton.setPrefWidth(Double.valueOf(180));
		exitButton.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(exitButton, Double.valueOf(200));
		this.setTopAnchor(exitButton, Double.valueOf(160));
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});
		this.getChildren().add(exitButton);
		Button userMButton=new Button("user manage");
		userMButton.setFont(new Font("Times New Roman", 20));
		userMButton.setPrefWidth(Double.valueOf(180));
		userMButton.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(userMButton, Double.valueOf(200));
		this.setTopAnchor(userMButton, Double.valueOf(60));
		userMButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("user manage");
			    stage.setScene(new Scene(new userManageUI(""),1200,730));
			    stage.show();
			}
		});
		this.getChildren().add(userMButton);
		Button detailMButton=new Button("detail manage");
		detailMButton.setFont(new Font("Times New Roman", 20));
		detailMButton.setPrefWidth(Double.valueOf(180));
		detailMButton.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(detailMButton, Double.valueOf(200));
		this.setTopAnchor(detailMButton, Double.valueOf(110));
		detailMButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("detail manage");
			    stage.setScene(new Scene(new detailManageUI(""),1200,730));
			    stage.show();
			}
		});
		this.getChildren().add(detailMButton);
		
	}
 	public void showMsg(String msg){
   	 Alert alert = new Alert(AlertType.INFORMATION);
        alert.titleProperty().set("hint");
        alert.headerTextProperty().set(msg);
        alert.showAndWait();
   }
}
