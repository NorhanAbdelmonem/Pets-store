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
    private Connection con;
    private PreparedStatement prepare;
    private ResultSet result;
    
    public void login(){
    String sql="Select * FROM admin WHERE username=? and password =?"; 
    con =(Connection) database.getCon();
    try{
   prepare = con.
   prepare.setString(1,username.getText());
    }
    catch (Exception e) {
            e.printStackTrace();
        }}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
