package com.napptilus.preciostarifas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.napptilus.preciostarifas.api.dto.ProductDto;
import com.napptilus.preciostarifas.api.model.Product;

@Mapper
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper( ProductMapper.class );

    @Mapping(source = "priceListId", target = "priceList")
    @Mapping(source = "startDate",target = "startDate", dateFormat = "yyyy-MM-dd-HH.mm.ss")
    @Mapping(source = "endDate",target = "endDate", dateFormat = "yyyy-MM-dd-HH.mm.ss")
    ProductDto toDto( Product product );
}