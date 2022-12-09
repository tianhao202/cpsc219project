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

public class adminUpdateUI extends AnchorPane {

	private String mainid;
	public String getMainid() {
		return mainid;
	}
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	Dao<admin> admin1 = new Dao(new admin());
	ObservableList<admin> adminL = FXCollections.observableArrayList();
	public adminUpdateUI(String param) {
		this.mainid=param;
		this.setStyle("-fx-background-size: 600 600;-fx-background-image: url('bank.png');-fx-font-family: 'Arial';");
		Label usernameLabel=new Label("username");
		usernameLabel.setFont(new Font("Times New Roman", 14));
		usernameLabel.setPrefWidth(Double.valueOf(100));
		usernameLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(usernameLabel, Double.valueOf(150));
		this.setTopAnchor(usernameLabel, Double.valueOf(60));
		this.getChildren().add(usernameLabel);
		TextField txtField1 = new TextField();
		txtField1.setFont(new Font("Times New Roman", 14));
		txtField1.setPrefWidth(Double.valueOf(93));
		txtField1.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField1, Double.valueOf(440));
		this.setTopAnchor(txtField1, Double.valueOf(60));
		this.getChildren().add(txtField1);
		TextField txtField2 = new TextField();
		txtField2.setFont(new Font("Times New Roman", 14));
		txtField2.setPrefWidth(Double.valueOf(93));
		txtField2.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField2, Double.valueOf(220));
		this.setTopAnchor(txtField2, Double.valueOf(60));
		this.getChildren().add(txtField2);
		Label passwordLabel=new Label("password");
		passwordLabel.setFont(new Font("Times New Roman", 14));
		passwordLabel.setPrefWidth(Double.valueOf(100));
		passwordLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(passwordLabel, Double.valueOf(370));
		this.setTopAnchor(passwordLabel, Double.valueOf(60));
		this.getChildren().add(passwordLabel);
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
		tableView1.setItems(adminL);
		this.getChildren().add(tableView1);
		adminLRefresh();
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
		Button saveButton=new Button("save");
		saveButton.setFont(new Font("Times New Roman", 14));
		saveButton.setPrefWidth(Double.valueOf(93));
		saveButton.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(saveButton, Double.valueOf(200));
		this.setTopAnchor(saveButton, Double.valueOf(350));
		/**
			save button action
		*/
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
		 			admin bean = adminL.get(Integer.valueOf(param));
				bean.setUsername(txtField2.getText());
				bean.setPassword(txtField1.getText());
				admin1.update(bean);
				showMsg("success");
			}
		});
		this.getChildren().add(saveButton);
		tableView1.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				int row = tableView1.getSelectionModel().getSelectedIndex();
				if (row == -1) {
					return;
				}
		 			admin bean = (admin)tableView1.getSelectionModel().getSelectedItems().get(0);
				txtField2.setText(bean.getUsername());
				txtField1.setText(bean.getPassword());
				
			};
		});
		adminLRefresh();
		 			admin bean = adminL.get(Integer.valueOf(param));
				txtField2.setText(bean.getUsername());
				txtField1.setText(bean.getPassword());
		
	}
	public void adminLRefresh(){
		adminL.clear();
    	adminL.addAll(admin1.getAll());
	}
 	public void showMsg(String msg){
   	 Alert alert = new Alert(AlertType.INFORMATION);
        alert.titleProperty().set("hint");
        alert.headerTextProperty().set(msg);
        alert.showAndWait();
   }
}
