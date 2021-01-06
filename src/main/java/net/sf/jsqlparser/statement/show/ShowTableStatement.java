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

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitor;

/**
 * A {@code SHOW TABLES} statement
 * @see <a href="https://dev.mysql.com/doc/refman/8.0/en/show-table-status.html">MySQL show table status</a>
 */
public class ShowTableStatement implements Statement {

    private SelectionMode selectionMode;
    private String dbName;
    private Expression likeExpression;
    private Expression whereCondition;

    public SelectionMode getSelectionMode() {
        return selectionMode;
    }

    public void setSelectionMode(SelectionMode selectionMode) {
        this.selectionMode = selectionMode;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public Expression getLikeExpression() {
        return likeExpression;
    }

    public void setLikeExpression(Expression likeExpression) {
        this.likeExpression = likeExpression;
    }

    public Expression getWhereCondition() {
        return whereCondition;
    }

    public void setWhereCondition(Expression whereCondition) {
        this.whereCondition = whereCondition;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SHOW TABLE STATUS");

        if (dbName != null) {
            builder.append(" ").append(selectionMode.name()).append(" ").append(dbName);
        }

        if (likeExpression != null) {
            builder.append(" ").append("LIKE").append(" ").append(likeExpression);
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
