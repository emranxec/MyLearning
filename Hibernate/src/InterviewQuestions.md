1. table name

        @Table(name = "orders",
        uniqueConstraints = @UniqueConstraint(name="customerId",columnNames = {"id","customerId"}))

2. id generator

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)//todo :: interview ::
            private UUID id;
3. what is optimistic locking

        @version
        @Column(name="version_number")
        public Integer getVersion;

4. How do you implement single table per class hierarchy strategy with Hibernate?

        single table per class hierarchy strategy

        @Entity
        @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
        @DiscriminatorColumn(
            name="cartype",
            discriminatorType=DiscriminatorType.STRING
        )

        @DiscriminatorValue("Car")
        public class Car { ... }

        @Entity
        @DiscriminatorValue("Formula1")
        public class FormulaOneCar extends Car { ... }

5. How do you implement table per class strategy with Hibernate?

        Table per class strategy is the default strategy for Hibernate.

        @Entity
        @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
        public class Car implements Serializable { ... }

        @Entity
        @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
        public class FormulaOneCar implements Serializable { ... }

6. How do you specify a one to many unidirectional relationship with Hiberate?

        public class Parent {
            @Id
            @GeneratedValue
            private long id;

            @OneToMany
            private Set<Child> children;
        }

        public class Child {
           @Id 
           @GeneratedValue
           private long id;
           private String name;
        }

7. How do you specify a one-to-many bidirectional relationship with Hibernate?


        public class Parent {
        @Id
        @GeneratedValue
        private long id;

            @OneToMany
            private Set<Child> children;
        }

        public class Child {
        @Id
        @GeneratedValue
        private long id;
        private String name;

            @ManyToOne
            private Parent parent;
            }

8. How do you implement pagination with Hibernate?

        Query q = sess.createQuery("Some HQL Query");
        q.setFirstResult(50); //50th row would be the first result returned
        q.setMaxResults(100); //100 is the maximum number of rows returned
        List cats = q.list();

9. What is a lazy association?
           Let’s consider a Parent table associated with a corresponding Child table.
        When we load the Parent table, should we load the content of the Child relationship? 
        In lazy association, the Child relationship is loaded when its need. 
        This is the default configuration in Hibernate.

10. What is N + 1 selects Problem in hibernate?

        1- parent
        10-children
        //hibernate do 11 queries

        solution : use fetch type "join"

        Default join in hibernate is select join. 

        In a Parent – Child relationship using select join - 
        if a Parent has N childs – 
        Hibernate should execute N + 1 queries to retrieve all the details of Parent and all Child’s. 
        This is called N + 1 selects problem in Hibernate.

        This can be avoided by making fetch type as join.

        --<set name="permissions" fetch="join">--

11. How can you do automatic schema generation from Hibernate Mappings?

        SQL DDL can be generated from mapping files by using SchemaExport tool that Hibernate Provides.
        We need to make sure that the mapping files provide detailed constraints like not null,
        maximum length, unique keys, foreign keys so that the generated schema generated
        has appropriate relationships and constraints. 

        Command used to run SchemaExport is :
        ---java -cp hibernate_classpaths org.hibernate.tool.hbm2ddl.SchemaExport options mapping_files----

        SchemaExport has the feature to generate incremental updates as
        well. Be careful when you use it, as SchemaExport depends on JDBC metadata API.


12. What is the use of SchemaValidator?

        SchemaValidator tool can be used to verify if the mapping configured “matches” the existing database structure.

        13. Suggest some Hibernate Best Practices?

        Identify natural keys : Identify natural keys for all entities, and map them using .

        Place each class mapping in its own file. 

        Externalize query strings to make applications more portable.

        Use bind variables to prevent SQL Injection.

        Use hand-coded JDBC sparing: Using SQL defeats the entire purpose of using Hibernate. So, use it sparingly, only when it is performance-critical.

        Prefer lazy fetching for associations. Explicitly disable eager fetching using lazy="false". 
        When join fetching is appropriate to a particular use case, use a query with a left join fetch.

        Use bidirectional associations: In a large application, almost all associations must be navigable in both directions in queries.
