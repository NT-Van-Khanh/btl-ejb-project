/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.EmployeeDTO;
import entity.Employee;
import java.util.Arrays;

/**
 *
 * @author ADMIN
 */
public class EmployeeMapper {
    public static EmployeeDTO toEmployeeDTO(Employee employee ){
        if(employee == null) return null;
        return new  EmployeeDTO(employee.getId(), employee.getFirstName()+ " " + employee.getLastName());
    } 

    static Employee toEmployee(EmployeeDTO employeeDTO) {
        if(employeeDTO == null) return null;
        String fullName = employeeDTO.getName().trim();
        String[] nameParts = fullName.split("\\s+");
        
        //Name: "Nguyen Van A", "A" la first name
        if(nameParts.length == 0)
            return new Employee(employeeDTO.getId(), "" ,"");
        
        String firstName = nameParts[nameParts.length - 1];
        String lastName = "";
        if(nameParts.length > 1)
            lastName = String.join(" ", Arrays.copyOfRange(nameParts, 0, nameParts.length-1));
        
        return new Employee(employeeDTO.getId(), lastName ,firstName);
    }
}
