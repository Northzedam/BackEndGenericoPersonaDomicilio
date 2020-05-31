package com.example.demo.service;

//import java.io.IOException;
//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.EntidadGenerica;

//import com.example.demo.BackendGenericoJava14Application;


public abstract class ServicioGenerico <E extends EntidadGenerica, R extends JpaRepository<E, Long>> implements IServicioGenerico<E> {
	
	
	
	@Autowired
	protected R repository;
	//private String upload_folder = String.valueOf(BackendGenericoJava14Application.getHome()+ "\\images\\").replace("\\","/");

	
	//---------------FINDALL---------------------------------------
	@Override
	public List<E> findAll(int page, int size) throws Exception {
		
		try {
			Pageable pageable = PageRequest.of(page, size);
			return repository.findAll(pageable).getContent();			

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	//---------------FINDBYID---------------------------------------

	@Override
	public E findById(long id) throws Exception{
		
		try {

			
			Optional<E> varOptional = repository.findById(id);

			E entity = varOptional.get();

			return entity;

		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}
	
	
	//---------------SAVE---------------------------------------

	@Override
	public E save(E entityForm) throws Exception {
		try {

			entityForm = repository.save(entityForm);

			return entityForm;

		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}
	
	
	//---------------UPDATE---------------------------------------

	@Override
	public E update(long id, E entityForm) throws Exception {

		try {
			Optional<E> entityOptional = repository.findById(id);

			E entity = entityOptional.get();

			entity = repository.save(entityForm);

			return entity;
			
		} catch (Exception e) {

			throw new Exception(e.getMessage());

		}

	}
	
	
	//---------------COUNTPAGES---------------------------------------

	@Override
	public int countPages(int size) throws Exception {
		try {
			Pageable pageable = PageRequest.of(0, size);
			return repository.findAll(pageable).getTotalPages();			

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	//---------------DELETE---------------------------------------

	public boolean delete(long id) throws Exception{
		try {
			if(repository.existsById(id)) {
				repository.deleteById(id);
			}		
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return true;
	}
	

}
