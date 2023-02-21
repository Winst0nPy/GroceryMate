package com.dc.grocerymateapi.util;

import com.ex.springbasics.dto.PostDTOreq;
import com.ex.springbasics.dto.ProductDTOreq;
import com.ex.springbasics.entity.Post;
import com.ex.springbasics.entity.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;


public class MapToEntity {

    private static ModelMapper modelMapper;

    private static ModelMapper instance(){
        if (modelMapper == null){
            modelMapper = new ModelMapper();
            modelMapper
                    .getConfiguration()
                    .setSourceNameTokenizer(NameTokenizers.UNDERSCORE)
                    .setDestinationNameTokenizer(NameTokenizers.CAMEL_CASE);
            return modelMapper;
        }
        return modelMapper;
    }

    public static Post map(PostDTOreq postDTO){
        Post post  = instance().map(postDTO, Post.class);
        Product product = map(postDTO.getProduct());
        post.setProduct(product);
        return post;
    }

    public static Product map(ProductDTOreq productDTO){
        return instance().map(productDTO, Product.class);
    }
}
