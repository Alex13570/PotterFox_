package ru.loonolud.potterfox.mapper;

import org.mapstruct.Mapper;
import ru.loonolud.potterfox.dto.request.ProductRequest;
import ru.loonolud.potterfox.dto.response.ProductResponse;
import ru.loonolud.potterfox.model.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<ProductEntity, ProductRequest, ProductResponse> {
}
