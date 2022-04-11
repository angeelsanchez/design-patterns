package com.kreitek.editor;

import com.kreitek.editor.editor.EditorFactory;

public class Application {

    public static void main(String[] args) {
        EditorFactory editorFactory = new EditorFactory();
        if (args.length == 1) {
            if (args[0].equals("json"))
                editorFactory.getJsonEditor().run();
            else if (args[0].equals("text"))
                editorFactory.getTextEditor().run();
            else {
                System.out.println("You must enter json or text");
            }
        } else {
            System.out.println("You must enter a parameter");
        }
    }
}
