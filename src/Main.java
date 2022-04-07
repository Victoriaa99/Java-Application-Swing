import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //TrainCondition tc = TrainCondition.NEW;
        //System.out.println(tc);
        //int[] tab = {2, 4, 6, 9 ,3};
        //for(Integer num : tab){
        //    System.out.println(num);
        //}
        /*String a = "alamakota";
        System.out.println(a.contains("ma"));
        List<Train> lista = new ArrayList<>();
        Train t1 = new Train();
        Train t2 = new Train();
        Train t3 = new Train();
        //t3.compareTo(t1);
        lista.add(t1);
        lista.add(t2);
        lista.add(t3);
        System.out.println(lista);
        lista.remove(t2);
        System.out.println(lista);
        */
        Train t1 = new Train("EuroCity", 30, 10, 3, TrainCondition.NEW, 7);
        Train t0 = new Train("EuroTown", 30, 10, 3, TrainCondition.NEW, 7);
        Train t2 = new Train("AtlantaCity", 20, 15, 2, TrainCondition.LATE, 6);
        Train t3 = new Train("Inter", 50, 20, 5, TrainCondition.BROKEN, 8);

        TrainStation krakow = new TrainStation("Krakow", 5);
        krakow.addTrain(t1);
        krakow.addTrain(t2);
        krakow.addTrain(t3);
        krakow.addTrain(t0);

        //krakow.wypiszStanStacji();
        //krakow.printAllTrains();
        //krakow.reduceTrainNumber(t2);
        //krakow.wypiszStanStacji();

        //krakow.removeTrain(t3);
        //krakow.wypiszStanStacji();
        //krakow.printAllTrains();

        /*Train train = krakow.search("Inter");
        train.wypisz();

        System.out.println("Pociągi z \"City\" w nazwie");
        List<Train> mojaLista = new ArrayList<>(krakow.przyjmij("City"));
        for(Train trainExample : mojaLista){
            trainExample.wypisz();
        }*/
        /*
        int n = krakow.zwroc_ilosc(TrainCondition.NEW);
        System.out.println(n);
        List<Train> myList = new ArrayList<>(krakow.sortedByName());
        for(Train trainExample : myList){
            trainExample.wypisz();
        }*/
        //Train train = krakow.max_shift();
        //train.wypisz();
        TrainStationContainer tsc = new TrainStationContainer();
        tsc.addNewStation("Warszawa", 8);
        tsc.addNewStation("Gdańsk", 10);
        tsc.wypisz_stacje();
        List<TrainStation> lista = new ArrayList<>(tsc.emptyTrainStation());
        for(TrainStation trainExample : lista){
            trainExample.wypiszStanStacji();
        }




    }
}
