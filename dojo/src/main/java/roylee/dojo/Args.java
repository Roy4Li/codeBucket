package roylee.dojo;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class Args {
    private List<String> booleanSchemaList;
    private String[] arguments;


    public Args() {
    }

    public Args(String schema, String[] arguments) {
        this.arguments = arguments;
        parseSchema(schema);
    }

    private void parseSchema(String schemaStr) {
        String[] schemaArray = schemaStr.split(" ");
        for (String schema : schemaArray) {
            if (schema.length() == 1) {
                addBooleanSchema(schema);
            }
        }
    }

    private void addBooleanSchema(String boolSchema) {
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
}
