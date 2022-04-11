package com.kreitek.editor;

import com.kreitek.editor.editor.JsonEditor;
import com.kreitek.editor.interfaces.Editor;
import com.kreitek.editor.editor.EditorFactory;

public class Application {

    public static void main(String[] args) {
        EditorFactory editorFactory = new EditorFactory();

        if (args[0].equals("json"))
            editorFactory.getJsonEditor().run();
        else if (args[0].equals("text"))
            editorFactory.getTextEditor().run();
    }
}
