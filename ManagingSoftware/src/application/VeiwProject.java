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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class VeiwProject {
	Text text=new Text("View All Projects");
	
	 Pane pane=new Pane();
     Stage stage=new Stage();
     private ObservableList<ObservableList> data;
     String JDBC_DRIVER="com.mysql.jdbc.Driver";
	 String DB_URL="jdbc:mysql://localhost/managingsoft";
	 Connection conn=null;
		Statement stmt=null;

	 public void project(){
		 data = FXCollections.observableArrayList();
		 TableView table = new TableView();
		    table.setEditable(true);
		 text.setFont(Font.font("o",FontWeight.NORMAL,30));
	   	  text.setFill(Color.BLACK);
	   	  text.relocate(100, 50);
	  	table.relocate(80, 150);
		table.setPrefSize(500, 300);
	   	pane.getChildren().addAll(text,table);
	    try{
			 Class.forName(JDBC_DRIVER);
				conn=DriverManager.getConnection(DB_URL,"root","");
				System.out.println("Successfully connected");
				stmt=conn.createStatement();
		    

		    //SQL FOR SELECTING ALL OF CUSTOMER

		    String SQL = "SELECT * from updateproject";

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
	    pane.setPrefSize(650, 650);
   	 Scene scene=new Scene(pane);
 		stage.setScene(scene);
 		stage.show();
	 }
		 
}
