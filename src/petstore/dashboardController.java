/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petstore;

import java.io.File;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
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
    private Button add_cart;

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
    private TableColumn<productData, Integer> availiable_coid;

    @FXML
    private TableColumn<productData, String> availiable_coname;

    @FXML
    private TableColumn<productData, Double> availiable_coprice;

    @FXML
    private TableColumn<productData, String> availiable_costatus;

    @FXML
    private Button availiable_delete;

    @FXML
    private AnchorPane available_form;

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
    private TableView<productData> availiable_table;

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
    private Spinner<Integer> productquantity;

    @FXML
    private Button purchase_btn;

    @FXML
    private AnchorPane purchase_form;

    @FXML
    private TableView<customerData> table_one;

    @FXML
    private TableColumn<customerData, String> tableid;

    @FXML
    private TableColumn<customerData, String> tablename;

    @FXML
    private TableColumn<customerData, Integer> tableprice;

    @FXML
    private TableColumn<customerData, Double>tablequantity;

    @FXML
    private Label total;

    @FXML
    private Label username;
    
    private java.sql.Connection connect;
    private PreparedStatement prepare;
 
    private ResultSet result;
    
    
    
      public void homeAF(){
        
        String sql = "SELECT COUNT(id) FROM product WHERE status = 'Available'";
        
        connect = database.getCon();
        
        try{
            int countAF = 0;
            Statement statement = connect.createStatement();
            result = statement.executeQuery(sql);
            
            if(result.next()){
                countAF = result.getInt("COUNT(id)");
            }
            home_available_product.setText(String.valueOf(countAF));
        }catch(Exception e){e.printStackTrace();}
        
    }
        public void homeTI(){
        
        String sql = "SELECT SUM(total) FROM customer_info";
        
         connect = database.getCon();

        
        try{
            double countTI = 0;
            Statement statement = connect.createStatement();
            result = statement.executeQuery(sql);
            
            if(result.next()){
                countTI = result.getInt("SUM(total)");
            }
            
            home_totalincome.setText("$" + String.valueOf(countTI));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
        
        
         public void homeTC(){
        
        String sql = "SELECT COUNT(id) FROM customer_info";
        
        connect = database.getCon();
        
        try{
            int countTC = 0;
            
            Statement statement = connect.createStatement();
            result = statement.executeQuery(sql);
            
            if(result.next()){
                countTC = result.getInt("COUNT(id)");
            }
            home_totalcustomer.setText(String.valueOf(countTC));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
     public void homeChart(){
        
        income_datachart.getData().clear();
        
        String sql = "SELECT date, SUM(total) FROM customer_info GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 7";
        
        connect = database.getCon();
        
        try{
            XYChart.Series chart = new XYChart.Series();
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }
            
            income_datachart.getData().add(chart);
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    
    
    public ObservableList<productData>availableProductListData(){
    ObservableList<productData> listData = FXCollections.observableArrayList();
     String sql="Select * FROM product"; 
   connect=database.getCon();
    try{
  prepare=connect.prepareStatement(sql);
          result=prepare.executeQuery();
          
         productData product;
         while(result.next()){
         
         product =new productData (result.getInt("product_id"),result.getString("name")
                 ,result.getString("status"),result.getDouble("price"),
         result.getString("image"),result.getDate("date"));
         listData.add(product);
         
                 }
          }
    catch (Exception e) {
            e.printStackTrace();
        }
    return listData;
    }
    
    
     private ObservableList<productData> availableProductList;

    public void availableProductShowListData() {
        availableProductList = availableProductListData();

        availiable_coid.setCellValueFactory(new PropertyValueFactory<>("productId"));
        availiable_coname.setCellValueFactory(new PropertyValueFactory<>("name"));
        availiable_costatus.setCellValueFactory(new PropertyValueFactory<>("status"));
       availiable_coprice.setCellValueFactory(new PropertyValueFactory<>("price"));

        availiable_table.setItems(availableProductList);
    }
    
    private Image image;
     public void availableFlowersInsertImage() {

        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));

        File file = open.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {

            getData.path = file.getAbsolutePath();

            image = new Image(file.toURI().toString(), 180, 130, false, true);
           availiable_image.setImage(image);

        }

    }
    
 public void availableFlowersSelect() {

        productData flower = availiable_table.getSelectionModel().getSelectedItem();
        int num = availiable_table.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

       availiable_id.setText(String.valueOf(flower.getProductId()));
       availiable_name.setText(flower.getName());
        availiable_price.setText(String.valueOf(flower.getPrice()));

        getData.path = flower.getImage();

        String uri = "file:" + flower.getImage();

        image = new Image(uri, 180, 135, false, true);
        availiable_image.setImage(image);

    }
    
    
    public void availableFlowersUpdate() {

        String uri = getData.path;
        if (!(uri == null || uri == "")) {
            uri = uri.replace("\\", "\\\\");
        }

        String sql = "UPDATE product SET name = '"
                + availiable_name.getText() + "', status = '"
                + availiable_status.getSelectionModel().getSelectedItem() + "', price = '"
                + availiable_price.getText() + "', image = '"
                + uri + "' WHERE product_id = '" + availiable_id.getText() + "'";

        connect = database.getCon();
        if (connect == null) {
    System.out.println("Failed to establish a database connection.");
    return;
}

        try {
            Alert alert;

            if (availiable_id.getText().isEmpty()
                    || availiable_name.getText().isEmpty()
                    || availiable_status.getSelectionModel().getSelectedItem() == null
                    || availiable_price.getText().isEmpty()
                    || uri == null || uri == "" || getData.path == null || getData.path == "") {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE product ID: " + availiable_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    Statement statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    availableProductShowListData();

                    // CLEAR ALL FIELDS
                    availableFlowersClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    
    public ObservableList<customerData> purchaseListData() {
        purchaseCustomerId();

        ObservableList<customerData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM customer WHERE customer_id = '" + customerId + "'";

        connect = database.getCon();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            customerData customer;

            while (result.next()) {
                customer = new customerData(result.getInt("customer_id"),
                         result.getInt("product_id"), result.getString("name"),
                         result.getInt("quantity"), result.getDouble("price"),
                         result.getDate("date"));

                listData.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    
    
     public void purchaseProductId() {
        String sql = "SELECT status, product_id FROM product WHERE status = 'Available'";

        connect = database.getCon();

        try {
            ObservableList listData = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                listData.add(result.getInt("product_id"));
            }
            productid.setItems(listData);

            purchaseProductName();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    

    private ObservableList<customerData> purchaseListD;

    public void purchaseShowListData() {
        purchaseListD = purchaseListData();

        tableid.setCellValueFactory(new PropertyValueFactory<>("productId"));
        tablename.setCellValueFactory(new PropertyValueFactory<>("name"));
        tablequantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tableprice.setCellValueFactory(new PropertyValueFactory<>("price"));

       table_one.setItems(purchaseListD);
    }

    
    
        public void purchaseAddToCart() {
        purchaseCustomerId();

        String sql = "INSERT INTO customer (customer_id, product_id, name, quantity, price, date) "
                + "VALUES(?,?,?,?,?,?)";

        connect = database.getCon();

        try {
            Alert alert;

            if (productid.getSelectionModel().getSelectedItem() == null
                    || productname.getSelectionModel().getSelectedItem() == null
                    || qty == 0) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please choose the product first");
                alert.showAndWait();
            } else {
                double priceData = 0;
                double totalPrice;
                String checkPrice = "SELECT name, price FROM product WHERE name = '"
                        + productname.getSelectionModel().getSelectedItem() + "'";

                Statement statement = connect.createStatement();
                result = statement.executeQuery(checkPrice);

                if (result.next()) {
                    priceData = result.getDouble("price");
                }

                prepare = connect.prepareStatement(sql);
                prepare.setString(1, String.valueOf(customerId));
                prepare.setInt(2, (Integer) productid.getSelectionModel().getSelectedItem());
                prepare.setString(3, (String) productname.getSelectionModel().getSelectedItem());
                prepare.setString(4, String.valueOf(qty));
                
                totalPrice = (priceData * qty);

                prepare.setString(5, String.valueOf(totalPrice));

                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                prepare.setString(6, String.valueOf(sqlDate));
                
                prepare.executeUpdate();
                
                purchaseShowListData();
                purchaseDisplayTotal();
               // purchaseDisplayTotal();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     
           
    public void purchasePay(){
        
        String sql = "INSERT INTO customer_info (customer_id, total, date) VALUES(?,?,?)";
        
        connect = database.getCon();
        
        try{
            Alert alert;
            
            if(totalP == 0){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Something wrong :3");
                alert.showAndWait();
            }else{
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, String.valueOf(customerId));
                    prepare.setString(2, String.valueOf(totalP));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    prepare.setString(3, String.valueOf(sqlDate));

                    prepare.executeUpdate();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successful !! Thanks for purchase.");
                    alert.showAndWait();
                    
                    totalP = 0;
                }
            }
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    
        
        
        
        
        
        
        private double totalP = 0;
    public void purchaseDisplayTotal(){
        purchaseCustomerId();
        String sql = "SELECT SUM(price) FROM customer WHERE customer_id = '"+customerId+"'";
        
        connect = database.getCon();
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            if(result.next()){
                totalP = result.getDouble("SUM(price)");
            }
            
            total.setText("$" + String.valueOf(totalP));
            
        }catch(Exception e){e.printStackTrace();}
        
    }

        
        
    
    
    private int customerId;

    public void purchaseCustomerId() {

        String sql = "SELECT MAX(customer_id) FROM customer";

        connect = database.getCon();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                customerId = result.getInt("MAX(customer_id)");
            }

            int countData = 0;

            String checkInfo = "SELECT MAX(customer_id) FROM customer_info";

            prepare = connect.prepareStatement(checkInfo);
            result = prepare.executeQuery();

            if (result.next()) {
                countData = result.getInt("MAX(customer_id)");
            }

            if (customerId == 0) {
                customerId += 1;
            } else if (customerId == countData) {
                customerId = countData + 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    } 
      public void purchaseProductName() {

        String sql = "SELECT product_id, name FROM product WHERE product_id = '"
                + productid.getSelectionModel().getSelectedItem() + "'";

        connect = database.getCon();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while (result.next()) {
                listData.add(result.getString("name"));
            }
            productname.setItems(listData);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    private SpinnerValueFactory<Integer> spinner;

    public void purchaseSpinner() {
        spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        productquantity.setValueFactory(spinner);
    }
    private int qty;

    public void purchaseQuantity() {
        qty = productquantity.getValue();
    }

    
    /*
         public void availableFlowersSearch() {

        FilteredList<productData> filter = new FilteredList<>(availableProductList, e -> true);

        availiable_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateProductData -> {

                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateProductData.getProductId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateProductData.getName().toString().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateProductData.getStatus().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateProductData.getPrice().toString().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });

        });
// تحقق من عدد العناصر في القائمة بعد تحميل البيانات
System.out.println("عدد المنتجات المحملة: " + availableProductList.size());

        SortedList<productData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(availiable_table.comparatorProperty());

        availiable_table.setItems(sortList);

     }

    
    
    */
    
   public void availableFlowersSearch() {
    FilteredList<productData> filter = new FilteredList<>(availableProductList, e -> true);

    // Attach listener to search field
    availiable_search.textProperty().addListener((observable, oldValue, newValue) -> {
        filter.setPredicate(productData -> {
            // If no search text, display all
            if (newValue.isEmpty()||newValue==null) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            // Check if product id, name, status, or price contains the search term
            return productData.getProductId().toString().toLowerCase().contains(searchKey)
                    || productData.getName().toLowerCase().contains(searchKey)
                    || productData.getStatus().toLowerCase().contains(searchKey)
                    || productData.getPrice().toString().contains(searchKey);
        });
    });

    // Bind the Comparator property
    SortedList<productData> sortList = new SortedList<>(filter);
    sortList.comparatorProperty().bind(availiable_table.comparatorProperty());

    // Set sorted list to the table
    availiable_table.setItems(sortList);
}

     public void availableFlowersDelete() {

        String sql = "DELETE FROM product WHERE product_id = '"
                + availiable_id.getText() + "'";

        connect = database.getCon();

        try {
            Alert alert;

            if (availiable_id.getText().isEmpty()
                    || availiable_name.getText().isEmpty()
                    || availiable_status.getSelectionModel().getSelectedItem() == null
                    || availiable_price.getText().isEmpty()
                    || getData.path == null || getData.path == "") {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Product ID: " + availiable_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    Statement statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    availableProductShowListData();

                    // CLEAR ALL FIELDS
                    availableFlowersClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    
    
    public void displayUsername() {
        String user = getData.username;
        username.setText(user.substring(0, 1).toUpperCase() + user.substring(1));

    }
    
  public void switchForm(ActionEvent event) {

        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            available_form.setVisible(false);
            purchase_form.setVisible(false);
            homeAF();
        homeTI();
        homeTC();
        homeChart();
        }
        else if (event.getSource() == available_product_btn) {
            home_form.setVisible(false);
            available_form.setVisible(true);
            purchase_form.setVisible(false);
            availableProductShowListData();
            availableFlowersStatus();
            availableFlowersSearch();
        }
        else if (event.getSource() == purchase_btn) {
            home_form.setVisible(false);
            available_form.setVisible(false);
            purchase_form.setVisible(true);
            purchaseShowListData();
        purchaseProductId();
          purchaseProductName();
          purchaseSpinner();
        
        }
  
  }
  
  
    

  public void availableProductAdd() {

        String sql = "INSERT INTO product (product_id, name, status, price, image, date) "
                + "VALUES(?,?,?,?,?,?)";

        connect = database.getCon();

        try {
            Alert alert;

            if (availiable_id.getText().isEmpty()
                    || availiable_name.getText().isEmpty()
                    || availiable_status.getSelectionModel().getSelectedItem() == null
                    || availiable_price.getText().isEmpty()
                    || getData.path == null || getData.path == "") {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {
                // CHECK IF THE FLOWER ID IS ALREADY EXIST
                String checkData = "SELECT product_id FROM product WHERE product_id = '"
                        + availiable_id.getText() + "'";

                Statement statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Product ID: " + availiable_id.getText() + " was already exist!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, availiable_id.getText());
                    prepare.setString(2,availiable_name.getText());
                    prepare.setString(3, (String) availiable_status.getSelectionModel().getSelectedItem());
                    prepare.setString(4,availiable_price.getText());

                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");
                    prepare.setString(5, uri);

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    prepare.setString(6, String.valueOf(sqlDate));

                    prepare.executeUpdate();
                    availableProductShowListData();
                    availableFlowersClear();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                  
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
  
  
    String listStatus[] = {"Available", "Not Available"};
      public void availableFlowersStatus() {

        List<String> listS = new ArrayList<>();

        for(String data : listStatus) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
       availiable_status.setItems(listData);

    }
  public void availableFlowersClear() {

        availiable_id.setText("");
       availiable_id.setText("");
        availiable_status.getSelectionModel().clearSelection();
       availiable_price.setText("");
        getData.path = "";

      availiable_image .setImage(null);

    }
  
  
  /*
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
      */
  
  
  
  
  
  
    public void logout() {

        try {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                // HIDE YOUR DASHBOARD FORM
                logout_btn.getScene().getWindow().hide();

                // LINK YOUR LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
    
    
    public void close() {
        System.exit(0);
    }
      public void minimize(){
      Stage stage=(Stage)main_form.getScene().getWindow();
      stage.setIconified(true);
      }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
  
        displayUsername(); 
availableProductShowListData();
availableFlowersStatus();
    purchaseShowListData();
    purchaseProductId();
      purchaseProductName();
      
     purchaseSpinner();
     purchaseDisplayTotal();
     homeAF();
        homeTI();
        homeTC();
        homeChart();
    }}
