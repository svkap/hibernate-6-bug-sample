package org.example.db.repository;

import org.example.db.entity.Item3Entity;
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
public interface Item3Repository extends JpaRepository<Item3Entity, Long> {

  @Query("""
      SELECT i FROM Item3Entity i WHERE 
        (:dateFrom <= i.createdOn) AND (:dateTo >= i.createdOn) 
        AND ( (:#{#statuses == null} = true) OR (i.status IN (:statuses)) ) 
        AND ( (:#{#types == null} = true) OR (i.type IN (:types)) ) 
      ORDER BY i.createdOn DESC
      """)
  Page<Item3Entity> findItemsJpqlEnumsSpEl(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query("""
      SELECT i FROM Item3Entity i WHERE 
        (:dateFrom <= i.createdOn) AND (:dateTo >= i.createdOn) 
        AND ( (coalesce(:statuses, null) is null) OR (i.status IN (:statuses)) ) 
        AND ( (coalesce(:types, null) is null) OR (i.type IN (:types)) ) 
      ORDER BY i.createdOn DESC
      """)
  Page<Item3Entity> findItemsJpqlEnumsCoalesce(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query("""
      SELECT i FROM Item3Entity i WHERE 
        (:dateFrom <= i.createdOn) AND (:dateTo >= i.createdOn) 
        AND ( i.status IN (:statuses) ) 
        AND ( i.type IN (:types) ) 
      ORDER BY i.createdOn DESC
      """)
  Page<Item3Entity> findItemsJpqlEnums(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item_3 i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (:#{#statuses == null} = true) OR (i.status IN (:statuses)) ) 
        AND ( (:#{#types == null} = true) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<Item3Entity> findItemsNativeEnumsSpEl(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<Integer> statuses, @Param("types") List<Integer> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item_3 i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (coalesce(:statuses, null) is null) OR (i.status IN (:statuses)) ) 
        AND ( (coalesce(:types, null) is null) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<Item3Entity> findItemsNativeEnumsCoalesce(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<Integer> statuses, @Param("types") List<Integer> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item_3 i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( i.status IN (:statuses) ) 
        AND ( i.type IN (:types) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<Item3Entity> findItemsNativeEnumsOnly(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<Integer> statuses, @Param("types") List<Integer> types, Pageable pageable);


  @Query("""
      SELECT i FROM Item3Entity i WHERE 
        (:dateFrom <= i.createdOn) AND (:dateTo >= i.createdOn) 
        AND ( (:#{#statuses == null} = true) OR (i.status IN (:statuses)) ) 
        AND ( (:#{#types == null} = true) OR (i.type IN (:types)) ) 
      ORDER BY i.createdOn DESC
      """)
  Page<ItemView> findItemsViewJpqlEnumsSpEl(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query("""
      SELECT i FROM Item3Entity i WHERE 
        (:dateFrom <= i.createdOn) AND (:dateTo >= i.createdOn) 
        AND ( (coalesce(:statuses, null) is null) OR (i.status IN (:statuses)) ) 
        AND ( (coalesce(:types, null) is null) OR (i.type IN (:types)) ) 
      ORDER BY i.createdOn DESC
      """)
  Page<ItemView> findItemsViewJpqlEnumsCoalesce(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query("""
      SELECT i FROM Item3Entity i WHERE 
        (:dateFrom <= i.createdOn) AND (:dateTo >= i.createdOn) 
        AND ( i.status IN (:statuses) ) 
        AND ( i.type IN (:types) ) 
      ORDER BY i.createdOn DESC
      """)
  Page<ItemView> findItemsViewJpqlEnums(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<StatusEnum> statuses, @Param("types") List<TypeEnum> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item_3 i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (:#{#statuses == null} = true) OR (i.status IN (:statuses)) ) 
        AND ( (:#{#types == null} = true) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<ItemView> findItemsViewNativeEnumsSpEl(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<Integer> statuses, @Param("types") List<Integer> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item_3 i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( (coalesce(:statuses, null) is null) OR (i.status IN (:statuses)) ) 
        AND ( (coalesce(:types, null) is null) OR (i.type IN (:types)) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<ItemView> findItemsViewNativeEnumsCoalesce(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<Integer> statuses, @Param("types") List<Integer> types, Pageable pageable);

  @Query(value = """
      SELECT i FROM item_3 i WHERE 
        (:dateFrom <= i.created_on) AND (:dateTo >= i.created_on) 
        AND ( i.status IN (:statuses) ) 
        AND ( i.type IN (:types) ) 
      ORDER BY i.created_on DESC
      """, nativeQuery = true)
  Page<ItemView> findItemsViewNativeEnumsOnly(@Param("dateFrom") Instant dateFrom, @Param("dateTo") Instant dateTo,
      @Param("statuses") List<Integer> statuses, @Param("types") List<Integer> types, Pageable pageable);

}
