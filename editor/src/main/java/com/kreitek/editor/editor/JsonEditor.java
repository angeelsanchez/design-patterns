package com.kreitek.editor.editor;

public class JsonEditor extends ConsoleEditor {
    @Override
    void showDocumentLines() {
        if (documentLines.size() > 0) {
            setTextColor(TEXT_YELLOW);
            printLnToConsole("{");
            printLnToConsole(" \"doc\":[");
            for (int index = 0; index < documentLines.size(); index++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("\t{\"line\":");
                stringBuilder.append("\"" + index + "\"text\":\"" + documentLines.get(index) + "\"");
                stringBuilder.append("} ");
                printLnToConsole(stringBuilder.toString());
            }
            printLnToConsole(" ]");
            printLnToConsole("}");
            setTextColor(TEXT_RESET);
        }
    }
}
