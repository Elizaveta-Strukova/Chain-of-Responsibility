package com.example.task14;

import com.example.task14.model.Player;
import com.example.task14.model.SlotMachine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public Label systemLabel, statusLabel, machineMoney, playerMoney;
    @FXML
    public ImageView Bag1, Bag2, Bag3;
    private SlotMachine slotMachine;
    private Player player;

    public void OnStart(ActionEvent actionEvent) {
        Image image1 = new Image("bag.png");
        Bag1.setImage(image1);
        Bag2.setImage(image1);
        Bag3.setImage(image1);
        UpdatingPointsOnScreen();
        systemLabel.setText("Выберите мешок!");
    }

    public void OnEnd(ActionEvent actionEvent) {
        systemLabel.setText("Игра окончена!");
    }

    public void OnMouseClick(MouseEvent event) {
        if (player.getCoins() <= 0) {
            systemLabel.setText("Нет монет!\nДля продолжения игры купите монеты");
            statusLabel.setVisible(false);
            return;
        }

        int result = slotMachine.play(player);
        UpdatingPointsOnScreen();
        if (result >= 7) {
            statusLabel.setVisible(true);
            statusLabel.setText("Вы выиграли!");
            Image image = new Image("coin.png");
            Bag1.setImage(image);
            Bag2.setImage(image);
            Bag3.setImage(image);
        } else {
            statusLabel.setVisible(true);
            statusLabel.setText("Вы проиграли!\nВыберите мешок для продолжения игры");
            Image image = new Image("bag.png");
            Bag1.setImage(image);
            Bag2.setImage(image);
            Bag3.setImage(image);
        }
    }

    public void addMoney(ActionEvent actionEvent) {
        player.addCoins(100);
        UpdatingPointsOnScreen();
        systemLabel.setText("Выберите мешок!");
    }

    private void UpdatingPointsOnScreen() {
        playerMoney.setText(String.valueOf(player.getCoins()));
        machineMoney.setText(String.valueOf(slotMachine.getCoins()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        slotMachine = new SlotMachine(100);
        player = new Player(100);
        systemLabel.setText("Начните игру!");
    }
}