package org.example.Entities;

import org.example.Enums.Action;

public class Cooperator extends Player {
    @Override
    public Action chooseAction() {
        return Action.COOPERATE;
    }
}
