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

import net.sf.jsqlparser.expression.Expression;

/**
 * only support show index from ...
 * indexes and keys not supported, please use index instead.
 *
 * dev.mysql.com/doc/refman/5.7/en/show-index.html
 * */
public class ShowIndexStatement implements Statement {

    private String tableName;

    private SelectionMode tableSelectionMode;

    private String dbName;

    private SelectionMode dbSelectionMode;

    private Expression whereCondition;

    public ShowIndexStatement() {
        // empty constructor
    }

    public ShowIndexStatement(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public SelectionMode getTableSelectionMode() {
        return tableSelectionMode;
    }

    public void setTableSelectionMode(SelectionMode tableSelectionMode) {
        this.tableSelectionMode = tableSelectionMode;
    }

    public SelectionMode getDbSelectionMode() {
        return dbSelectionMode;
    }

    public void setDbSelectionMode(SelectionMode dbSelectionMode) {
        this.dbSelectionMode = dbSelectionMode;
    }

    public Expression getWhereCondition() {
        return whereCondition;
    }

    public void setWhereCondition(Expression whereCondition) {
        this.whereCondition = whereCondition;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("SHOW INDEX");
        builder.append(" ").append(tableSelectionMode.name()).append(" ").append(tableName);
        if (dbName != null) {
            builder.append(" ").append(dbSelectionMode.name()).append(" ").append(dbName);
        }

        if (whereCondition != null) {
            builder.append(" ").append("WHERE").append(" ").append(whereCondition);
        }
        return builder.toString();
    }

    @Override
    public void accept(StatementVisitor statementVisitor) {
        statementVisitor.visit(this);
    }

    public enum SelectionMode {
        FROM, IN
    }

}
