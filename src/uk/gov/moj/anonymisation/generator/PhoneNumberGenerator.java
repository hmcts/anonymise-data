package uk.gov.moj.anonymisation.generator;

public class PhoneNumberGenerator extends Generator<String> {
    @Override
    public String convert(final String fieldValue) {
        return "0123456789";
    }
}
