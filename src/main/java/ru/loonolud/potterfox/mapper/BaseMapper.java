package ru.loonolud.potterfox.mapper;

public interface BaseMapper<ENTITY, REQUEST, RESPONSE> {
    ENTITY toEntity(REQUEST request);
    RESPONSE toResponse(ENTITY entity);
}