package org.tserkovnikov.apitests.tests;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tserkovnikov.apitests.apicommands.TendersAPI;

public class TendersTests extends TendersAPI{

    @Test
    public void GetThreeTenders() {
        JsonPath result = getFirstThreeTenders("2953");
        Assert.assertEquals(result.get("result.args.max_rows"), "3"); // проверяем, что наш запрос вернул только 3 записи
        Assert.assertEquals(result.get("result.data[0].company_name"), "КАМАЗ"); // проверяем название фирмы, которая огранизует тендер
        // очевидно, что имея json мы можем проверить любые параметры
    }
}
