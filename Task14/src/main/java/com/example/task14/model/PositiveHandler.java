package com.example.task14.model;

import com.example.task14.model.Player;
import com.example.task14.model.SlotMachine;

public class PositiveHandler extends Handler {
    public PositiveHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(int result, Player player, SlotMachine slotMachine) {
        if (result >= 7) {
            player.addCoins(10);
            slotMachine.removeCoins(10);
            if (player.getCoins() >= 10) {
                System.out.println("");
            } else {
                getProcessor().handle(result, player, slotMachine);
            }
        } else {
            getProcessor().handle(result, player, slotMachine);
        }
    }
}
