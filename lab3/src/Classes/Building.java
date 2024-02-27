package Classes;

import java.util.Objects;

public abstract class Building {
    protected String address;
    protected Person owner;
    protected int personCount;
    protected int isCar;

    public Building(String address, Person owner){
        this.address = address;
        this.owner = owner;
        this.personCount = 0;
        isCar = 0;
    }
    public void addPerson(){
        personCount ++;
    }

    public void removePerson(){
        personCount --;
    }

    public void addCar(){
        isCar ++;
    }

    public void removeCar(){
        isCar --;
    }

    public abstract boolean isOpend(int time);
    @Override
    public String toString() {
        return "Здание по адресу " + address + " которым владеет " + owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return Objects.equals(address, building.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    public Person getOwner(){
        return owner;
    }
    public int getPersonCount(){
        return personCount;
    }
    public String getAddress(){
        return address;
    }
    public void setOwner(Person owner){
        if (owner instanceof Adult) {
            this.owner = owner;
        }
    }

    public int getIsCar() {
        return isCar;
    }

    public void setPersonCount(int personCount){
        if (personCount >= 0){
            this.personCount = personCount;
        }
    }
}
