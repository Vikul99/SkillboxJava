import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToDoList {

    private List<String> list = new ArrayList<String>();

    public List<String> list() {
        return Collections.unmodifiableList(list);
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
        if (index > list.size()) {
            list.remove(list.size() - 1);
        } else {
            list.remove(index);
        }
    }
}
