package control;

import javax.swing.table.DefaultTableModel;
import model.CounterTag;
import model.NodeList;

public class TagCounterList {

    private LinkedList<CounterTag> list = new LinkedList<>();

    public void addOrIncrement(String tagName) {
        NodeList<CounterTag> actual = list.getFirst();

        while (actual != null) {
            if (actual.getInfo().getName().equalsIgnoreCase(tagName)) {
                actual.getInfo().increment();
                return;
            }
            actual = actual.getNext();
        }

        list.insert(new CounterTag(tagName));
    }

    public void order() {
        int n = list.getLength();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                CounterTag a = list.getNode(i).getInfo();
                CounterTag b = list.getNode(j).getInfo();

                if (a.getName().compareToIgnoreCase(b.getName()) > 0) {
                    list.getNode(i).setInfo(b);
                    list.getNode(j).setInfo(a);
                }
            }
        }
    }

    public DefaultTableModel insertTableRows(DefaultTableModel tableModel) {
        order();
        NodeList<CounterTag> actual = list.getFirst();

        while (actual != null) {
            tableModel.addRow(new Object[]{actual.getInfo().getName(), actual.getInfo().getCount()});
            actual = actual.getNext();
        }

        return tableModel;
    }

    public boolean isEmpty() {
        return list.getFirst() == null;
    }
}
