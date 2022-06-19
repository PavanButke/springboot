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


### Dependencies

* Spring Web Services 
* Spring Dev Tools
* jackson formatter


### Installing

* Create Project in STS using New Project-> SpringBoot -> Select Specification -> Specify your java version
* Any modifications needed to be made to files/folders


### Executing program

* Run ProductServiceApplication as SpringBoot Application

```
Endpoints:
	```
	Getting all the Products from List
	 http://localhost:8080/products/
	```
	```
	Getting an specific record based on Product's Id
	 http://localhost:8080/products/{productId}
	 ex.
	 http://localhost:8080/products/89
	```
	
	```
	Uploading new Product Record in the List
	 http://localhost:8080/products/
	 ex.
	 	body of Postman-->
	 	 {
        "productId": 101,
        "productName": "Cheeze",
        "expDate": "28May2023"
   		 }
   		 
   		Hit the Post on mentioned URI
	```
```




## Authors

Pavan Butke


## Acknowledgments