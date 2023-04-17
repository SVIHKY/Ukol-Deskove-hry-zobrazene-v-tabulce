import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Zobrazeno extends JFrame {
    private JPanel panelMain;
    private JTable table;
    private JTextField textPole;
    private JCheckBox checkBox;
    private JButton pedchoziButton;
    private JButton dalsiButton;
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;

    int pocetStranke=0;
    private List<Deskovka> seznam = new ArrayList<>();
    private DeskovkyTableModel model;
    public Zobrazeno() {
        initTable();
       vypis(0);
        pedchoziButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pocetStranke--;
                vypis(pocetStranke);


            }
        });
        dalsiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SouborDeskovka deskovka = new SouborDeskovka();
                pocetStranke++;
                vypis(pocetStranke);
            }
        });
    }
    private void initTable() {
        SouborDeskovka souborDeskovka = new SouborDeskovka();
        seznam = souborDeskovka.vypisSoubor("deskovky.txt",";");
        model = new DeskovkyTableModel(seznam);
        table.setModel(model);
    }
        void vypis(int index) {
        SouborDeskovka souborDeskovka = new SouborDeskovka();
        seznam = souborDeskovka.vypisSoubor("deskovky.txt",";");
        if (index == seznam.size()-1){
            pedchoziButton.setEnabled(true);
            dalsiButton.setEnabled(false);
        } else if (index == 0) {
            pedchoziButton.setEnabled(false);
            dalsiButton.setEnabled(true);
        } else {
            pedchoziButton.setEnabled(true);
            dalsiButton.setEnabled(true);
        }
        Deskovka pocetSeznam = seznam.get(index);
        textPole.setText(pocetSeznam.getNazev());
        if(pocetSeznam.isZakoupeno()== true) {
            checkBox.setSelected(true);
        } else {
            checkBox.setSelected(false);
        }

        if(pocetSeznam.getOblibenost()==1) {
            a1RadioButton.setSelected(true);
            } else {
            a1RadioButton.setSelected(false);
            } if (pocetSeznam.getOblibenost()==2) {
            a2RadioButton.setSelected(true);
            } else {
            a2RadioButton.setSelected(false);
            } if (pocetSeznam.getOblibenost()== 3) {
            a3RadioButton.setSelected(true);
            } else {
            a3RadioButton.setSelected(false);
            }








        }


    public static void main(String[] args) {
        Zobrazeno zobrazeno = new Zobrazeno();
        zobrazeno.setContentPane(zobrazeno.panelMain);
        zobrazeno.setTitle("Ukol");
        zobrazeno.pack();
        zobrazeno.setVisible(true);
        zobrazeno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(zobrazeno.a1RadioButton);
        btnGroup.add(zobrazeno.a2RadioButton);
        btnGroup.add(zobrazeno.a3RadioButton);
    }
}
