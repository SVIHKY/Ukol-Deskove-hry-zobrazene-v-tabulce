import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SouborDeskovka {

   private List<Deskovka> deskovkaList = new ArrayList<>();

    protected List<Deskovka> vypisSoubor(String nazevSouboru, String oddelovac) {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(nazevSouboru)));
            while (sc.hasNextLine()) {
                String radek = sc.nextLine();
                String[] polozka = radek.split(oddelovac);
                String nazev = polozka[0];
                Boolean zakoupeno = Boolean.parseBoolean(polozka[1]);
                int oblibenost = Integer.parseInt(polozka[2]);
                deskovkaList.add(new Deskovka(nazev, zakoupeno, oblibenost));

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return new ArrayList<>(deskovkaList);
    }

    public List<Deskovka> pocetSouboru() {
       deskovkaList.size();
       return new ArrayList<>(deskovkaList);
    }
}
