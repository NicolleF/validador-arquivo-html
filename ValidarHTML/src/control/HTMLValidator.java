package control;

import exceptions.MalformedFileException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class HTMLValidator {
    private static final String[] SINGLETONS = {
        "meta", "base", "br", "col", "command", "embed", "hr", "img", "input",
        "link", "param", "source", "!doctype"
    };

    private LinkedListStack<String> stack = new LinkedListStack<>();
    private TagCounterList counter = new TagCounterList();

    private boolean isSingleton(String tag) {
        for (String t : SINGLETONS) {
            if (t.equalsIgnoreCase(tag)) return true;
        }
        return false;
    }

    private String extractTagName(String tag) {
        tag = tag.replaceAll("<|>|/", "").trim();
        String[] parts = tag.split("\\s+");
        return parts[0].toLowerCase();
    }

    public boolean validateFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        int actualLine = 0;

        while ((line = reader.readLine()) != null) {
            actualLine++;
            line = line.trim();
            if (line.isEmpty()) continue;

            int init = 0;
            while ((init = line.indexOf("<", init)) != -1) {
                int end = line.indexOf(">", init);
                if (end == -1){
                    reader.close();
                    throw new MalformedFileException("Erro na linha " + actualLine + ": Tag inicio < sem fechamento");
                }

                String completeTag = line.substring(init, end + 1);
                String tagName = extractTagName(completeTag);
                boolean isClose = completeTag.startsWith("</");

                if (isSingleton(tagName)) {
                    counter.addOrIncrement(tagName);
                } else if (isClose) {
                    if (stack.isEmpty()) {
                        reader.close();
                        throw new MalformedFileException("Erro na linha " + actualLine + ": Tag final inesperada: " + completeTag);
                    }
                    String top = stack.pop();
                    if (!top.equalsIgnoreCase(tagName)) {
                        reader.close();
                        throw new MalformedFileException("Erro na linha " + actualLine + ": Esperava </" + top + ">, mas encontrou " + completeTag);
                    }
                } else {
                    stack.push(tagName);
                    counter.addOrIncrement(tagName);
                }

                init = end + 1;
            }
        }
        
        reader.close();

        if (!stack.isEmpty()) {
            StringBuilder sb = new StringBuilder("Erro: Faltam as seguintes tags de fechamento:");
            while (!stack.isEmpty()) {
                sb.append("</" + stack.pop() + ">");
            }
            throw new MalformedFileException(sb.toString());
        }
        
        if (counter.isEmpty()) {
            throw new MalformedFileException("Não existem tags HTML neste arquivo.");
        }

        return true;
    }
    
    public DefaultTableModel insertTableRows(DefaultTableModel tableModel) {
        return counter.insertTableRows(tableModel);
    }
}
