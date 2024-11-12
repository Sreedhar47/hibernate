# Summary of Relationships

# School - Principal: One-to-One
A school has a single principal, and a principal is associated with a single school. The School entity owns the relationship.

# School - Student: One-to-Many
A school has many students, but each student is associated with only one school. Student owns this relationship.

# Student - Course: Many-to-Many
Students can enroll in multiple courses, and courses can have multiple students. This is managed through a student_course join table.

# @Entity
Used on a class to designate it as a JPA entity, meaning it will be mapped to a table in the database.
Each class marked with @Entity must have a primary key, which is usually defined with @Id.

# @Table
Used to specify the table details in the database for the entity. By default, the table name will be the same as the entity name, but @Table(name = "table_name") can be used to provide a custom table name.
# Example: 
@Table(name = "school") in the School entity maps this class to a table named school in the database.
# @Id
Marks a field as the primary key of the entity. Each entity must have a primary key to uniquely identify its records.
# @GeneratedValue
Used in combination with @Id to specify the primary key generation strategy. In the code, it is used as @GeneratedValue(strategy = GenerationType.IDENTITY).
# GenerationType.IDENTITY:
Uses auto-incremented values from the database for each new record.
Other strategies include AUTO, SEQUENCE, and TABLE, but IDENTITY is commonly used when the database itself is responsible for generating the IDs.

# @Column
Used to specify details about a column in the database. It can be used to set properties like nullable, unique, length, and name.
# Example: 
@Column(nullable = false) on the name field in School means the name column cannot be null.

# @OneToOne
Defines a one-to-one relationship between two entities. It can be bidirectional or unidirectional.
@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY): This establishes a one-to-one relationship where all operations (persist, merge, remove) cascade to the related entity, and the related entity is lazily loaded (fetched only when accessed).

# @JoinColumn:
Used to specify the foreign key column in the database that manages this relationship.
# Example: 
@JoinColumn(name = "principal_id") in the School entity indicates that the principal_id column in the school table holds the foreign key for the Principal entity.

# @OneToMany
Defines a one-to-many relationship, where one entity can have multiple related entities.
# mappedBy:
Used to specify that this entity is not the owner of the relationship, and the mapping is defined by the referenced entity.
# Example: 
@OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY) in the School entity indicates a one-to-many relationship with Student, where the School entity is the parent, and cascading operations will propagate to associated Student entities.
# @ManyToOne
Defines a many-to-one relationship, where multiple entities can be related to a single entity.
# Example: 
@ManyToOne in the Student entity specifies that each student is associated with a single School.
# @JoinColumn: 
Specifies the foreign key column that maintains this relationship.
# Example:
@JoinColumn(name = "school_id") indicates that the school_id column in the student table holds the foreign key to the School entity.
# @ManyToMany
Defines a many-to-many relationship between two entities, where each entity can have multiple related entities on both sides.
# @JoinTable:
Specifies the join table that manages the many-to-many relationship between the two entities.
# name: 
Specifies the join table name (e.g., "student_course").
# joinColumns: 
Defines the foreign key column for the current entity (e.g., @JoinColumn(name = "student_id") in Student).
# inverseJoinColumns: 
Defines the foreign key column for the other entity (e.g., @JoinColumn(name = "course_id") in Course).
# mappedBy: 
Used in the inverse side of the relationship to indicate that this entity does not own the relationship, with the owner specified in the other entity.
# Example:
@ManyToMany(mappedBy = "courses") in the Course entity indicates that the Course entity does not own the relationship and Student is the owner.

# CascadeType
Cascade types control which operations performed on the parent entity should cascade to its associated entities. The possible cascade options include:

# ALL: 
Propagates all operations (persist, merge, remove, refresh, and detach).

# PERSIST:
When a parent entity is saved, related entities are also saved.

# MERGE:
When a parent entity is merged (updated), related entities are also merged.

# REMOVE:
When a parent entity is deleted, related entities are also deleted.

# REFRESH: 
When a parent entity is refreshed, related entities are also refreshed.

# DETACH: 
When a parent entity is detached from the persistence context, related entities are also detached.

# FetchType
Defines the fetching strategy for loading related entities. There are two types:

# LAZY:
Related entities are loaded only when they are accessed, not immediately upon loading the parent entity. This improves performance.

# EAGER:
Related entities are loaded immediately when the parent entity is loaded.

# In the code:
FetchType.LAZY is used in the one-to-one and one-to-many relationships to avoid loading the associated entities until they are accessed. This is useful for optimizing performance when large collections or nested relationships are involved.
