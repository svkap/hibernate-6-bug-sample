package org.example.db.entity.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TypeEnum {
  TYPE_ONE(1), TYPE_TWO(10), TYPE_THREE(20);

  private final int value;

  public int getValue() {
    return value;
  }
}
