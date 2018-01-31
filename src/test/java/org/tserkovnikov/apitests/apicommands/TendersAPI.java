package org.tserkovnikov.apitests.apicommands;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.get;

public class TendersAPI {

    public JsonPath getFirstThreeTenders(String companyId) {
        String url = "http://www.tender.pro/api/_info.tenderlist_by_set.json?_key=1732ede4de680a0c93d81f01d7bac7d1&set_type_id=1&set_id=" + companyId + "&max_rows=3&open_only=true";
        Response res = get(url);
        Assert.assertEquals(200, res.getStatusCode());
        String json = res.asString();
        JsonPath jp = new JsonPath(json);
        return jp;
    }
}
