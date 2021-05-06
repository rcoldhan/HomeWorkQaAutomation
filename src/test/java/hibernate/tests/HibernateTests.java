package hibernate.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.fintech.qa.homework.db.hibernate.DbHibernateService;
import ru.fintech.qa.homework.utils.BeforeUtils;

import java.math.BigInteger;

public class HibernateTests {
    @BeforeAll
    public static void createData() {
        BeforeUtils.createData();
    }

    /**
     * В таблице public.animal ровно 10 записей
     */
    @Test
    void countRowsFromAnimal() {
        Assertions.assertEquals(BigInteger.valueOf(10), new DbHibernateService()
                .countRows("select count(*) from ", "animal"));
    }

    /**
     * В таблицу public.animal нельзя добавить строку с индексом от 1 до 10 включительно
     */
    @Test
    void cantAddRowWithIndexOneToTenToAnimal() {
        new DbHibernateService().addRowWithSameID(10);
    }

    /**
     * В таблицу public.workman нельзя добавить строку с name = null
     */
    @Test
    void cantAddRowWithNameNull() {
        new DbHibernateService().addRowWithNameNull("null");
    }

    /**
     * Если в таблицу public.places добавить еще одну строку, то в ней будет 6 строк
     */
    @Test
    void ifAddOneRowThenSixRows() {
        new DbHibernateService().addOneRow(6);
        Assertions.assertEquals(BigInteger.valueOf(6), new DbHibernateService()
                .countRows("select count(*) from ", "places"));
    }

    /**
     * В таблице public.zoo всего три записи с name 'Центральный', 'Северный', 'Западный'
     */
    @Test
    void countRowsFromZooAndCheckNames() {
        String sqlQuery = "select * from zoo where id = ";
        Assertions.assertEquals(BigInteger.valueOf(3), new DbHibernateService()
                .countRows("select count(*) from ", "zoo"));
        Assertions.assertEquals("Центральный", DbHibernateService.getNameByID(1, sqlQuery));
        Assertions.assertEquals("Северный", DbHibernateService.getNameByID(2, sqlQuery));
        Assertions.assertEquals("Западный", DbHibernateService.getNameByID(3, sqlQuery));
    }
}