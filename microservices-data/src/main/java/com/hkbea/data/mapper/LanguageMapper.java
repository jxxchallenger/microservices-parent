package com.hkbea.data.mapper;

import java.util.List;

import com.hkbea.data.model.Language;

public interface LanguageMapper {

	int createTable();
	
	int batchInsert(List<Language> languages);
}
