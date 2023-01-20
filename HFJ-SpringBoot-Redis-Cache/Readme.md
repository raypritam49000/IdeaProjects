# Running Spring Boot Redis Cache Application
## Spring web service of a CRUD of bookmarker using Spring JPA, Spring MVC and Spring Boot, including GET, PUT, POST and DELETE operations for a bookmarker entity.

   Spring have now devised a simple to use caching system based around a couple of annotations

# @EnableCaching 

   EnableCaching annotation triggers a post processor that inspects every Spring bean for the presence of caching annotations on public methods. If such an annotation is found, a proxy is automatically created to intercept the method call and handle the caching behavior 

# @Cacheable:

@Cacheable on the method which you want to cache
which will mark the method return values that will be stored in the cache without hitting the method 2nd time if data is available.

   Cacheable annotations has 3 attributes

   Value 	: is the cache name and it is mandatory ,
   Key		: based on this data will be cached and it is optional
   Condition:  based on the condition data will be cached. In example if the id < 10 then only data will be cached otherwise won’t. it is optional

# @CacheEvict:

@CacheEvict annotation will be used to delete the data from existing cache.

CacheEvict has 5 attributes:

   1 Value 				: is the cache name and it is mandatory ,
   2 Key				: based on this data will be cached and it is optional
   3 Condition			:  based on the condition data will be cached.
   4 allEntries 		: is a Boolean type and delete entire cache
   5 beforeInvocation	: is Boolean type and will delete the cache before the method execution


# @CachePut:

@CachePut on the method which you want to be updated with the result of the method execution.

   CachePut annotations has 3 attributes

   Value 	: is the cache name and it is mandatory ,
   Key		: based on this data will be cached and it is optional
   Condition:  based on the condition data will be cached. In example if the id < 10 then only data will be cached otherwise won’t. it is optional
   

## How to run

1. Clone the repository.

https://github.com/HarishForJava/HFJ-BookMarker-SpringBoot-msql-restApi.git

2. Create the database "test" in MySQL.

mysql -u root -p

mysql> create database test;

3. Change mysql username and password as per your installation

   open src/main/resources/application.properties.

   change spring.datasource.username and spring.datasource.password as per your MySQL installation.
   
4. start the Application.   

The app will start running at http://localhost:8080.

## Configuring Redis Cache

With Spring Boot and the required dependency already in work with Maven, we can configure local Redis instance with only three lines in our application.properties:

spring.cache.type=redis
spring.redis.host=localhost
spring.redis.port=6379

##Explore Rest APIs

The app defines following CRUD APIs.

## 1. POST http://localhost:8080/api/bookmarker
Create data
###sample Request
{
	"title":"Git-Hub",
	"content":"www.github.com/HarishForJava"
}


## 2.GET http://localhost:8080/api/bookmarkers

## 3.GET http://localhost:8080/api/bookmarker/{id}

## 4.PUT http://localhost:8080/api/bookmarkers/{id}
update data
###sample Request
{
	"title":"Git-Hub",
	"content":"www.github.com/"
}

## 5.DELETE http://localhost:8080/api/bookmarkers/{id}

You can test them using postman or any other rest client.
