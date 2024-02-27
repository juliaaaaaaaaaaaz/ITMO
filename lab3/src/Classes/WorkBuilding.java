package Classes;

import Enumerations.ActivityType;

import java.util.Objects;

public class WorkBuilding extends Building {
    private int workerCount;
    private ActivityType purpose;

    @Override
    public boolean isOpend(int time) {
        if (time > 9 && time < 22)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return purpose + " по адресу " + address + " которым владеет " + owner;
    }

    public WorkBuilding(String address, Person owner, int workerCount, ActivityType purpose){
        super(address, owner);
        this.workerCount = workerCount;
        this.purpose = purpose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WorkBuilding that = (WorkBuilding) o;
        return workerCount == that.workerCount && purpose == that.purpose;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workerCount, purpose);
    }

    public int getWorkerCount(){
        return workerCount;
    }

    public ActivityType getPurpose(){
        return purpose;
    }
    public void setWorkerCount(ActivityType purpose){
        this.purpose = purpose;
    }
    public void setWorkerCount(int workerCount){
        if (workerCount >= 0){
            this.workerCount = workerCount;
        }
    }
}
