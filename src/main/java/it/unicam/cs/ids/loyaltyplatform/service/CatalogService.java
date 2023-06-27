package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Catalog;
import it.unicam.cs.ids.loyaltyplatform.repository.CatalogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {
    private final CatalogRepository catalogRepository;
    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public void addCatalog(Catalog catalog) {//come posso aggiungere il prodotto

        this.catalogRepository.save(catalog);
     }

    public void deleteCatalog(Catalog catalog) {// come cancellare il prodotto

        this.catalogRepository.delete(catalog);

    }


    public void updateCatalog(Catalog catalog) {
        this.catalogRepository.saveAndFlush(catalog);
    }

    public List<Catalog> getCatalogByProductId(Integer idProduct) {
        return this.catalogRepository.findAll().parallelStream().filter(x -> x.getIdProduct() == (idProduct)).toList();

    }
}
