package com.kreitek.editor.editor;

import java.util.ArrayList;
import java.util.List;

public class MementoEditor {
    private final List<String> state;

    public MementoEditor(ArrayList<String> state) {
        this.state = new ArrayList<>(state);
    }

    public List<String> getState() {
        return this.state;
    }
}