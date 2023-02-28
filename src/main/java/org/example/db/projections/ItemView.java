package org.example.db.projections;

import org.example.db.entity.enums.StatusEnum;
import org.example.db.entity.enums.TypeEnum;

import java.math.BigDecimal;
import java.time.Instant;

public interface ItemView {
  Long getId();

  BigDecimal getAmount();

  String getNotes();

  Boolean getActive();

  Integer getItemsCount();

  StatusEnum getStatus();

  TypeEnum getType();

  Instant getCreatedOn();

  Instant getUpdatedOn();
}
