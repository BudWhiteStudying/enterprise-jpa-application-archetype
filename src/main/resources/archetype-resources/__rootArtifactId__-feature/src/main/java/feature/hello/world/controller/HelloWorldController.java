#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.feature.hello.world.controller;

import ${package}.feature.hello.world.service.HelloWorldServiceV1;
import ${package}.framework.api.ApiPath;
import ${package}.framework.api.MediaType;
import ${package}.model.dto.v1.hello.world.response.GetGreetingResponseV1;
import ${package}.model.dto.v1.hello.world.request.PostGreetingRequestV1;
import ${package}.model.dto.v1.hello.world.response.PostGreetingResponseV1;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPath.HelloWorld.BASE)
@RequiredArgsConstructor
public class HelloWorldController {

    private final HelloWorldServiceV1 helloWorldServiceV1;

    @GetMapping(
            path = ApiPath.HelloWorld.GREETING,
            produces = MediaType.HelloWorld.GET_GREETING_RESPONSE_V1
    )
    public GetGreetingResponseV1 getGreeting() {
        return helloWorldServiceV1.getGreeting();
    }

    @PostMapping(
            path = ApiPath.HelloWorld.GREETING,
            consumes = MediaType.HelloWorld.POST_GREETING_REQUEST_V1,
            produces = MediaType.HelloWorld.POST_GREETING_RESPONSE_V1
    )
    public PostGreetingResponseV1 postGreeting(@RequestBody @Valid PostGreetingRequestV1 request) {
        return helloWorldServiceV1.postGreeting(request.getGreeterName());
    }
}
