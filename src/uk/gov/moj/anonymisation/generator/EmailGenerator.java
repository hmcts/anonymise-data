package uk.gov.moj.anonymisation.generator;


public class EmailGenerator extends Generator<String> {


    @Override
    public String convert(String fieldValue) {
        return "xyz@mail.com";
    }
}
