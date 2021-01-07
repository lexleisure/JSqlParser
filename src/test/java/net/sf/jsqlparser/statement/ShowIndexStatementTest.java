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
 * @author lex
 */
public class ShowIndexStatementTest {

    @Test
    public void testSimpleUse() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW INDEX FROM my_table");
    }

    @Test
    public void testSimpleUseWithIn() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW INDEX IN my_table");
    }

    @Test
    public void testWithFromDb() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW INDEX FROM my_table FROM my_database");
    }

    @Test
    public void testWithInDb() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW INDEX FROM my_table IN my_database");
    }

    @Test
    public void testWithWhere() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW INDEX FROM my_table WHERE name = 'abc'");
    }

}
