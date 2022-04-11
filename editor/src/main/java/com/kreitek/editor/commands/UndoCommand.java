package com.kreitek.editor.commands;

import com.kreitek.editor.editor.CaretakerEditor;
import com.kreitek.editor.interfaces.Command;

import java.util.ArrayList;

public class UndoCommand implements Command {

    @Override
    public void execute(ArrayList<String> documentLines) {
        CaretakerEditor caretaker = CaretakerEditor.getInstance();
        documentLines.clear();
        documentLines.addAll(caretaker.pop().getState());
    }
}