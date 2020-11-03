import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class apitest {
    @Test
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















