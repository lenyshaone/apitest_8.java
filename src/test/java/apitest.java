import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import jdk.jfr.Description;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
public class apitest {
    @Test
    @Description(value = "Тест проверяет, что больше всего фактов написал Kasimir Schulz")
    void Test_01() {
       String expected_user = "Kasimir Schulz";
        Object actual_user;
    Map<Object, Long> collect_users = RestAssured.get("https://cat-fact.herokuapp.com/facts").
                jsonPath().
                getList("all", Responces.class).
                stream().filter(e -> e.getUser() != null).collect(
                Collectors.groupingBy(res-> res.getUser().getName().get_first_last(), Collectors.counting()));
        actual_user=  Collections.max(collect_users.entrySet(), Map.Entry.comparingByValue()).getKey();
        Assert.assertEquals(actual_user,expected_user);
    }
}















