package uk.gov.moj.anonymisation;


import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RuleParser {

    public static final String EVENT_NAME = "eventName";
    public static final String FIELDS_TO_BE_ANONYMISED = "fieldsToBeAnonymised";

    public Map<String, Map<String, String>> loadAnanymisationRules(String ruleFileName) {

        StringWriter writer = new StringWriter();
        try {
            InputStream stream = RuleParser.class.getResourceAsStream(ruleFileName);
            IOUtils.copy(stream, writer, "UTF-8");
            SchemaValidatorUtil.validateAgainstSchema("/schema/data-anon.json", writer.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't find data anonymisation rule.");
        }

        JSONObject rules = new JSONObject(writer.toString());
        JSONArray array = rules.getJSONArray("events");
        Map<String, Map<String, String>> rulesMap = new HashMap();

        for(int i = 0; i < array.length(); i++) {
            JSONObject eventObject = array.getJSONObject(i);
            String eventName = eventObject.getString(EVENT_NAME);
            JSONArray fieldsToBeAnonymisedArray = eventObject.getJSONArray(FIELDS_TO_BE_ANONYMISED);
            Map<String, String> ananymisationRules = new HashMap();

            for (int j = 0; j < fieldsToBeAnonymisedArray.length(); j++) {
                JSONObject fieldToBeAnonymised = fieldsToBeAnonymisedArray.getJSONObject(j);
                Set<String> keys = fieldToBeAnonymised.keySet();
                for(String key : keys) {
                    String keyValue = (String) fieldToBeAnonymised.get(key);
                    ananymisationRules.put(key, keyValue);
                }
                rulesMap.put(eventName, ananymisationRules);
            }
        }
        return rulesMap;
    }
}
