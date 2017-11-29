package application;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import application.UpdateUser.UpdateUser1;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UpdateProject {
	Text text=new Text("Add/Update Project");
	TextField t4=new TextField();
	TextField t1=new TextField();
	TextField t2=new TextField();
	TextField t3=new TextField();
	TextField t5=new TextField();
	TextField t6=new TextField();
	TextField t7=new TextField();
	TextField t8=new TextField();
	DatePicker d1 = new DatePicker();
	DatePicker d2 = new DatePicker();
	Label l9=new Label("Project_ID");
	Label l1=new Label("Name");
    Label l2=new Label("Code");
    Label l3=new Label("Description");
    Label l4=new Label("PossibleStartDate");
    Label l5=new Label("possibleendDate");
    Label l6=new Label("DurationinDay");
    Label l7=new Label("Upload File");
    Label l8=new Label("Status");
    Label l10=new Label("Select Task");
    
    RadioButton rb = new RadioButton();
	RadioButton rb1 = new RadioButton();
	RadioButton rb2 = new RadioButton();
	RadioButton rb3 = new RadioButton();
	 Button b1=new Button("Save");
	 Button b2=new Button("Browse");
    Pane pane=new Pane();
    Stage stage=new Stage();
    String JDBC_DRIVER="com.mysql.jdbc.Driver";
	 String DB_URL="jdbc:mysql://localhost/managingsoft";
	 Connection conn=null;
		Statement stmt=null;
	 public void UpdateProject(){
		 text.setFont(Font.font("o",FontWeight.NORMAL,30));
	   	  text.setFill(Color.BLACK);
	   	  text.relocate(100, 50);
	   	l9.relocate(60,100 );
		 l9.setPrefSize(200, 30);
	l9.setFont(Font.font("o",FontWeight.NORMAL,20));
	t7.relocate(170, 100);
	t7.setPrefSize(200, 30);
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
	l4.relocate(10,300 );
	l4.setPrefSize(200, 30);
	l4.setFont(Font.font("o",FontWeight.NORMAL,20));
	d1.relocate(170, 300);
	d1.setPrefSize(200, 30);
	l5.relocate(10,350 );
	l5.setPrefSize(200, 30);
	l5.setFont(Font.font("o",FontWeight.NORMAL,20));
	d2.relocate(170, 350);
	d2.setPrefSize(200, 30);
	l6.relocate(20,400 );
	l6.setPrefSize(200, 30);
	l6.setFont(Font.font("o",FontWeight.NORMAL,20));
	t6.relocate(170, 400);
	t6.setPrefSize(200, 30);
	l7.relocate(20,450 );
	l7.setPrefSize(200, 30);
	l7.setFont(Font.font("o",FontWeight.NORMAL,20));
	b2.relocate(170, 450);
	b2.setPrefSize(200, 30);
	l10.relocate(20,500 );
	l10.setPrefSize(200, 30);
	l10.setFont(Font.font("o",FontWeight.NORMAL,20));
	t8.relocate(170, 500);
	t8.setPrefSize(200, 30);
	l8.relocate(20,550 );
	l8.setPrefSize(200, 30);
	l8.setFont(Font.font("o",FontWeight.NORMAL,20));
	rb.setText("Not Started");
	rb1.setText("Started");
	rb2.setText("Completed");
	rb3.setText("cancelled");
	rb.relocate(200,550 );
	rb.setPrefSize(100, 30);
	rb1.relocate(400,550 );
	rb1.setPrefSize(100, 30);
	rb2.relocate(200,590 );
	rb2.setPrefSize(100, 30);
	rb3.relocate(400,590 );
	rb3.setPrefSize(100, 30);
	b1.relocate(400,630 );
	b1.setPrefSize(100, 30);
	b1.setOnAction(e1->{
		UpdateProject1 a=new UpdateProject1();
		a.UserProject1();
	});
	b2.setOnAction(e1->{
		  FileChooser fileChooser = new FileChooser();
          FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
          fileChooser.getExtensionFilters().add(extFilter);
          File file = fileChooser.showOpenDialog(stage);
          System.out.println(file);
	});
	
		 pane.getChildren().addAll(t1,t2,t3,t6,l1,l2,l3,l4,l5,l6,l7,
				 l8,text,rb,rb1,rb2,rb3,b1,b2,l9,t7,t8,l10,d1,d2);
		 pane.setPrefSize(650, 700);
    	 Scene scene=new Scene(pane);
  		stage.setScene(scene);
  		stage.show();
		 
	 }
	  public class UpdateProject1 extends Button{
	       	 
	     	public void UserProject1(){

	     		String status = null;
				if(rb.isSelected()) 
	     	        status="Not Started";
	     	else if(rb1.isSelected()) 
	     	        status="Started";
	     	else if(rb2.isSelected()) 
     	        status="Completed";
	     	else if(rb3.isSelected()) 
     	        status="Canceled";
	     		
	     		   try{
	     			   Class.forName(JDBC_DRIVER);
	     				conn=DriverManager.getConnection(DB_URL,"root","");
	     				System.out.println("Successfully connected");
	     				stmt=conn.createStatement();
	     				String query="insert into updateproject values('"+t7.getText()+"','"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+d1.getValue()+"','"+d2.getValue()+"','"+t6.getText()+"','"+t8.getText()+"','"+status+"')";
	     				stmt.executeUpdate(query);
	     				
	     					
	     					System.out.println("Successfully connected");	
	     				
	     		   }catch
	     			 (Exception ex){
	     				
	     					ex.printStackTrace();
	     			 }
	     		      		
	     		
	     		     }
	     	}
	  
}
