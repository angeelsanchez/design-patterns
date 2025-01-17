package com.kreitek.editor.commands;

import com.kreitek.editor.editor.CaretakerEditor;
import com.kreitek.editor.editor.MementoEditor;
import com.kreitek.editor.interfaces.Command;

import java.util.ArrayList;

public class AppendCommand implements Command {
    private final String text;

    public AppendCommand(String text) {
        this.text = text;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        CaretakerEditor caretaker = CaretakerEditor.getInstance();
        caretaker.push(new MementoEditor(documentLines));
        documentLines.add(text);
    }
}
