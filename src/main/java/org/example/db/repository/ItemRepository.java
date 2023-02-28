package org.example.db.repository;

import org.example.db.entity.ItemEntity;
import org.example.db.entity.enums.StatusEnum;
import org.example.db.entity.enums.TypeEnum;
import org.example.db.projections.ItemView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

  @Query("""
      SELECT i FROM ItemEntity i WHERE 
        (:dateFrom <= i.createdOn) AND (:dateTo >= i.createdOn) 
        AND ( (:#{#statuses == null} = true) OR (i.status IN (:statuses)) ) 
        AND ( (:#{#types == null} = true) OR (i.type IN (:types)) ) 
      ORDER BY i.createdOn DESC
      """)
  Page<ItemEntity> findItemsJpqlEnumsSpEl(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query("""
      SELECT i FROM ItemEntity i WHERE 
        (:dateFrom <= i.createdOn) AND (:dateTo >= i.createdOn) 
        AND ( (coalesce(:statuses, null) is null) OR (i.status IN (:statuses)) ) 
        AND ( (coalesce(:types, null) is null) OR (i.type IN (:types)) ) 
      ORDER BY i.createdOn DESC
      """)
  Page<ItemEntity> findItemsJpqlEnumsCoalesce(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query("""
      SELECT i FROM ItemEntity i WHERE 
        (:dateFrom <= i.createdOn) AND (:dateTo >= i.createdOn) 
        AND ( i.status IN (:statuses) ) 
        AND ( i.type IN (:types) ) 
      ORDER BY i.createdOn DESC
      """)
  Page<ItemEntity> findItemsJpqlEnums(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (:#{#statuses == null} = true) OR (i.status IN (:statuses)) ) 
        AND ( (:#{#types == null} = true) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<ItemEntity> findItemsNativeEnumsSpEl(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (coalesce(:statuses, null) is null) OR (i.status IN (:statuses)) ) 
        AND ( (coalesce(:types, null) is null) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<ItemEntity> findItemsNativeEnumsCoalesce(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( i.status IN (:statuses) ) 
        AND ( i.type IN (:types) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<ItemEntity> findItemsNativeEnumsOnly(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (:#{#statuses == null} = true) OR (i.status IN (:statuses)) ) 
        AND ( (:#{#types == null} = true) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<ItemEntity> findItemsNativeEnumsSpElString(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<String> statuses, @Param("types") List<String> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (coalesce(:statuses, null) is null) OR (i.status IN (:statuses)) ) 
        AND ( (coalesce(:types, null) is null) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<ItemEntity> findItemsNativeEnumsCoalesceString(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<String> statuses, @Param("types") List<String> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( i.status IN (:statuses) ) 
        AND ( i.type IN (:types) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<ItemEntity> findItemsNativeEnumsOnlyString(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<String> statuses, @Param("types") List<String> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (:#{#statuses == null} = true) OR (i.status IN (:statuses)) ) 
        AND ( (:#{#types == null} = true) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<ItemView> findItemsViewNativeEnumsSpEl(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (coalesce(:statuses, null) is null) OR (i.status IN (:statuses)) ) 
        AND ( (coalesce(:types, null) is null) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<ItemView> findItemsViewNativeEnumsCoalesce(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( i.status IN (:statuses) ) 
        AND ( i.type IN (:types) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<ItemView> findItemsViewNativeEnumsOnly(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (:#{#statuses == null} = true) OR (i.status IN (:statuses)) ) 
        AND ( (:#{#types == null} = true) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<ItemView> findItemsViewNativeEnumsSpElString(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<String> statuses, @Param("types") List<String> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (coalesce(:statuses, null) is null) OR (i.status IN (:statuses)) ) 
        AND ( (coalesce(:types, null) is null) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<ItemView> findItemsViewNativeEnumsCoalesceString(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<String> statuses, @Param("types") List<String> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( i.status IN (:statuses) ) 
        AND ( i.type IN (:types) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<ItemView> findItemsViewNativeEnumsOnlyString(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<String> statuses, @Param("types") List<String> types, Pageable pageable);
}
