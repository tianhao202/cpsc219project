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

public class adminManageUI extends AnchorPane {

	private String mainid;
	public String getMainid() {
		return mainid;
	}
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	Dao<admin> admin1 = new Dao(new admin());
	ObservableList<admin> adminL = FXCollections.observableArrayList();
	public adminManageUI(String param) {
		this.mainid=param;
		this.setStyle("-fx-background-size: 1200 730;-fx-background-image: url('bank.png');-fx-font-family: 'Arial';");
		TextField txtField1 = new TextField();
		txtField1.setFont(new Font("Times New Roman", 14));
		txtField1.setPrefWidth(Double.valueOf(93));
		txtField1.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField1, Double.valueOf(440));
		this.setTopAnchor(txtField1, Double.valueOf(30));
		this.getChildren().add(txtField1);
		Label passwordLabel=new Label("password");
		passwordLabel.setFont(new Font("Times New Roman", 14));
		passwordLabel.setPrefWidth(Double.valueOf(100));
		passwordLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(passwordLabel, Double.valueOf(370));
		this.setTopAnchor(passwordLabel, Double.valueOf(30));
		this.getChildren().add(passwordLabel);
		TextField txtField2 = new TextField();
		txtField2.setFont(new Font("Times New Roman", 14));
		txtField2.setPrefWidth(Double.valueOf(93));
		txtField2.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField2, Double.valueOf(220));
		this.setTopAnchor(txtField2, Double.valueOf(30));
		this.getChildren().add(txtField2);
		Label usernameLabel=new Label("username");
		usernameLabel.setFont(new Font("Times New Roman", 14));
		usernameLabel.setPrefWidth(Double.valueOf(100));
		usernameLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(usernameLabel, Double.valueOf(150));
		this.setTopAnchor(usernameLabel, Double.valueOf(30));
		this.getChildren().add(usernameLabel);
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
		 tableColumn2.setCellValueFactory(new PropertyValueFactory<>("yonghuming"));
		 tableView1.getColumns().add(tableColumn2);
		 TableColumn tableColumn3=new TableColumn("password");
		 tableColumn3.setCellValueFactory(new PropertyValueFactory<>("mima"));
		 tableView1.getColumns().add(tableColumn3);
		tableView1.setItems(adminL);
		this.getChildren().add(tableView1);
		adminLRefresh();
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
				admin bean = (admin)tableView1.getSelectionModel().getSelectedItems().get(0);
				admin1.delBykey("id", bean.getId().toString());
				showMsg("success");
				adminLRefresh();
				
			}
		});
		this.getChildren().add(deleteButton);
		Button editButton=new Button("edit");
		editButton.setFont(new Font("Times New Roman", 14));
		editButton.setPrefWidth(Double.valueOf(93));
		editButton.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(editButton, Double.valueOf(300));
		this.setTopAnchor(editButton, Double.valueOf(100));
		/**
			edit button misson
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
			    stage.setScene(new Scene(new adminUpdateUI(String.valueOf(row)),600,600));
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
				admin bean=new admin();
				bean.setUsername(txtField2.getText());
				bean.setPassword(txtField1.getText());
				adminL.clear();
				adminL.addAll(admin1.query(bean));
				
			}
		});
		this.getChildren().add(searchButton);
		Button addButton=new Button("add");
		addButton.setFont(new Font("Times New Roman", 14));
		addButton.setPrefWidth(Double.valueOf(93));
		addButton.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(addButton, Double.valueOf(200));
		this.setTopAnchor(addButton, Double.valueOf(100));
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("addd");
			    stage.setScene(new Scene(new adminAddUI(""),600,600));
			    stage.show();
			}
		});
		this.getChildren().add(addButton);
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
			}
		});
		this.getChildren().add(resetButton);
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
