package com.jesus.ShopSpring.mapper;

import java.text.ParseException;

public interface MapperServiceDate<T, S> {
	T mapToDto(S entity);

	S mapToEntity(T dto) throws ParseException;
}
