package ${package}.factory;

import ${package}.model.dto.v2.something.SomeObjectV2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Greeting Factory")
@SpringBootTest(classes = {SomeObjectFactory.class})
class SomeObjectFactoryTest {

    @Autowired
    private SomeObjectFactory someObjectFactory;

    private final String A_VALUE = "Some string value";

    @Test
    @DisplayName("should load correctly")
    void instantiateClass_shouldNotBeNull() {
        assertNotNull(someObjectFactory);
    }

    @Test
    @DisplayName("the getSomeObjectV1 should relay a SomeObjectV1 object whose properties match the input parameters")
    void getSomeObjectV1_shouldBuildAMatchingObject() {
        assertEquals(
                A_VALUE,
                someObjectFactory.getSomeObjectV1(A_VALUE).getSomeProperty()
        );
    }

    @Test
    @DisplayName("the getSomeObjectV2 should relay a SomeObjectV2 object whose properties match the input parameters")
    void getSomeObjectV2_shouldBuildAMatchingObject() {
        final boolean MOCK_IS_COOL_VALUE = true;
        final boolean MOCK_IS_WORKING_VALUE = false;
        final SomeObjectV2 builtObject = someObjectFactory.getSomeObjectV2(A_VALUE,MOCK_IS_COOL_VALUE,MOCK_IS_WORKING_VALUE);

        assertEquals(
                A_VALUE,
                builtObject.getAnotherProperty()
        );
        assertEquals(
                MOCK_IS_COOL_VALUE,
                builtObject.isCool()
        );
        assertEquals(
                MOCK_IS_WORKING_VALUE,
                builtObject.getWorking()
        );
    }
}