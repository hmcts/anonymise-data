package uk.gov.moj.anonymisation.generator;

import java.util.regex.Pattern;

import com.mifmif.common.regex.Generex;

public class RegexGenerator extends Generator<String> {

    private final Generex generex;

    public RegexGenerator(final Pattern pattern) {
        generex = new Generex(pattern.toString());
    }

    @Override
    public String convert(final String fieldValue) {
        return generex.random();
    }
}