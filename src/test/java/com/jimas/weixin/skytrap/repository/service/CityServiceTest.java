package com.jimas.weixin.skytrap.repository.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.base.Charsets;
import com.google.gson.reflect.TypeToken;
import com.jimas.common.util.GsonUtil;
import com.jimas.weixin.skytrap.BaseTest;
import com.jimas.weixin.skytrap.repository.entity.City;

public class CityServiceTest extends BaseTest {

    @Autowired
    private CityService cityService;

    @Test
    public void testSaveCity() {
        try {
            String template_path = CityServiceTest.class.getResource("/").getPath();
            template_path = template_path.replace("target/test-classes/", "src/main/webapp/static/json/");
            String cityJson = com.google.common.io.Resources.toString(com.google.common.io.Resources.getResource(template_path+"areas.json"), Charsets.UTF_8);
            @SuppressWarnings("unchecked")
            List<City> resList = (List<City>) GsonUtil.parseJsonList(cityJson, new TypeToken<ArrayList<City>>() {
            }.getType());
            for (City cityRes : resList) {
                cityService.saveCity(cityRes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
