package com.springbootsoap.endpoint;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.springbootsoap.luizromao02.AddEmployeeRequest;
import com.springbootsoap.luizromao02.AddEmployeeResponse;
import com.springbootsoap.luizromao02.DeleteEmployeeRequest;
import com.springbootsoap.luizromao02.DeleteEmployeeResponse;
import com.springbootsoap.luizromao02.EmployeeInfo;
import com.springbootsoap.luizromao02.GetEmployeeByIdRequest;
import com.springbootsoap.luizromao02.GetEmployeeResponse;
import com.springbootsoap.luizromao02.ServiceStatus;
import com.springbootsoap.luizromao02.UpdateEmployeeRequest;
import com.springbootsoap.luizromao02.UpdateEmployeeResponse;
import com.springbootsoap.model.Employee;
import com.springbootsoap.services.EmployeeService;

@Endpoint
public class EmployeeEndpoint {

	private static final String NAMESPACE_URI = "http://luizromao02.springbootsoap.com";
	private static final String SUCCESS = "SUCCESS";
	
	@Autowired
	private EmployeeService employeeService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
	@ResponsePayload
	public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
		AddEmployeeResponse response = new AddEmployeeResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		Employee employee = new Employee();
		
		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
		employeeService.addEmployee(employee);
		
		serviceStatus.setStatus(SUCCESS);
		serviceStatus.setMessage("Content Added Successfully");
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeByIdRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		EmployeeInfo employeeInfo = new EmployeeInfo();
		
		BeanUtils.copyProperties(employeeService.getEmployeeById(request.getEmployeeId()), employeeInfo);
		response.setEmployeeInfo(employeeInfo);
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
	@ResponsePayload
	public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
		Employee employee = new Employee();
		UpdateEmployeeResponse response = new UpdateEmployeeResponse();
		ServiceStatus serviceStatus = new ServiceStatus();

		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
		employeeService.updateEmployee(employee);
		
		serviceStatus.setStatus(SUCCESS);
		serviceStatus.setMessage("Content Updated Successfully");
		response.setServiceStatus(serviceStatus);
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
	@ResponsePayload
	public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
		ServiceStatus serviceStatus = new ServiceStatus();
		DeleteEmployeeResponse response = new DeleteEmployeeResponse();
		
		employeeService.deleteEmployee(request.getEmployeeId());

		serviceStatus.setStatus(SUCCESS);
		serviceStatus.setMessage("Content Deleted Sucessfully");
		response.setServiceStatus(serviceStatus);
		
		return response;
	}
	
}
