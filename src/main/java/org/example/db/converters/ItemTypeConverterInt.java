package org.example.db.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.db.entity.enums.TypeEnum;

import java.util.Arrays;

@Converter
public class ItemTypeConverterInt implements AttributeConverter<TypeEnum, Integer> {

  @Override
  public Integer convertToDatabaseColumn(TypeEnum attribute) {
    return attribute == null ? null : attribute.getValue();
  }

  @Override
  public TypeEnum convertToEntityAttribute(Integer dbData) {
    return dbData != null ? Arrays.stream(TypeEnum.values()).filter(s -> s.getValue() == dbData.intValue()).findFirst()
        .orElse(null) : null;
  }
}
