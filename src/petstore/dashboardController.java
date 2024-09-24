/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petstore;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static oracle.net.aso.C00.x;
import static oracle.net.aso.C00.y;

/**
 *
 * @author Norhan
 */
public class dashboardController implements Initializable {
    private double x;
        private double y;

    @FXML
    private AnchorPane main_form;

     @FXML
    private Button available_product_btn;

    @FXML
    private Button availiable_add;

    @FXML
    private Button availiable_btn;

    @FXML
    private Button availiable_clear;

    @FXML
    private TableColumn<?, ?> availiable_coid;

    @FXML
    private TableColumn<?, ?> availiable_coname;

    @FXML
    private TableColumn<?, ?> availiable_coprice;

    @FXML
    private TableColumn<?, ?> availiable_costatus;

    @FXML
    private Button availiable_delete;

    @FXML
    private AnchorPane availiable_form;

    @FXML
    private TextField availiable_id;

    @FXML
    private ImageView availiable_image;

    @FXML
    private TextField availiable_name;

    @FXML
    private TextField availiable_price;

    @FXML
    private TextField availiable_search;

    @FXML
    private ComboBox<?> availiable_status;

    @FXML
    private TableView<?> availiable_table;

    @FXML
    private Button availiable_update;

    @FXML
    private Label home_available_product;

    @FXML
    private Button home_btn;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_totalcustomer;

    @FXML
    private Label home_totalincome;

    @FXML
    private BarChart<?, ?> income_datachart;

    @FXML
    private Button logout_btn;

    @FXML
    private Button pay;

    @FXML
    private ComboBox<?> productid;

    @FXML
    private ComboBox<?> productname;

    @FXML
    private Spinner<?> productquantity;

    @FXML
    private Button purchase_btn;

    @FXML
    private AnchorPane purchase_form;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> tableid;

    @FXML
    private TableColumn<?, ?> tablename;

    @FXML
    private TableColumn<?, ?> tableprice;

    @FXML
    private TableColumn<?, ?> tablequantity;

    @FXML
    private Label total;

    @FXML
    private Label username;

     public void close(){
    System.exit(0);
    
    }
     public void logout(){
     try{
    Alert  alert=new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("CONFIRM MESSAGE");
      alert.setHeaderText(null);
      alert.setContentText("Are You sure you want to Logout?");
       alert.showAndWait();
    Optional<ButtonType>option=alert.showAndWait();
    if(option.get().equals(ButtonType.OK)){ logout_btn.getScene().getWindow().hide();
     Parent root=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       
          Scene scene =new Scene(root);
      Stage stage=new Stage();
      
      root.setOnMousePressed((MouseEvent event)->{
        x=event.getSceneX();
                y=event.getSceneY();
               
        });
         root.setOnMouseDragged((MouseEvent event)->{
         stage.setX(event.getScreenX() - x);
                  stage.setY(event.getScreenY() - y);
                  stage.setOpacity(.8);

         });
         root.setOnMouseReleased((MouseEvent event)->{
stage.setOpacity(1); 
});
         stage.initStyle(StageStyle.TRANSPARENT);
         stage.setScene(scene);
         stage.show();
         
         

    }
     
     }
     catch(Exception e){
     e.printStackTrace();
     }
     
     }
      public void minimize(){
      Stage stage=(Stage)main_form.getScene().getWindow();
      stage.setIconified(true);
      }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
