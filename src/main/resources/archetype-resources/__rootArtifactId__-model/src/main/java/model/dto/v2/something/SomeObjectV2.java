#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model.dto.v2.something;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import com.budwhite.studying.framework.web.model.dto.BaseDTO;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SomeObjectV2 implements BaseDTO{
    private String anotherProperty;
    @JsonProperty("isCool")
    private boolean cool;
    @JsonProperty("isWorking")
    private Boolean working;
}
