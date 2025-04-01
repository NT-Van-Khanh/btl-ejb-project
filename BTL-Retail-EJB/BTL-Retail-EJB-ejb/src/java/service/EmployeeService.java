/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dto.EmployeeDTO;
import javax.ejb.Remote;

@Remote
public interface EmployeeService {
    EmployeeDTO findById(String id);
}
