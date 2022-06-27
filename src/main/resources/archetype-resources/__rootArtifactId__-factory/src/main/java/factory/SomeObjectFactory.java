#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.factory;

import ${package}.model.dto.v1.something.SomeObjectV1;
import ${package}.model.dto.v2.something.SomeObjectV2;
import org.springframework.stereotype.Component;

@Component
public class SomeObjectFactory extends BaseFactory {

    public SomeObjectV1 getSomeObjectV1(String somePropertyValue) {
        return new SomeObjectV1(somePropertyValue);
    }

    public SomeObjectV2 getSomeObjectV2(String somePropertyValue, boolean cool, boolean working) {
        return new SomeObjectV2(somePropertyValue, cool, working);
    }
}
