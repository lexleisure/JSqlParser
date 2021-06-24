/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.util.validation.validator;

import net.sf.jsqlparser.parser.feature.Feature;
import net.sf.jsqlparser.statement.create.schema.CreateSchema;
import net.sf.jsqlparser.util.validation.metadata.NamedObject;

/**
 * @author lex
 */
public class CreateSchemaValidator extends AbstractValidator<CreateSchema> {

    @Override
    public void validate(CreateSchema createSchema) {
        validateFeatureAndName(Feature.createSchema, NamedObject.schema, createSchema.getSchemaName());
    }
}
