package com.adrian.spring.graphql.hplus.controller;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.jspecify.annotations.Nullable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class HPlusExceptionHandler extends DataFetcherExceptionResolverAdapter {
    @Override
    protected @Nullable GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        ErrorType errorType = null;
        if (ex instanceof DataIntegrityViolationException) {
            errorType = ErrorType.BAD_REQUEST;
        } else {
        errorType = ErrorType.INTERNAL_ERROR;
         }
          return  GraphqlErrorBuilder.newError(env).message("Received message: " + ex.getMessage()).errorType(errorType).build() ;
    }
}
