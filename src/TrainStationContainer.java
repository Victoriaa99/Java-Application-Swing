import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainStationContainer {
    private Map<String, TrainStation> stacje_kolejowe;

    public TrainStationContainer() {
        this.stacje_kolejowe = new HashMap<>();
    }

    public void addNewStation(String s, int max){
        TrainStation ts = new TrainStation(s, max);
        stacje_kolejowe.put(s, ts);
    }
    public void removeStation(String s){
        stacje_kolejowe.remove(s);
    }
    public List<TrainStation> emptyTrainStation(){
        List<TrainStation> lista_pustych_stacji = new ArrayList<>();
        for(String key : stacje_kolejowe.keySet()){
            TrainStation stacja = stacje_kolejowe.get(key);
            if(stacja.getCurrent() == 0)
                lista_pustych_stacji.add(stacja);
        }
        return lista_pustych_stacji;
    }
    public void wypisz_stacje() {
        for (String key : stacje_kolejowe.keySet()) {
            TrainStation stacja = stacje_kolejowe.get(key);
            System.out.println("Nazwa stacji: " + stacja.getNazwa_s());
            System.out.println("Obciazenie: " + stacja.getCurrent());
        }
    }
}
