package edu.salynskii.test;

import ru.ncedu.java.tasks.CheckerImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alimantu on 04/11/15.
 */
public class CheckerImplTest {
    public static void main(String[] args) {
        CheckerImpl checker = new CheckerImpl();
        List<String> list = new ArrayList<String>();

        //checkAccordance and getPLSQL test
        /*list.add("asd");
        list.add("A_12");
        list.add("b_$33");
        list.add("1223");
        list.add("_amm");
        list.add("b$");
        list.add("B_");
        list.add("$a33");
        list.add("$33");
        list.add("$");
        list.add("_");
        for (String s : list) {
            if (checker.checkAccordance(s,
                    checker.getPLSQLNamesPattern())) {
                System.out.println(s);
            }
        }*/

        //checkAccordance and getEMail test
        list.add("ali-mantu@mail.ru");
        list.add("ali_mantu1@gmail.com");
        list.add("1a@todo.todo.net");
        list.add("1_.-2@why.me.org");
        list.add("_@wft");
        list.add("here is error");
        list.add("_error@here.org");
        list.add("error_@here.org");
        list.add("");
        list.add("lastone@i-am-here.net");
        list.add("1a_a@mail.ru.com.ru.erevan-news.com.org.net");
        for (String s : list) {
            if (checker.checkAccordance(s,
                    checker.getEMailPattern())) {
                System.out.println(s);
            }
        }

        //fetchAll test
        /*StringBuffer sb = new StringBuffer();
        for (String s : list) {
            sb.append(s + " ");
        }
        System.out.println(sb);
        System.out.println(checker.fetchAllTemplates(sb
                , checker.getEMailPattern()));*/
    }
}
