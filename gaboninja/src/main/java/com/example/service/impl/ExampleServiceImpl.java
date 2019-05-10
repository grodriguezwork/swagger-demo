package com.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.InputExample;
import com.example.entity.OutputExample;
import com.example.entity.Productos;
import com.example.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

	@Override
	public List<Productos> getProductos(String in) {
		
		
		return null;
	}

	@Override
	public OutputExample setExample(InputExample in) {
		
		OutputExample response = new OutputExample();
		response.setMessageExample("Input recibido : " + "|name: " + in.getNameExample() + " |alias: " + in.getAliasExample() + " |operation: " + in.getOperationExampe());
		response.setResultExample("Input succes for operation " + in.getOperationExampe());

		return response;
	}

}
