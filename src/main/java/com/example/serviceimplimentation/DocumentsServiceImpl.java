package com.example.serviceimplimentation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Documents;
import com.example.entity.Test;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.DocumentRepository;
import com.example.services.DocumentsService;
@Service
public class DocumentsServiceImpl implements DocumentsService
{

	
	@Autowired
	DocumentRepository docrep;

	@Override
	public void addDocuments(Documents documents) {
		// TODO Auto-generated method stub
		docrep.save(documents);
	}

	@Override
	public List<Documents> getDocumentsByUserId(int userId) {
		List<Documents> doclist=docrep.findByJobsekersUserId(userId);
				return doclist;
	}

	@Override
	public Documents getDocById(int docId) {
		Optional<Documents> documents =docrep.findById(docId);
		Documents Doc;
		if( documents.isPresent()) {
			Doc= documents.get();
		}else {
			throw new ResourceNotFoundException("Documents", "docId", docId);
		}
		return Doc;
	}
	@Override
	public boolean deleteDoc(int docId) {
		Optional<Documents> doc =docrep.findById(docId);
		if(doc.isPresent()) {
			docrep.deleteById(docId);
			return true;
		}
		else 
		{
		return false;
	}
	}

	@Override
	public boolean updateDoc(Documents documents) {
		Optional<Documents> doc =docrep.findById(documents.getDocId());
		if(doc.isPresent()) {
			docrep.save(documents);
			return true;
		
	}else {
		return false;
	}

	}
	
	
}
