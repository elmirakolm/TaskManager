import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnMatchingTasksForQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {simpleTask};
        Task[] actual = todos.search("родителям");
        Assertions.assertArrayEquals(expected, actual);


        expected = new Task[]{epic};
        actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);


        expected = new Task[]{meeting};
        actual = todos.search("Выкатка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayForNonMatchingQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {};
        Task[] actual = todos.search("несуществующий запрос");
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldReturnMultipleMatchingTasksForQuery() {
        SimpleTask simpleTask1 = new SimpleTask(1, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(2, "Позвонить другу");
        Epic epic = new Epic(3, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(4, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask1, simpleTask2};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnExactlyOneMatchingTaskForQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayForNoMatchingQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("несуществующий запрос");
        Assertions.assertArrayEquals(expected, actual);
    }

}


