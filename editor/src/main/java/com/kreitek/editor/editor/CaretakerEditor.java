package com.kreitek.editor.editor;

import java.util.ArrayList;
import java.util.List;

public class CaretakerEditor {
    private static volatile CaretakerEditor instance = null;
    private List<MementoEditor> mementos = new ArrayList<>();

    private CaretakerEditor() {
        if (instance != null) {
            throw new RuntimeException("Usage getInstance method to create");
        }
    }

    public static CaretakerEditor getInstance() {
        if (instance == null) {
            synchronized (CaretakerEditor.class) {
                if (instance == null) {
                    instance = new CaretakerEditor();
                }
            }
        }
        return instance;
    }

    public void push(MementoEditor memento) {
        mementos.add(memento);
    }

    public MementoEditor pop() {
        if (mementos.size() > 0) {
            MementoEditor memento = mementos.get(mementos.size() - 1);
            mementos.remove(mementos.size() - 1);
            return memento;
        }
        return null;
    }
}