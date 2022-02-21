package client;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.config.EncoderConfig.encoderConfig;

public class HttpClient {

    protected RequestSpecification defaultRequestSpecification;

    protected HttpClient(String pathUrl) {
        RestAssuredConfig config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                .setParam("http.connection.timeout", 30000)
                .setParam("http.socket.timeout", 30000))
                .encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
        defaultRequestSpecification = new RequestSpecBuilder()
                .setConfig(config)
                .addHeader("api_key", "252525") // - token authorization -- підставляти динамічно
                .setBaseUri("https://petstore.swagger.io/v2/")
                .setBasePath(pathUrl)
                .setContentType(ContentType.JSON)
                .build();
    }
}
