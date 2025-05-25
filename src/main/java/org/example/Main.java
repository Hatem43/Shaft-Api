package org.example;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SHAFT.API api = new SHAFT.API("https://jsonplaceholder.typicode.com");
        api.get("/posts").perform();
        int code=api.getResponseStatusCode();
        System.out.println("status code is " +  code);
        String responsebody=api.getResponseBody();
        System.out.println("response body is "+ responsebody);
        String response= String.valueOf(api.getResponse());
        System.out.println("response is "+ response);
        int responsecode=api.getResponseStatusCode();
        System.out.println("status code is " +  responsecode);
        long restime=api.getResponseTime();
        SHAFT.Validations.verifyThat().number(restime).isLessThanOrEquals(613).perform();
        String value=api.getResponseJSONValue("$.id").toString();
        String vale=api.getResponseJSONValue("$[1].id").toString();
        SHAFT.Validations.verifyThat().object(value).isEqualTo(1).perform();
        SHAFT.Validations.verifyThat().object(vale).isEqualTo(2).perform();

        api = new SHAFT.API("https://jsonplaceholder.typicode.com");
        JSONObject bod= new JSONObject();
        bod.put("name","hatem");
        bod.put("job","tester");
        api.post("/posts").setRequestBody(bod).setContentType(ContentType.JSON).perform();
        String nam=api.getResponseJSONValue("$.name").toString();
        String job=api.getResponseJSONValue("$.job").toString();
        System.out.println("my name is "+ nam);
        System.out.println("my job is "+ job);
        int status=api.getResponseStatusCode();
        System.out.println("the status code is " + status);
        SHAFT.Validations.verifyThat().object(nam).isEqualTo("hatem").perform();
        SHAFT.Validations.verifyThat().object(job).isEqualTo("tester").perform();
        SHAFT.Validations.verifyThat().number(status).isEqualTo(201).perform();



        api=new SHAFT.API("https://jsonplaceholder.typicode.com");
        JSONObject bode=new JSONObject();
        bode.put("name","ali");
        bode.put("job","fisher");
        api.put("/posts/1").setRequestBody(bode).setContentType(ContentType.JSON).perform();
        String name= api.getResponseJSONValue("$.name").toString();
        String jobe= api.getResponseJSONValue("$.job").toString();
        System.out.println("my name is "+ name);
        System.out.println("my job is "+ jobe);
        int statuscode=api.getResponseStatusCode();
        System.out.println("the status code is " + statuscode);
        SHAFT.Validations.verifyThat().object(name).isEqualTo("ali").perform();
        SHAFT.Validations.verifyThat().object(jobe).isEqualTo("fisher").perform();
        SHAFT.Validations.verifyThat().number(statuscode).isEqualTo(200).perform();



        api=new SHAFT.API("https://jsonplaceholder.typicode.com");
        JSONObject bodee=new JSONObject();
        bodee.put("name","hossam");
        bodee.put("job","fisher");
        api.patch("/posts/1").setRequestBody(bodee).setContentType(ContentType.JSON).perform();
        String namee= api.getResponseJSONValue("$.name").toString();
        String jobee= api.getResponseJSONValue("$.job").toString();
        System.out.println("my name is "+ namee);
        System.out.println("my job is "+ jobee);
        int statuscodee=api.getResponseStatusCode();
        System.out.println("the status code is " + statuscodee);
        SHAFT.Validations.verifyThat().object(namee).isEqualTo("hossam").perform();
        SHAFT.Validations.verifyThat().object(jobee).isEqualTo("fisher").perform();
        SHAFT.Validations.verifyThat().number(statuscodee).isEqualTo(200).perform();


        api=new SHAFT.API("https://jsonplaceholder.typicode.com");
        JSONObject bodeee=new JSONObject();
        bodeee.put("name","hossam");
        bodeee.put("job","fisher");
        api.delete("/posts/1").setRequestBody(bodeee).setContentType(ContentType.JSON).perform();
        int statuscodeee=api.getResponseStatusCode();
        System.out.println("the status code is " + statuscodeee);
        SHAFT.Validations.verifyThat().number(statuscodeee).isEqualTo(200).perform();
    }


}