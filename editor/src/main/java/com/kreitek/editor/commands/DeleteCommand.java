package com.kreitek.editor.commands;

import com.kreitek.editor.editor.CaretakerEditor;
import com.kreitek.editor.editor.MementoEditor;
import com.kreitek.editor.interfaces.Command;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    private final int lineNumber;

    public DeleteCommand(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        CaretakerEditor caretaker = CaretakerEditor.getInstance();
        caretaker.push(new MementoEditor(documentLines));
        documentLines.remove(lineNumber);
    }
}
