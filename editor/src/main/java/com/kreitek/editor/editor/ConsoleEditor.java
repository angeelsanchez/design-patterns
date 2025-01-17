package com.kreitek.editor.editor;

import com.kreitek.editor.exceptions.BadCommandException;
import com.kreitek.editor.interfaces.Command;
import com.kreitek.editor.exceptions.ExitException;
import com.kreitek.editor.commands.CommandFactory;
import com.kreitek.editor.interfaces.Editor;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class ConsoleEditor implements Editor {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";

    private final CommandFactory commandFactory = new CommandFactory();
    protected ArrayList<String> documentLines = new ArrayList<String>();

    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            String commandLine = waitForNewCommand();
            try {
                Command command = commandFactory.getCommand(commandLine);
                command.execute(documentLines);
            } catch (BadCommandException e) {
                printErrorToConsole("Bad command");
            } catch (ExitException e) {
                exit = true;
            } catch (NullPointerException e) {
                printErrorToConsole("There is nothing more to undo");
            }

            showDocumentLines();
            showHelp();
        }
    }

    abstract void showDocumentLines();

    private String waitForNewCommand() {
        printToConsole("Enter a command : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void showHelp() {
        printLnToConsole("To add new line          -> a \"your text\"");
        printLnToConsole("To update line           -> u [line number] \"your text\"");
        printLnToConsole("To delete line           -> d [line number]");
        printLnToConsole("To undo the last command -> undo");
    }

    private void printErrorToConsole(String message) {
        setTextColor(TEXT_RED);
        printToConsole(message);
        setTextColor(TEXT_RESET);
    }

    protected void setTextColor(String color) {
        System.out.println(color);
    }

    protected void printLnToConsole(String message) {
        System.out.println(message);
    }

    private void printToConsole(String message) {
        System.out.print(message);
    }

}
