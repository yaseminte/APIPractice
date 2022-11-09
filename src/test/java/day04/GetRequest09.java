package day04;

import io.restassured.response.Response;
import org.junit.Test;
import pojos.Country;
import pojos.Customer;
import pojos.User;
import utilities.GMIBankBaseUrl;

import static io.restassured.RestAssured.given;

public class GetRequest09 extends GMIBankBaseUrl {

    /*
    http://www.gmibank.com/api/tp-customers/110452
    */

    @Test
    public void test09(){
        spec.pathParams("bir","tp-customers","iki","tp-customers");

        // EXPECTED DATA
        User user = new User(110016,"leopoldo.reinger", "Jasmine", "Stehr",
                "marni.zboncak@yahoo.com", true, "en", null, null);

        Country country = new Country(3, "USA", null);

        Customer expectedData = new Customer(110452, "Jasmine", "Stehr", "V", "marni.zboncak@yahoo.com"
                , "463-609-2097", "1-112-497-0270", "16525", "14387 Al Ridge5343 Bert Burgs","Waltermouth"
                , "761-59-2911", "2021-11-28T21:00:00Z", false, country, "California", user);

        Response response = given().spec(spec).headers("Authorization","Bearer " + generateToken())
                .when()
                .get("/{bir}/{iki}");



        //response.prettyPrint();

        Customer actualData = response.as(Customer.class);
        System.out.println(actualData);




    }
}
