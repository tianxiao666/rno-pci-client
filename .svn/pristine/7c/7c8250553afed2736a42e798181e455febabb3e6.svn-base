package com.hgicreate.rno.service.mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D> - DTO type parameter.
 * @param <E> - Entity type parameter.
 * @author chen.c10
 */
public interface EntityMapper<D, E> {

    /**
     * dto to entity
     *
     * @param dto dto
     * @return entity
     */
    E dtoToEntity(D dto);

    /**
     * dto list to entity list
     *
     * @param dtoList dto list
     * @return entity list
     */
    default List<E> dtoListToEntityList(List<? extends D> dtoList) {
        if (dtoList == null) {
            return null;
        }
        return dtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    /**
     * dto steam to entity steam
     *
     * @param dtoStream dto steam
     * @return entity steam
     */
    default Stream<E> dtoStreamToEntityStream(Stream<? extends D> dtoStream) {
        if (dtoStream == null) {
            return null;
        }
        return dtoStream.map(this::dtoToEntity);
    }

    /**
     * entity to dto
     *
     * @param entity entity
     * @return dto
     */
    D entityToDto(E entity);

    /**
     * entity list to dto list
     *
     * @param entityList entity list
     * @return dto list
     */
    default List<D> entityListToDtoList(List<? extends E> entityList) {
        if (entityList == null) {
            return null;
        }
        return this.entityStreamToDtoStream(entityList.stream()).collect(Collectors.toList());
    }

    /**
     * entity stream to dto stream
     *
     * @param entityStream entity stream
     * @return dto stream
     */
    default Stream<D> entityStreamToDtoStream(Stream<? extends E> entityStream) {
        if (entityStream == null) {
            return null;
        }
        return entityStream.map(this::entityToDto);
    }
}
