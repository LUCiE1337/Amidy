import java.util.ArrayList;
import java.util.Scanner;

        class Task
        {
        private String name;
        private String description;
        private boolean completed;

        public Task(String name, String description)
        {
            this.name = name;
            this.description = description;
            this.completed = false;
        }

        public String getName()
        {
            return name;
        }

        public String getDescription()
        {
            return description;
        }

        public boolean isCompleted()
        {
            return completed;
        }

        public void markCompleted()
        {
            completed = true;
        }
    }

     class ToDoList
     {
        public static void main(String[] args)
        {
            ArrayList<Task> tasks = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);

            while (true)
            {
                System.out.println("1. Dodaj nowe zadanie");
                System.out.println("2. Oznacz zadanie jako zakończone");
                System.out.println("3. Usuń zadanie");
                System.out.println("4. Wyświetl listę zadań");
                System.out.println("5. Wyjście");

                System.out.print("Wybierz opcję (1/2/3/4/5): ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice)
                {
                                case 1:
                        System.out.print("Podaj nazwę zadania: ");
                        String taskName = scanner.nextLine();
                        System.out.print("Podaj opis zadania: ");
                        String taskDescription = scanner.nextLine();
                        Task newTask = new Task(taskName, taskDescription);
                        tasks.add(newTask);
                        System.out.println("Zadanie \"" + taskName + "\" zostało dodane do listy.");
                        break;
                                case 2:
                        System.out.print("Podaj numer zadania do oznaczenia jako zakończone: ");
                        int completeTaskIndex = scanner.nextInt();
                        if (completeTaskIndex >= 1 && completeTaskIndex <= tasks.size())
                        {
                            Task taskToComplete = tasks.get(completeTaskIndex - 1);
                            taskToComplete.markCompleted();
                            System.out.println("Zadanie \"" + taskToComplete.getName() + "\" zostało oznaczone jako zakończone.");
                        } else {
                            System.out.println("Nieprawidłowy numer zadania.");
                        }
                        break;
                                case 3:
                        System.out.print("Podaj numer zadania do usunięcia: ");
                        int deleteTaskIndex = scanner.nextInt();
                        if (deleteTaskIndex >= 1 && deleteTaskIndex <= tasks.size())
                        {
                            Task removedTask = tasks.remove(deleteTaskIndex - 1);
                            System.out.println("Zadanie \"" + removedTask.getName() + "\" zostało usunięte z listy.");
                        } else {
                            System.out.println("Nieprawidłowy numer zadania.");
                        }
                        break;
                                case 4:
                        System.out.println("Lista zadań:");
                        for (int i = 0; i < tasks.size(); i++)
                        {
                            Task task = tasks.get(i);
                            String status = task.isCompleted() ? "[x]" : "[ ]";
                            System.out.println((i + 1) + ". " + status + " " + task.getName() + ": " + task.getDescription());
                        }
                        break;
                                case 5:
                        System.out.println("Koniec programu.");
                        scanner.close();
                        System.exit(0);
                        break;
                                default:
                        System.out.println("Nieprawidłowa opcja. Wybierz jeszcze raz.");
                }
            }
        }
    }
