import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to To-Do List");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add a task");
            System.out.println("2. Mark a task as completed");
            System.out.println("3. Delete a task");
            System.out.println("4. View tasks");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    markTaskAsCompleted(scanner);
                    break;
                case 3:
                    deleteTask(scanner);
                    break;
                case 4:
                    viewTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task description: ");
        String task = scanner.next();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        System.out.print("Enter task number to mark as completed (1-" + tasks.size() + "): ");
        int taskNumber = scanner.nextInt();
        if (isValidTaskNumber(taskNumber)) {
            System.out.println("Task \"" + tasks.get(taskNumber - 1) + "\" marked as completed.");
            tasks.remove(taskNumber - 1);
        } else {
            System.out.println("Invalid task number!");
        }
    }

    private static void deleteTask(Scanner scanner) {
        System.out.print("Enter task number to delete (1-" + tasks.size() + "): ");
        int taskNumber = scanner.nextInt();
        if (isValidTaskNumber(taskNumber)) {
            System.out.println("Task \"" + tasks.get(taskNumber - 1) + "\" deleted.");
            tasks.remove(taskNumber - 1);
        } else {
            System.out.println("Invalid task number!");
        }
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static boolean isValidTaskNumber(int taskNumber) {
        return taskNumber >= 1 && taskNumber <= tasks.size();
    }
}

