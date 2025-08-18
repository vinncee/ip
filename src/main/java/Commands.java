
public enum Commands {
    TODO,
    DEADLINE,
    EVENT,
    LIST,
    BYE,
    MARK,
    UNMARK,
    DELETE;

public static Commands convertStringToEnum(String input) throws ItachiException  {
    switch (input.toLowerCase()) {
        case "todo": return TODO;
        case "deadline": return DEADLINE;
        case "event": return EVENT;
        case "list": return LIST;
        case "bye": return BYE;
        case "mark": return MARK;
        case "unmark": return UNMARK;
        case "delete": return DELETE;
        default: throw new ItachiException("This is an invalid command!");
        }
    }
}