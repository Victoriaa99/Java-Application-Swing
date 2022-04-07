import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TrainStation implements Comparator<Train> {
    private String nazwa_s;
    private int max;
    private List<Train> lista;
    private int current;

    public TrainStation(String nazwa_s, int max){
        this.nazwa_s = nazwa_s;
        this.max = max;
        this.lista = new ArrayList<Train>();
        this.current = 0;

    }

    public int getMax() {
        return max;
    }

    public List<Train> getLista() {
        return lista;
    }

    public void addTrain(Train t){
        if(max ==  current){
            System.err.println("Osiagnieto maksymalna pojemnosc stacji!");
        }else{
            System.out.println("Dodano pociag "+t.getName()+" do listy");
            lista.add(t);
            current++;
        }

    }
    public void reduceTrainNumber(Train t){
        if(t.getStan().equals(TrainCondition.LATE) || t.getStan().equals(TrainCondition.BROKEN)){
            current--;
            if(current == 0){
                lista.remove(t);
            }
        }
    }
    public void removeTrain(Train t){
        lista.remove(t);
        current--;
    }

    @Override
    public int compare(Train o1, Train o2) {
        return o1.compareTo(o2);
    }

    public int compare(Train o1, String o2) {
        return o1.compareTo(o2);
    }

    public Train search(String s){
        for(int i = 0; i < lista.size(); i++){
            if(compare(lista.get(i), s) == 1){
                return lista.get(i);
            }
        }
        return null;

    }
    public List<Train> przyjmij(String s){
        List<Train> lista_pociagow = new ArrayList<Train>();
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getName().contains(s))
            lista_pociagow.add(lista.get(i));

        }
        return lista_pociagow;

    }
    public int zwroc_ilosc(TrainCondition stan){
        int counter = 0;
        for(int i = 0; i < lista.size(); i++){
            if(stan.equals(lista.get(i).getStan()))
                counter++;
        }
        return counter;
    }

    public void printAllTrains(){

        for(int i = 0; i < lista.size(); i++){
            lista.get(i).wypisz();
            System.out.println();
        }
    }

    public List<Train> sortedByName(){
        List<Train> sortedByNameList = new ArrayList<>(lista);
        Comparator<Train> compareByName = (Train t1, Train t2) -> t1.getName().compareTo(t2.getName());
        Collections.sort(sortedByNameList, compareByName);
        return sortedByNameList;
    }
    public List<Train> sortedByCapacity(){
        List<Train> sortedByCapacityList = new ArrayList<>(lista);
        Comparator<Train> compareByCapacity  = (Train t1, Train t2) -> Integer.compare(t1.getNumber(), t2.getNumber());
        Collections.sort(sortedByCapacityList, compareByCapacity.reversed());
        return sortedByCapacityList;
    }
    public Train max_shift(){
        Comparator<Train> compareByShiftLength = (Train t1, Train t2) -> Integer.compare(t1.getShift_length(), t2.getShift_length());
        return Collections.max(lista, compareByShiftLength);
    }

    public int getCurrent() {
        return current;
    }

    public String getNazwa_s() {
        return nazwa_s;
    }
    public void wypiszStanStacji(){
        System.out.println("Stacja " + nazwa_s);
        System.out.println("Obecna liczba pociągów: " + current);
    }
}
