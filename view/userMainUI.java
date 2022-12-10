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
import javax.swing.SwingUtilities;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

public class userMainUI extends AnchorPane {

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
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JFXPanel(); 
                Platform.setImplicitExit(false);
                Platform.runLater(new Runnable() {
                    public void run() {
                    	try {
                    		userMainUI root=new userMainUI("");
							Stage stage=new Stage();
						    stage.setScene(new Scene(root,
						    		Integer.valueOf(600),Integer.valueOf(600)));
						    stage.show();
                    	} catch (Exception e) {
							e.printStackTrace();
						}
                    }
                });
            }
        });
	}
	public userMainUI(String param) {
		this.mainid=param;
		this.setStyle("-fx-background-size: 600 600;-fx-background-image: url('bank.png');-fx-font-family: 'Arial';");
		Button withdrawButton=new Button("withdraw");
		withdrawButton.setFont(new Font("Times New Roman", 20));
		withdrawButton.setPrefWidth(Double.valueOf(100));
		withdrawButton.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(withdrawButton, Double.valueOf(280));
		this.setTopAnchor(withdrawButton, Double.valueOf(187));
		withdrawButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("withdraw");
			    stage.setScene(new Scene(new DrawUI(username),600,600));
			    stage.show();
			}
		});
		this.getChildren().add(withdrawButton);
		Button transferButton=new Button("transfer");
		transferButton.setFont(new Font("Times New Roman", 20));
		transferButton.setPrefWidth(Double.valueOf(100));
		transferButton.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(transferButton, Double.valueOf(448));
		this.setTopAnchor(transferButton, Double.valueOf(187));
		transferButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("transfer");
			    stage.setScene(new Scene(new TransferUI(username),600,600));
			    stage.show();
			}
		});
		this.getChildren().add(transferButton);
		Button exitButton=new Button("exit");
		exitButton.setFont(new Font("Times New Roman", 20));
		exitButton.setPrefWidth(Double.valueOf(100));
		exitButton.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(exitButton, Double.valueOf(485));
		this.setTopAnchor(exitButton, Double.valueOf(510));
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});
		this.getChildren().add(exitButton);
		Button myBalanceButton=new Button("my balance");
		myBalanceButton.setFont(new Font("Times New Roman", 20));
		myBalanceButton.setPrefWidth(Double.valueOf(150));
		myBalanceButton.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(myBalanceButton, Double.valueOf(397));
		this.setTopAnchor(myBalanceButton, Double.valueOf(303));
		myBalanceButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("my balance");
			    stage.setScene(new Scene(new BalanceUI(username),600,400));
			    stage.show();
			}
		});
		this.getChildren().add(myBalanceButton);
		Button checkDetailButton=new Button("check detail");
		checkDetailButton.setFont(new Font("Times New Roman", 20));
		checkDetailButton.setPrefWidth(Double.valueOf(200));
		checkDetailButton.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(checkDetailButton, Double.valueOf(213));
		this.setTopAnchor(checkDetailButton, Double.valueOf(80));
		checkDetailButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("check detail");
			    stage.setScene(new Scene(new detailListUI(username),1000,600));
			    stage.show();
			}
		});
		this.getChildren().add(checkDetailButton);
		Button depositButton=new Button("deposit");
		depositButton.setFont(new Font("Times New Roman", 20));
		depositButton.setPrefWidth(Double.valueOf(100));
		depositButton.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(depositButton, Double.valueOf(124));
		this.setTopAnchor(depositButton, Double.valueOf(187));
		depositButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("deposit");
			    stage.setScene(new Scene(new DepositUI(username),600,600));
			    stage.show();
			}
		});
		this.getChildren().add(depositButton);
		Button informationButton=new Button("information");
		informationButton.setFont(new Font("Times New Roman", 20));
		informationButton.setPrefWidth(Double.valueOf(150));
		informationButton.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(informationButton, Double.valueOf(123));
		this.setTopAnchor(informationButton, Double.valueOf(303));
		informationButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("information");
			    stage.setScene(new Scene(new MyinfoUI(username),600,600));
			    stage.show();
			}
		});
		this.getChildren().add(informationButton);
		
	}
 	public void showMsg(String msg){
   	 Alert alert = new Alert(AlertType.INFORMATION);
        alert.titleProperty().set("hint");
        alert.headerTextProperty().set(msg);
        alert.showAndWait();
   }
}
