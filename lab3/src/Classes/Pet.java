package Classes;

import Classes.Building;
import Enumerations.PetType;
import Interfaces.*;

import java.util.Objects;

public class Pet implements IEmotion, Movable {
    private String name;
    private Person owner;
    private PetType type;
    private boolean isSleep;
    private Building location;

    public Pet(String name, Person owner, PetType type, boolean isSleep) {
        this.name = name;
        this.owner = owner;
        this.type = type;
        this.isSleep = isSleep;
    }

    @Override
    public void move(Building location){
        this.location = location;
        System.out.println(this + " перебегает в " + location);
    }
    @Override
    public void feelHappy(){
        System.out.println(this + " радостно виляет хвостом.");
    }
    @Override
    public void feelSad(){
        System.out.println(this + " приуныл.");
    }
    @Override
    public void feelAngry(){
        System.out.println(this + "злится.");
    }

    public void sleep(){
        isSleep = true;
        System.out.println(this + " заснул.");
    }

    @Override
    public void move(Building location, int time) {
        if (location.isOpend(time)){
            System.out.println(this + " отправился в " + location + " и удачно прибыл туда");
        } else{
            System.out.println(location + " закрыто, придется прибежать в другое время");
            this.feelSad();
        }
    }

    @Override
    public String toString() {
        return type + name + "у которого хозяин " + owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(name, pet.name) && Objects.equals(owner, pet.owner) && type == pet.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, owner, type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public boolean isSleep() {
        return isSleep;
    }

    public void setSleep(boolean sleep) {
        isSleep = sleep;
    }
}
