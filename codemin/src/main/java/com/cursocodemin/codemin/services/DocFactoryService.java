package com.cursocodemin.codemin.services;
import com.cursocodemin.codemin.models.Person;
import com.cursocodemin.codemin.repositories.PersonRepository;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class DocFactoryService {

    @Autowired
    private PersonRepository personRepository;

    public byte[] generatePdf(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Add title
        document.add(new Paragraph("Person Report"));

        // Fetch persons from the database
        List<Person> people = personRepository.findAll();

        // Add table with persons
        Table table = new Table(4); // 4 columns: ID, Name, UserName, Date

        // Add table headers
        table.addCell("ID");
        table.addCell("Name");
        table.addCell("UserName");
        table.addCell("Date");

        // Add rows
        for (Person person : people) {
            table.addCell(person.getId().toString());
            table.addCell(person.getName());
            table.addCell(person.getUserName());
            table.addCell(person.getDate().toString());
        }

        document.add(table);
        document.close();

        return byteArrayOutputStream.toByteArray();

    }

}
