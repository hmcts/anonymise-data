package uk.gov.moj.anonymisation.generator;


public class SimpleStringGenerator extends Generator<String> {


    @Override
    public String convert(String fieldValue) {
        return "XXXXX";
    }
}
