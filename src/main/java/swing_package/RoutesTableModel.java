package swing_package;

import javax.swing.table.AbstractTableModel;
import java.net.NoRouteToHostException;
import java.util.LinkedList;

public class RoutesTableModel extends AbstractTableModel{

    private LinkedList<String []> dataLinkedList;

    public RoutesTableModel(){
        dataLinkedList = new LinkedList<String[]>();
        for(int i = 0; i < dataLinkedList.size(); i++){
            dataLinkedList.add(new String[getColumnCount()]);
        }
    }

    @Override
    public int getRowCount() {
        return dataLinkedList.size();
    }

    @Override
    public String getColumnName(int columnIndex){
        switch (columnIndex){
            case 0: return "user_name";
            case 1: return "id";
            case 2: return "name";
            case 3: return "coordinate_x";
            case 4: return "coordinate_y";
            case 5: return "creationDate";
            case 6: return "from_x";
            case 7: return "from_y";
            case 8: return "from_z";
            case 9: return "from_name";
            case 10: return "to_x";
            case 11: return "to_y";
            case 12: return "to_z";
            case 13: return "to_name";
            case 14: return "distance";
        }
        return "";
    }

    @Override
    public int getColumnCount() {
        return 15;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String rows[] = dataLinkedList.get(rowIndex);
        return rows[columnIndex];
    }

    public void addDate(String row[]){
        String []rawTable = new String[getColumnCount()];
        rawTable = row;
        dataLinkedList.add(rawTable);
    }
}
