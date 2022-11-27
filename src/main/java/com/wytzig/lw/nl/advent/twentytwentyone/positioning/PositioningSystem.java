package com.wytzig.lw.nl.advent.twentytwentyone.positioning;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PositioningSystem {
    private int x;  // the horizontal position
    private int y;  // the depth

    private int aim;

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

    public void processOperationSimpleOperation(Operations operation, Integer amount) {
        switch (operation) {
            case forward -> this.forward(amount);
            case down -> this.down(amount);
            case up -> this.up(amount);
        }
    }

    public void processComplexOperation(Operations operation, Integer amount) {
        switch (operation) {
            case forward -> {
                this.x += amount;
                this.y += (aim * amount);
            }
            case down -> {
                this.aim += amount;
            }
            case up -> {
                this.aim -= amount;
            }
        }
    }

    public void prettyPrint() {
        System.out.println("Our current horizontal(x) position is: " + x + " and our depth(y) is: " + y);
        System.out.println("positioning multiplication is: " + (x * y));
    }
}
