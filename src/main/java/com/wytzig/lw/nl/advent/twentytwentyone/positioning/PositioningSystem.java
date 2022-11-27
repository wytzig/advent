package com.wytzig.lw.nl.advent.twentytwentyone.positioning;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PositioningSystem {
    private int x;  // the horizontal position
    private int y;  // the depth

    private void forward(int amount) {
        assert amount >= 0;
        this.x += amount;
    }

    private void down(int amount) {
        assert amount >= 0;
        this.y += amount;
    }

    private void up(int amount) {
        assert amount >= 0;
        this.y-=amount;
    }

    public void processOperation(Operations operation, Integer amount) {
        switch (operation) {
            case forward -> this.forward(amount);
            case down -> this.down(amount);
            case up -> this.up(amount);
        }
    }

    public void prettyPrint() {
        System.out.println("Our current horizontal(x) position is: " + x + " and our depth(y) is: " + y);
        System.out.println("positioning multiplication is: " + (x * y));
    }
}
