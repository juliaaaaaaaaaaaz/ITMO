package Classes;

import java.util.Objects;

public class Child extends Person{
    private Adult parent;

    public Child(String name, int age, String gender,
                 Building location, Adult parent) {
        super(name, age, gender, location);
        this.parent = parent;
    }


    @Override
    public void sick() {
        System.out.println(this + " поразила ужасная болезнь");
        this.setSick(true);
        this.feelSad();
        parent.callAmbulance();
    }

    public void play(Pet pet){
        if (!pet.isSleep()) {
            System.out.println(this + " играет с питомцем");
            this.feelHappy();
        }else{
            this.feelSad();
        }
    }

    @Override
    public String toString() {
        return name + " " + age + " лет";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Child child = (Child) o;
        return Objects.equals(parent, child.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), parent);
    }

    public Adult getparent() {
        return parent;
    }

    public void setparent(Adult parent) {
        this.parent = parent;
    }
}
