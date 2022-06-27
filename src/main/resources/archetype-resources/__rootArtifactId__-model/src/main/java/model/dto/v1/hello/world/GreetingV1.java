#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model.dto.v1.hello.world;

import ${package}.model.enumeration.GreetingTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.budwhite.studying.framework.web.model.dto.BaseDTO;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GreetingV1 implements BaseDTO{
    private String text;
    private GreetingTitle recipientTitle;
}
