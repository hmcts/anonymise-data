package uk.gov.moj.anonymisation.generator;

public class PostCodeGenerator extends Generator<String> {
    @Override
    public String convert(final String fieldValue) {
        return "AA1 1AA";
    }
}
