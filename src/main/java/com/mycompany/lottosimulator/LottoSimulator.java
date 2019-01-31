package com.mycompany.lottosimulator;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LottoSimulator extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    //Counting times one has played
    int totalgamesplayed = 0;
     //Counting sum of wins over several games 
     int winsumeuro = 0;
     //result label
     Label result;
     //Array for how many different numbers the user has given pro guess
      ArrayList<Integer> diffNum = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        Label infotext = new Label("\nThis is a lotto simulator. Pick 7 numbers between 1 and 35 and insert them below.\n Press submit and see if you won!");
        infotext.setAlignment(Pos.CENTER);
        
        //Text Fields for the users lotto row
        TextField n1 = new TextField();
        TextField n2 = new TextField();
        TextField n3 = new TextField();
        TextField n4 = new TextField();
        TextField n5 = new TextField();
        TextField n6 = new TextField();
        TextField n7 = new TextField();

        n1.setMaxWidth(50);
        n2.setMaxWidth(50);
        n3.setMaxWidth(50);
        n4.setMaxWidth(50);
        n5.setMaxWidth(50);
        n6.setMaxWidth(50);
        n7.setMaxWidth(50);
        //Label that will show result of the game
        result = new Label();

        Button button = new Button("Submit!");

        //Users lotto row in HBox
        HBox boxie = new HBox();
        boxie.getChildren().addAll(n1, n2, n3, n4, n5, n6, n7);
        boxie.setAlignment(Pos.CENTER);
        boxie.setSpacing(5);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(button,result);
        vbox.setAlignment(Pos.CENTER);

        //Border Pane for all content
        BorderPane borre = new BorderPane();
        borre.setTop(infotext);
        borre.setCenter(boxie);
        borre.setBottom(vbox);
        
         //List for the correct lotto row
        ArrayList<Integer> rightLottoNumbers = new ArrayList<>();
        

        button.setOnAction(e -> {
            try {
                Random rande = new Random();
                 //Counting amount of right numbers
         int correctguesses = 0;         

                //Creating the correct lotto row
                int ri1 = 1 + rande.nextInt(36);
                int ri2 = 1 + rande.nextInt(36);
                int ri3 = 1 + rande.nextInt(36);
                int ri4 = 1 + rande.nextInt(36);
                int ri5 = 1 + rande.nextInt(36);
                int ri6 = 1 + rande.nextInt(36);
                int ri7 = 1 + rande.nextInt(36);
                //adding the correct numbers to the list
                rightLottoNumbers.add(ri1);
                rightLottoNumbers.add(ri2);
                rightLottoNumbers.add(ri3);
                rightLottoNumbers.add(ri4);
                rightLottoNumbers.add(ri5);
                rightLottoNumbers.add(ri6);
                rightLottoNumbers.add(ri7);
              

                //Getting int values of user lotto row
                int u1 = Integer.valueOf(n1.getText());
                int u2 = Integer.valueOf(n2.getText());
                int u3 = Integer.valueOf(n3.getText());
                int u4 = Integer.valueOf(n4.getText());
                int u5 = Integer.valueOf(n5.getText());
                int u6 = Integer.valueOf(n6.getText());
                int u7 = Integer.valueOf(n7.getText());
                
                //Check if same number is given several times
                int[]usersNumbers = new int[7];
                usersNumbers[0]=u1;
                usersNumbers[1]=u2;
                usersNumbers[2]=u3;
                usersNumbers[3]=u4;
                usersNumbers[4]=u5;
                usersNumbers[5]=u6;
                usersNumbers[6]=u7;
                                               
                for(int i=0;i<usersNumbers.length;i++){
                    if (!diffNum.contains(usersNumbers[i])){
                        diffNum.add(usersNumbers[i]);                        
                    }
                }
                for(int i=0;i<usersNumbers.length;i++){
                    usersNumbers[i]=0;
                }
                

                //Counting amount of times the user guessed right 
                if (rightLottoNumbers.contains(u1)) {
                    correctguesses++;
                }
                if (rightLottoNumbers.contains(u1)) {
                    correctguesses++;
                }
                if (rightLottoNumbers.contains(u2)) {
                    correctguesses++;
                }
                if (rightLottoNumbers.contains(u3)) {
                    correctguesses++;
                }
                if (rightLottoNumbers.contains(u4)) {
                    correctguesses++;
                }
                if (rightLottoNumbers.contains(u5)) {
                    correctguesses++;
                }
                if (rightLottoNumbers.contains(u6)) {
                    correctguesses++;
                }
                if (rightLottoNumbers.contains(u7)) {
                    correctguesses++;
                }
                if(correctguesses==3){
                    winsumeuro=winsumeuro +rande.nextInt(4);
                }
                if(correctguesses==4){
                    winsumeuro=winsumeuro + rande.nextInt((20 - 8) + 1) + 8;
                }
                if(correctguesses==5){
                    winsumeuro=winsumeuro +rande.nextInt((200 - 40) + 1) + 40;
                }
                if(correctguesses==6){
                    winsumeuro=winsumeuro +rande.nextInt((100000 - 8000) + 1) + 8000;
                }
                if(correctguesses==7){
                    winsumeuro=winsumeuro +rande.nextInt((1000000 - 150000) + 1) + 150000;
                }
             totalgamesplayed++;
             
             //Check that user gives number that can be drawn (0>integer <36)
             if(u1>35|u1<0|u2>35|u2<0|u3>35|u3<0|u4>35|u4<0|u5>35|u5<0|u6>35|u6<0|u7>35|u7<0){
                 loserText();
             } else if(diffNum.size()<7){
               loserText();
             } 
             //If everything is OK -> Print result text
             else{           
                result.setText("\n"+Fresulttext(correctguesses)+winsumeuro+"\nAmount of games played: "+totalgamesplayed+"\nThe right numbers were: "+rightLottoNumbers); 
             }
            
            rightLottoNumbers.clear();
            diffNum.clear();
            //Check that input are integers
            } catch (NumberFormatException el) {
                result.setText("\nCould not give action, input was not an integer!");
                 rightLottoNumbers.clear();
                 diffNum.clear();
            }
        });

        Scene scene = new Scene(borre, 600, 400);

        stage.setScene(scene);
        stage.setTitle("Lotto Simulator");
        stage.show();
    }
    //Function for part of the result text
    private String Fresulttext(int correctnumber){
        StringBuilder st = new StringBuilder();
        String intro = "YOUR RESULT:\n";
        st.append(intro);
        st.append(correctnumber);
        st.append(" correct guess(es)");
        if(correctnumber<3){
            st.append("\nYou won 0 €");
        }
        else if(correctnumber==3){
            st.append("\nYou won 2 €");
        }
        else if(correctnumber==4){
            st.append("\nYou won 10 €");
        }
        else if(correctnumber==5){
            st.append("\nYou won 50 €");
        }
        else if(correctnumber==6){
            st.append("\nYou won 3000 €");
        }
        else if(correctnumber==5){
            st.append("\nYou won 180 000 €");
        }
        st.append("\nTotal win so far is: ");
        
        return st.toString();
    }
    //function for text when user has chosen integers that cannot be drawn
    private void loserText(){
        result.setText("\nYou chose at least on number lower than 1 or higher than 35.\n"
                + "Alternatively, not all your numbers were unique.\n"
                + "Not so smart if you want to have a chance to win...\n"
                + "Change numbers and try again!");
    }
    
  

}
