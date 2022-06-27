#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.model.dto.v1.administration.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.budwhite.studying.framework.web.model.dto.BaseDTO;
import ${package}.model.entity.Employee;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostOrPutEmployeeRequest implements BaseDTO{
    private Employee employee;
}
