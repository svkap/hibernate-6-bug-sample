package org.example.db.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.db.entity.enums.TypeEnum;

@Converter
public class ItemTypeConverter implements AttributeConverter<TypeEnum, String> {

  @Override
  public String convertToDatabaseColumn(TypeEnum attribute) {
    return attribute == null ? null : attribute.name();
  }

  @Override
  public TypeEnum convertToEntityAttribute(String dbData) {
    return TypeEnum.valueOf(dbData);
  }
}
