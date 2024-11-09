package com.raxe.ems_backend.dto;

import com.raxe.ems_backend.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// DTO (Data Transfer Object) is a simple Java class used to transfer data
// between different layers of an application | Specificaly Between Client - Server | in Controller
// - Simple Structure - Immutable - Serialization
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Task> tasks = new ArrayList<>();
}

//    Benefits of Using DTOs:
//        Decoupling Layers: DTOs help decouple the presentation layer from the business logic layer, making the application more modular and maintainable.
//        Performance Improvement: By transferring only the required data, DTOs can reduce the overhead of network calls and improve performance.
//        Data Security: DTOs can be used to expose only specific fields to the client, ensuring sensitive data is not leaked.
//
//    In Spring applications, DTOs are often used in conjunction with controllers and services to handle data transfer between the client and the server. If you need more details or specific examples, feel free to ask
//

