#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model.entity;

import ${package}.model.enumeration.EmployeeCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee implements Serializable {
    @NotNull
    @Id
    private int id;
    @NotNull
    private String name;
    private String middleName;
    @NotNull
    private String surname;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EmployeeCategory category;
}
