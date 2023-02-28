package org.example.db.repository;

import org.example.db.entity.Item2Entity;
import org.example.db.entity.Item2Entity;
import org.example.db.entity.enums.StatusEnum;
import org.example.db.entity.enums.TypeEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface Item2Repository extends JpaRepository<Item2Entity, Long> {

  @Query("""
      SELECT i FROM Item2Entity i WHERE 
        (:dateFrom <= i.createdOn) AND (:dateTo >= i.createdOn) 
        AND ( (:#{#statuses == null} = true) OR (i.status IN (:statuses)) ) 
        AND ( (:#{#types == null} = true) OR (i.type IN (:types)) ) 
      ORDER BY i.createdOn DESC
      """)
  Page<Item2Entity> findItemsJpqlEnumsSpEl(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query("""
      SELECT i FROM Item2Entity i WHERE 
        (:dateFrom <= i.createdOn) AND (:dateTo >= i.createdOn) 
        AND ( (coalesce(:statuses, null) is null) OR (i.status IN (:statuses)) ) 
        AND ( (coalesce(:types, null) is null) OR (i.type IN (:types)) ) 
      ORDER BY i.createdOn DESC
      """)
  Page<Item2Entity> findItemsJpqlEnumsCoalesce(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query("""
      SELECT i FROM Item2Entity i WHERE 
        (:dateFrom <= i.createdOn) AND (:dateTo >= i.createdOn) 
        AND ( i.status IN (:statuses) ) 
        AND ( i.type IN (:types) ) 
      ORDER BY i.createdOn DESC
      """)
  Page<Item2Entity> findItemsJpqlEnums(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query("""
      SELECT i FROM Item2Entity i WHERE 
        (:dateFrom <= i.createdOn) AND (:dateTo >= i.createdOn) 
        AND ( (:#{#statuses == null} = true) OR (i.status IN (:statuses)) ) 
        AND ( (:#{#types == null} = true) OR (i.type IN (:types)) ) 
      ORDER BY i.createdOn DESC
      """)
  Page<Item2Entity> findItemsJpqlEnumsSpElString(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<String> statuses, @Param("types") List<String> types, Pageable pageable);

  @Query("""
      SELECT i FROM Item2Entity i WHERE 
        (:dateFrom <= i.createdOn) AND (:dateTo >= i.createdOn) 
        AND ( (coalesce(:statuses, null) is null) OR (i.status IN (:statuses)) ) 
        AND ( (coalesce(:types, null) is null) OR (i.type IN (:types)) ) 
      ORDER BY i.createdOn DESC
      """)
  Page<Item2Entity> findItemsJpqlEnumsCoalesceString(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<String> statuses, @Param("types") List<String> types, Pageable pageable);

  @Query("""
      SELECT i FROM Item2Entity i WHERE 
        (:dateFrom <= i.createdOn) AND (:dateTo >= i.createdOn) 
        AND ( i.status IN (:statuses) ) 
        AND ( i.type IN (:types) ) 
      ORDER BY i.createdOn DESC
      """)
  Page<Item2Entity> findItemsJpqlEnumsString(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<String> statuses, @Param("types") List<String> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item_2 i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (:#{#statuses == null} = true) OR (i.status IN (:statuses)) ) 
        AND ( (:#{#types == null} = true) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<Item2Entity> findItemsNativeEnumsSpEl(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item_2 i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (coalesce(:statuses, null) is null) OR (i.status IN (:statuses)) ) 
        AND ( (coalesce(:types, null) is null) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<Item2Entity> findItemsNativeEnumsCoalesce(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item_2 i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( i.status IN (:statuses) ) 
        AND ( i.type IN (:types) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<Item2Entity> findItemsNativeEnumsOnly(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item_2 i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (:#{#statuses == null} = true) OR (i.status IN (:statuses)) ) 
        AND ( (:#{#types == null} = true) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<Item2Entity> findItemsNativeEnumsSpElString(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<String> statuses, @Param("types") List<String> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item_2 i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (coalesce(:statuses, null) is null) OR (i.status IN (:statuses)) ) 
        AND ( (coalesce(:types, null) is null) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<Item2Entity> findItemsNativeEnumsCoalesceString(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<String> statuses, @Param("types") List<String> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item_2 i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( i.status IN (:statuses) ) 
        AND ( i.type IN (:types) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<Item2Entity> findItemsNativeEnumsOnlyString(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<String> statuses, @Param("types") List<String> types, Pageable pageable);
}
