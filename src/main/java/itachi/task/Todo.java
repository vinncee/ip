package itachi.task;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
        assert description != null : "Description can't be null";
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toSaveFormat() {
        return "T | " + super.toSaveFormat();
    }
}
