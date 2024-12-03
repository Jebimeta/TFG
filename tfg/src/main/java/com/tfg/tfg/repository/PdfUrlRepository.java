package com.tfg.tfg.repository;

import com.tfg.tfg.model.PdfUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PdfUrlRepository extends JpaRepository<PdfUrl, Long> {
    Optional<PdfUrl> findByName(String name);
}
