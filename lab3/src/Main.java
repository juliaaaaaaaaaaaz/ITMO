import Classes.*;
import Enumerations.*;

public class Main {
    public static void main(String[] args) {
        Adult putin = new Adult("В. В. Путин", 71, "мужской", null, "президент", null, null);
        DwelingBuilding home = new DwelingBuilding("Кирова ул., д. 20 кв.57", putin, 12);
        WorkBuilding hospital = new WorkBuilding("Заречная ул., д. 22 ", putin, 45, ActivityType.HOSPITAL);
        Transport car = new Transport("машина мамы", TransportType.CAR, 2345, home);
        Transport ambulance = new Transport("машина скорой помощи", TransportType.CAR, 2346, hospital);
        Transport good_ambulance = new Transport("машина скорой помощи", TransportType.CAR, 2347, hospital);
        WorkBuilding office = new WorkBuilding("Набережная ул., д. 19", putin, 12, ActivityType.OFFICE);
        Adult mama = new Adult("мама", 37, "женский", home, "бухгалтер", car, office);
        Pet bimbo = new Pet("bimbo", mama, PetType.DOG, false);
        Child baby = new Child("Малыш", 7, "мужской", home, mama);
        Child betan = new Child("Бетан", 13, "женский", home, mama);
        Child bocce = new Child("Боссе", 15, "мужской", home, mama);
        baby.play(bimbo);
        betan.sick();
        baby.checkStatus(betan);
        ambulance.move(home);
        bocce.sick();
        baby.checkStatus(betan);
        ambulance.move(home, 7);
        bocce.move(hospital, 10);
        betan.move(hospital, 10);
    }
}