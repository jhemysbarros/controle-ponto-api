package me.jhemysbarros.controlepontoapi.domain.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.jhemysbarros.controlepontoapi.domain.model.Momento;

@Repository
public interface MomentoRepository extends JpaRepository<Momento, Long> {

    @Query("SELECT m FROM Momento m WHERE day(m.dataHora) = day(?1) and month(m.dataHora) = month(?1) and year(m.dataHora) = year(?1) ORDER BY m.dataHora ASC")
    List<Momento> findByData(LocalDate dataHora);

    Optional<Momento> findOneByDataHora(LocalDateTime dataHora);
}