package com.dc.grocerymateapi.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;

import java.util.List;
import java.util.stream.Collectors;

public class HandlerMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    static void setConfigUnderToCamel(){
        modelMapper
                .getConfiguration()
                .setSourceNameTokenizer(NameTokenizers.UNDERSCORE)
                .setDestinationNameTokenizer(NameTokenizers.CAMEL_CASE);
    }

    static void setConfigCamelToUnder(){
        modelMapper
                .getConfiguration()
                .setSourceNameTokenizer(NameTokenizers.CAMEL_CASE)
                .setDestinationNameTokenizer(NameTokenizers.UNDERSCORE);
    }


}
