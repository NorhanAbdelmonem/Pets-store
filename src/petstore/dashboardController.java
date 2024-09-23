/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petstore;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Norhan
 */
public class dashboardController implements Initializable {
    
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
      public void minimize(){
      Stage stage=(Stage)main_form.getScene().getWindow();
      stage.setIconified(true);
      }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
