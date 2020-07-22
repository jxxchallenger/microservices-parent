package io.jxxchallenger.data.mapper;

import java.util.List;

import io.jxxchallenger.data.model.Language;

public interface LanguageMapper {

	int createTable();
	
	int batchInsert(List<Language> languages);
}
