package Interfaces;

import Classes.Building;

public interface Movable {
    void move(Building location);
    void move(Building location, int time);

}
