package Classes;

import java.util.Objects;

public class Adult extends Person{
    private String profession;
    private Transport transport;
    private WorkBuilding workPlace;

    public Adult(String name, int age, String gender,
                 Building location, String profession,
                 Transport transport, WorkBuilding workPlace) {
        super(name, age, gender, location);
        this.profession = profession;
        this.transport = transport;
        this.workPlace = workPlace;
    }


    public void callAmbulance(){
        System.out.println(this + " вызывает скорою");
    }
    @Override
    public void sick() {
        isSick = true;
        this.feelSad();
        this.callAmbulance();
    }

    public void goToWork(){
        location = workPlace;
    }

    @Override
    public String toString() {
        return name + " с профессией " + profession + ", " + age + " лет";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Adult adult = (Adult) o;
        return Objects.equals(profession, adult.profession) && Objects.equals(transport, adult.transport) && Objects.equals(workPlace, adult.workPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), profession, transport, workPlace);
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public WorkBuilding getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(WorkBuilding workPlace) {
        this.workPlace = workPlace;
    }
}
