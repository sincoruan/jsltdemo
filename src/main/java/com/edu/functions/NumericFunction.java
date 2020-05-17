package com.edu.functions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumericFunction implements Function {
    public static final String NUM_FUNCTION = "num_func";
    public String getName() {
        return NUM_FUNCTION;
    }

    public int getMinArguments() {
        return 1;
    }

    public int getMaxArguments() {
        return 3;
    }

    public JsonNode call(JsonNode input, JsonNode[] arguments) {
        Pattern p = Pattern.compile("(?s)[0-9.]]+");
        String value = arguments[0].textValue();
        if(value==null) value = "";
        Matcher m = p.matcher(value);
        String lastNumber = "";
        while(m.find()){
            lastNumber = m.group();
        }
        return new TextNode(lastNumber);
    }
}
