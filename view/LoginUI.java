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

public class LoginUI extends AnchorPane {

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
                    		LoginUI root=new LoginUI("");
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
	public LoginUI(String param) {
		this.mainid=param;
		this.setStyle("-fx-background-size: 600 600;-fx-background-image: url('bank.png');-fx-font-family: 'Arial';");
		Button userLoginButton=new Button("userLogin");
		userLoginButton.setFont(new Font("getUsername", 20));
		userLoginButton.setPrefWidth(Double.valueOf(180));
		userLoginButton.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(userLoginButton, Double.valueOf(200));
		this.setTopAnchor(userLoginButton, Double.valueOf(250));
		userLoginButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("userLogin");
			    stage.setScene(new Scene(new userLoginUI(""),600,600));
			    stage.show();
			    ((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
			}
		});
		this.getChildren().add(userLoginButton);
		Button exitButton=new Button("exit");
		exitButton.setFont(new Font("getUsername", 20));
		exitButton.setPrefWidth(Double.valueOf(180));
		exitButton.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(exitButton, Double.valueOf(200));
		this.setTopAnchor(exitButton, Double.valueOf(300));
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});
		this.getChildren().add(exitButton);
		Button adminLoginButton=new Button("adminLogin");
		adminLoginButton.setFont(new Font("getUsername", 20));
		adminLoginButton.setPrefWidth(Double.valueOf(180));
		adminLoginButton.setPrefHeight(Double.valueOf(40));
		this.setLeftAnchor(adminLoginButton, Double.valueOf(200));
		this.setTopAnchor(adminLoginButton, Double.valueOf(200));
		adminLoginButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			    Stage stage=new Stage();
			    stage.setTitle("adminLogin");
			    stage.setScene(new Scene(new adminLoginUI(""),600,600));
			    stage.show();
			    ((Stage) ((Button)e.getSource()).getScene().getWindow()).close();
			}
		});
		this.getChildren().add(adminLoginButton);
		
	}
 	public void showMsg(String msg){
   	 Alert alert = new Alert(AlertType.INFORMATION);
        alert.titleProperty().set("hint");
        alert.headerTextProperty().set(msg);
        alert.showAndWait();
   }
}
