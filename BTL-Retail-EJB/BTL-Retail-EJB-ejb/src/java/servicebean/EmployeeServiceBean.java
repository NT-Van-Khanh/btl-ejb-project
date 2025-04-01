/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicebean;

import dao.EmployeeDAO;
import dto.EmployeeDTO;
import entity.Employee;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mapper.EmployeeMapper;
import service.EmployeeService;

@Stateless  
public class EmployeeServiceBean implements EmployeeService{

    @EJB
    private EmployeeDAO employeeDAO;
    
    @Override
    public EmployeeDTO findById(String id) {
        Employee employee = employeeDAO.findById(id);
        return employee == null ? null : EmployeeMapper.toEmployeeDTO(employee);
    }
    
}
