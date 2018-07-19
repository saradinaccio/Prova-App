package it.univaq.disim.mobile.myunivaq.business.impl.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import it.univaq.disim.mobile.myunivaq.domain.Esercizio;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface EsercizioRepository extends JpaRepository <Esercizio, Long>{

}
