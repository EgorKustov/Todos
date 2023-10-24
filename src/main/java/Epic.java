public class Epic extends Task {
    private final String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {

        return subtasks;
    }

    public void addSubtask(SimpleTask subtask1) {
    }

    @Override
    public boolean matches(String query) {
        // Перебираем подзадачи и проверяем каждую через if
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                return true;
            }
        }
        return false;
    }
}
