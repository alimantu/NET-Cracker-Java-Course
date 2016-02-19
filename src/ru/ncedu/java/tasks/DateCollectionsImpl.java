package ru.ncedu.java.tasks;

import java.text.*;
import java.util.*;

/**
 * Created by Alimantu on 27/10/15.
 */
public class DateCollectionsImpl implements DateCollections {
    private int dateStyle;
    private final int LIFETIME = 2000;
    private final int DATE_SHIFT = 110;
    private Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            try {
                Calendar calendar1 = toCalendar(o1);
                Calendar calendar2 = toCalendar(o2);
                int result;
                if ((result = compareByParameter(calendar1,
                        calendar2, Calendar.YEAR)) != 0) {
                    return result;
                }
                if ((result = compareByParameter(calendar1,
                        calendar2, Calendar.MONTH)) != 0) {
                    return result;
                }
                return compareByParameter(calendar1, calendar2, Calendar.DATE);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return 0;
        }

        private int compareByParameter(Calendar calendar1, Calendar calendar2, int param) {
            return Integer.compare(calendar1.get(param), calendar2.get(param));
        }
    };
    private TreeMap<String, Element> mainMap;
    private Locale USED_LOCALE = Locale.getDefault();

    public DateCollectionsImpl(){
        this.dateStyle = DateFormat.MEDIUM;
    }

    @Override
    public void setDateStyle(int dateStyle) {
        this.dateStyle = dateStyle;
    }

    @Override
    public Calendar toCalendar(String dateString) throws ParseException {
        DateFormat dateFormat = DateFormat.getDateInstance(dateStyle, USED_LOCALE);
        Calendar calendar = dateFormat.getCalendar();
        calendar.setTime(dateFormat.parse(dateString));
        return calendar;
    }

    @Override
    public String toString(Calendar date) {
        DateFormat dateFormat = DateFormat.getDateInstance(dateStyle,
                USED_LOCALE);
        return dateFormat.format(date.getTime());
    }

    @Override
    public void initMainMap(int elementsNumber, Calendar firstDate) {
        Random random = new Random();
        mainMap = new TreeMap<>(comparator);
        for (int i = 0; i < elementsNumber; i++) {
            Calendar calendar = (Calendar) firstDate.clone();
            calendar.add(Calendar.DATE, DATE_SHIFT * i);
            mainMap.put(toString(calendar), new Element(calendar, random.nextInt(LIFETIME)));
        }
    }



    @Override
    public void setMainMap(Map<String, Element> map) {
        mainMap = new TreeMap<String, Element>(comparator);
        for (Map.Entry<String, Element> entry : map.entrySet()) {
            mainMap.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Map<String, Element> getMainMap() {
        return mainMap;
    }

    @Override
    public SortedMap<String, Element> getSortedSubMap() {
        Calendar calendar = DateFormat
                .getDateInstance(dateStyle, USED_LOCALE)
                .getCalendar();
        calendar.setTime(new Date());
        return mainMap.tailMap(toString(calendar), false);
    }

    @Override
    public List<Element> getMainList() {
        return new ArrayList<>(mainMap.values());
    }

    @Override
    public void sortList(List<Element> list) {
        Collections.sort(list, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                Calendar calendar1 = o1.getDeathDate();
                Calendar calendar2 = o2.getDeathDate();
                int result;
                if ((result = compareByParameter(calendar1,
                        calendar2, Calendar.YEAR)) != 0) {
                    return result;
                }
                if ((result = compareByParameter(calendar1,
                        calendar2, Calendar.MONTH)) != 0) {
                    return result;
                }
                return compareByParameter(calendar1, calendar2, Calendar.DATE);
            }

            private int compareByParameter(Calendar calendar1, Calendar calendar2, int param) {
                return Integer.compare(calendar1.get(param), calendar2.get(param));
            }
        });
    }

    @Override
    public void removeFromList(List<Element> list) {
        for (Iterator<Element> iterator = list.iterator(); iterator.hasNext();) {
            Element element = iterator.next();
            int month = element.getBirthDate().get(Calendar.MONTH);
            if (month == Calendar.DECEMBER
                    || month == Calendar.JANUARY
                    || month == Calendar.FEBRUARY) {
                iterator.remove();
            }
        }
    }
}
