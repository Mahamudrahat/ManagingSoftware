package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	Label l1=new Label("UserName");
	Label l2=new Label("Password");
	TextField t2=new TextField();
	PasswordField t4=new PasswordField();
	Button b1=new Button("OK");
	Button b2=new Button("EXIT");
	Pane pane=new Pane();
	Stage stage=new Stage();
	 String JDBC_DRIVER="com.mysql.jdbc.Driver";
	 String DB_URL="jdbc:mysql://localhost/managingsoft";	
			Connection conn=null;
			Statement stmt=null;
	public void start(Stage stage) {
		//Pane pane=new Pane();
		pane.setPrefSize(650, 650);
		t2.relocate(300,250 );
		t2.setPrefSize(200, 30);
		t4.relocate(300, 300);
		t4.setPrefSize(200,30);
		l1.relocate(150, 250);
		//l1.setPrefSize(80, 50);
		l1.setFont(Font.font("o",FontWeight.NORMAL,20));
		l2.relocate(150, 300);
		//l2.setPrefSize(80, 50);
		l2.setFont(Font.font("o",FontWeight.NORMAL,20));
		b1.relocate(300,350);
		b2.relocate(450, 350);
		b1.setPrefSize(80, 50);
		b2.setPrefSize(80, 50);
		pane.getChildren().addAll(t2,t4,l1,l2,b1,b2);
		b1.setOnAction(e1->{
			
		//	Menu s=new Menu();
			//s.menu();
			adminlogin1 a=new adminlogin1();
			a.adminlogin1();
			//stage.hide();
		});
		b2.setOnAction(e->{
			System.exit(0);
		});
		Scene scene=new Scene(pane);
		stage.setScene(scene);
		stage.show();
		
		
	}
	public class adminlogin1 extends Button{
		Label l3=new Label("Please enter your correct ");
		Label l4=new Label("username OR password ");
	
		 
		public void adminlogin1(){
	

			l3.relocate(300, 450);
			l4.relocate(300, 500);
			
	
			
			try{
				Class.forName(JDBC_DRIVER);
				conn=DriverManager.getConnection(DB_URL,"root","");
				System.out.println("Successfully connected");
				stmt=conn.createStatement();
				System.out.println("Successfully connected");
				String query="select Name,Password from adminpannel where Name='"+t2.getText()+"'and Password='"+t4.getText()+"'";
				ResultSet rset = stmt.executeQuery(query);
				
				if(rset.next()){
					
					//System.out.println("success");
					Menu p=new Menu();
					p.menu();
					//stage.hide();
					//Adminpanel1 s=new Adminpanel1();
					//s.Adminpanel1();
				} else{
					
					 l3.setFont(Font.font("o",FontWeight.NORMAL,20));
					 l4.setFont(Font.font("o",FontWeight.NORMAL,20));
					 pane.getChildren().addAll(l3,l4);
						

					
					System.out.println("please enter correct username and password");
				}
				
			}catch(Exception e){
				
				e.printStackTrace();
			}
			
		}
		}
	public static void main(String[] args) {
		launch(args);
	}
}
