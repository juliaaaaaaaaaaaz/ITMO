package Classes;

import Classes.Building;
import Enumerations.TransportType;
import Interfaces.Movable;

import java.util.Objects;
import java.util.Random;

public class Transport implements Movable {
    private String name;
    private int id;
    private TransportType type;
    private boolean isBroken;
    private Building location;

    public Transport(String name, TransportType type, int id, Building location) {
        this.name = name;
        this.type = type;
        this.id = id;
        isBroken = false;
        this.location = location;
        location.addCar();
    }

    @Override
    public void move(Building location){
        Random rand = new Random();
        if (rand.nextInt(100) <= 50){
            broke();
            System.out.println(this + " не доехало до " + location + ", так как сломалось.");
            return;
        }
        this.location.removeCar();
        location.addCar();
        this.location = location;
        System.out.println(this + " направляется в " + location);
    }

    @Override
    public void move(Building location, int time) {
        Random rand = new Random();
        if (rand.nextInt(100) <= 50){
            broke();
            System.out.println(this + " не доехало до " + location + ", так как сломалось.");
            return;
        }

        if (location.isOpend(time)){
            System.out.println(this + " отправился в " + location + " и удачно прибыл туда");
            location.removeCar();
            this.location = location;
            location.addCar();
        } else{
            System.out.println(location + " закрыто, придется приехать в другое время");
        }
    }



    @Override
    public String toString() {
        return "транспортное средство " + name + " типа " + type.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return id == transport.id && Objects.equals(name, transport.name) && type == transport.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, type);
    }

    public void broke(){
        this.isBroken = true;
        System.out.println(this + " сломалось");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransportType getType() {
        return type;
    }

    public void setType(TransportType type) {
        this.type = type;
    }

    public boolean isBroken() {
        return isBroken;
    }


}
