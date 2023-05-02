package com.dennis;

import com.dennis.DTO.ProductDTO;
import com.dennis.Model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDTO productToProductDTO(Product product);
    Product productDTOToProduct(ProductDTO productDTO);
    List<ProductDTO> productListToProductDTOList(List<Product> productList);
    List<Product> productDTOListToProductList(List<ProductDTO> productDTOList);
}
