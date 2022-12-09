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

public class detailUpdateUI extends AnchorPane {

	private String mainid;
	public String getMainid() {
		return mainid;
	}
	public void setMainid(String mainid) {
		this.mainid = mainid;
	}
	Dao<detail> detail1 = new Dao(new detail());
	ObservableList<detail> detailL = FXCollections.observableArrayList();
	public detailUpdateUI(String param) {
		this.mainid=param;
		this.setStyle("-fx-background-size: 600 600;-fx-background-image: url('bank.png');-fx-font-family: 'Arial';");
		TextField txtField1 = new TextField();
		txtField1.setFont(new Font("Times New Roman", 14));
		txtField1.setPrefWidth(Double.valueOf(93));
		txtField1.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField1, Double.valueOf(440));
		this.setTopAnchor(txtField1, Double.valueOf(60));
		this.getChildren().add(txtField1);
		Label detailsLabel=new Label("details");
		detailsLabel.setFont(new Font("Times New Roman", 14));
		detailsLabel.setPrefWidth(Double.valueOf(100));
		detailsLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(detailsLabel, Double.valueOf(150));
		this.setTopAnchor(detailsLabel, Double.valueOf(60));
		this.getChildren().add(detailsLabel);
		Label noteLabel=new Label("note");
		noteLabel.setFont(new Font("Times New Roman", 14));
		noteLabel.setPrefWidth(Double.valueOf(100));
		noteLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(noteLabel, Double.valueOf(150));
		this.setTopAnchor(noteLabel, Double.valueOf(180));
		this.getChildren().add(noteLabel);
		TextField txtField2 = new TextField();
		txtField2.setFont(new Font("Times New Roman", 14));
		txtField2.setPrefWidth(Double.valueOf(93));
		txtField2.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField2, Double.valueOf(220));
		this.setTopAnchor(txtField2, Double.valueOf(180));
		this.getChildren().add(txtField2);
		Label amountLabel=new Label("amount");
		amountLabel.setFont(new Font("Times New Roman", 14));
		amountLabel.setPrefWidth(Double.valueOf(100));
		amountLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(amountLabel, Double.valueOf(150));
		this.setTopAnchor(amountLabel, Double.valueOf(120));
		this.getChildren().add(amountLabel);
		TextField txtField3 = new TextField();
		txtField3.setFont(new Font("Times New Roman", 14));
		txtField3.setPrefWidth(Double.valueOf(93));
		txtField3.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField3, Double.valueOf(220));
		this.setTopAnchor(txtField3, Double.valueOf(120));
		this.getChildren().add(txtField3);
		ComboBox<String> comboBox1 = new ComboBox<>();
		comboBox1.setPrefWidth(Double.valueOf(93));
		comboBox1.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(comboBox1, Double.valueOf(220));
		this.setTopAnchor(comboBox1, Double.valueOf(60));
		comboBox1.getItems().add("");
		comboBox1.getItems().add("withdraw");
		comboBox1.getItems().add("deposit");
		comboBox1.getItems().add("transfer");
		this.getChildren().add(comboBox1);
		Label timeLabel=new Label("time");
		timeLabel.setFont(new Font("Times New Roman", 14));
		timeLabel.setPrefWidth(Double.valueOf(100));
		timeLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(timeLabel, Double.valueOf(370));
		this.setTopAnchor(timeLabel, Double.valueOf(60));
		this.getChildren().add(timeLabel);
		Label userLabel=new Label("user");
		userLabel.setFont(new Font("Times New Roman", 14));
		userLabel.setPrefWidth(Double.valueOf(100));
		userLabel.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(userLabel, Double.valueOf(370));
		this.setTopAnchor(userLabel, Double.valueOf(120));
		this.getChildren().add(userLabel);
		TextField txtField4 = new TextField();
		txtField4.setFont(new Font("Times New Roman", 14));
		txtField4.setPrefWidth(Double.valueOf(93));
		txtField4.setPrefHeight(Double.valueOf(23));
		this.setLeftAnchor(txtField4, Double.valueOf(440));
		this.setTopAnchor(txtField4, Double.valueOf(120));
		this.getChildren().add(txtField4);
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
		 TableColumn tableColumn2=new TableColumn("details");
		 tableColumn2.setCellValueFactory(new PropertyValueFactory<>("details"));
		 tableView1.getColumns().add(tableColumn2);
		 TableColumn tableColumn3=new TableColumn("time");
		 tableColumn3.setCellValueFactory(new PropertyValueFactory<>("time"));
		 tableView1.getColumns().add(tableColumn3);
		 TableColumn tableColumn4=new TableColumn("amount");
		 tableColumn4.setCellValueFactory(new PropertyValueFactory<>("amount"));
		 tableView1.getColumns().add(tableColumn4);
		 TableColumn tableColumn5=new TableColumn("user");
		 tableColumn5.setCellValueFactory(new PropertyValueFactory<>("user"));
		 tableView1.getColumns().add(tableColumn5);
		 TableColumn tableColumn6=new TableColumn("note");
		 tableColumn6.setCellValueFactory(new PropertyValueFactory<>("note"));
		 tableView1.getColumns().add(tableColumn6);
		tableView1.setItems(detailL);
		this.getChildren().add(tableView1);
		detailLRefresh();
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
			save button mission
		*/
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
		 			detail bean = detailL.get(Integer.valueOf(param));
				bean.setDetails(comboBox1.getSelectionModel().getSelectedItem());
				bean.setTime(txtField1.getText());
				bean.setAmount(txtField3.getText());
				bean.setUser(txtField4.getText());
				bean.setNote(txtField2.getText());
				detail1.update(bean);
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
		 			detail bean = (detail)tableView1.getSelectionModel().getSelectedItems().get(0);
				comboBox1.setValue(bean.getDetails());
				txtField1.setText(bean.getTime());
				txtField3.setText(bean.getAmount());
				txtField4.setText(bean.getuser());
				txtField2.setText(bean.getNote());
				
			};
		});
		detailLRefresh();
		 			detail bean = detailL.get(Integer.valueOf(param));
				comboBox1.setValue(bean.getDetails());
				txtField1.setText(bean.getTime());
				txtField3.setText(bean.getAmount());
				txtField4.setText(bean.getuser());
				txtField2.setText(bean.getNote());
		
	}
	public void detailLRefresh(){
		detailL.clear();
    	detailL.addAll(detail1.getAll());
	}
 	public void showMsg(String msg){
   	 Alert alert = new Alert(AlertType.INFORMATION);
        alert.titleProperty().set("hint");
        alert.headerTextProperty().set(msg);
        alert.showAndWait();
   }
}
