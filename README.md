<h1 align="center">Spring Boot Clean Architecture Sample<br>Iran Plate Location Finder</h1>

<p align="left"> 
I used the Clean Architecture in my project. In this method we can develop our project without considering framework or database.<br>
The core module has no dependency on the spring framework so we can use it on Android or Other frameworks.<br>
Business logic implemented at the core can be tested.<br>
This method causes parallel development, which increases the speed of development.
  </p>
  
  <img src="![lbexLhWvRfpexSV0lSIWczkHd5KdszeDy9a3](https://user-images.githubusercontent.com/87154763/166200317-ad9a9298-9a17-4aa0-b2dd-356f78078b70.png)" alt="Spring Boot Clean Architecture Sample" class="center">


<h2 align="left">Features</h2>

- JAVA 17
- Modular
- Swagger 3
- PostgreSQL Database

<h2 align="left">API Reference</h2>


<h3 align="left">Swagger</h3>

```http
  http://localhost:8080/api/v1/swagger-ui.html
```

<h3 align="left">Create items</h3>

```http
  POST /api/v1/plate/create-plate
```

| Description                       |
| :-------------------------------- |
| Use Data in [IranNumberPlate.json](https://github.com/sudoitir/IranVehicleNumberPlateLocationFinder/blob/master/IranNumberPlate.json)          |




<h3 align="left">Get all items</h3>

```http
  GET /api/v1/plate/get-all-plate-list
```


<h3 align="left">Find plate from number</h3>

```http
  GET /api/v1/plate/get-state/${number}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `number`  | `Integer`| **Required And Unique**           |
