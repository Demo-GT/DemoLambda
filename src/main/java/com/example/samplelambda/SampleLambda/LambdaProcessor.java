package com.example.samplelambda.SampleLambda;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LambdaProcessor implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

   /* @Autowired
    LambdaRepository lambdaRepository;*/

    @Autowired
    LambdaService lambdaService;

    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent requestEvent) {
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setStatusCode(200);
        if(requestEvent.getHttpMethod().equalsIgnoreCase("GET"))
            /*if(requestEvent.getBody().length() > 0)
                responseEvent.setBody(lambdaService.getBookbyId(Integer.parseInt(requestEvent.getBody())));
            else*/
                responseEvent.setBody(lambdaService.getAllBooks());
        else
            responseEvent.setBody("Invalid Operations");
            
        //responseEvent.setBody("Hello  " + requestEvent.getHttpMethod() + "  " + requestEvent.getBody());
        //if(requestEvent.getHttpMethod().equalsIgnoreCase("GET"))

        return responseEvent;
    }

}
