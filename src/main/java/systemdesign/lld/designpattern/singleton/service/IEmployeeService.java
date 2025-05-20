package systemdesign.lld.designpattern.singleton.service;

import systemdesign.lld.designpattern.singleton.model.Employee;

public interface IEmployeeService {
    public void saveEmployeeInDB(Employee employee);
    public Employee fetchEmployee(String id);
}
