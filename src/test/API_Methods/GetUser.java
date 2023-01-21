import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUser {
    @Test
    void UserDetails()
    {

        RestAssured.baseURI="https://apis.buzzboard.com/v4.0";
        RequestSpecification httprequest=RestAssured.given().header("Authorization", "Bearer bc093c75-645d-3500-94c3-0719e52104b6");
        Response response=httprequest.request(Method.GET,"/users");
        String responsebody=response.getBody().asString();
//        System.out.println(responsebody);

        int statuscoderesponse=response.getStatusCode();
        Assert.assertEquals(statuscoderesponse,200);

        System.out.println("Response : "+response.asString());
        System.out.println("Status Code : "+response.statusCode());
        System.out.println("Body :"+response.getBody().asString());
        System.out.println("Time taken :"+response.getTime());
        System.out.println("Header :"+response.getHeader("content-type"));

//        int statusCode= response.statusCode();
//        Assert.assertEquals(statusCode, 200);

        String statusline=response.getStatusLine();
        Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
//        System.out.println("Details :"+response.log().all());

    }

}
