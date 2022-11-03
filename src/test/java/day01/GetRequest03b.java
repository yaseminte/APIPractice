package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest03b {

    String url = "https://reqres.in/api/users?page=2";


    @Test
    public void test07() {

         /*

       "data":
       {
            "id": 7,
            "email": "michael.lawson@reqres.in",
            "first_name": "Michael",
            "last_name": "Lawson",
            "avatar": "https://reqres.in/img/faces/7-image.jpg"
       },
       "support": {
             "url": "https://reqres.in/#support-heading",
             "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
    statusCode = 200
    statusLine = "HTTP/1.1 200 OK";
    Content-Type = "application/json; charset=utf-8"

     */

        Response response = given().when().get(url);


        // HEADER TESTI ICIN

        // 1) JUnit Assert
        assertEquals(200, response.getStatusCode());
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
        assertEquals("application/json; charset=utf-8", response.getContentType());

        // 2) assertThat ile
        response.then().assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType("application/json; charset=utf-8");


        // BODY TESTI ICIN

        // Matchers Class Ile
        response.then().body("data[0].id", equalTo(7));
        response.then().body("data[0].email", equalTo("michael.lawson@reqres.in"));
        response.then().body("data[0].first_name", equalTo("Michael"));
        response.then().body("data[0].last_name", equalTo("Lawson"));
        response.then().body("data[0].avatar", equalTo("https://reqres.in/img/faces/7-image.jpg"));

        response.then().body("support.url", equalTo("https://reqres.in/#support-heading"));
        response.then().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

        // SoftAssert ile
        response.then().assertThat().body("data[0].id", equalTo(7),
                "data[0].email", equalTo("michael.lawson@reqres.in"),
                "data[0].first_name", equalTo("Michael"),
                "data[0].last_name", equalTo("Lawson"),
                "data[0].avatar", equalTo("https://reqres.in/img/faces/7-image.jpg"),
                "support.url", equalTo("https://reqres.in/#support-heading"),
                "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }

    @Test
    public void test08() {

        /*
          "data":
         {
            "id": 8,
            "email": "lindsay.ferguson@reqres.in",
            "first_name": "Lindsay",
            "last_name": "Ferguson",
            "avatar": "https://reqres.in/img/faces/8-image.jpg"
        },
         "support": {
             "url": "https://reqres.in/#support-heading",
             "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
           statusCode = 200
           statusLine = "HTTP/1.1 200 OK";
           Content-Type = "application/json; charset=utf-8"

         */


        Response response = given().when().get(url);

        // HEADER ICIN

        // 1) JUnit Assert
        assertEquals(200, response.getStatusCode());
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
        assertEquals("application/json; charset=utf-8", response.getContentType());

        // 2) assertThat ile
        response.then().assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType(ContentType.JSON);

        // BODY TESTI ICIN

        // Matchers Class ile
        response.then().body("data[1].id", equalTo(8));
        response.then().body("data[1].email", equalTo("lindsay.ferguson@reqres.in"));
        response.then().body("data[1].first_name", equalTo("Lindsay"));
        response.then().body("data[1].last_name", equalTo("Ferguson"));
        response.then().body("data[1].avatar", equalTo("https://reqres.in/img/faces/8-image.jpg"));

        response.then().body("support.url", equalTo("https://reqres.in/#support-heading"));
        response.then().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

        // Soft Assert ile
        response.then().assertThat().body("data[1].id", equalTo(8),
                "data[1].email", equalTo("lindsay.ferguson@reqres.in"),
                "data[1].first_name", equalTo("Lindsay"),
                "data[1].last_name", equalTo("Ferguson"),
                "data[1].avatar", equalTo("https://reqres.in/img/faces/8-image.jpg"),
                "support.url", equalTo("https://reqres.in/#support-heading"),
                "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }

    @Test
    public void test09() {
        /*
          "data":
         {
            "id": 9,
            "email": "tobias.funke@reqres.in",
            "first_name": "Tobias",
            "last_name": "Funke",
            "avatar": "https://reqres.in/img/faces/9-image.jpg"
        },
         "support": {
             "url": "https://reqres.in/#support-heading",
             "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
           statusCode = 200
           statusLine = "HTTP/1.1 200 OK";
           Content-Type = "application/json; charset=utf-8"

         */

        Response response = given().when().get(url);

        // HEADER ICIN
        // 1) JUnit Assert
        assertEquals(200, response.getStatusCode());
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
        assertEquals("application/json; charset=utf-8", response.getContentType());

        // assertThat ile
        response.then().assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType("application/json; charset=utf-8");

        // BODY TESTI ICIN
        // Matchers Class ile
        response.then().body("data[2].id", equalTo(9));
        response.then().body("data[2].email", equalTo("tobias.funke@reqres.in"));
        response.then().body("data[2].first_name", equalTo("Tobias"));
        response.then().body("data[2].last_name", equalTo("Funke"));
        response.then().body("data[2].avatar", equalTo("https://reqres.in/img/faces/9-image.jpg"));

        response.then().body("support.url", equalTo("https://reqres.in/#support-heading"));
        response.then().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

        // SoftAssert ile
        response.then().assertThat().body("data[2].id", equalTo(9),
                "data[2].email", equalTo("tobias.funke@reqres.in"),
                "data[2].first_name", equalTo("Tobias"),
                "data[2].last_name", equalTo("Funke"),
                "data[2].avatar", equalTo("https://reqres.in/img/faces/9-image.jpg"),
                "support.url", equalTo("https://reqres.in/#support-heading"),
                "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


    }

    @Test
    public void test10() {
        /*
          "data":
         {
           "id": 10,
            "email": "byron.fields@reqres.in",
            "first_name": "Byron",
            "last_name": "Fields",
            "avatar": "https://reqres.in/img/faces/10-image.jpg"
        },
         "support": {
             "url": "https://reqres.in/#support-heading",
             "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
           statusCode = 200
           statusLine = "HTTP/1.1 200 OK";
           Content-Type = "application/json; charset=utf-8"

         */

        Response response = given().when().get(url);

        // HEADER TESTI ICIN
        // 1) JUnit Assert
        assertEquals(200, response.getStatusCode());
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
        assertEquals("application/json; charset=utf-8", response.getContentType());

        // 2) assertThat
        response.then().assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType("application/json; charset=utf-8");

        // BODY TESTI ICIN
        // Matcher Class ile

        response.then().body("data[3].id", equalTo(10));
        response.then().body("data[3].email", equalTo("byron.fields@reqres.in"));
        response.then().body("data[3].first_name", equalTo("Byron"));
        response.then().body("data[3].last_name", equalTo("Fields"));
        response.then().body("data[3].avatar", equalTo("https://reqres.in/img/faces/10-image.jpg"));

        response.then().body("support.url", equalTo("https://reqres.in/#support-heading"));
        response.then().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

        // SoftAssert ile
        response.then().assertThat().body("data[3].id", equalTo(10),
                "data[3].email", equalTo("byron.fields@reqres.in"),
                "data[3].first_name", equalTo("Byron"),
                "data[3].last_name", equalTo("Fields"),
                "data[3].avatar", equalTo("https://reqres.in/img/faces/10-image.jpg"),
                "support.url", equalTo("https://reqres.in/#support-heading"),
                "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }
    @Test
    public void test11() {

        /*
          "data":
         {
            "id": 11,
            "email": "george.edwards@reqres.in",
            "first_name": "George",
            "last_name": "Edwards",
            "avatar": "https://reqres.in/img/faces/11-image.jpg"
        },
         "support": {
             "url": "https://reqres.in/#support-heading",
             "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
           statusCode = 200
           statusLine = "HTTP/1.1 200 OK";
           Content-Type = "application/json; charset=utf-8"

         */

        Response response = given().when().get(url);

        // HEADER TESTI ICIN
        // 1) JUnit Assert
        assertEquals(200,response.getStatusCode());
        assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
        assertEquals("application/json; charset=utf-8",response.getContentType());

        // 2) assertThat
        response.then().assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType(ContentType.JSON);

        // BODY TESTI ICIN
        // Matcher Class ile
        response.then().body("data[4].id",equalTo(11));
        response.then().body("data[4].email",equalTo("george.edwards@reqres.in"));
        response.then().body("data[4].first_name",equalTo("George"));
        response.then().body("data[4].last_name",equalTo("Edwards"));
        response.then().body("data[4].avatar",equalTo("https://reqres.in/img/faces/11-image.jpg"));

        response.then().body("support.url",equalTo("https://reqres.in/#support-heading"));
        response.then().body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

        // SoftAssert ile
        response.then().assertThat().body("data[4].id",equalTo(11),
                "data[4].email",equalTo("george.edwards@reqres.in"),
                "data[4].first_name",equalTo("George"),
                "data[4].last_name",equalTo("Edwards"),
                "data[4].avatar",equalTo("https://reqres.in/img/faces/11-image.jpg"),
                "support.url",equalTo("https://reqres.in/#support-heading"),
                "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }
    @Test
    public void test12() {
         /*
          "data":
         {
            "id": 12,
            "email": "rachel.howell@reqres.in",
            "first_name": "Rachel",
            "last_name": "Howell",
            "avatar": "https://reqres.in/img/faces/12-image.jpg"
        },
         "support": {
             "url": "https://reqres.in/#support-heading",
             "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
           statusCode = 200
           statusLine = "HTTP/1.1 200 OK";
           Content-Type = "application/json; charset=utf-8"

         */


        Response response = given().when().get(url);

        // HEADER TESTI ICIN
        // 1) JUnit Assert
        assertEquals(200,response.getStatusCode());
        assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
        assertEquals("application/json; charset=utf-8",response.getContentType());

        // 2) assertThat
        response.then().assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType("application/json; charset=utf-8");

        // BODY TESTI ICIN
        // Matcher Class ile
        response.then().body("data[5].id",equalTo(12));
        response.then().body("data[5].email",equalTo("rachel.howell@reqres.in"));
        response.then().body("data[5].first_name",equalTo("Rachel"));
        response.then().body("data[5].last_name",equalTo("Howell"));
        response.then().body("data[5].avatar",equalTo("https://reqres.in/img/faces/12-image.jpg"));

        response.then().body("support.url",equalTo("https://reqres.in/#support-heading"));
        response.then().body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

        // SoftAssert ile
        response.then().assertThat().body("data[5].id",equalTo(12),
                "data[5].email",equalTo("rachel.howell@reqres.in"),
                "data[5].first_name",equalTo("Rachel"),
                "data[5].last_name",equalTo("Howell"),
                "data[5].avatar",equalTo("https://reqres.in/img/faces/12-image.jpg"),
                "support.url",equalTo("https://reqres.in/#support-heading"),
                "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }

}
