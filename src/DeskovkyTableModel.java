import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DeskovkyTableModel extends AbstractTableModel {
    private List<Deskovka> seznam;

    public DeskovkyTableModel(List<Deskovka> seznam) {
        this.seznam = seznam;
    }

    @Override
    public int getRowCount() {
        return seznam.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Deskovka deskovka = seznam.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return deskovka.getNazev();
            case 1:
                return deskovka.isZakoupeno();
            case 2:
                return deskovka.getOblibenost();
            default:
                throw new IllegalArgumentException("Neplatný index sloupce: " + columnIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Název";
            case 1:
                return "Zakoupeno";
            case 2:
                return "Oblíbenost";
            default:
                throw new IllegalArgumentException("Neplatný index sloupce: " + columnIndex);
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Boolean.class;
            case 2:
                return Integer.class;
            default:
                throw new IllegalArgumentException("Neplatný index sloupce: " + columnIndex);
        }
    }

    public Deskovka getDeskovkaAt(int rowIndex) {
        return seznam.get(rowIndex);
    }
}