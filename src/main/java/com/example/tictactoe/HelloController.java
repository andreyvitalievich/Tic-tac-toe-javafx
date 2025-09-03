package com.example.tictactoe;

import java.net.URL;
import java.util.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class HelloController {

    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public Button btn5;
    public Button btn6;
    public Button btn7;
    public Button btn8;
    public Button btn9;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    private char nowsym = 'X';
    private char walks[][] = new char[3][3];
    @FXML
    void btnClick(ActionEvent event) {
        List<Button> buttons = new ArrayList<>();
        buttons.addAll(Arrays.asList(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8));
        Collections.shuffle(buttons);
        Button btn = (Button) event.getSource();
        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        int colIndex = GridPane.getColumnIndex(btn) ==  null ? 0 : GridPane.getColumnIndex(btn);
        boolean draw = true;
        // Checking if the same button is pressed
        if (btn.getText().equals("X") || btn.getText().equals("0")) {

        } else {
            walks[rowIndex][colIndex]='X';
            btn.setText(String.valueOf(walks[rowIndex][colIndex]));
            System.out.println(rowIndex);
            System.out.println(colIndex);

            //Finding an empty button
            for (Button b : buttons) {
                if (b.getText() == null || b.getText().isEmpty()) {
                    b.setText("0");
                    int rowIndexS = GridPane.getRowIndex(b) == null ? 0 : GridPane.getRowIndex(b);
                    int colIndexS = GridPane.getColumnIndex(b) ==  null ? 0 : GridPane.getColumnIndex(b);
                    walks[rowIndexS][colIndexS] = '0';
                    break;
                }
            }
        }
        // Checking rows
        for (int i = 0; i < 3; i++) {
            if(walks[i][0]!='\0' && walks[i][0] == walks[i][1] && walks[i][1] == walks[i][2]) {
                if(walks[i][1] == 'X'){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вы победитель!");
                    alert.showAndWait();
                    Platform.exit();
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вы проиграли!" );
                    alert.showAndWait();
                    Platform.exit();
                }
            }
        }
        // Checking the columns
        for (int i = 0; i < 3; i++) {
            if(walks[0][i]!='\0' && walks[0][i] == walks[1][i] && walks[1][i] == walks[2][i]) {
                if(walks[0][i] == 'X'){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вы победитель!");
                    alert.showAndWait();
                    Platform.exit();
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вы проиграли!" );
                    alert.showAndWait();
                    Platform.exit();
                }
            }
        }
        // Diagonal check \
        if (walks [0][0]!='\0' && walks[0][0] == walks[1][1] && walks[1][1] == walks[2][2]) {
            if(walks[0][0] == 'X'){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вы победитель!");
                alert.showAndWait();
                Platform.exit();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вы проиграли!" );
                alert.showAndWait();
                Platform.exit();
            }
        }
        //Diagonal check /
        if(walks [0][2]!='\0' && walks[0][2] == walks[1][1] && walks[1][1] == walks[2][0]) {
            if(walks[0][0] == 'X'){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вы победитель!");
                alert.showAndWait();
                Platform.exit();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вы проиграли!" );
                alert.showAndWait();
                Platform.exit();
            }
        }
        // Checking whether all elements of the array are filled
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (walks[i][j] == '\0'){
                    draw = false;
                    break;
                }
            }
        }
        // If all elements are filled
        if(draw){

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ничья!");
            alert.showAndWait();
            Platform.exit();

        }
    }

    @FXML
    void initialize() {

    }

}
