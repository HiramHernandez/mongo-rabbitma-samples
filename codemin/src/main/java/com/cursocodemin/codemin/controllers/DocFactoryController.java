package com.cursocodemin.codemin.controllers;

import com.cursocodemin.codemin.services.AzureBlobStorageService;
import com.cursocodemin.codemin.services.DocFactoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping("/api/pdf")
public class DocFactoryController {

    @Autowired
    private DocFactoryService docFactoryService;

    @Autowired
    private AzureBlobStorageService azureBlobStorageService;

    @GetMapping("/download")
    public ResponseEntity<byte[]> donwloadPdf(){
        byte[] pdfContent = docFactoryService.generatePdf();

        HttpHeaders headers = new HttpHeaders();

        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=person_report.pdf");
        headers.set(HttpHeaders.CONTENT_TYPE, "application/pdf");

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }



    /*@PostMapping("/{containerName}")
    public String uploadBlob(@PathVariable String containerName, @RequestParam MultipartFile file) {
        return azureBlobStorageService.uploadBlob(containerName, file);
    }*/



}
