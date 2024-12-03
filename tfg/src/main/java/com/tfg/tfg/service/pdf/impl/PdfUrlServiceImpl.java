package com.tfg.tfg.service.pdf.impl;

import com.tfg.tfg.model.PdfUrl;
import com.tfg.tfg.repository.PdfUrlRepository;
import com.tfg.tfg.service.pdf.PdfUrlService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PdfUrlServiceImpl implements PdfUrlService {

    private final PdfUrlRepository pdfUrlRepository;

    @Transactional
    @Override
    public List<PdfUrl> findAll() {
        return pdfUrlRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<PdfUrl> findById(Long id) {
        Optional<PdfUrl> pdfUrl = pdfUrlRepository.findById(id);
        if (pdfUrl.isPresent()) {
            return pdfUrl;
        }else {
            throw new UsernameNotFoundException("PdfUrl not found");
        }
    }

    @Transactional
    @Override
    public Optional<PdfUrl> findByName(String name) {
        Optional<PdfUrl> pdfUrl = pdfUrlRepository.findByName(name);
        if (pdfUrl.isPresent()) {
            return pdfUrl;
        }else {
            throw new UsernameNotFoundException("PdfUrl not found");
        }
    }

    @Transactional
    @Override
    public PdfUrl save(PdfUrl pdfUrl) {
        return pdfUrlRepository.save(pdfUrl);
    }

    @Transactional
    @Override
    public PdfUrl update(PdfUrl pdfUrl) {
        Optional<PdfUrl> pdfUrlOptional = pdfUrlRepository.findById(pdfUrl.getId());
        if (pdfUrlOptional.isPresent()) {
            PdfUrl pdfUrlToUpdate = pdfUrlOptional.get();
            pdfUrlToUpdate.setName(pdfUrl.getName());
            pdfUrlToUpdate.setUrl(pdfUrl.getUrl());
            return pdfUrlRepository.save(pdfUrlToUpdate);
        }else {
            throw new UsernameNotFoundException("PdfUrl not found");
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Optional<PdfUrl> pdfUrl = pdfUrlRepository.findById(id);
        if (pdfUrl.isPresent()) {
            pdfUrlRepository.deleteById(id);
        }else {
            throw new UsernameNotFoundException("PdfUrl not found");
        }
    }
}
