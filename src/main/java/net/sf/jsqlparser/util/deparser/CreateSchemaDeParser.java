/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2021 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.util.deparser;

import net.sf.jsqlparser.statement.create.schema.CreateSchema;

/**
 * @auth lex
 */
public class CreateSchemaDeParser extends AbstractDeParser<CreateSchema>{

    protected CreateSchemaDeParser(StringBuilder buffer) {
        super(buffer);
    }

    @Override
    void deParse(CreateSchema cs) {
        buffer.append("CREATE ").append(cs.getSchemaKey().name());
        if(cs.getKeyIf() != null){
            buffer.append(" IF");
        }
        if(cs.getKeyNot() != null){
            buffer.append(" NOT");
        }
        if(cs.getKeyExists() != null){
            buffer.append(" EXISTS");
        }
        if (cs.getSchemaName() != null) {
            buffer.append(" ").append(cs.getSchemaName());
        }
        if (cs.getAuthorization() != null) {
            buffer.append(" AUTHORIZATION ").append(cs.getAuthorization());
        }
    }
}
