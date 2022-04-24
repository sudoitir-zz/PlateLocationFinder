
# Spring Boot Clean Architecture Sample- Iran Plate Location Finder


## Features

- Use Clean architecture 
- Separation of core(Without using the spring framework) and infrastructure(Spring Boot)
- You can use the Core in other frameworks or Android
- JAVA 17
- Modular
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