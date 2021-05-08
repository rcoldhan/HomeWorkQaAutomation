package hibernate.tests;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.fintech.qa.homework.db.hibernate.DbHibernateService;
import ru.fintech.qa.homework.utils.BeforeUtils;

import java.math.BigInteger;

public class HibernateTests {
    @BeforeAll
    public static void createData() {
        BeforeUtils.createData();
    }

    /**
     * В таблице public.animal ровно 10 записей.
     */
    @Test
    void tenRowsFromAnimal() {
        Assertions.assertEquals(BigInteger.valueOf(10), new DbHibernateService()
                .countRows("select count(*) from ", "animal"));
    }

    /**
     * В таблицу public.animal нельзя добавить строку с индексом от 1 до 10 включительно.
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void cantAddRowWithIndexOneToTenToAnimal(final int number) {
        Assertions.assertThrows(ConstraintViolationException.class,
                () -> new DbHibernateService()
                        .addRowWithSameID("insert into animal (id) values (" + number + ")"));
    }

    /**
     * В таблицу public.workman нельзя добавить строку с name = null.
     */
    @Test
    void cantAddRowWithNameNull() {
        Assertions.assertThrows(ConstraintViolationException.class,
                () -> new DbHibernateService()
                        .addRowWithNameNull("insert into workman (\"name\") values (null)"));
    }

    /**
     * Если в таблицу public.places добавить еще одну строку, то в ней будет 6 строк.
     */
    @Test
    void ifAddOneMoreRowThenSixRows() {
        new DbHibernateService().addOneRow("insert into places (id) values (" + 6 + ")");
        Assertions.assertEquals(BigInteger.valueOf(6), new DbHibernateService()
                .countRows("select count(*) from ", "places"));
    }

    /**
     * В таблице public.zoo всего три записи с name 'Центральный', 'Северный', 'Западный'.
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