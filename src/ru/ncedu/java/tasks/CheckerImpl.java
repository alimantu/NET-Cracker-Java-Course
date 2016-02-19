package ru.ncedu.java.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alimantu on 03/11/15.
 */
public class CheckerImpl implements Checker {
    @Override
    public Pattern getPLSQLNamesPattern() {
        return Pattern.compile("[A-Za-z][\\w_$]{0,29}");
    }

    @Override
    public Pattern getHrefURLPattern() {
        return Pattern.compile("<(a|A)(\\s)*([Hh][Rr][Ee][Ff])(\\s)*" +
                "=" +
                "(\\s)*(([\\w@.#/\\\\]+)|(\"([\\s\\w.@#])*\"))(\\s)*>");
    }

    @Override
    public Pattern getEMailPattern() {
        return Pattern.compile("([A-Za-z0-9]([\\w.-]{0,20}[A-Za-z0-9])?)" +
                "@" +
                "([A-Za-z0-9]([A-Za-z0-9-]*[A-Za-z0-9])+[.])+" +
                "(ru|com|net|org)");
    }

    @Override
    public boolean checkAccordance(String inputString, Pattern pattern) throws IllegalArgumentException {
        if (inputString == null && pattern == null) {
            return true;
        }
        if (inputString == null || pattern == null) {
            throw new IllegalArgumentException();
        }
        return pattern.matcher(inputString).matches();
    }

    @Override
    public List<String> fetchAllTemplates(StringBuffer inputString, Pattern pattern) throws IllegalArgumentException {
        List<String> list = new ArrayList<String>();
        Matcher matcher = Pattern
                .compile("(?=(" + pattern.toString() + "))")
                .matcher(inputString);
        while (matcher.find()) {
            list.add(matcher.group(1));
        }
        return list;
    }
}
