package Classes;

import Classes.Building;

import java.util.Objects;

public class DwelingBuilding extends Building {
    private int dwellerCount;

    public DwelingBuilding(String address, Person owner, int dwellerCount){
        super(address, owner);
        this.dwellerCount = dwellerCount;
    }
    @Override
    public boolean isOpend(int time) {
        return true;
    }
    @Override
    public String toString() {
        return "Жилой дом по адресу " +  address + " которым владеет " + owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DwelingBuilding that = (DwelingBuilding) o;
        return dwellerCount == that.dwellerCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dwellerCount);
    }

    public int getDwellerCount() {
        return dwellerCount;
    }

    public void setDwellerCount(int dwellerCount) {
        if (dwellerCount >= 0) {
            this.dwellerCount = dwellerCount;
        }
    }
}
