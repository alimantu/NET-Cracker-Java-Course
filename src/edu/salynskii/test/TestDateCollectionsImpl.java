package edu.salynskii.test;

import ru.ncedu.java.tasks.DateCollections;
import ru.ncedu.java.tasks.DateCollectionsImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Alimantu on 28/10/15.
 */
public class TestDateCollectionsImpl {
    public static void main(String[] args) {
        DateCollectionsImpl dateCollections = new DateCollectionsImpl();
        SortedMap<String, DateCollections.Element> tmp;
        try {
            /*System.out.println(dateCollections.
                    toString(dateCollections.toCalendar("Jul 11, 2018")));*/
            dateCollections.initMainMap(12, dateCollections.toCalendar("Jan 11, 2014"));

            // test for subMap
            System.out.println();
            tmp = dateCollections.getSortedSubMap();
            for (SortedMap.Entry<String,DateCollections.Element> entry : tmp.entrySet()) {
                System.out.println(entry.getValue());
            }

            // test for getList
//            System.out.println();
//            List<DateCollections.Element> list = dateCollections.getMainList();
//            for (DateCollections.Element element : list) {
//                System.out.println(element.toString());
//                //System.out.println(element.getDeathDate().getTime());
//            }

            // test for sortList
//            System.out.println();
//            dateCollections.sortList(list);
//            for (DateCollections.Element element : list) {
//                System.out.println(element.toString());
//                System.out.println(element.getDeathDate().getTime());
//            }

            // test for removeFromList
//            System.out.println();
//            dateCollections.removeFromList(list);
//            for (DateCollections.Element element : list) {
//                System.out.println(element.toString());
//            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
