package uk.gov.moj.anonymisation.generator;

public class AnonymizeGenerator extends Generator<String> {

    Generator<String> generator;
    private final static String EMAIL_RULE = "anonymisedEmail";
    private final static String URI_RULE = "anonymisedURI";
    private final static String PAST_DATE_RULE = "anonymisedPastDate";
    private final static String FUTURE_DATE_RULE = "anonymisedFutureDate";
    private final static String DOB_RULE = "anonymisedDOB";
    private final static String SIMPLE_STRING_RULE = "anonymisedString";
    private final static String PHONE_RULE = "anonymisedPhoneNumber";
    private final static String POST_CODE_RULE = "anonymisedPostcode";

    public Generator<String> getGenerator(String rule){
        switch (rule) {
            case EMAIL_RULE:
                generator = new EmailGenerator();
                break;
            case URI_RULE:
                generator = new UriGenerator();
                break;
            case PAST_DATE_RULE:
                generator = new PastDateGenerator();
                break;
            case FUTURE_DATE_RULE:
                generator = new FutureDateGenerator();
                break;
            case DOB_RULE:
                generator = new RandomDateOfBirthGenerator();
                break;
            case SIMPLE_STRING_RULE:
                generator = new SimpleStringGenerator();
                break;
            case PHONE_RULE:
                generator = new PhoneNumberGenerator();
                break;
            case POST_CODE_RULE:
                generator = new PostCodeGenerator();
                break;
            default:
                break;
        }
        return generator;
    }



    @Override
    public String convert(final String fieldValue) {
        return generator.convert(fieldValue);
    }
}
