package com.example.task14.model;



public class NullHandler extends Handler {
    public NullHandler() {
        super(null);
    }

    @Override
    public void handle(int result, Player player, SlotMachine slotMachine) {
        if (player.getCoins() <= 0) {
            System.out.println("Вы проиграли все монеты!");
        } else if (slotMachine.getCoins() <= 0) {
            System.out.println("Автомат проиграл все свои монеты!");
        }
    }
}
