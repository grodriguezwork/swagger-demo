package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.InputExample;
import com.example.entity.OutputExample;
import com.example.service.ExampleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ResponseHeader;

@RestController
@RequestMapping("/")
public class ExampleController {
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	@ResponseHeader
	@GetMapping(value = "example/{code}", produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
	@ApiOperation(value = "Ejemplo de operación GET con parametro de entrada", response = String.class, responseContainer = "String", notes = "Returns a String Message and input value")
	public ResponseEntity<String> getAllAlgo(@PathVariable("code") String code) {		
		ResponseEntity<String> response =  new ResponseEntity<>("Prueba de API con un parametro :  " + code, HttpStatus.OK);	
		return response;

	}
	
	@ResponseHeader
	@GetMapping(value = "example", produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
	@ApiOperation(value = "Ejemplo de operación GET", response = String.class, responseContainer = "String", notes = "Returns a String Message")
	public ResponseEntity<String> getOne() {
		
		ResponseEntity<String> response =  new ResponseEntity<>("Prueba de API sin parametro ", HttpStatus.OK);
		return response;
	}
	
	@PostMapping(value = "example", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ApiOperation(value = "Ejemplo de operación POST con Json de entrada y de salida", response = OutputExample.class, responseContainer = "OutputExample", notes = "Returns a JSON Object")
	public ResponseEntity<OutputExample> postOne(@ApiParam(name = "Data for query service delivery ", value = "Json InputExampe with data for query service delivery", required = true) @RequestBody InputExample requestIN) {
		
		OutputExample response = exampleService.setExample(requestIN);
		response.setStatusExample("Created");
		ResponseEntity<OutputExample> responseHttp =  new ResponseEntity<OutputExample>(response, HttpStatus.OK);
		
		return responseHttp;
	}
	
	
	@PutMapping(value = "example", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ApiOperation(value = "Ejemplo de operación PUT con Json de entrada y de salida", response = OutputExample.class, responseContainer = "OutputExample", notes = "Returns a JSON Object")
	public ResponseEntity<OutputExample> putOne(@ApiParam(name = "Data for query service delivery ", value = "Json InputExampe with data for query service delivery", required = true) @RequestBody InputExample requestIN) {
		
		OutputExample response = exampleService.setExample(requestIN);
		response.setStatusExample("Updated");
		ResponseEntity<OutputExample> responseHttp =  new ResponseEntity<OutputExample>(response, HttpStatus.OK);
		
		return responseHttp;
	}
	
	@ResponseHeader
	@DeleteMapping(value = "example/{code}", produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
	@ApiOperation(value = "Ejemplo de operación DELETE con parametro de entrada", response = String.class, responseContainer = "String", notes = "Returns a String Message")
	public ResponseEntity<String> deleteOne(@PathVariable("code") String code) {		
		ResponseEntity<String> response =  new ResponseEntity<>("DELETED " + code, HttpStatus.OK);	
		return response;

	}

}
