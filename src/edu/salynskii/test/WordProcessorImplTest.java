package edu.salynskii.test;

import ru.ncedu.java.tasks.WordProcessorImpl;

import java.io.IOException;

/**
 * Created by Alimantu on 04/11/15.
 */
public class WordProcessorImplTest {

    public static void main(String[] args) throws IOException {
        WordProcessorImpl processor = new WordProcessorImpl();

        // setSourse and getText test
        /*processor.setSource("Abc aarg, asdasd   asd asd              " +
                "asdasa             sada12421 ggidasfgf78g23");
        System.out.println(processor.getText());*/

        // setSourceFile, setSource(fis) and getText test
        processor.setSourceFile("files/in.txt");
        System.out.println(processor.getText());

        // wordsStartWith test
        System.out.println(processor.wordsStartWith("\""));
    }
}
