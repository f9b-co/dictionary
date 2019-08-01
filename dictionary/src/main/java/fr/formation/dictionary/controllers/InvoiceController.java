package fr.formation.dictionary.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dictionary.business.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @PostMapping()
    public void create(@RequestBody @Valid Invoice invoice) {
	System.out.println("creating invoice:" + invoice);
    }

    @GetMapping("/{id}")
    public Invoice invoice(@PathVariable("id") Long id) {
	LocalDate date = LocalDate.of(2018, 12, 26);
	Invoice invoice = new Invoice("A01", date, 1005.36);
	invoice.setId(id);
	return invoice;
    }

    @GetMapping()
    public ArrayList<Invoice> invoices(@RequestParam("size") int size,
	    @RequestParam("page") int page) {
	System.out.println("size" + size + ", page=" + page);
	ArrayList<Invoice> invoices = new ArrayList<>();
	LocalDate date1 = LocalDate.of(2018, 12, 26);
	Invoice invoice1 = new Invoice("A01", date1, 1005.36);
	LocalDate date2 = LocalDate.of(2019, 3, 14);
	Invoice invoice2 = new Invoice("A02", date2, 4004);
	invoice2.setPaid(true);
	invoices.add(invoice1);
	invoices.add(invoice2);
	return invoices;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id) {
	System.out.println("Updating invoice with id " + id);
    }

    @PatchMapping("/{id}/paid")
    public void paid(@PathVariable("id") Long id) {
	System.out.println("Patching paid invoice with id " + id);
    }

    @PatchMapping("/{id}/unpaid")
    public void unpaid(@PathVariable("id") Long id) {
	System.out.println("Patching unpaid invoice with id " + id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
	System.out.println("Deleting invoice with id " + id);
    }
}
