package org.tserkovnikov.apitests.tests;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tserkovnikov.apitests.apicommands.TendersAPI;

public class TendersTests {

    @Test
    public void GetThreeTenders() {
        TendersAPI api = new TendersAPI(); // это, конечно, костыль.
        JsonPath result = api.getFirstThreeTenders("2953");
        Assert.assertEquals("3", result.get("result.args.max_rows")); // проверяем, что наш запрос вернул только 3 записи
        Assert.assertEquals("КАМАЗ", result.get("result.data[0].company_name")); // проверяем название фирмы, которая огранизует тендер
        // очевидно, что имея json мы можем проверить любые параметры
    }
}
