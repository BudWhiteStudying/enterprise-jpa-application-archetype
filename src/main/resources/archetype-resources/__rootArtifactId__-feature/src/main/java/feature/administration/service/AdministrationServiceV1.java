#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.feature.administration.service;

import ${package}.model.dto.v1.administration.response.GetAllEmployeesResponse;
import ${package}.model.dto.v1.administration.response.PostOrPutEmployeeResponse;
import ${package}.model.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ${package}.data.dao.EmployeeDao;

@Service
@RequiredArgsConstructor
public class AdministrationServiceV1 {
    private final EmployeeDao administrationDao;

    public GetAllEmployeesResponse getEmployees() {
        return new GetAllEmployeesResponse(administrationDao.findAll());
    }

    public PostOrPutEmployeeResponse putEmployee(Employee employee) {
        if(administrationDao.existsById(employee.getId()))
            return new PostOrPutEmployeeResponse(administrationDao.save(employee));
        else
            return new PostOrPutEmployeeResponse();
    }

    public PostOrPutEmployeeResponse postEmployee(Employee employee) {
        if(!administrationDao.existsById(employee.getId()))
            return new PostOrPutEmployeeResponse(administrationDao.save(employee));
        else
            return new PostOrPutEmployeeResponse();
    }
}
