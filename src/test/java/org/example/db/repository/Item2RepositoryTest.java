package org.example.db.repository;

import org.example.db.entity.Item2Entity;
import org.example.db.entity.enums.StatusEnum;
import org.example.db.entity.enums.TypeEnum;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class Item2RepositoryTest {

  // 2023-02-27 10:00:00.000000
  private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss.SSSSSS");
  @Autowired
  private Item2Repository item2Repository;
  @Autowired
  private Flyway flyway;

  @BeforeEach
  public void setup() {
    flyway.clean();
    flyway.migrate();
  }

  @Test
  void testCreate() {
    Item2Entity item = new Item2Entity();
    item.setItemsCount(1);
    item.setActive(true);
    item.setAmount(BigDecimal.ONE);
    item.setNotes("Note 1");
    item.setStatus(StatusEnum.STATUS_THREE);
    item.setType(TypeEnum.TYPE_THREE);
    Item2Entity result = item2Repository.save(item);
    assertNotNull(result);
    assertNotNull(result.getId());
  }

  @Test
  void testUpdate() {
    Item2Entity item = item2Repository.findById(1L).orElseThrow();
    item.setItemsCount(2);
    Item2Entity result = item2Repository.save(item);
    assertNotNull(result);
    assertEquals(2, result.getItemsCount());
  }

  @Test
  void testFindItemsJpqlEnumsSpEl() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsJpqlEnumsSpEl(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS),
            List.of(StatusEnum.STATUS_ONE), List.of(TypeEnum.TYPE_ONE), PageRequest.of(0, 10));
    assertEquals(1, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsJpqlEnumsSpEl2() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsJpqlEnumsSpEl(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS),
            List.of(StatusEnum.STATUS_ONE, StatusEnum.STATUS_TWO), null, PageRequest.of(0, 10));
    assertEquals(2, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsJpqlEnumsCoalesce() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsJpqlEnumsCoalesce(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS),
            List.of(StatusEnum.STATUS_ONE), List.of(TypeEnum.TYPE_ONE), PageRequest.of(0, 10));
    assertEquals(1, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsJpqlEnumsCoalesce2() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsJpqlEnumsCoalesce(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS),
            List.of(StatusEnum.STATUS_ONE, StatusEnum.STATUS_TWO), null, PageRequest.of(0, 10));
    assertEquals(2, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsJpqlEnumsSpElNull() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsJpqlEnumsSpEl(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS), null, null,
            PageRequest.of(0, 10));
    assertEquals(2, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsJpqlEnumsCoalesceNull() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsJpqlEnumsCoalesce(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS), null, null,
            PageRequest.of(0, 10));
    assertEquals(2, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsJpqlEnums() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsJpqlEnums(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS),
            List.of(StatusEnum.STATUS_ONE), List.of(TypeEnum.TYPE_ONE), PageRequest.of(0, 10));
    assertEquals(1, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsNativeEnumsSpEl() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsNativeEnumsSpEl(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS),
            List.of(StatusEnum.STATUS_ONE), List.of(TypeEnum.TYPE_ONE), PageRequest.of(0, 10));
    assertEquals(1, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsNativeEnumsSpEl2() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsNativeEnumsSpEl(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS),
            List.of(StatusEnum.STATUS_ONE, StatusEnum.STATUS_TWO), null, PageRequest.of(0, 10));
    assertEquals(2, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsNativeEnumsCoalesce() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsNativeEnumsCoalesce(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS),
            List.of(StatusEnum.STATUS_ONE), List.of(TypeEnum.TYPE_ONE), PageRequest.of(0, 10));
    assertEquals(1, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsNativeEnumsCoalesce2() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsNativeEnumsCoalesce(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS),
            List.of(StatusEnum.STATUS_ONE, StatusEnum.STATUS_TWO), null, PageRequest.of(0, 10));
    assertEquals(1, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsNativeEnumsSpElNull() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsNativeEnumsSpEl(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS), null, null,
            PageRequest.of(0, 10));
    assertEquals(1, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsNativeEnumsCoalesceNull() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsNativeEnumsCoalesce(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS), null, null,
            PageRequest.of(0, 10));
    assertEquals(1, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsNativeEnumsOnly() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsNativeEnumsOnly(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS),
            List.of(StatusEnum.STATUS_ONE), List.of(TypeEnum.TYPE_ONE), PageRequest.of(0, 10));
    assertEquals(1, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsNativeEnumsSpElString() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsNativeEnumsSpElString(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS),
            List.of(StatusEnum.STATUS_ONE.name()), List.of(TypeEnum.TYPE_ONE.name()), PageRequest.of(0, 10));
    assertEquals(1, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsNativeEnumsCoalesceString() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsNativeEnumsCoalesceString(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS),
            List.of(StatusEnum.STATUS_ONE.name()), List.of(TypeEnum.TYPE_ONE.name()), PageRequest.of(0, 10));
    assertEquals(1, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsNativeEnumsSpElNullString() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsNativeEnumsSpElString(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS), null, null,
            PageRequest.of(0, 10));
    assertEquals(1, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsNativeEnumsCoalesceNullString() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsNativeEnumsCoalesceString(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS), null,
            null, PageRequest.of(0, 10));
    assertEquals(1, pageResult.getTotalElements());
  }

  @Test
  void testFindItemsNativeEnumsOnlyString() {
    Instant time = OffsetDateTime.parse("2023-02-27T10:00+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
    Page<Item2Entity> pageResult =
        item2Repository.findItemsNativeEnumsOnlyString(time.minus(1, ChronoUnit.DAYS), time.plus(1, ChronoUnit.DAYS),
            List.of(StatusEnum.STATUS_ONE.name()), List.of(TypeEnum.TYPE_ONE.name()), PageRequest.of(0, 10));
    assertEquals(1, pageResult.getTotalElements());
  }
}
