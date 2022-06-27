package ${package}.feature.administration.service;

import ${package}.data.dao.EmployeeDao;
import ${package}.feature.administration.controller.AdministrationController;
import ${package}.model.entity.Employee;
import ${package}.model.enumeration.EmployeeCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Administration Service")
@SpringBootTest(classes = {AdministrationServiceV1.class})
class AdministrationServiceV1Test {

    @MockBean
    private EmployeeDao employeeDao;

    @Autowired
    private AdministrationServiceV1 administrationServiceV1;

    private static final Employee AN_EMPLOYEE = new Employee(1,"Name","","Surname", EmployeeCategory.EMPLOYEE);
    private static final Employee ANOTHER_EMPLOYEE = new Employee(2,"AnotherName","","AnotherSurname", EmployeeCategory.EMPLOYEE);
    private static final List<Employee> SOME_EMPLOYEES = Arrays.asList(AN_EMPLOYEE, ANOTHER_EMPLOYEE);

    @Test
    @DisplayName("should load correctly")
    void instantiateClass_shouldNotBeNull() {
        assertNotNull(administrationServiceV1);
    }

    @Test
    @DisplayName("the getEmployees method should relay the same list of employees returned by the DAO")
    void getEmployees() {
        Mockito.when(employeeDao.findAll())
                .thenReturn(SOME_EMPLOYEES);
        assertArrayEquals(
                SOME_EMPLOYEES.toArray(),
                administrationServiceV1.getEmployees().getEmployees().toArray()
        );
    }

    @Test
    @DisplayName("the postEmployee method should relay the same employee returned by the DAO if such employee doesn't already exist")
    void postEmployee_employeeDoesNotExist_returnPersistedEmployee() {
        Mockito.when(employeeDao.existsById(AN_EMPLOYEE.getId()))
                .thenReturn(false);
        Mockito.when(employeeDao.save(AN_EMPLOYEE))
                .thenReturn(AN_EMPLOYEE);

        assertEquals(
                AN_EMPLOYEE,
                administrationServiceV1.postEmployee(AN_EMPLOYEE).getEmployee()
        );
    }

    @Test
    @DisplayName("the postEmployee method should relay a null employee if such employee already exists")
    void postEmployee_employeeAlreadyExists_returnNullEmployee() {
        Mockito.when(employeeDao.existsById(AN_EMPLOYEE.getId()))
                .thenReturn(true);

        assertNull(administrationServiceV1.postEmployee(AN_EMPLOYEE).getEmployee());
    }

    @Test
    @DisplayName("the putEmployee method should relay a null employee if such employee doesn't exists")
    void putEmployee_employeeDoesNotExist_returnNull() {
        Mockito.when(employeeDao.existsById(AN_EMPLOYEE.getId()))
                .thenReturn(false);

        assertNull(administrationServiceV1.putEmployee(AN_EMPLOYEE).getEmployee());
    }

    @Test
    @DisplayName("the putEmployee method should relay the same employee returned by the DAO if such employee exists")
    void putEmployee_employeeAlreadyExists_returnUpdatedEmployee() {
        Mockito.when(employeeDao.existsById(AN_EMPLOYEE.getId()))
                .thenReturn(true);
        Mockito.when(employeeDao.save(AN_EMPLOYEE))
                .thenReturn(AN_EMPLOYEE);

        assertEquals(
                AN_EMPLOYEE,
                administrationServiceV1.putEmployee(AN_EMPLOYEE).getEmployee()
        );
    }
}