package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * FilterRule is one clause of a segment list's membership query.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilterRule {

    private String field;

    private String operator;

    private Object value;

    public FilterRule field(String field) { this.field = field; return this; }
    public String getField() { return field; }
    public FilterRule operator(String operator) { this.operator = operator; return this; }
    public String getOperator() { return operator; }
    public FilterRule value(Object value) { this.value = value; return this; }
    public Object getValue() { return value; }
}
