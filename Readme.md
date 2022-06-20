# ProducService Application

An Springboot Application For Product Service .

## Steps Involved
* Creating an Entity
* Created an Endpoints with the help @RequestMapping within Controller Class.
* Code an Static List
* Code methods for Getting all Product Records
* Test all the EndPoints on PostMan
* Add Shorthands for @RequestMapping --> For method like GET use @GetMapping , POST @PostMapping
* Applied Content Negotiation for XML Format using -->produces , consumes , MediaType
* Coded three new classes Implementing ProductApplicationRunner , ProductCommandLineRunner , ProductCommandLineRunner2 within main package
* These new classes implements the Respective Interfaces
* Coded a new TestClass within new Package Testing 
* Scanned these non-child class with the of @ComponentScan
* Ordered all three ProductApplicationRunner , ProductCommandLineRunner , ProductCommandLineRunner2 according your requirment.
* Coded ProductServiceImpl class which implements ProductService Interface
* Shifted Methods and List from Controller Layer to ProductService Layer and Autowired Product Service Interface
* Make Sure to use @Service annotation with Implementer Class
* An Repository Layer added as ProductRepository which extends an JpaInterface which is again an Interface[Read More About Jpa](https://spring.io/projects/spring-data-jpa)
* H2 Database Connected to Project [Read More About H2DB](https://www.h2database.com/html/main.html)
* Tested Crud Ops on Postman and Browser
* Connected to MySQL db as H2DB is an Viotile DB as it is local memory based DB
* Tested CRUD OPs on Postman
* DTO Layer Added as ProductDto class in com.assignment.dto package
* DTO secure the application while taking inputs and o/ps as well.. [Read More About DTO Layer](https://www.javaguides.net/2021/02/spring-boot-dto-example-entity-to-dto.html)
* MapToEntity Pattern Developed
* MapToDta Pattern Developed
* Integrated within all the Methods
* Integrated an ModelMapper replacing mapToEntity and mapToDto
* Integrated ResponseEntity for HTTPs status in accordance with action.
* Updated MSGs
* Get Product based on their names
* Used concept of Custom Queries--> getByProductName()
* We can use all the parameters to find an product in the existing list
* We are using findByProductNameAndExpDate
* This methods comes under JpaRepository Interface [Wanna learn more Jpa Method Implementation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
* Used NameQuery and Cascaded NamedQueries using @NameQueries annotation
* Coded @NamedQueries within Product class , changes reflected to ProductRepository --> ProductService --> ProductServiceImpl
* Coded an JPQL query inside the @Query withing ProductRepository Interface
* Implemented ProductServiceImpl
* Coded an Query to Search Product Name using First Letters of Product
* For example , if product name is Mustang ...Then you need to enter just M and it will display all the product in the list starting with M
* Replace ?1 & ?2 with respective parameters with the help @Param
* Perform native queries
* PagingAndSorting Concept Implemented
* we can now filter product data according to page number which are indexes and page size as well
* We have implemented this concept over getAllProducts method in ProductServiceImpl which is implementing JpaRepository Interfaces methods
* We know that Jpa is an Interface , it is have SuperInterfaces as following: CrudRepository<T,ID>, PagingAndSortingRepository<T,ID>, QueryByExampleExecutor<T>, Repository<T,ID>
* Out of which we are using  PagingAndSortingRepository<T,ID> 
* Here we have #Pageable which is an abstract interface whos implementer is PageRequest
* PageRequest has diffrent overload methods , we have used .of() which take page number and page size (int)
* Tested Succesfully in Postman
* Sorting has been done by adding parameters such as order --> which is an boolean datatype
* We have used ternary operator on implementor getAllProducts in ProductServiceImpl 
* We have used #Varargs over properties as String... properties
* With the help @RequestParam --> we have set default property as productName

### Dependencies

* Spring Web Services 
* Spring Dev Tools
* jackson formatter
* Jpa Maven Dependency Added
* H2Database Maven Dependency Added
* MySql Connector Maven Dependency Added
* Application.yml transition
* ModelMapper Maven Dependency



### Installation

* Create Project in STS using New Project-> SpringBoot -> Select Specification -> Specify your java version



### Executing program

* Run ProductServiceApplication as SpringBoot Application

```
Endpoints:
	```
	Getting all the Products from List
	 http://localhost:8080/product-api/products/
	```
	```
	Getting an specific record based on Product's Id
	 http://localhost:8080/product-api/products/{productId}
	 ex.
	 http://localhost:8080/products/89
	```
	
	```
	Uploading new Product Record in the List
	 http://localhost:8080/product-api/products/
	 ex.
	 	body of Postman-->
	 	 {
        "productId": 101,
        "productName": "Cheeze",
        "expDate": "28May2023"
   		 }
   		 
   		Hit the Post on mentioned URI
	```
	
	Getting an specific record based on Product's Name (not a Prime Key)
	 http://localhost:8080/product-api/products/list/{productName}
	 ex.
	 http://localhost:8080/product-api/products/list/Playstation5
	```
	
	Getting an specific record based on Product's Name and ExpiryDate of Project(not a Prime Key)
	 http://localhost:8080/product-api/products/{productName}/{expDate}
	 ex.
	http://localhost:8080/product-api/products/Bike/23Jun2022	
	```
	
	Getting an specific record based on Product's First Character ; all product list based on First Letters of Product Name
	 http://localhost:8080/product-api/products/list/{FirstCharsofProductName}
	 ex.
	 http://localhost:8080/product-api/products/list/P
	 return list of products starting with "P"--> Playstation5
	```
	Getting an Records with "4" Records Per Page on PageNumber "0" order in ASCENDING Order and sort on the basis of ProductId
	http://localhost:8080/product-api/products?pageNumber=0&pageSize=4&order=true&sort=productId
	
	```
	
```




## Authors

Pavan Butke


## Acknowledgments