package com.ipi.jva350.repository;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import com.ipi.jva350.model.SalarieAideADomicile;

import com.ipi.jva350.service.SalarieAideADomicileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(SpringExtension.class)
//@DataJpaTest
@SpringBootTest
public class SalarieAideADomicileRepositoryTest {

    @Autowired
    private SalarieAideADomicileService service;
    @Autowired
    private SalarieAideADomicileRepository repository;

    @Test
    public void testFindByNom() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile("Wadi", LocalDate.of(2022, 1, 1),
                LocalDate.now(), 0, 0, 15, 0, 0);
        repository.save(salarie);
        // When
        SalarieAideADomicile result = repository.findByNom("Wadi");

        assertEquals("Wadi", result.getNom());
    }

    @BeforeEach
    public void before() throws SalarieException {
        SalarieAideADomicile salarie = new SalarieAideADomicile("Anthony", LocalDate.of(2022, 1, 1),
                LocalDate.now(), 0, 0, 15, 0, 0);

        service.creerSalarieAideADomicile(salarie);
    }

    @Test

    public void testajouteConge() throws SalarieException {

        //Given
        SalarieAideADomicile result = repository.findByNom("Anthony");
        //When
        service.ajouteConge(result, LocalDate.of(2022, 5, 1), LocalDate.of(2022, 5, 8));
        //Then
        assertEquals(5, result.getCongesPayesPris());

    }



}
