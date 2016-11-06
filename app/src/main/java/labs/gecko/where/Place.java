package labs.gecko.where;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



/**
 * Created by punkah on 11/5/2016.
 */
public class Place {
    public String reference;
    public String name;
    public String icon;
    public String formatted_address;
    public String formatted_phone_number;

    @Override
    public String toString() {
        return this.name;
    }
}