package com.vivek.informationmodule.repositories;

import java.util.List;
import java.util.Map;

import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.vivek.informationmodule.models.information;

@Repository
public interface informationrepository extends JpaRepository<information, String>{
	
	
}