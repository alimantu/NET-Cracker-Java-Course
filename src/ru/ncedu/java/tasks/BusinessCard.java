package ru.ncedu.java.tasks ;

import java.util.Scanner;

/**
 * ЦЕЛИ ЗАДАЧИ:<br/>
 * - Научиться разбирать (parse) потоки InputStreams с помощью java.util.Scanner.<br/>
 * - Разобраться с java.util.Calendar.<br/>
 * - Привыкать читать требования по-английски :).<br/>
 * <br/>
 * ЗАДАНИЕ<br/>
 * Создать экземпляр своего класса визитной карточки (класса, реализующего данный интерфейс)
 *  в методе {@link #getBusinessCard(Scanner)}.<br/>
 * Большинство методов должны просто возвращать считанные через {@link Scanner} значения.<br/>
 * Расчет возраста по дате рождения может проводиться в методе {@link #getAge()}
 *  - необязательно это делать сразу в {@link #getBusinessCard(Scanner)}).<br/>
 *
 * @author Alexander Kharichkin
 */
public interface BusinessCard{
    /**
     * This method obtains (via Scanner) information from an input stream
     *  that contains the following information about an Employee:<br/>
     * Name - String<br/>
     * Last name - String<br/>
     * Department - String <br/>
     * Birth date - String in format: "DD-MM-YYYY", where DD - two-digits birth date,
     *					MM - two-digits month of birth, YYYY - year of birth<br/>
     * Gender : F or M - Character<br/>
     * Salary : number from 100 to 100000<br/>
     * Phone number : 10-digits number<br/>
     * All entries are separated with ";" sign<br/>
     * The format of input is the following:<br/>
     * Name;Last name;Department;Birth date;Gender;Salary;Phone number
     *
     * @param scanner Data source
     * @return Business Card
     * @throws java.util.InputMismatchException Thrown if input value
     *   does not correspond to the data format given above (for example,
     *   if phone number is like "AAA", or date format is incorrect, or salary is too high)
     * @throws java.util.NoSuchElementException Thrown if input stream hasn't enough values
     *   to construct a BusinessCard
     */
    public BusinessCard getBusinessCard (Scanner scanner);
	/*
	 * For example, input stream contains following
	 *
	 * Chuck;Norris;DSI;10-04-1940;M;1000;1234567890
	 *
	 * And business card should look like this
	 *
	 * Employee: Chuck Norris
	 * Department: DSI
	 * Salary: 1000
	 * Age: 69
	 * Gender: Male
	 * Phone: +7 123-456-78-90
	 */

    /**
     * @return Employee Name and Last name separated by space (" "), like "Chuck Norris"
     */
    public String getEmployee();

    /**
     * @return Employee Department name, like "DSI"
     */
    public String getDepartment();

    /**
     * @return Employee Salary, like 1000
     */
    public int getSalary();

    /**
     * @return Employee Age in years, like 69
     */
    public int getAge();

    /**
     * @return Employee Gender: either "Female" or "Male"
     */
    public String getGender();

    /**
     * @return Employee Phone Number in the following format: "+7 123-456-78-90"
     */
    public String getPhoneNumber();

}
