package com.kreitek.editor.editor;

import com.kreitek.editor.interfaces.Editor;

public class EditorFactory {
    public Editor getTextEditor() {
        return new TextEditor();
    }

    public Editor getJsonEditor() {
        return new JsonEditor();
    }
}
