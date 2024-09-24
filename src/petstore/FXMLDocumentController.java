/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package petstore;

import com.sun.jdi.connect.spi.Connection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.sql.*;
import java.sql.PreparedStatement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 *
 * @author Norhan
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button close;

    @FXML
    private Button login;

    @FXML
    private AnchorPane mainform;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    public void close(){
    System.exit(0);
    
    }
    private double x =0;
        private double y =0;

private java.sql.Connection connect;
    private PreparedStatement prepare;
 
    private ResultSet result;

    public void login() throws SQLException{
    String sql="Select * FROM admin WHERE username=? and password =?"; 
   connect=database.getCon();
    try{
  prepare=connect.prepareStatement(sql);
   prepare.setString(1,username.getText());
      prepare.setString(2,password.getText());
      result=prepare.executeQuery();
      Alert alert;
      if(username.getText().isEmpty()||password.getText().isEmpty()){
      alert=new Alert(AlertType.ERROR);
      alert.setTitle("ERROR MESSAGE");
      alert.setHeaderText(null);
      alert.setContentText("Please fill all the blank feilds");
      alert.showAndWait();
      }
      if(result.next()){
         
             alert=new Alert(AlertType.INFORMATION);
      alert.setTitle("INFORMATION MESSAGE");
      alert.setHeaderText(null);
      alert.setContentText("SUCCESFULLY LOGIN");
      alert.showAndWait(); 
     
      login.getScene().getWindow().hide();
          Parent root=FXMLLoader.load(getClass().getResource("dashboard.fxml"));
          Stage stage=new Stage();
          Scene scene =new Scene(root);
          
          root.setOnMousePressed((MouseEvent event)->{
        x=event.getSceneX();
                y=event.getSceneY();
               
        });
         root.setOnMouseDragged((MouseEvent event)->{
         stage.setX(event.getScreenX() - x);
                  stage.setY(event.getScreenY() - y);
                  stage.setOpacity(.8);

         });
 stage.initStyle(StageStyle.TRANSPARENT);
          stage.setScene(scene);
         
          stage.show();
        
      
    }
      else{
      alert=new Alert(AlertType.ERROR);
      alert.setTitle("ERROR MESSAGE");
      alert.setHeaderText(null);
      alert.setContentText("Wrong Username/Password");
      alert.showAndWait();
      
      
      }}
    catch (Exception e) {
            e.printStackTrace();
        }}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
