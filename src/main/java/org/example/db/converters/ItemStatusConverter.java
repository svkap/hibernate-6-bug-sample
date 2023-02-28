package org.example.db.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.db.entity.enums.StatusEnum;

@Converter
public class ItemStatusConverter implements AttributeConverter<StatusEnum, String> {

  @Override
  public String convertToDatabaseColumn(StatusEnum attribute) {
    return attribute == null ? null : attribute.name();
  }

  @Override
  public StatusEnum convertToEntityAttribute(String dbData) {
    return StatusEnum.valueOf(dbData);
  }
}
