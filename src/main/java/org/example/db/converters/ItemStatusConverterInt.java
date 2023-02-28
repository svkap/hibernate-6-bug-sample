package org.example.db.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.db.entity.enums.StatusEnum;

import java.util.Arrays;

@Converter
public class ItemStatusConverterInt implements AttributeConverter<StatusEnum, Integer> {

  @Override
  public Integer convertToDatabaseColumn(StatusEnum attribute) {
    return attribute == null ? null : attribute.getValue();
  }

  @Override
  public StatusEnum convertToEntityAttribute(Integer dbData) {
    return dbData != null ? Arrays.stream(StatusEnum.values()).filter(s -> s.getValue() == dbData.intValue()).findFirst()
        .orElse(null) : null;
  }
}
