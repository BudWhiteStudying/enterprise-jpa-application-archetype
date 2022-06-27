package ${package}.factory;

import ${package}.model.dto.v1.hello.world.GreetingV1;
import ${package}.model.enumeration.GreetingTitle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Greeting Factory")
@SpringBootTest(classes = {GreetingFactory.class})
class GreetingFactoryTest {

    @Autowired
    private GreetingFactory greetingFactory;

    private final String A_GREETING = "Hello";

    @Test
    @DisplayName("should load correctly")
    void instantiateClass_shouldNotBeNull() {
        assertNotNull(greetingFactory);
    }

    @Test
    @DisplayName("the getGreetingV1 should return a GreetingV1 whose properties match the input arguments if those arguments are valid")
    void getGreetingV1_validParameters_shouldMatchInputParameters() {
        String a_VALID_TITLE = GreetingTitle.MR.name();
        final GreetingV1 builtGreetingObject = greetingFactory.getGreetingV1(A_GREETING, a_VALID_TITLE);

        assertEquals(
                A_GREETING,
                builtGreetingObject.getText()
        );
        assertEquals(
                GreetingTitle.valueOf(a_VALID_TITLE),
                builtGreetingObject.getRecipientTitle()
        );
    }

    @Test
    @DisplayName("the getGreetingV1 should return a GreetingV1 whose properties match the input arguments but fall back to default values for those arguments that are not valid")
    void getGreetingV1_invalidParameters_shouldMatchInputOrDefaultParameters() {
        String AN_INVALID_TITLE = "BR";
        final GreetingV1 builtGreetingObject = greetingFactory.getGreetingV1(A_GREETING, AN_INVALID_TITLE);

        assertEquals(
                A_GREETING,
                builtGreetingObject.getText()
        );
        assertEquals(
                GreetingTitle.DEFAULT,
                builtGreetingObject.getRecipientTitle()
        );
    }
}