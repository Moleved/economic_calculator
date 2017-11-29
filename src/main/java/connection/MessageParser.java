package connection;

import java.util.HashMap;

public class MessageParser {
    private String message;

    private String appId;
    private String method;
    private String object;
    private String values;

    public MessageParser(String message) {
        this.message = message;

        parse();
    }

    public void parse() {
        String[] arr = message.split(";");

        this.appId = arr[0];
        this.method = arr[1];
        this.object = arr[2];
        this.values = arr[3];
    }

    public String getAppId() {
        return appId;
    }

    public String getMethod() {
        return method;
    }

    public String getObject() {
        return object;
    }

    public HashMap<String, String> getValues() {
        HashMap<String, String> map = new HashMap<String, String>();

        String[] arr = values.split(",");

        for (String elem : arr) {
            String[] tmp = elem.split(":");
            map.put(tmp[0], tmp[1]);
        }

        return map;
    }
}
