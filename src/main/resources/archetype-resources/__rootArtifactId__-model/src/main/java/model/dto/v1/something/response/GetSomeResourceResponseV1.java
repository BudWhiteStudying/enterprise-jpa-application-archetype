#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model.dto.v1.something.response;

import com.budwhite.studying.framework.web.model.dto.BaseResponse;
import ${package}.model.dto.v1.something.SomeObjectV1;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class GetSomeResourceResponseV1 extends BaseResponse {
    private SomeObjectV1 someObject;
}
