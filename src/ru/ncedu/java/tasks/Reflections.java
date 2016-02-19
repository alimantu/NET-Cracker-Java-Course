package ru.ncedu.java.tasks;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

/**
 * ЦЕЛЬ ЗАДАЧИ - научиться извлекать информацию о классах и обращаться
 * к полям и методам объектов с помощью Reflection API.<br/>
 * Дополнительно: научиться упаковывать данные в коллекции (с Generics).<br/>
 * <br/>
 * ЗАДАНИЕ<br/>
 * Реализовать методы данного интерфейса путем вызова Reflection API
 *  (с минимальным объемом собственной логики в реализуемых методах).<br/>
 *
 * @author Alexey Vasiliev
 * */
public interface Reflections {

    /**
     * Метод возвращает текущее значение поля для данного экземпляра,
     * имеющего идентификатор private, public, protected или default.
     * @param object экземпляр класса
     * @param fieldName имя поля класса
     * @throws NoSuchFieldException если поля с указанным именем не существует
     * @throws NullPointerException если fieldName or object является null-ом
     * @return Текущее значение поля
     * */
    public Object getFieldValueByName(Object object, String fieldName) throws NoSuchFieldException ;

    /**
     * Метод возвращает набор имен методов для класса, помеченных идентификатором protected
     * @param clazz класс
     * @throws NullPointerException если clazz является null-ом
     * @return Набор имен методов
     * */
    public Set<String> getProtectedMethodNames(Class clazz);

    /**
     * Метод возвращает набор всех методов класса, в т.ч. методов его суперклассов.
     * Возвращаемые методы могут иметь любые модификаторы.
     * Если в иерархии есть переопределенные методы, должны возвращаться все они
     *   (а не только метод, переопределяющий остальные).<br/>
     * @param clazz класс
     * @throws NullPointerException если clazz является null-ом
     * @return Набор методов для всей иерархии классов.
     * */
    public Set<Method> getAllImplementedMethodsWithSupers(Class clazz);

    /**
     * Метод возвращает список классов, являющихся суперклассами для указанного класса.
     * @param clazz класс
     * @throws NullPointerException если clazz является null-ом
     * @return Набор классов всей иерархии.
     * */
    public List<Class> getExtendsHierarchy(Class clazz);

    /**
     * Метод возвращает список интерфейсов, которые реализует класс/интерфейс clazz
     * @param clazz - класс/интерфейс
     * @throws NullPointerException - если clazz является null-ом
     * @return Набор интерфейсов
     * */
    public Set<Class> getImplementedInterfaces(Class clazz);


    /**
     * Метод возвращает список исключений, которые может порождать метод
     * @param method метод
     * @return Список порождаемых исключений
     * @throws NullPointerException если method является null-ом
     * */
    public List<Class> getThrownExceptions(Method method);

    /**
     * Метод создает экземпляр класса SecretClass с помощью конструктора по умолчанию,
     * после чего вызвает его метод foo()
     * @return результат, который возвращает метод foo()
     * */
    public String getFooFunctionResultForDefaultConstructedClass() ;

    /**
     * Метод создает экземпляр класса SecretClass с помощью конструктора с параметром constructorParameter
     * после чего вызвает его метод foo(...), в который передается тот же самый набор аргументов, что получила функция
     * @param constructorParameter параметр, передаваемый конструктору
     * @param string первый аргумент для функции foo
     * @param integers последующие аргументы для функции foo
     * @return результат, который возвращает метод foo(...)
     * */
    public String getFooFunctionResultForClass(String constructorParameter, String string, Integer ... integers);

    @SuppressWarnings("unused")
    public class SecretClass {

        private String text = null;

        private String secret = "secret";

        private SecretClass() {
        }

        public SecretClass(String text) {
            this.text = text;
        }

        public void setSecret (String secret) {
            this.secret = secret;
        }

        private String foo(String string, Integer ... integers){
            String s = "";
			/* Some text hidden : start */
            int in = 0;
            if(integers != null)
                for(Integer i : integers)
                    in += i;
            s += string + " - > " + in;
			/* Some text hidden : end */
            return s;
        }

        private String foo(){
            String s = "";
			/* Some text hidden : start */
            s += "abraKadabra";
			/* Some text hidden : end */
            return s;
        }

    }

}
