package com.dennis.Adapter;

import com.dennis.DTO.ProductDTO;
import com.dennis.Model.Product;
import com.dennis.ProductMapper;
import com.dennis.Repository.ProductRepository;
import com.dennis.spi.ProductPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductAdapter implements ProductPersistencePort {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.productDTOToProduct(productDTO);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.INSTANCE.productToProductDTO(savedProduct);
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        return addProduct(productDTO);
    }

    @Override
    public List<ProductDTO> getProducts() {
        return ProductMapper.INSTANCE.productListToProductDTOList(productRepository.findAll());
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.map(ProductMapper.INSTANCE::productToProductDTO).orElse(null);
    }
}
