import java.util.Objects;
import java.util.Arrays;

public class SimpleTask extends Task {
    protected String title;

    public SimpleTask(int id, String title) {
        super(id); // вызов родительского конструктора
        this.title = title; // заполнение своих полей
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleTask that = (SimpleTask) o;
        return Objects.equals(title, that.title);
    }

    public boolean matches(String query) {
        return title.contains(query);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title);
    }
}



