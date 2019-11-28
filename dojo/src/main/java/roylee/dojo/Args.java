package roylee.dojo;

import java.util.Map;

public class Args {
    private Map<String,Object> schemaMap;
    private String[] arguments;



    public Args() {
    }

    public Args(String schema, String[] arguments) {
        Args instance = new Args();
        instance.setArguments(arguments);
    }

    public Map<String, Object> getSchemaMap() {
        return schemaMap;
    }

    public void setSchemaMap(Map<String, Object> schemaMap) {
        this.schemaMap = schemaMap;
    }

    public String[] getArguments() {
        return arguments;
    }

    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }

    public boolean getBoolean(String l) {
        return true;
    }
}
