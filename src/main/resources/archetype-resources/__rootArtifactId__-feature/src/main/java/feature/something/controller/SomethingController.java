#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.feature.something.controller;

import ${package}.feature.something.service.SomethingServiceV1;
import ${package}.feature.something.service.SomethingServiceV2;
import ${package}.framework.api.ApiPath;
import ${package}.framework.api.MediaType;
import ${package}.model.dto.v1.something.response.GetSomeResourceResponseV1;
import ${package}.model.dto.v2.something.response.GetSomeResourceResponseV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPath.Something.BASE)
@RequiredArgsConstructor
public class SomethingController {

    private final SomethingServiceV1 somethingServiceV1;

    private final SomethingServiceV2 somethingServiceV2;

    @GetMapping(
            path = ApiPath.Something.SOME_RESOURCE,
            produces = MediaType.Something.GET_SOME_RESOURCE_RESPONSE_V1
    )
    public GetSomeResourceResponseV1 getSomeResourceResponseV1() {
        return somethingServiceV1.getSomeResourceResponse();
    }

    @GetMapping(
            path = ApiPath.Something.SOME_RESOURCE,
            produces = MediaType.Something.GET_SOME_RESOURCE_RESPONSE_V2
    )
    public GetSomeResourceResponseV2 getSomeResourceResponseV2() {
        return somethingServiceV2.getSomeResourceResponse();
    }
}
