/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement.create.schema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitor;

/**
 * support mysql
 * reference: https://dev.mysql.com/doc/refman/8.0/en/create-database.html
 */
public class CreateSchema implements Statement {

    private String authorization;
    private SchemaKey schemaKey = SchemaKey.SCHEMA;
    private String keyIf;
    private String keyNot;
    private String keyExists;
    private String schemaName;
    private List<String> schemaPath;
    private List<Statement> statements = new ArrayList<>();

    @Override
    public void accept(StatementVisitor statementVisitor) {
        statementVisitor.visit(this);
    }

    /**
     * Add a statement to the schema definition
     *
     * @param statement The statement to be added
     * @return true if the operation was successful
     *
     */
    public boolean addStatement(Statement statement) {
        return statements.add(statement);
    }

    /**
     * The owner of the schema.
     *
     * @return Owner name
     *
     */
    public String getAuthorization() {
        return authorization;
    }

    /**
     * The name of the schema
     *
     * @return Schema name
     */
    public String getSchemaName() {
        return schemaName;
    }

    /**
     * The path of the schema
     *
     * @return Schema path
     *
     */
    public List<String> getSchemaPath() {
        return schemaPath;
    }

    /**
     * The statements executed as part of the schema creation
     *
     * @return the statements
     *
     */
    public List<Statement> getStatements() {
        return statements;
    }

    /**
     * The owner of the schems.
     *
     * @param authorization Owner name
     *
     */
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    /**
     * Set the name of the schema
     *
     * @param schemaName Schema name
     *
     */
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public SchemaKey getSchemaKey() {
        return schemaKey;
    }

    public void setSchemaKey(SchemaKey schemaKey) {
        this.schemaKey = schemaKey;
    }

    /**
     * Set the path of the schema
     *
     * @param schemaPath Schema path
     *
     */
    public void setSchemaPath(List<String> schemaPath) {
        this.schemaPath = schemaPath;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE ").append(schemaKey.name());
        if(keyIf != null){
            builder.append(" IF");
        }
        if(keyNot != null){
            builder.append(" NOT");
        }
        if(keyExists != null){
            builder.append(" EXISTS");
        }
        if (schemaName != null) {
            builder.append(" ").append(schemaName);
        }
        if (authorization != null) {
            builder.append(" AUTHORIZATION ").append(authorization);
        }
        return builder.toString();
    }

    public CreateSchema withAuthorization(String authorization) {
        this.setAuthorization(authorization);
        return this;
    }

    public CreateSchema withSchemaName(String schemaName) {
        this.setSchemaName(schemaName);
        return this;
    }

    public CreateSchema withSchemaPath(List<String> schemaPath) {
        this.setSchemaPath(schemaPath);
        return this;
    }

    public CreateSchema addSchemaPath(String... schemaPath) {
        List<String> collection = Optional.ofNullable(getSchemaPath()).orElseGet(ArrayList::new);
        Collections.addAll(collection, schemaPath);
        return this.withSchemaPath(collection);
    }

    public CreateSchema addSchemaPath(Collection<String> schemaPath) {
        List<String> collection = Optional.ofNullable(getSchemaPath()).orElseGet(ArrayList::new);
        collection.addAll(schemaPath);
        return this.withSchemaPath(collection);
    }

    public String getKeyIf() {
        return keyIf;
    }

    public void setKeyIf(String keyIf) {
        this.keyIf = keyIf;
    }

    public String getKeyNot() {
        return keyNot;
    }

    public void setKeyNot(String keyNot) {
        this.keyNot = keyNot;
    }

    public String getKeyExists() {
        return keyExists;
    }

    public void setKeyExists(String keyExists) {
        this.keyExists = keyExists;
    }

    public enum SchemaKey {
        SCHEMA, DATABASE
    }

}
