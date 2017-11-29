package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import application.AssignResource.AssignResource1;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UpdateTask {
	int i=1,j=1;
	Text text=new Text("Update Task");
	Label l1=new Label("Select Project");
    Label l2=new Label("Assign to");
    Label l3=new Label("Description");
    Label l4=new Label("Due Date");
    Label l5=new Label("priority");
    TextField t1=new TextField();
    Button b1=new Button("Save");
    ComboBox<String> cb1=new ComboBox();
	ComboBox<String> cb2=new ComboBox();
	DatePicker d1 = new DatePicker();
	ComboBox<String> cb4=new ComboBox();
	 Pane pane=new Pane();
     Stage stage=new Stage();
     private ObservableList<ObservableList> data;
     String JDBC_DRIVER="com.mysql.jdbc.Driver";
	 String DB_URL="jdbc:mysql://localhost/managingsoft";
	 Connection conn=null;
		Statement stmt=null;
	 public void Task(){
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
	t1.relocate(170, 250);
	t1.setPrefSize(200, 100);
	l4.relocate(20,400 );
	l4.setPrefSize(150, 30);
	l4.setFont(Font.font("o",FontWeight.NORMAL,20));
	d1.relocate(170, 400);
	d1.setPrefSize(200, 30);
	l5.relocate(20,450 );
	l5.setPrefSize(150, 30);
	l5.setFont(Font.font("o",FontWeight.NORMAL,20));
	cb4.relocate(170, 450);
	cb4.setPrefSize(200, 30);
	cb4.getItems().addAll("High","Medium","Low");
	b1.relocate(250, 500);
	b1.setPrefSize(100, 30);
	 pane.getChildren().addAll(l1,l2,l3,l4,l5,cb1,cb2,d1,text,b1,cb4,t1);
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
			UpdateTask1 a=new UpdateTask1();
			a.Task1();
		});
	 pane.setPrefSize(650, 650);
	 Scene scene=new Scene(pane);
		stage.setScene(scene);
		stage.show();
		 
	 }
	 public class UpdateTask1  extends Button{
       	 
	     	public void Task1(){
	     		  try{
	     			   Class.forName(JDBC_DRIVER);
	     				conn=DriverManager.getConnection(DB_URL,"root","");
	     				System.out.println("Successfully connected");
	     				stmt=conn.createStatement();
	     				String query="insert into updatetask values('"+cb1.getValue()+"','"+cb2.getValue()+"','"+t1.getText()+"','"+d1.getValue()+"','"+cb4.getValue()+"')";
	     				stmt.executeUpdate(query);
	     				
	     					
	     					System.out.println("Successfully connected");	
	     				
	     		   }catch
	     			 (Exception ex){
	     				
	     					ex.printStackTrace();
	     			 }
	     	}
	 }
}
