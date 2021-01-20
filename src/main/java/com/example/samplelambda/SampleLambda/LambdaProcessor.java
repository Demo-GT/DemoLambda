package com.example.samplelambda.SampleLambda;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LambdaProcessor implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Autowired
    LambdaRepository lambdaRepository;

    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent requestEvent) {
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setStatusCode(200);
        responseEvent.setBody("Hello  " + requestEvent.getHttpMethod() + "  " + requestEvent.getBody());
//        if(requestEvent.getHttpMethod().equalsIgnoreCase("GET"))

        return responseEvent;
    }

}
