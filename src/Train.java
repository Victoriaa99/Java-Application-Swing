public class Train implements Comparable<Train>{
    private String name;
    private int number;
    private int price;
    private int ilosc_w;
    private TrainCondition stan;
    private int shift_length;

    public Train(String name, int number, int price, int ilosc_w, TrainCondition stan, int shift_length) {
        this.name = name;
        this.number = number;
        this.price = price;
        this.ilosc_w = ilosc_w;
        this.stan = stan;
        this.shift_length = shift_length;


    }

    public int getPrice() {
        return price;
    }

    public int getIlosc_w() {
        return ilosc_w;
    }

    public Train(){

    }

    public void wypisz(){
        System.out.println("Nazwa pociagu: " + this.name);
        System.out.println("Ilosc miejsc: " + this.number);
        System.out.println("Cena biletu: " + this.price);
        System.out.println("Ilosc wagonow: "+ this.ilosc_w);
        System.out.println("Stan pociagu: " + this.stan);
        System.out.println("Dlugosc zmiany: " + this.shift_length);
    }

    @Override
    public int compareTo(Train pociag) {
        if (this.name.equals(pociag.getName()))
            return 1;
        return 0;

    }
    public int compareTo(String pociag) {
        if (this.name.equals(pociag))
            return 1;
        return 0;

    }

    public String getName() {
        return name;
    }

    public TrainCondition getStan() {
        return stan;
    }

    public int getShift_length() {
        return shift_length;
    }


    public int getNumber() {
        return number;


    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setShift_length(int shift_length) {
        this.shift_length = shift_length;
    }
}
