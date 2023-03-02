package Pages.com.Json;

    import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
        //this is for reading data from the json file
        public class JsonData
        {
        public String  read(String attribute) throws Exception {
            JsonParser jsonParser = new JsonParser();
            FileReader reader = new FileReader(System.getProperty("user.dir") + "/readdata/readingdatafromjson.json");
            Object obj = jsonParser.parse(reader);
            JsonObject jsonObject = (JsonObject) obj;
            String value = jsonObject.get(attribute).getAsString();
            return value;
        }
    }

