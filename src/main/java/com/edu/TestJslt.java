package com.edu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.schibsted.spt.data.jslt.Expression;
import com.schibsted.spt.data.jslt.Parser;

public class TestJslt {
    public static void main(String[] args) throws JsonProcessingException {
        String json =
                "{\n" +
                        "  \"schema\" : \"http://schemas.schibsted.io/thing/pulse-simple.json#1.json\",\n" +
                        "  \"id\" : \"94b27ca1-8729-4773-986b-1c0517dd6af1\",\n" +
                        "  \"published\" : \"2017-05-04T09:13:29+02:00\",\n" +
                        "  \"type\" : \"View1\",\n" +
                        "  \"environmentId\" : \"urn:schibsted.com:environment:uuid\",\n" +
                        "  \"url\" : \"http://www.aftenposten.no/\"\n" +
                        "}\n";
        String query =
                "{\n" +
                        "  \"type\" : if (.type and .type != \"View\") .type,\n" +
                        "  * : .\n" +
                        "}";
        System.out.println(json);
        ObjectMapper objectMapper =  new ObjectMapper();
        JsonNode input = objectMapper.readTree(json);
        Expression jslt = Parser.compileString(query);
        JsonNode output = jslt.apply(input);
        System.out.println(output.toPrettyString());
    }
}
