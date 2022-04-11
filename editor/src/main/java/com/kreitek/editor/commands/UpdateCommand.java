package com.kreitek.editor.commands;

import com.kreitek.editor.editor.CaretakerEditor;
import com.kreitek.editor.editor.MementoEditor;
import com.kreitek.editor.interfaces.Command;

import java.util.ArrayList;

public class UpdateCommand implements Command {
    private final String text;
    private final int lineNumber;

    public UpdateCommand(String text, int lineNumber) {
        this.text = text;
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        CaretakerEditor caretaker = CaretakerEditor.getInstance();
        caretaker.push(new MementoEditor(documentLines));

        if (documentLines.size() > lineNumber)
            documentLines.set(lineNumber, text);
        else
            documentLines.add(text);
    }
}
