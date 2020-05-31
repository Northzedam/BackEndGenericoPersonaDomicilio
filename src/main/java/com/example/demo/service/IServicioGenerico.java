package com.example.demo.service;

import java.util.List;


public interface IServicioGenerico <E> {
	
    public E findById(long id) throws Exception;
	
	public E save(E entityForm) throws Exception;
	
	public E update (long id, E entityForm) throws Exception;
	
	public List<E> findAll (int page, int size) throws Exception;
	
	public boolean delete (long id) throws Exception;
	
	public int countPages(int size) throws Exception; 

}
