import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TasksTest {

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(5, "Позвонить родителям");
        assertTrue(task.matches("Позвонить"));
        assertTrue(task.matches("родителям"));
    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        assertTrue(epic.matches("Молоко"));
        assertTrue(epic.matches("Яйца"));
        assertTrue(epic.matches("Хлеб"));
    }

    @Test
    public void testMeetingMatches() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        assertTrue(meeting.matches("Выкатка 3й версии приложения"));
        assertTrue(meeting.matches("Приложение НетоБанка"));
        assertFalse(meeting.matches("Во вторник после обеда"));
    }
}