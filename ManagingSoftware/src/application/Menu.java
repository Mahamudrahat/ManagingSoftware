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

public class Menu extends Button  {
		Button b1=new Button("Update User");
		Button b2=new Button("Update Project");
		Button b3=new Button("Assign Resource Person");
		Button b4=new Button("View All Projects");
		Button b5=new Button("Project Details");
		Button b6=new Button("Update Task");
		Button b7=new Button("Add Comment");
		Button b8=new Button("View Comments of Task");
		//Button b9=new Button("Add newUser");
		Button b10=new Button("Close");
		Button b11=new Button("Logout");
		public void menu(){
			Pane pane=new Pane();
			pane.setPrefSize(650, 650);
			b1.relocate(200,100);
			b1.setPrefSize(200, 50);
			b2.relocate(200,150);
			b2.setPrefSize(200, 50);
			b3.relocate(200,200);
			b3.setPrefSize(200, 50);
			b4.relocate(200,250);
			b4.setPrefSize(200, 50);
			b5.relocate(200,300);
			b5.setPrefSize(200, 50);
			b6.relocate(200,350);
			b6.setPrefSize(200, 50);
			b7.relocate(200,400);
			b7.setPrefSize(200, 50);
			b8.relocate(200,450);
			b8.setPrefSize(200, 50);
			//b9.relocate(200,500);
			//b9.setPrefSize(200, 50);
			b10.relocate(200,600);
			b10.setPrefSize(100, 50);
			b11.relocate(350,600);
			b11.setPrefSize(100, 50);
			pane.getChildren().addAll(b1,b2,b3,b4,b5,b6,b7,b8,b10,b11);
		
			Stage stage=new Stage();
			Scene scene=new Scene(pane);
			stage.setScene(scene);
			stage.show();
			b1.setOnAction(e1->{
				UpdateUser b1=new UpdateUser();
				b1.Updateuser();
			});
			b2.setOnAction(e1->{
				UpdateProject b2=new UpdateProject();
				b2.UpdateProject();
			});
			b3.setOnAction(e1->{
				AssignResource b3=new AssignResource();
				b3.Resource();
			});
			b4.setOnAction(e1->{
				VeiwProject b3=new VeiwProject();
				b3.project();
			});
			b6.setOnAction(e1->{
				UpdateTask b3=new UpdateTask();
				b3.Task();
			});
			b7.setOnAction(e1->{
				AddComment b3=new AddComment();
				b3.Comment();
			});
			b8.setOnAction(e1->{
				ViewComment b3=new ViewComment();
				b3.View();
			});
		}

}
