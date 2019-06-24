package com.jesus.ShopSpring.mapper;

public interface MapperService<T, S> {
	T mapToDto(S entity);

	S mapToEntity(T dto);
}
