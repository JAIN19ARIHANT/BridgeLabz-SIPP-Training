import java.util.Scanner;

class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

public class TextEditorUndoRedo {
    private TextState head = null;
    private TextState current = null;
    private int size = 0;

    public void addState(String content) {
        TextState newState = new TextState(content);

        if (current != null) {
            current.next = null;
        }

        if (head == null) {
            head = current = newState;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
        }

        size++;
        int MAX_HISTORY = 10;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("New state saved.");
    }

    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Cannot undo.");
            return;
        }
        current = current.prev;
        System.out.println("Undo performed.");
    }

    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Cannot redo.");
            return;
        }
        current = current.next;
        System.out.println("Redo performed.");
    }

    public void displayCurrentState() {
        if (current == null) {
            System.out.println("Editor is empty.");
        } else {
            System.out.println("Current Text:\n\"" + current.content + "\"");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditorUndoRedo editor = new TextEditorUndoRedo();

        while (true) {
            System.out.println("\n--- Text Editor Menu ---");
            System.out.println("1. Type/Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show Current Text");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String content = sc.nextLine();
                    editor.addState(content);
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.displayCurrentState();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}