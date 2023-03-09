package com.wamazon.wamazonservice.test;

import com.wamazon.wamazonservice.dto.ProductDto;

public interface IProductService {

    /**
     * Метод сохранения нового товара
     */
    ProductDto save(ProductDto productDto);

    /**
     * Метод получения имеющегося товара
     *
     * @param id - идентификатор товара
     */
    ProductDto get(Long id);

    /**
     * Метод обновления имеющегося товара
     */
    ProductDto update(ProductDto productDto);

    /**
     * Метод удаления имеющегося товара
     *
     * @param id - идентификатор товара
     */
    void delete(Long id);

}
