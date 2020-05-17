package com.edu;

import com.edu.functions.Function;
import com.edu.functions.NumericFunction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.schibsted.spt.data.jslt.Expression;
import com.schibsted.spt.data.jslt.Parser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestJslt {
    public static void main(String[] args) throws JsonProcessingException {

        List<Function> collection = Arrays.asList(new NumericFunction());

        String json =
                "{\n" +
                        "  \"schema\" : \"http://schemas.schibsted.io/thing/pulse-simple.json#1.json\",\n" +
                        "  \"id\" : \"94b27ca1-8729-4773-986b-1c0517dd6af1\",\n" +
                        "  \"published\" : \"2017-05-04T09:13:29+02:00\",\n" +
                        "  \"type\" : \"View1\",\n" +
                        "  \"num\" : \"123\",\n" +
                        "  \"environmentId\" : \"urn:schibsted.com:environment:uuid\",\n" +
                        "  \"url\" : \"http://www.aftenposten.no/\"\n" +
                        "}\n";
        String query =
                "{\n" +
                        "  \"type\" : if (.type and .type != \"View\") .type,\n" +
                        "  * : .\n" +
                        "}";
        InputStream inputStream  = null;
        String inputstr = null;
        try{
            Class classobj  =Class.forName(TestJslt.class.getName());
            inputStream = classobj.getResourceAsStream("/test.jslt");
            Scanner scanner = new Scanner(inputStream);
            inputstr = scanner.useDelimiter("\\A").next();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(inputstr);

        ObjectMapper objectMapper =  new ObjectMapper();
        JsonNode input = objectMapper.readTree(json);
        List<Function> list =new ArrayList<Function>();
        list.add(new NumericFunction());
        Expression jslt = Parser.compileString(inputstr, list);
        JsonNode output = jslt.apply(input);
        System.out.println(output.toPrettyString());
    }
}
