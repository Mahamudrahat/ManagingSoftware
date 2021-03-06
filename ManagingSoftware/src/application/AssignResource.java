package application;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import application.UpdateProject.UpdateProject1;
import application.UpdateUser.UpdateUser1;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AssignResource {
	int i=1,j=1;
	Text text=new Text("Assign Resource Person");
	Label l1=new Label("Select Project");
    Label l2=new Label("Select person");
    Label l3=new Label("Designation");
	ComboBox<String> cb1=new ComboBox();
	ComboBox<String> cb2=new ComboBox();
	ComboBox<String> cb3=new ComboBox();
	 Button b1=new Button("Save");
	 Pane pane=new Pane();
     Stage stage=new Stage();
     private ObservableList<ObservableList> data;
     String JDBC_DRIVER="com.mysql.jdbc.Driver";
	 String DB_URL="jdbc:mysql://localhost/managingsoft";
	 Connection conn=null;
		Statement stmt=null;
	 public void Resource(){
		 data = FXCollections.observableArrayList();
   		 TableView table = new TableView();
   		    table.setEditable(true);
		 text.setFont(Font.font("o",FontWeight.NORMAL,30));
	   	  text.setFill(Color.BLACK);
	   	  text.relocate(100, 50);
	   	 l1.relocate(20,150 );
		 l1.setPrefSize(200, 30);
	l1.setFont(Font.font("o",FontWeight.NORMAL,20));
	cb1.relocate(170, 150);
	cb1.setPrefSize(200, 30);
	l2.relocate(20,200 );
	l2.setPrefSize(200, 30);
	l2.setFont(Font.font("o",FontWeight.NORMAL,20));
	cb2.relocate(170, 200);
	cb2.setPrefSize(200, 30);
	l3.relocate(20,250 );
	l3.setPrefSize(150, 30);
	l3.setFont(Font.font("o",FontWeight.NORMAL,20));
	cb3.relocate(170, 250);
	cb3.setPrefSize(200, 30);
	cb3.getItems().addAll("Developer","Project Manager","Team Lead","QA Engineer","UX Engineer");
	b1.relocate(250,300 );
	b1.setPrefSize(100, 30);
	table.relocate(80, 350);
	table.setPrefSize(400, 300);
	 pane.getChildren().addAll(l1,l2,l3,cb1,cb2,cb3,text,b1,table);
	 try{
		 Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(DB_URL,"root","");
			System.out.println("Successfully connected");
			stmt=conn.createStatement();
	    

	    //SQL FOR SELECTING ALL OF CUSTOMER

	    String SQL = "SELECT * from assignresource";

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
	 try{
		   Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(DB_URL,"root","");
			System.out.println("Successfully connected");
			stmt=conn.createStatement();
			String query="select   Name from updateproject ";
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()){
				
				String s=rset.getString(i);
				cb1.getItems().addAll(s);
			}i++;
	   }catch
		 (Exception ex){
			
				ex.printStackTrace();
		 }
	 try{
		   Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(DB_URL,"root","");
			System.out.println("Successfully connected");
			stmt=conn.createStatement();
			String query="select   Name from updateuser ";
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()){
				
				String s=rset.getString(j);
				cb2.getItems().addAll(s);
			}j++;
	   }catch
		 (Exception ex){
			
				ex.printStackTrace();
		 }
	 b1.setOnAction(e1->{
			AssignResource1 a=new AssignResource1();
			a.Resource1();
		});
		 pane.setPrefSize(650, 650);
    	 Scene scene=new Scene(pane);
  		stage.setScene(scene);
  		stage.show();
		 
	 }
	 public class AssignResource1  extends Button{
       	 
	     	public void Resource1(){
	     		  try{
	     			   Class.forName(JDBC_DRIVER);
	     				conn=DriverManager.getConnection(DB_URL,"root","");
	     				System.out.println("Successfully connected");
	     				stmt=conn.createStatement();
	     				String query="insert into assignresource values('"+cb1.getValue()+"','"+cb2.getValue()+"','"+cb3.getValue()+"')";
	     				stmt.executeUpdate(query);
	     				
	     					
	     					System.out.println("Successfully connected");	
	     				
	     		   }catch
	     			 (Exception ex){
	     				
	     					ex.printStackTrace();
	     			 }
	     	}
	 }
}
