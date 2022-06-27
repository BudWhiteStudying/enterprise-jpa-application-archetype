#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model.dto.v1.administration.response;

import com.budwhite.studying.framework.web.model.dto.BaseResponse;
import ${package}.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class PostOrPutEmployeeResponse extends BaseResponse {
    private Employee employee;
}
