package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Company;
import com.example.entity.Documents;
import com.example.entity.Test;
import com.example.services.DocumentsService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("api/v1")
public class DocumentController {
@Autowired
DocumentsService docserv;

@PostMapping("/addDocuments")
public ResponseEntity<Object> adddoc(@RequestBody Documents doc) {
	docserv.addDocuments(doc);
	return new ResponseEntity<>("Document Added Welcome To Hire Me Now", HttpStatus.CREATED);

}

@GetMapping("/getDocuments/{docId}")
public ResponseEntity<Object> getMethodName(@PathVariable("docId")int docId) {
	
		List<Documents> company = docserv.getDocumentsByUserId(docId);
		ResponseEntity<Object> entity = new ResponseEntity<>(company, HttpStatus.OK);

		return entity;
	}
    
@GetMapping(value="/getDoc/{docId}")
public ResponseEntity<Object> getTest(@PathVariable("docId") int docId){
	Documents doc;
	
		doc=docserv.getDocById(docId);
		
	
	ResponseEntity<Object> entity = new ResponseEntity<>(doc,HttpStatus.OK);
	return entity;
	
}


@DeleteMapping(value="/deleteDocuments/{docId}")
public ResponseEntity<Object> deleteDocuments(@PathVariable("docId") int docId){
	
	boolean flag;
		flag = docserv.deleteDoc(docId);
	
	
	return new ResponseEntity<>(flag,HttpStatus.OK);
	
}

@PutMapping(value="/updateDocuments/{docId}")
public ResponseEntity<Object> updateDocuments(@PathVariable("docId") int docId, @RequestBody Documents documents)
{
	
	boolean flag;
		flag = docserv.updateDoc(documents);

	return new ResponseEntity<>(flag, HttpStatus.OK);
	
}


}
