package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Documents;
import com.example.entity.Test;

@Service
public interface DocumentsService {
	void addDocuments(Documents documents);
	Documents getDocById(int docId);
	boolean deleteDoc(int docId);
	boolean updateDoc(Documents documents);
	 List<Documents> getDocumentsByUserId(int userId);

}
