package uk.gov.moj.anonymisation;

import java.io.InputStream;
import java.net.URL;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchemaValidatorUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchemaValidatorUtil.class);

    public static void validateAgainstSchema(final String schemaFileName, final String jsonString) {
        final URL resource = SchemaValidatorUtil.class.getResource(schemaFileName);
        try (InputStream inputStream = resource.openStream()) {
            JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));

            Schema schema = SchemaLoader.load(rawSchema);

            schema.validate(new JSONObject(jsonString));

        } catch (Exception e) {
            LOGGER.error("Error validating payload against schema", e);
            throw new RuntimeException("Error validating payload against schema");

        }
    }
}
