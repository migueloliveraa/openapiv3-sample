package com.openapi.sample.openapiv3sample.person.controller;

import com.openapi.sample.openapiv3sample.person.model.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PersonController {

    @Operation(summary = "Get a person by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the person",
                    content = { @Content(schema = @Schema(implementation = Person.class)) })
    })
    @GetMapping(value = "person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getPersonbyId(@PathVariable Long id) {
        log.info("getPersonbyId: {}", id);
        var person = Person.builder().firstName("Bob").lastName("Lassar").id(id).build();
        return new ResponseEntity<>(person, HttpStatus.OK);
    }


}
