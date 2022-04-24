<h1 align="center">Spring Boot Clean Architecture Sample<br>Iran Plate Location Finder</h1>

<p align="left"> 
I used the Clean Architecture in my project. In this way we can develop our project without considering any framework or database.<br>
The core module has no dependency on the spring framework so we can use it on Android or Other frameworks.<br>
Business logic implemented at the core can be tested.<br>
This method causes parallel development, which increases the speed of development.
  </p>

## Features

- JAVA 17
- Modular
- Swagger 3
- PostgreSQL Database

## API Reference

### Swagger

```http
  http://localhost:8080/api/v1/swagger-ui.html
```

#### Create items

```http
  POST /api/v1/plate/create-plate
```

| Description                       |
| :-------------------------------- |
| Use Data in [IranNumberPlate.json](https://github.com/sudoitir/IranVehicleNumberPlateLocationFinder/blob/master/IranNumberPlate.json)          |




#### Get all items

```http
  GET /api/v1/plate/get-all-plate-list
```

#### Find plate from number

```http
  GET /api/v1/plate/get-state/${number}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `number`  | `Integer`| **Required And Unique**           |
