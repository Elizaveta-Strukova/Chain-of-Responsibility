package com.example.task14.model;

import com.example.task14.model.Handler;
import com.example.task14.model.NegativeHandler;
import com.example.task14.model.PositiveHandler;
import com.example.task14.model.NullHandler;

import java.util.Random;

public class SlotMachine {
    private int coins;
    private final Handler handler;

    public SlotMachine(int coins) {
        this.coins = coins;
        this.handler = new PositiveHandler(new NegativeHandler(new NullHandler()));
    }
    public int getCoins() {
        return coins;
    }

    public void addCoins(int coins) {
        this.coins += coins;
    }

    public void removeCoins(int coins) {
        if (this.coins >= coins) {
            this.coins -= coins;
        } else {
            System.out.println("В автомате недостаточно монет!");
        }
    }

    public int play(Player player) {
        int result = spin();
        handler.handle(result, player, this);
        return result;
    }

    private int spin() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
