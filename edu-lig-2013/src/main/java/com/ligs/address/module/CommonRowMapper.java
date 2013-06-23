package com.ligs.address.module;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class CommonRowMapper<T> implements RowMapper<T> {

	private Class<T> entityClass;

	public CommonRowMapper(Class<T> clazz) {
		this.entityClass = clazz;
	}

	@Override
	public T mapRow(ResultSet rs, int arg1) throws SQLException {
		T t = null;
		try {
			t = entityClass.newInstance();
			Field[] fields = t.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				field.set(t, getValueByType(rs, field));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return t;
	}

	private Object getValueByType(ResultSet rs, Field field) throws SQLException {
		final String fieldTypeName = field.getType().getName();
		final String filedName = getColumnNameFromField(field);
		
		if (fieldTypeName.equals(Date.class.getName())) {
			return rs.getDate(filedName);
		} else if (fieldTypeName.equals(String.class.getName())) {
			return rs.getString(filedName);
		} else {
			throw new UnsupportedOperationException("해당 타입은 지원하지 않습니다. type : " + fieldTypeName);
		}
	}
	
	private String 	getColumnNameFromField(Field field) {
		MappingColumn column = field.getAnnotation(MappingColumn.class);
		String columnName = column.name();

		return columnName.isEmpty() ? field.getName() : columnName;
	}


}
