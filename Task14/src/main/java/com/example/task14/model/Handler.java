package com.example.task14.model;

import com.example.task14.model.Player;
import com.example.task14.model.SlotMachine;

public abstract class Handler {
    private Handler processor;

    public Handler(Handler processor){
        this.processor = processor;
    }

    public abstract void handle(int result, Player player, SlotMachine slotMachine);

    public Handler getProcessor() {
        return processor;
    }
}
