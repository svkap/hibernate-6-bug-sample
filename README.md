# hibernate-6-bug-sample

This is a sample project demonstrating several Hibernate 6 problems related to using 'IN (:list)' in where clause.

The project uses docker-compose for spinning up PostgreSQL + Flyway for db initialization. It uses spring-data and lombok. 

It seems there are problems when lists are used in queries and with coalesce. 

The Entities are fairly simple but have different column types. 
There are 3 different entity definition:
 1. Using PostgreSQL enum + @Enumerated(EnumType.STRING)
 2. Using varchar column + @Convert(...)
 3. Using int column + @Convert(...)

---

The sample project tests several different queries and scenarios.
Result summary:

1. Entity creation work for all scenarios.
2. Entity update work for all scenarios.
3. Return entity, use SpEl ( (:#{#list == null} = true) OR (i.list IN (:list)) ) works in JPQL
4. Pass Integer/String to native query works for coalesce and SpEl only when projection is returned

---
The exceptions seem the same when using PostgreSQL enum, Converter + String and Converter + Integer:

1. Return entity, native query + pass enums to repository method + ( (coalesce(:list, null) is null) OR (i.list IN (:list)) )
   1. java.lang.NullPointerException: Cannot invoke "org.hibernate.metamodel.mapping.JdbcMapping.getJdbcValueBinder()" because "jdbcMapping" is null
2. Return entity, native query + pass strings to repository method + ( (coalesce(:list, null) is null) OR (i.list IN (:list)) )
   1. org.springframework.dao.InvalidDataAccessResourceUsageException: Unable to find column position by name: id; SQL [n/a]
3. Return entity, native query + pass null to repository method + ( (coalesce(:list, null) is null) OR (i.list IN (:list)) )
   1. org.springframework.dao.InvalidDataAccessResourceUsageException: Unable to find column position by name: id; SQL [n/a]
4. Return entity, native query + pass enums to repository method + ( (:#{#list == null} = true) OR (i.list IN (:list)) )
    1. java.lang.NullPointerException: Cannot invoke "org.hibernate.metamodel.mapping.JdbcMapping.getJdbcValueBinder()" because "jdbcMapping" is null
5. Return entity, native query + pass null to repository method + ( (:#{#list == null} = true) OR (i.list IN (:list)) )
   1. org.springframework.dao.InvalidDataAccessResourceUsageException: Unable to find column position by name: id; SQL [n/a]
6. Return entity, native query + pass enum to repository method
   1. java.lang.NullPointerException: Cannot invoke "org.hibernate.metamodel.mapping.JdbcMapping.getJdbcValueBinder()" because "jdbcMapping" is null
7. Return entity, native query + pass string to repository method + ( (:#{#list == null} = true) OR (i.list IN (:list)) )
   1. org.springframework.dao.InvalidDataAccessResourceUsageException: Unable to find column position by name: id; SQL [n/a]
7. Return entity, JPQL query + pass enum to repository method + ( (coalesce(:list, null) is null) OR (i.list IN (:list)) )
   1. java.lang.ClassCastException: class java.util.ImmutableCollections$List12 cannot be cast to class java.lang.Enum (java.util.ImmutableCollections$List12 and java.lang.Enum are in module java.base of loader 'bootstrap')
7. Return projection, native query + pass enum to repository method + ( (:#{#list == null} = true) OR (i.list IN (:list)) )
   1. java.lang.NullPointerException: Cannot invoke "org.hibernate.metamodel.mapping.JdbcMapping.getJdbcValueBinder()" because "jdbcMapping" is null
