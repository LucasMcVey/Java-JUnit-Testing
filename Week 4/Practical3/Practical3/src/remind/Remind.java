package remind;

import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Remind {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command;
        PDA jeeves = new PDA();

        do {
            System.out.print("\nCommand? ");
            StringTokenizer line = new StringTokenizer(input.nextLine());
            command = line.nextToken().toLowerCase();
            switch (command) {
                case "exit" -> {
                }
                case "list" -> jeeves.list();
                case "memo" -> {
                    if (line.countTokens() == 0) {
                        jeeves.listMemo();
                    } else {
                        jeeves.createMemo(line.nextToken("").trim());
                    }
                }
                case "phone" -> {
                    String name, number;
                    switch (line.countTokens()) {
                        case 0 -> jeeves.listPhone();
                        case 1 -> {
                            name = line.nextToken();
                            if (name.equals("-a"))
                                jeeves.listPhoneAlphabetically();
                            else
                                jeeves.listPhone(name);
                        }
                        default -> {
                            name = line.nextToken();
                            number = line.nextToken();
                            jeeves.createPhone(name, number);
                        }
                    }
                }
                case "todo" -> {
                    Date when;
                    String what;
                    switch (line.countTokens()) {
                        case 0 -> jeeves.listTodo();
                        case 1 -> {
                            String comm = line.nextToken().toLowerCase();
                            if (comm.equals("-d"))
                                jeeves.listTodoByDate();
                            else {
                                when = Todo.dateParse(comm);
                                jeeves.listTodo(when);
                            }
                        }
                        default -> {
                            when = Todo.dateParse(line.nextToken());
                            what = line.nextToken("").trim();
                            jeeves.createTodo(when, what);
                        }
                    }
                }
                default -> System.out.println("Can't understand command " + command);

            }
        } while (!command.equals("exit"));
    }
}
