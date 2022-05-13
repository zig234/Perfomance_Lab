package test3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Three {
    public static void main(String[] msi) throws IOException, ParseException {
        create(compare(tests("src\\main\\java\\test3\\tests.json"), values("src\\main\\java\\test3\\values.json")));
        //create(compare(tests(msi[0].trim()), values(msi[1].trim())));
    }

    public static void create(JSONArray jarr) {
        try {
            try (FileWriter file = new FileWriter("src\\main\\java\\test3\\report.json")) {
                file.write(jarr.toJSONString());
                file.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONArray compare(JSONArray tests, JSONArray value) {
        int x = -1;
        int y;
        while (++x < tests.size()) {
            if (((JSONObject) tests.get(x)).get("values") != null)
                compare((JSONArray) ((JSONObject) tests.get(x)).get("values"), value);
            y = -1;
            while (++y < value.size()) {
                if (((JSONObject) tests.get(x)).get("id").equals(((JSONObject) value.get(y)).get("id")))
                    ((JSONObject) tests.get(x)).put("value", ((JSONObject) value.get(y)).get("value"));
            }
        }
        return tests;
    }

    public static void print(JSONArray jarr) {
        int i = -1;
        while (++i < jarr.size()) {
            if (((JSONObject) jarr.get(i)).get("values") != null)
                print((JSONArray) ((JSONObject) jarr.get(i)).get("values"));
            System.out.print(((JSONObject) jarr.get(i)).get("id") + "  ");
            System.out.println(((JSONObject) jarr.get(i)).get("value"));
        }
    }

    public static JSONArray tests(String name) throws IOException, ParseException {
        JSONObject jsonObject = ((JSONObject) new JSONParser().parse(new FileReader(name)));
        JSONArray jsonarr = ((JSONArray) jsonObject.get("tests"));
        return jsonarr;
    }

    public static JSONArray values(String name) throws IOException, ParseException {
        FileReader reader = new FileReader(name);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray jsonarr = ((JSONArray) jsonObject.get("values"));
        return jsonarr;
    }

}
