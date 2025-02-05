package uk.gov.moj.anonymisation.generator;

public class UriGenerator extends Generator<String> {

    private final uk.gov.justice.services.test.utils.core.random.UriGenerator generator =
            new uk.gov.justice.services.test.utils.core.random.UriGenerator();

    @Override
    public String convert(String value) {
        return generator.next().toString();
    }
}
