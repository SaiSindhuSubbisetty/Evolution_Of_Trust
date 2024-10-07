package org.example.Entities;

import org.example.Enums.Action;

public class Cheater extends Player {
    @Override
    public Action chooseAction() {
        return Action.CHEAT;
    }
}
