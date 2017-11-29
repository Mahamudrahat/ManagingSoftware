package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class UpdateUser extends Button  {
	int i=1;
	Text text=new Text("Add/Update User");
	TextField t4=new TextField();
	TextField t1=new TextField();
	TextField t2=new TextField();
	PasswordField t3=new PasswordField();
	RadioButton rb = new RadioButton();
	RadioButton rb1 = new RadioButton();
	 ComboBox<String> cb1=new ComboBox();
	 Button b1=new Button("Save");
	 Label l6=new Label("ID NO");
	Label l1=new Label("Name");
    Label l2=new Label("Email");
    Label l3=new Label("DefaultPassward");
    Label l4=new Label("Status");
    Label l5=new Label("Designation");
	 Pane pane=new Pane();
     Stage stage=new Stage();
     private ObservableList<ObservableList> data;
     String JDBC_DRIVER="com.mysql.jdbc.Driver";
	 String DB_URL="jdbc:mysql://localhost/managingsoft";
	 Connection conn=null;
		Statement stmt=null;

     public void Updateuser(){
    	 data = FXCollections.observableArrayList();
   		 TableView table = new TableView();
   		    table.setEditable(true);
    	 text.setFont(Font.font("o",FontWeight.NORMAL,30));
   	  text.setFill(Color.BLACK);
   	  text.relocate(100, 50);
   	l6.relocate(100,100 );
	 l6.setPrefSize(80, 30);
l6.setFont(Font.font("o",FontWeight.NORMAL,20));
t4.relocate(170, 100);
t4.setPrefSize(200, 30);
   	 l1.relocate(100,150 );
	 l1.setPrefSize(80, 30);
l1.setFont(Font.font("o",FontWeight.NORMAL,20));
t1.relocate(170, 150);
t1.setPrefSize(200, 30);
l2.relocate(100,200 );
l2.setPrefSize(80, 30);
l2.setFont(Font.font("o",FontWeight.NORMAL,20));
t2.relocate(170, 200);
t2.setPrefSize(200, 30);
l3.relocate(20,250 );
l3.setPrefSize(150, 30);
l3.setFont(Font.font("o",FontWeight.NORMAL,20));
t3.relocate(170, 250);
t3.setPrefSize(200, 30);
l4.relocate(100,300 );
l4.setPrefSize(80, 30);
l4.setFont(Font.font("o",FontWeight.NORMAL,20));
rb.setText("Active");
rb1.setText("Inactive");
rb.relocate(200,300 );
rb.setPrefSize(80, 30);
rb1.relocate(400,300 );
rb1.setPrefSize(80, 30);
l5.relocate(50,350 );
l5.setPrefSize(200, 30);
l5.setFont(Font.font("o",FontWeight.NORMAL,20));
cb1.relocate(200,350 );
cb1.setPrefSize(200, 50);
cb1.getItems().addAll("Developer","Project Manager","Team Lead","QA Engineer","UX Engineer");
b1.relocate(350,450 );
b1.setPrefSize(80, 30);
b1.setFont(Font.font("o",FontWeight.NORMAL,20));
table.relocate(80, 500);
table.setPrefSize(400, 300);
b1.setOnAction(e1->{
	UpdateUser1 a=new UpdateUser1();
	a.User1();
});
try{
	 Class.forName(JDBC_DRIVER);
		conn=DriverManager.getConnection(DB_URL,"root","");
		System.out.println("Successfully connected");
		stmt=conn.createStatement();
    

    //SQL FOR SELECTING ALL OF CUSTOMER

    String SQL = "SELECT ID_NO,Name,Email,Status,Designation from updateuser";

    //ResultSet

    ResultSet rs = stmt.executeQuery(SQL);



    /**********************************

     * TABLE COLUMN ADDED DYNAMICALLY *

     **********************************/

    for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){

        //We are using non property style for making dynamic table

        final int j = i;               

        TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));

        col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                   

            public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                             

                return new SimpleStringProperty(param.getValue().get(j).toString());                       

            }                   

        });

        

        table.getColumns().addAll(col);

        System.out.println("Column ["+i+"] ");

    }



    /********************************

     * Data added to ObservableList *

     ********************************/

    while(rs.next()){

        //Iterate Row

        ObservableList<String> row = FXCollections.observableArrayList();

        for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){

            //Iterate Column
            row.add(rs.getString(i));

        }

        System.out.println("Row [1] added "+row );

        data.add(row);



    }


    //FINALLY ADDED TO TableView

    table.setItems(data);

  }catch(Exception e){
      e.printStackTrace();

      System.out.println("Error on Building Data");            
  }



   	pane.getChildren().addAll(t1,t2,t3,l1,l2,l3,l4,text,rb,rb1,l5,cb1,b1,l6,t4,table);
  
    	 pane.setPrefSize(650, 650);
    	 Scene scene=new Scene(pane);
  		stage.setScene(scene);
  		stage.show();
     }
     public class UpdateUser1 extends Button{
       	 
     	public void User1(){
     	
     		
     		String status = null;
			if(rb.isSelected()) 
     	        status="Active";
     	else if(rb1.isSelected()) 
     	        status="Inactive";
     		
     		   try{
     			   Class.forName(JDBC_DRIVER);
     				conn=DriverManager.getConnection(DB_URL,"root","");
     				System.out.println("Successfully connected");
     				stmt=conn.createStatement();
     				String query="insert into Updateuser values('"+t4.getText()+"','"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+status+"','"+cb1.getValue()+"')";
     				stmt.executeUpdate(query);
     				
     					
     					System.out.println("Successfully connected");	
     				
     		   }catch
     			 (Exception ex){
     				
     					ex.printStackTrace();
     			 }
     		      		
     		
     		     }

     	}
	

}
