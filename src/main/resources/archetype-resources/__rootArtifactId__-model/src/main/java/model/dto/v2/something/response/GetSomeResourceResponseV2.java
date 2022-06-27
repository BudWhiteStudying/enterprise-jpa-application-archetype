#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model.dto.v2.something.response;

import com.budwhite.studying.framework.web.model.dto.BaseResponse;
import ${package}.model.dto.v2.something.SomeObjectV2;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class GetSomeResourceResponseV2 extends BaseResponse {
    private SomeObjectV2 someObject;
}
