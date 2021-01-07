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

import java.util.EnumSet;

public class ShowColumnsStatement implements Statement {

    private String tableName;
    private SelectionMode tableSelectionMode;
    private String dbName;
    private SelectionMode dbSelectionMode;
    private Expression likeExpression;
    private Expression whereCondition;

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
        builder.append("SHOW");
        if (modifiers.contains(Modifiers.FULL)) {
            builder.append(" FULL");
        }
        builder.append(" COLUMNS ").append(tableSelectionMode.name()).append(" ").append(tableName);
        if (dbName != null) {
            builder.append(" ").append(dbSelectionMode.name()).append(" ").append(dbName);
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

    public enum SelectionMode {
        FROM, IN
    }
}
