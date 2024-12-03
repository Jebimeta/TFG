package com.tfg.tfg.service.pdf;

import com.tfg.tfg.model.PdfUrl;

import java.util.List;
import java.util.Optional;

public interface PdfUrlService {

    List<PdfUrl> findAll();

    Optional<PdfUrl> findById(Long id);

    Optional<PdfUrl> findByName(String name);

    PdfUrl save(PdfUrl pdfUrl);

    PdfUrl update(PdfUrl pdfUrl);

    void delete(Long id);
}
