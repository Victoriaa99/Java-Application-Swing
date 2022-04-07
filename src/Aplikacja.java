import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Aplikacja extends JFrame {

    private static DefaultTableModel model2;
    static List<TrainStation> listOfTrainStations;
    static DefaultTableModel model;

    public static void trainTable(int rowCount, String nazwaStacji){
        model2 = new DefaultTableModel();
        TrainStation current = null;

        for(TrainStation t : listOfTrainStations){
            if(t.getNazwa_s().equals(nazwaStacji))
                current = t;
        }
        JFrame frame = new JFrame();
        frame.setSize(600, 500);
        frame.setVisible(true);

        JButton btnAdd = new JButton("Dodaj");
        btnAdd.setBounds(180, 220, 100, 25);

        JButton btnRemove = new JButton("Usun");
        btnRemove.setBounds(180, 265, 100, 25);

        JButton btnChangeInfo = new JButton("Zmien parametry");
        btnChangeInfo.setBounds(180, 310, 100, 25);

        JTable table = new JTable();
        Object[] columns = {"Nazwa pociagu", "Ilosc wagonow", "Cena biletu", "Ilosc miejsc", "Czas przejazdu", "Stan pociagu"};
        model2.setColumnIdentifiers(columns);
        table.setModel(model2);

        for(Train t : current.getLista()){
            Object[] row = {t.getName(), t.getIlosc_w(), t.getPrice(), t.getNumber(), t.getShift_length(), t.getStan()};
            model2.addRow(row);
        }

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0,0,600,200);

        frame.setLayout(null);
        frame.add(btnAdd);
        frame.add(btnRemove);
        frame.add(btnChangeInfo);
        frame.add(pane);

        TrainStation finalCurrent = current;
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int currentCapacity = Integer.parseInt(String.valueOf(model.getValueAt(rowCount, 2)));
                int maxCapacity = Integer.parseInt(String.valueOf(model.getValueAt(rowCount, 1)));
                if(currentCapacity == maxCapacity){
                    JOptionPane.showMessageDialog(null, "Osiągnięto limit stacji!");
                    return;
                }
                Object[] row = new Object[6];
                row[0] = JOptionPane.showInputDialog("Wprowadź nazwę pociągu");
                row[1] = 3;
                row[2]  = 15;
                row[3]  = 80;
                row[4]  = JOptionPane.showInputDialog("Wprowadź czas przejazdu pociagu");
                row[5]  = JOptionPane.showInputDialog("Wprowadź stan pociagu");

                String nazwa = String.valueOf(row[0]);
                int iloscW = Integer.parseInt(String.valueOf(row[1]));
                int cena = Integer.parseInt(String.valueOf(row[2]));
                int iloscM = Integer.parseInt(String.valueOf(row[3]));
                int czas = Integer.parseInt(String.valueOf(row[4]));
                TrainCondition stan = TrainCondition.valueOf(String.valueOf(row[5]));


                finalCurrent.addTrain(new Train(nazwa, iloscM, cena, iloscW, stan, czas));

                currentCapacity++;
                model.setValueAt(currentCapacity,rowCount,2);
                model2.addRow(row);

            }
        });
        TrainStation finalCurrent1 = current;
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if(i >= 0){
                    int currentCapacity = Integer.parseInt(String.valueOf(model.getValueAt(rowCount, 2)));
                    for(Train t : finalCurrent1.getLista()){
                        if(t.getName().equals(String.valueOf(model2.getValueAt(i,0))));
                            finalCurrent1.removeTrain(t);
                            break;
                    }
                    currentCapacity--;
                    model.setValueAt(currentCapacity,rowCount,2);
                    model2.removeRow(i);

                }else{
                    JOptionPane.showMessageDialog(null,"Nie zaznaczono pociągu!");
                }
            }
        });
        TrainStation finalCurrent2 = current;
        btnChangeInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if(i >= 0){
                    int czas = Integer.parseInt(JOptionPane.showInputDialog("Wpisz czas przejazdu"));
                    int iloscM = Integer.parseInt(JOptionPane.showInputDialog("Wpisz ilośc miejsc"));


                    model2.setValueAt(czas,i,4); //czas przejazdu
                    model2.setValueAt(iloscM,i,3); //ilosc miejsc


                    for(Train t : finalCurrent2.getLista()){
                        if(t.getName().equals(String.valueOf(model2.getValueAt(i, 0)))){
                            t.setNumber(iloscM);
                            t.setShift_length(czas);
                        }
                    }

                }else{
                    JOptionPane.showMessageDialog(null,"Nie zaznaczono pociągu!");
                }
            }
        });
    }
    public Aplikacja() {

        listOfTrainStations = new ArrayList<>();
        model = new DefaultTableModel();

        JFrame frame = new JFrame();
        frame.setSize(600, 500);
        frame.setVisible(true);


        JTable table = new JTable();
        Object[] columns = new Object[]{"Nazwa stacji", "Maksymalna pojemność", "Obecna pojemność"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);


        JButton btnAdd = new JButton("Dodaj");
        JButton btnRemove = new JButton("Usun");
        JButton btnSortStations = new JButton("Sortuj");

        btnAdd.setBounds(180, 220, 100, 25);
        btnRemove.setBounds(180, 265, 100, 25);
        btnSortStations.setBounds(180, 310,100,25);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0,0, 500,200);

        frame.add(btnAdd);
        frame.add(btnRemove);
        frame.add(btnSortStations);

        frame.add(pane);

        frame.setResizable(false);
        //frame.getContentPane().setBackground(Color.darkGray);
        frame.setBounds(0,1,500,600);

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] row = new Object[3];
                row[0] = JOptionPane.showInputDialog("Wpisz nazwę stacji");
                row[1] = JOptionPane.showInputDialog("Wpisz maksymalną pojemność");
                row[2] = 0;

                if(row[0].equals("") || row[1].equals("")) {
                    JOptionPane.showMessageDialog(null, "Wykryto puste pole");
                }else {
                    String nazwa = String.valueOf(row[0]);
                    int max = Integer.parseInt(String.valueOf(row[1]));
                    listOfTrainStations.add(new TrainStation(nazwa,max));
                    model.addRow(row);
                }
            }
        });
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if(i >= 0){
                    model.removeRow(i);
                }
                else{
                    System.out.println("Niepoprawna operacja");
                }
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                if(i >= 0){

                    trainTable(i, String.valueOf(model.getValueAt(i,0)));
                }
            }
        });

        btnSortStations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comparator<TrainStation> compareByCapacity = (TrainStation t1, TrainStation t2) -> Integer.compare(t1.getCurrent(), t2.getCurrent());
                listOfTrainStations.sort(compareByCapacity);

                for(TrainStation t : listOfTrainStations){

                    model.removeRow(0);

                    Object[] row = {t.getNazwa_s(), t.getMax(), t.getCurrent()};
                    model.addRow(row);
                }
            }
        });


    }

    public static void main(String[] args) {
        Aplikacja app = new Aplikacja();
    }
}
