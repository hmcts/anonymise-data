package uk.gov.moj.anonymisation.generator;

public abstract class Generator<T> {

    public Generator() {

    }

    public abstract T convert(String fieldValue);

}
