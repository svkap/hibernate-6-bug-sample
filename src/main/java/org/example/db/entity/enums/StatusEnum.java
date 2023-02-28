package org.example.db.entity.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusEnum {
  STATUS_ONE(1), STATUS_TWO(10), STATUS_THREE(20);

  private final int value;

  public int getValue() {
    return value;
  }
}
