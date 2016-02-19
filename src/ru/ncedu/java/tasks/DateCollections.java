package ru.ncedu.java.tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;


/**
 * ЦЕЛЬ ЗАДАЧИ - научиться использовать коллекции из Java Collections Framework.<br/>
 * Дополнительно: освоить работу с датами ({@link Calendar}, {@link Date}, {@link DateFormat}),
 *  генерацию случайных чисел ({@link Random}).<br/>
 * <p/>
 * ЗАДАНИЕ<ul>
 * <li>Преобразовывать дату в строку стандартного формата, парсить строку в дату.</li>
 * <li>Создавать объекты класса {@link Element} со случайным значением одного из параметров
 *     конструктора, добавляя созданные объекты в {@link Map}.</li>
 * <li>Возвращать подмножество элементов {@link Map} в виде упорядоченного {@link SortedMap}.</li>
 * <li>Возвращать элементы {@link Map} в виде упорядоченного {@link List}.</li>
 * <li>Сортировать {@link List}.</li>
 * <li>Удалять из {@link List} некоторые элементы по критерию.</li>
 * </ul>
 * <p/>
 * ПРИМЕЧАНИЯ<ul>
 * <li>Задачу можно решать без явной обработки и генерации исключительных ситуаций (Exceptions).</li>
 * <li>Для главного поля класса можно выбрать любой тип, реализующий интерфейс {@link Map}, но рекомендуется
 *   выбирать реализацию {@link SortedMap} (и передавать в ее конструктор свой {@link Comparator}) -
 *   это чтобы методы, возвращающие упорядоченные коллекции, реализовывались тривиально.</li>
 * </ul>
 *  @author Alexey Evdokimov
 *  @author Elena Protsenko
 */
public interface DateCollections{
    /**
     * Sets a style of string representation of dates that is used by other methods of the class.<br/>
     * If this method is NOT called, the default {@link DateFormat#MEDIUM} style is used.
     * @param dateStyle One of the style constants defined in the {@link DateFormat} class
     */
    void setDateStyle(int dateStyle);
    /**
     * Parses the <code>dateString</code> (a date with no time) to {@link Date} (with {@link DateFormat}))
     *  and converts it to {@link Calendar}.
     * @param dateString string compatible with a style set by {@link #setDateStyle(int)})
     * @throws ParseException if <code>dateString</code> can't be parsed
     */
    Calendar toCalendar(String dateString) throws ParseException;
    /**
     * Returns string representation of {@link Calendar} (a date with no time)
     * with {@link DateFormat} using a style set by {@link #setDateStyle(int)}.<br/>
     * Note: the result depends on the system's Locale. E.g. if the locale is en_US
     *  the example of the string is "Jan 15, 2015" (for style = {@link DateFormat#MEDIUM})
     */
    String toString(Calendar date);

    /**
     * Creates a map and adds <code>elementsNumber</code> instances of {@link Element} class
     *  to the map (key,element), where key is the String representation of
     *  <code>birthDate</code> field of the element (use {@link #toString(Calendar)}).<br/>
     * The parameters of an element's constructor must obey the following rules:
     * <dl>
     * <dt>birthDate</dt><dd>firstDate + i * 110 days (i is the index of the element)</dd>
     * <dt>lifetime (days)</dt><dd>random uniformly distributed {@code int} value
     *     between 0 (inclusive) and 2000 (exclusive)</dd>
     * </dl>
     * The created map must be stored as a field.
     * Note: when implementing <code>getMainMap, getMainList, getSortedSubMap</code>
     *  you can rely on the fact that this method is called BEFORE that methods.
     * Note 2: the work of this method depends on the style set by {@link #setDateStyle(int)}.
     * @param elementsNumber the number of elements to instantiate
     * @param firstDate birth date of the first element; the time fields (hours/minutes/..) do not matter
     */
    void initMainMap(int elementsNumber, Calendar firstDate);

    /**
     * Sets the given map to the the main field of the class.<br/>
     * Note: this method exists in order to test other methods
     *  if {@link #initMainMap(int, Calendar)} has incorrect implementation.
     */
    void setMainMap(Map<String, Element> map);

    /**
     * Returns the result of {@link #initMainMap(int, Calendar)} method.
     * @return map, the main field of the class.
     * Can be null if <code>initMainMap</code> method was not called
     */
    Map<String, Element> getMainMap();

    /**
     * Returns those entries of the main map, where elements' <code>birthDate</code> &gt; today
     *  (i.e. elements to be born in future: not today and not in the past).
     * The resulting sub-map must be sorted according to the <code>birthDate</code>
     * (ascending order of dates; but it's not alphabetic natural order of keys!).
     * @return sorted map containing a subset of the {@link #getMainMap()}
     */
    SortedMap<String, Element> getSortedSubMap();

    /**
     * Represents values of the main map as a {@link List}.
     * The list must be sorted according to the <code>birthDate</code> (ascending order).
     * @return list with all the values of the {@link #getMainMap()}.
     */
    List<Element> getMainList();

    /**
     * Sorts the given list according to the <code>deathDate</code> (ascending order).<br/>
     * Don't use {@link List#sort(Comparator)} method because it's since Java 8
     * (and Java version in Skill Bench is 7 now). Use a method of {@link Collections}.
     */
    void sortList(List<Element> list);
    /**
     * Removes some elements from the given list. The <code>birthDate</code> of removing elements
     *  must be in winter (i.e. in December, January or February).<br/>
     * Hint: remove elements via {@link Iterator}.
     */
    void removeFromList(List<Element> list);

    /**
     * A class for objects to store in the collections.
     * Has two dates - Calendars where the time fields (hours/minutes/..) do not matter.
     */
    public static class Element {
        private Calendar birthDate;
        private Calendar deathDate;

        /**
         * @param birthDate can't be null
         * @param lifetime duration of the object's life in days
         */
        public Element(Calendar birthDate, int lifetime){
            this.birthDate = birthDate;
            this.deathDate = (Calendar) birthDate.clone();
            deathDate.add(Calendar.DATE, lifetime);
        }
        /**
         * Returns birth date. Can't be null
         */
        public final Calendar getBirthDate() {
            return birthDate;
        }
        /**
         * Returns death date. Can't be null
         */
        public final Calendar getDeathDate() {
            return deathDate;
        }
        /**
         * Two elements are assumed to be equal if birthDates are equal;
         * and deathDate is NOT used to test DateCollectionsImpl because deathDates are random.
         */
        @Override
        public boolean equals(Object obj) {
            if(obj==null) return false;
            if(!(obj instanceof Element)) return false;
            Calendar bd = ((Element)obj).getBirthDate();
            //return birthDate.equals(bd);//If so, hours/minutes/.. DO matter.

            if(!equalFields(bd, Calendar.DATE)) return false;
            if(!equalFields(bd, Calendar.MONTH)) return false;
            if(!equalFields(bd, Calendar.YEAR)) return false;
            return true;
        }
        private boolean equalFields(Calendar bd, int field) {
            return birthDate.get(field) == bd.get(field);
        }
        @Override
        public String toString() {
            //String s = super.toString();//like "ru.ncedu.java.tasks.DateCollections$Element@1513e285"
            //return s.substring(s.lastIndexOf('@')+1);
            return toString(birthDate);//+"-"+toString(deathDate);
        }
        /*
         * Returns date in the US format.
         * This method is just for debug purpose - for toString() method
         */
        private String toString(Calendar date){
            return date.get(Calendar.MONTH)+1+"/"
                    +birthDate.get(Calendar.DATE)+"/"
                    +birthDate.get(Calendar.YEAR);
        }
    }

}
