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
import net.sf.jsqlparser.statement.ShowIndexStatement;
import net.sf.jsqlparser.util.validation.metadata.NamedObject;

/**
 * @author gitmotte
 */
public class ShowIndexStatementValidator extends AbstractValidator<ShowIndexStatement> {

    @Override
    public void validate(ShowIndexStatement show) {
        validateFeatureAndName(Feature.showIndex, NamedObject.index, show.getTableName());
    }
}
