package org.example.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.db.converters.ItemStatusConverter;
import org.example.db.converters.ItemTypeConverter;
import org.example.db.entity.enums.StatusEnum;
import org.example.db.entity.enums.TypeEnum;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "item_2")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Item2Entity {

  @Id
  @GeneratedValue(generator = "item_2_id_seq", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "item_2_id_seq", sequenceName = "item_2_id_seq")
  private Long id;

  private BigDecimal amount;
  private String notes;
  private Boolean active;
  private Integer itemsCount;

  //@Column(columnDefinition = "item_status", nullable = false)
  @Column(nullable = false)
  @Convert(converter = ItemStatusConverter.class)
  private StatusEnum status;
  //@Column(columnDefinition = "item_type", nullable = false)
  @Column(nullable = false)
  @Convert(converter = ItemTypeConverter.class)
  private TypeEnum type;

  @CreatedDate
  private Instant createdOn;
  @LastModifiedDate
  private Instant updatedOn;
  @Version
  private int version;
}
