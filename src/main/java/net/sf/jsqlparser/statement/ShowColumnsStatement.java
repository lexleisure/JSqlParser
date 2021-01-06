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

import java.util.EnumSet;

public class ShowColumnsStatement implements Statement {

    private String tableName;

    private EnumSet<Modifiers> modifiers;

    public ShowColumnsStatement() {
        // empty constructor
    }

    public ShowColumnsStatement(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SHOW");
        if (modifiers.contains(Modifiers.FULL)) {
            builder.append(" FULL");
        }
        builder.append(" COLUMNS FROM ").append(tableName);
        return builder.toString();
    }

    @Override
    public void accept(StatementVisitor statementVisitor) {
        statementVisitor.visit(this);
    }

    public ShowColumnsStatement withTableName(String tableName) {
        this.setTableName(tableName);
        return this;
    }

    public EnumSet<Modifiers> getModifiers() {
        return modifiers;
    }

    public void setModifiers(EnumSet<Modifiers> modifiers) {
        this.modifiers = modifiers;
    }

    public enum Modifiers {
        FULL
    }
}
