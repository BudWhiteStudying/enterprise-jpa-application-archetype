package ${package}.feature.administration.controller;

import ${package}.feature.administration.service.AdministrationServiceV1;
import ${package}.model.dto.v1.administration.request.PostOrPutEmployeeRequest;
import ${package}.model.dto.v1.administration.response.GetAllEmployeesResponse;
import ${package}.model.dto.v1.administration.response.PostOrPutEmployeeResponse;
import ${package}.model.entity.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Administration API Controller")
@SpringBootTest(classes = {AdministrationController.class})
class AdministrationControllerTest {

    @Autowired
    private AdministrationController administrationController;

    @MockBean
    private AdministrationServiceV1 administrationServiceV1;

    private static final Employee AN_EMPLOYEE = new Employee();
    private static final Employee ANOTHER_EMPLOYEE = new Employee();
    private static final List<Employee> SOME_EMPLOYEES = Arrays.asList(AN_EMPLOYEE, ANOTHER_EMPLOYEE);

    @Test
    @DisplayName("should load correctly")
    void instantiateClass_shouldNotBeNull() {
        assertNotNull(administrationController);
    }

    @Test
    @DisplayName("the getEmployees method should relay the same list of employees returned by the administrationService")
    void getEmployees_serviceReturnsEmployees_shouldRelaySameEmployees() {
        Mockito.when(administrationServiceV1.getEmployees())
                .thenReturn(new GetAllEmployeesResponse(SOME_EMPLOYEES));
        assertArrayEquals(
                SOME_EMPLOYEES.toArray(),
                administrationController.getEmployees().getEmployees().toArray()
        );
    }

    @Test
    @DisplayName("the postEmployee method should relay the same employee returned by the administrationService if an employee is returned")
    void postEmployee_serviceReturnsCreatedEmployee_shouldRelaySameEmployee() {
        Mockito.when(administrationServiceV1.postEmployee(AN_EMPLOYEE))
                .thenReturn(new PostOrPutEmployeeResponse(AN_EMPLOYEE));
        assertEquals(
                AN_EMPLOYEE,
                administrationController.postEmployee(new PostOrPutEmployeeRequest(AN_EMPLOYEE)).getEmployee());
    }

    @Test
    @DisplayName("the postEmployee method should relay a null employee  as returned by the administrationService if a null employee is returned")
    void postEmployee_serviceReturnsNullEmployee_shouldRelayNullEmployee() {
        Mockito.when(administrationServiceV1.postEmployee(AN_EMPLOYEE))
                .thenReturn(new PostOrPutEmployeeResponse(null));
        assertNull(administrationController.postEmployee(new PostOrPutEmployeeRequest(AN_EMPLOYEE)).getEmployee());
    }

    @Test
    @DisplayName("the putEmployee method should relay the same employee returned by the administrationService if an employee is returned")
    void putEmployee_serviceReturnsCreatedEmployee_shouldRelaySameEmployee() {
        Mockito.when(administrationServiceV1.putEmployee(AN_EMPLOYEE))
                .thenReturn(new PostOrPutEmployeeResponse(AN_EMPLOYEE));
        assertEquals(
                AN_EMPLOYEE,
                administrationController.putEmployee(new PostOrPutEmployeeRequest(AN_EMPLOYEE)).getEmployee());
    }

    @Test
    @DisplayName("the putEmployee method should relay a null employee  as returned by the administrationService if a null employee is returned")
    void putEmployee_serviceReturnsNullEmployee_shouldRelayNullEmployee() {
        Mockito.when(administrationServiceV1.putEmployee(AN_EMPLOYEE))
                .thenReturn(new PostOrPutEmployeeResponse(null));
        assertNull(administrationController.putEmployee(new PostOrPutEmployeeRequest(AN_EMPLOYEE)).getEmployee());
    }
}