import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TodosTest {


    public TodosTest() {

    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
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

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWithMatchingQuery() {
        Todos todos = new Todos();
        Task task1 = new SimpleTask(5, "Позвонить родителям");
        Task task2 = new Epic(55, new String[]{"Молоко", "Яйца", "Хлеб"});
        Task task3 = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);
        Task[] result = todos.search("Выкатка 3й версии приложения");

        assertEquals(1, result.length); // Проверка на отсутствие найденных задач
        assertEquals(task3, result[0]);
    }

    @Test
    public void testSearchWithNoMatchingQuery() {
        Todos todos = new Todos();
        Task task1 = new SimpleTask(5, "Позвонить родителям");
        Task task2 = new Epic(55, new String[]{"Молоко", "Яйца", "Хлеб"});
        Task task3 = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);
        Task[] result = todos.search("Парашют");

        assertEquals(0, result.length); // Проверка на отсутствие найденных задач
    }
}