/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2020 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement.create.schema;

import static net.sf.jsqlparser.test.TestUtils.assertSqlCanBeParsedAndDeparsed;
import org.junit.Test;
import net.sf.jsqlparser.JSQLParserException;

/**
 *
 * @author tw
 */
public class CreateSchemaTest {  
    @Test
    public void testSimpleCreateSchema() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("CREATE SCHEMA myschema");
    }

    @Test
    public void testSimpleCreateWithAuth() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("CREATE SCHEMA myschema AUTHORIZATION myauth");
    }

    @Test
    public void testSimpleCreateDatabase() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("CREATE DATABASE myschema AUTHORIZATION myauth");
    }

    @Test
    public void testSimpleCreateDatabaseNoAuth() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("CREATE DATABASE myschema");
    }

    @Test
    public void testSimpleCreateDatabaseIfNotExists() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("CREATE DATABASE IF NOT EXISTS myschema");
    }

    @Test
    public void testSimpleCreateSchemaIfNotExists() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("CREATE SCHEMA IF NOT EXISTS myschema");
    }
}
