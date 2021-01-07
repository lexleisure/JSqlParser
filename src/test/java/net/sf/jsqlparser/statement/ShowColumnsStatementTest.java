/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement;

import net.sf.jsqlparser.JSQLParserException;
import org.junit.Test;

import static net.sf.jsqlparser.test.TestUtils.assertSqlCanBeParsedAndDeparsed;

/**
 *
 * @author oshai
 */
public class ShowColumnsStatementTest {


    @Test
    public void testSimpleUse() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW COLUMNS FROM mytable");
    }

    @Test
    public void testSimpleUseWhere() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW COLUMNS FROM mytable WHERE name = 'abc'");
    }

    @Test
    public void testSimpleUseLike() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW COLUMNS FROM mytable LIKE '%abc'");
    }

    @Test
    public void testSimpleUseIn() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW COLUMNS IN mytable");
    }

    @Test
    public void testSimpleUseFromDb() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW COLUMNS FROM mytable FROM mydatabase");
    }

    @Test
    public void testSimpleUseInDb() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW COLUMNS FROM mytable IN mydatabase");
    }

    @Test
    public void testSimpleUseFull() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW FULL COLUMNS FROM mytable");
    }

    @Test
    public void testSimpleUseWhereFull() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW FULL COLUMNS FROM mytable WHERE name = 'abc'");
    }

    @Test
    public void testSimpleUseLikeFull() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW FULL COLUMNS FROM mytable LIKE '%abc'");
    }

    @Test
    public void testSimpleUseInFull() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW FULL COLUMNS IN mytable");
    }

    @Test
    public void testSimpleUseFromDbFull() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW FULL COLUMNS FROM mytable FROM mydatabase");
    }

    @Test
    public void testSimpleUseInDbFull() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW FULL COLUMNS FROM mytable IN mydatabase");
    }
}
