package ru.ncedu.java.tasks;

import java.io.InputStream;

import javax.xml.transform.Transformer;

import org.xml.sax.SAXException;

/**
 * ЦЕЛИ ЗАДАЧИ:<br/>
 * - Разобраться с DOM API для работы с XML-деревом.<br/>
 * - Разобраться с SAX API для разбора (parsing'а) XML по модели событий.<br/>
 * - Понять, в каких случаях оправданно применение DOM и SAX.<br/>
 * <br/>
 * ЗАДАНИЕ<br/>
 * В данном интерфейсе собраны две независимые друг от друга задачи:<br/>
 * 1) Создание XML по имени и текстовому значению тега.<br/>
 * 2) Проверка корректности (большого) XML документа.<br/>
 *
 * @author Sergey Pankratov
 */
public interface SimpleXML {
	/*
	 * С помощью DOM API в Java-коде создать XML документ вида "<tagName>textNode</tagName>".<br/> 
	 * В частности, для вызова createXML("root","<R&D>") должно вернуться <root>&lt;R&amp;D&gt;</root>.<br/>
	 * Требования:<br/>
	 * - Результат должен быть корректным (well-formed) XML документом.<br/>
	 * - Никаких переводов строк или других дополнительных символов не должно быть добавлено в textNode.<br/>
	 * Правильный подход к решению:<br/>
	 * - Использовать именно DOM, а не писать логику обработки спецсимволов вручную.<br/>
	 * - С целью удаления в документе декларации "<?xml...?>" следует использовать метод 
	 *     {@link Transformer#setOutputProperty(String, String)} для свойства OMIT_XML_DECLARATION.
	 */
    //НИЖЕ - ТОТ ЖЕ САМЫЙ КОММЕНТАРИЙ, НО КОРРЕКТНО ОТОБРАЖАЕМЫЙ В JAVADOC
    /**
     * С помощью DOM API в Java-коде создать XML документ вида "&lt;tagName&gt;textNode&lt;/tagName&gt;".<br/>
     * В частности, для вызова createXML("root","&lt;R&amp;D&gt;") должно вернуться &lt;root&gt;&amp;lt;R&amp;amp;D&amp;gt;&lt;/root&gt;.<br/>
     * Требования:<br/>
     * - Результат должен быть корректным (well-formed) XML документом.<br/>
     * - Никаких переводов строк или других дополнительных символов не должно быть добавлено в textNode.<br/>
     * Правильный подход к решению:<br/>
     * - Использовать именно DOM, а не писать логику обработки спецсимволов вручную.<br/>
     * - С целью удаления в документе декларации "&lt;?xml...?&gt;" следует использовать метод
     *     {@link Transformer#setOutputProperty(String, String)} для свойства OMIT_XML_DECLARATION.
     * @param tagName Имя тега элемента
     * @param textNode Текстовое содержимое тега.
     * @return Корректный XML документ без декларации "&lt;?xml...?&gt;"
     */
    public String createXML(String tagName, String textNode);
    /**
     * С помощью SAX API проверить входящий поток на соответствие правилам XML-документа.<br/>
     * В качестве результата вернуть имя корневого элемента документа,
     *  а в случае ошибки валидации бросить {@link SAXException}.<br/>
     * Требование: Потребляемая память не должна зависеть от размера входящего документа.
     * @param xmlStream Поток с XML документом
     * @return Имя корневого элемента.
     */
    public String parseRootElement(InputStream xmlStream) throws SAXException;
}