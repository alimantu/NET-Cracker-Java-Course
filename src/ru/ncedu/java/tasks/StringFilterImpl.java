package ru.ncedu.java.tasks;

import java.util.*;

/**
 * Created by Alimantu on 28/10/15.
 */
public class StringFilterImpl implements StringFilter {
    private HashSet<String> set;

    public StringFilterImpl(){
        this.set = new HashSet<>();
    }

    @Override
    public void add(String s) {
        set.add(s == null ? null : s.toLowerCase());
    }

    @Override
    public boolean remove(String s) {
        return set.remove(s == null ? null : s.toLowerCase());
    }

    @Override
    public void removeAll() {
        set.clear();
    }

    @Override
    public Collection<String> getCollection() {
        return set;
    }

    @Override
    public Iterator<String> getStringsContaining(String chars) {
        Filter filter = new Filter() {
            @Override
            public boolean check(String string, String pattern) {
                return string != null && string.contains(pattern);
            }
        };
        return filterHandler(chars, filter);
    }

    @Override
    public Iterator<String> getStringsStartingWith(String begin) {
        Filter filter = new Filter() {
            @Override
            public boolean check(String string, String pattern) {
                return string != null && string.startsWith(pattern);
            }
        };
        return filterHandler(begin, filter);
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {
        Filter filter = new Filter() {
            @Override
            public boolean check(String string, String pattern) {
                if (string == null) {
                    return false;
                }
                if (string.length() != pattern.length()) {
                    return false;
                }
                for (int i = 0; i < string.length(); i++){
                    if (pattern.charAt(i) == '#') {
                        if (!Character.isDigit(string.charAt(i))) {
                            return false;
                        }
                    } else if (pattern.charAt(i) != string.charAt(i)) {
                        return false;
                    }
                }
                return true;
            }
        };
        return filterHandler(format, filter);
    }

    @Override
    public Iterator<String> getStringsByPattern(String pattern) {
        Filter filter = new Filter() {
            @Override
            public boolean check(String string, String pattern) {
                if (string == null) {
                    return false;
                }
                String tmpPattern = pattern;
                String tmpString = string;
                int index;
                boolean first = false;
                while ((index = tmpPattern.indexOf("*")) != -1) {
                    if (index == 0) {
                        tmpPattern = tmpPattern.substring(1);
                        first = true;
                        continue;
                    }
                    int tmpIndex = tmpString
                            .indexOf(tmpPattern.substring(0, index));
                    if (tmpIndex == -1
                            || (!first && tmpIndex != 0)) {
                        return false;
                    }
                    tmpString = tmpString.substring(tmpIndex + index);
                    tmpPattern = tmpPattern.substring(index);
                    first = false;
                }
                return (first && new StringBuilder(tmpString).reverse().toString()
                        .startsWith(new StringBuilder(tmpPattern).reverse().toString()))
                        || tmpString.equals(tmpPattern);
            }
        };
        return filterHandler(pattern, filter);
    }

    private Iterator<String> filterHandler(String pattern, Filter filter){
        if (pattern == null || pattern.equals("")) {
            return set.iterator();
        }
        String tmpPattern = pattern.toLowerCase();
        ArrayList<String> tmp = new ArrayList<>();
        for (String s : set) {
            if (filter.check(s, tmpPattern)) {
                tmp.add(s);
            }
        }
        return tmp.iterator();
    }

    private interface Filter {
        boolean check(String string, String pattern);
    }
}
