package Classes;

import Interfaces.IEmotion;
import Interfaces.Movable;

import java.util.Objects;

public abstract class Person implements IEmotion, Movable {
    protected String name;
    protected int age;
    protected String gender;
    protected boolean isSick;
    protected Building location;

    public Person(String name, int age, String gender, Building location) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.location = location;
        isSick = false;
    }

    public abstract void sick();
    public void checkStatus(Person person){
        if (person.getIsSick()){
            this.feelSad();
        }
    }
    public void cry(){
        System.out.println(this + " плачет");
    }

    @Override
    public void move(Building location, int time) {
        if (location.isOpend(time) && location.isCar > 0){
            System.out.println(this + " уедет на транспортном средстве в " + location + " и удачно прибыл туда");
            this.location.removePerson();
            this.location = location;
            location.addPerson();
        } else if (location.isOpend(time) && location.isCar == 0) {
            System.out.println(this + " идет пешком в " + location + " и удачно прибыл туда");
            this.location.removePerson();
            this.location = location;
            location.addPerson();
        }else{
            System.out.println(location + " закрыто, придется приехать в другое время");
            this.feelSad();
        }
    }
    @Override
    public void move(Building location){
        this.location = location;
        System.out.println(this + " отпраляется в " + location);
    }
    @Override
    public void feelHappy(){
        System.out.println(this + " счастлив, проблем нет, вокруг летают бабочки");
    }
    @Override
    public void feelSad(){
        System.out.println(this + " приуныл, ведь боится за своих любимых");
        this.cry();
    }
    @Override
    public void feelAngry(){
        System.out.println(this + "злится");
    }
    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name + age + " лет";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean getIsSick() {
        return isSick;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }

    public Building getLocation() {
        return location;
    }

    public void setLocation(Building location) {
        this.location = location;
    }
}
