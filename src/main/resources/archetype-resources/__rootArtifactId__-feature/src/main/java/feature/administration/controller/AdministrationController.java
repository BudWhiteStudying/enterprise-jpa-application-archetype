#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.feature.administration.controller;

import ${package}.feature.administration.service.AdministrationServiceV1;
import ${package}.framework.api.ApiPath;
import ${package}.framework.api.MediaType;
import ${package}.model.dto.v1.administration.request.PostOrPutEmployeeRequest;
import ${package}.model.dto.v1.administration.response.GetAllEmployeesResponse;
import ${package}.model.dto.v1.administration.response.PostOrPutEmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPath.Administration.BASE)
@RequiredArgsConstructor
public class AdministrationController {
    private final AdministrationServiceV1 administrationServiceV1;


    @GetMapping(
            path = ApiPath.Administration.EMPLOYEE,
            produces = MediaType.Administration.GET_ALL_EMPLOYEES_RESPONSE_V1
    )
    public GetAllEmployeesResponse getEmployees() {
        return administrationServiceV1.getEmployees();
    }

    @PostMapping(
            path = ApiPath.Administration.EMPLOYEE,
            consumes = MediaType.Administration.POST_EMPLOYEE_REQUEST_V1,
            produces = MediaType.Administration.POST_EMPLOYEE_RESPONSE_V1
    )
    public PostOrPutEmployeeResponse postEmployee(@RequestBody @Valid PostOrPutEmployeeRequest request) {
        return administrationServiceV1.postEmployee(request.getEmployee());
    }

    @PutMapping(
            path = ApiPath.Administration.EMPLOYEE,
            consumes = MediaType.Administration.PUT_EMPLOYEE_REQUEST_V1,
            produces = MediaType.Administration.PUT_EMPLOYEE_RESPONSE_V1
    )
    public PostOrPutEmployeeResponse putEmployee(@RequestBody @Valid PostOrPutEmployeeRequest request) {
        return administrationServiceV1.putEmployee(request.getEmployee());
    }
}
