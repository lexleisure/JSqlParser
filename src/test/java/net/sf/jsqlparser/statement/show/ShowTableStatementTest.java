/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2020 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement.show;

import org.junit.Test;

import static net.sf.jsqlparser.test.TestUtils.assertSqlCanBeParsedAndDeparsed;

public class ShowTableStatementTest {

    @Test
    public void showTableLike() throws Exception {
        assertSqlCanBeParsedAndDeparsed("SHOW TABLE STATUS LIKE 'my_table'");
    }

    @Test
    public void showTableFromDb() throws Exception {
        assertSqlCanBeParsedAndDeparsed("SHOW TABLE STATUS FROM mydatabase LIKE 'my_table'");
    }

    @Test
    public void showTableInDbName() throws Exception {
        assertSqlCanBeParsedAndDeparsed("SHOW TABLE STATUS IN mydatabase LIKE 'my_table'");
    }

    @Test
    public void showTableWhereLike() throws Exception {
        assertSqlCanBeParsedAndDeparsed("SHOW TABLE STATUS IN mydatabase WHERE name LIKE 'my_table'");
    }

    @Test
    public void showTableWhereEqual() throws Exception {
        assertSqlCanBeParsedAndDeparsed("SHOW TABLE STATUS IN mydatabase WHERE name = 'my_table'");
    }

}
