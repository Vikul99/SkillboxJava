import java.util.ArrayList;

public class ToDoList {

    private ArrayList<String> list = new ArrayList<>();

    public void list() {
        for (int i = 0; i < list.size(); ++i) {
            System.out.println(i + " - " + list.get(i));
        }
    }

    public void addElement(String str) {
        list.add(str);
    }

    public void addElement(int index, String str) {
        if (index > list.size()) {
            addElement(str);
        } else {
            list.add(index, str);
        }
    }

    public void edit(int index, String str) {
        if (index > list.size()) {
            addElement(str);
        } else {
            list.set(index, str);
        }
    }

    public void delete(int index) {
        list.remove(index);
    }
}
