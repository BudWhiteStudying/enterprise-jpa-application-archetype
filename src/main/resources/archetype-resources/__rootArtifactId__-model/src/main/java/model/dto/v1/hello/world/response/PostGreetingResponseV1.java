#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model.dto.v1.hello.world.response;

import com.budwhite.studying.framework.web.model.dto.BaseResponse;
import ${package}.model.dto.v1.hello.world.GreetingV1;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostGreetingResponseV1 extends BaseResponse {
    private GreetingV1 greeting;
}
