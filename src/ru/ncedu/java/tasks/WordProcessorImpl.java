package ru.ncedu.java.tasks;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alimantu on 04/11/15.
 */
public class WordProcessorImpl implements WordProcessor {
    private String text;
    private Set<String> words;
    private final static int BUFF_SIZE = 1024;

    @Override
    public String getText() {
        return text;
    }

    private void checkNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void setSource(String src) {
        checkNull(src);
        text = src;
        words = new HashSet<>(Arrays.asList(src.toLowerCase().split("[\\s]+")));
    }

    @Override
    public void setSourceFile(String srcFile) throws IOException {
        checkNull(srcFile);
        setSource(new FileInputStream(srcFile));
    }

    @Override
    public void setSource(FileInputStream fis) throws IOException {
        checkNull(fis);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader =
                      new BufferedReader(
                              new InputStreamReader(fis, StandardCharsets.UTF_8))) {
            char[] buff = new char[BUFF_SIZE];
            int size;
            while ((size = reader.read(buff)) != -1) {
                sb.append(buff, 0, size);
            }
        }
        setSource(sb.toString());
    }

    @Override
    public Set<String> wordsStartWith(String begin) {
        if(begin == null || begin.equals("")){
            return words;
        }
        Set<String> tmp = new HashSet<>();
        for (String word : words) {
            if (word.startsWith(begin)) {
                tmp.add(word);
            }
        }
        return tmp;
    }
}
