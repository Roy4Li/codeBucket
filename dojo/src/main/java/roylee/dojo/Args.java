package roylee.dojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Args {
    private List<Character> booleanSchemaList;
    private List<Character> intSchemaList;
    private Map<Character, Integer> intArgMap;
    private String[] arguments;


    public Args() {
    }

    public Args(String schema, String[] arguments) {
        this.arguments = arguments;
        parseSchema(schema);
        parseArguments(arguments);
    }

    private void parseArguments(String[] arguments) {
        if (nonNull(intSchemaList) && intSchemaList.size() > 0) {
            parseIntArgs(arguments);
        }
    }

    private void parseIntArgs(String[] arguments) {
        for (Character intSchema : intSchemaList) {
            // find int value
            for (int i = 0; i < arguments.length; i++) {
                if (arguments[i].matches("-" + intSchema) && i + 1 < arguments.length) {
                    String intStr = arguments[i + 1];
                    addToIntArgMap(intSchema, Integer.parseInt(intStr));
                }
            }
        }
    }

    private void addToIntArgMap(Character intSchema, Integer intValue) {
        if (isNull(intArgMap)) {
            intArgMap = new HashMap<>();
        }
        intArgMap.put(intSchema, intValue);
    }

    private void parseSchema(String schemaStr) {
        String[] schemaArray = schemaStr.split(",");
        for (String schema : schemaArray) {
            if (schema.length() == 1) {
                addBooleanSchema(schema.charAt(0));
            }
            if (schema.length() == 2 && schema.matches("[a-zA-Z]#")) {
                Character intSchema = schema.charAt(0);
                addIntSchema(intSchema);
            }
        }
    }

    private void addIntSchema(Character intSchema) {
        if (isNull(intSchemaList)) {
            intSchemaList = new ArrayList<>();
        }
        intSchemaList.add(intSchema);
    }

    private void addBooleanSchema(Character boolSchema) {
        if (isNull(booleanSchemaList)) {
            booleanSchemaList = new ArrayList<>();
        }
        booleanSchemaList.add(boolSchema);
    }

    public boolean getBoolean(String letter) {
        if (!booleanSchemaList.contains(letter)) {
            return false;
        }
        if (isNull(arguments) || arguments.length == 0) {
            return false;
        }
        for (String arg : arguments) {
            if (arg.equals("-" + letter)) {
                return true;
            }
        }
        return false;
    }

    public int getInt(Character schemaChar) {

        return Integer.parseInt(arguments[1]);
    }
}
