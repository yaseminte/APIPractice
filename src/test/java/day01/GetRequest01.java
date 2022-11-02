package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    @Test
    public void test01() {

        String url = "https://restful-booker.herokuapp.com/booking";

        Response response = given().auth().basic("user","password").when().get(url);
        // given().when().get(url); end point'e göndermek için request oluşturmuş olduk.
        // Response response -> api tarafından bana dönen response (cevap)
        // Response response = given().auth().basic("user","password").when().get(url);
        // basic aut ile request göndermek için

        // response.prettyPrint();   // response'daki body'i yazdırır

        // response.prettyPeek();       // response'daki her şeyi yazdırır

        // response.peek();          // tüm veriyi string olarak verir.

        // response.print();
        // [{"bookingid":1215},{"bookingid":844},{"bookingid":87}, ...]


        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
        System.out.println(response.contentType());

        // 1) JUnit Assert'leri ile API testi yapabiliriz
        Assert.assertEquals("Status Kod Hatalı",200,response.statusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.statusLine());
        Assert.assertEquals("application/json; charset=utf-8",response.contentType());

        // 2) assertthat ile
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");

    }
}
