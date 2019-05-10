package com.example.service;

import java.util.List;

import com.example.entity.InputExample;
import com.example.entity.OutputExample;
import com.example.entity.Productos;

public interface ExampleService {
	
	public List<Productos> getProductos(String in);
	
	public OutputExample setExample(InputExample in);

}
