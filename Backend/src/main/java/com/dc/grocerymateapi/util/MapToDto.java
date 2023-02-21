package com.dc.grocerymateapi.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;

import java.util.List;
import java.util.stream.Collectors;

public class MapToDto {

    private static ModelMapper modelMapper;

    private static ModelMapper instance(){
        if (modelMapper == null){
            modelMapper = new ModelMapper();
            modelMapper
                    .getConfiguration()
                    .setSourceNameTokenizer(NameTokenizers.CAMEL_CASE)
                    .setDestinationNameTokenizer(NameTokenizers.UNDERSCORE);
            return modelMapper;
        }
        return modelMapper;
    }



}
