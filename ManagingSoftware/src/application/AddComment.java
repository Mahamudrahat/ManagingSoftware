package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import application.UpdateTask.UpdateTask1;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddComment {
	int i=1,j=1;
	Text text=new Text("Add Comment");
	Label l1=new Label("Select Project");
    Label l2=new Label("Select task");
    Label l3=new Label("Comment");
    Label l4=new Label("Comment by");
    ComboBox<String> cb1=new ComboBox();
   	ComboBox<String> cb2=new ComboBox();
   	TextField t1=new TextField();
   	TextField t2=new TextField();
    Button b1=new Button("Save");
    Pane pane=new Pane();
    Stage stage=new Stage();
    String JDBC_DRIVER="com.mysql.jdbc.Driver";
	 String DB_URL="jdbc:mysql://localhost/managingsoft";
	 Connection conn=null;
		Statement stmt=null;
  public void Comment(){
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
l4.relocate(20,350 );
l4.setPrefSize(200, 100);
l4.setFont(Font.font("o",FontWeight.NORMAL,20));
t2.relocate(170, 380);
t2.setPrefSize(200, 30);
b1.relocate(250, 500);
b1.setPrefSize(100, 30);
pane.getChildren().addAll(l1,l2,l3,l4,cb1,cb2,text,b1,t1,t2);
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
		String query="select   Select_task from updateproject ";
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
	AddComment1 a=new AddComment1();
	a.Comment1();
});
pane.setPrefSize(650, 650);
Scene scene=new Scene(pane);
	stage.setScene(scene);
	stage.show();
  }
  public class AddComment1  extends Button{
    	 
   	public void Comment1(){
   		
		  try{
			   Class.forName(JDBC_DRIVER);
				conn=DriverManager.getConnection(DB_URL,"root","");
				System.out.println("Successfully connected");
				stmt=conn.createStatement();
				String query="insert into addcomment values('"+cb1.getValue()+"','"+cb2.getValue()+"','"+t1.getText()+"','"+t2.getText()+"')";
				stmt.executeUpdate(query);
				
					
					System.out.println("Successfully connected");	
				
		   }catch
			 (Exception ex){
				
					ex.printStackTrace();
			 
   	}

  }
  }
}
