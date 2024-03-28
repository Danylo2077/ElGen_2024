
package com.elgen.controller;

        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.bind.annotation.RequestMapping;
        import io.swagger.annotations.Api;
        import io.swagger.annotations.ApiOperation;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
@Api(description = "APIs for working with resources")
public class MessengerApplication {
    @GetMapping("/resource")
    @ApiOperation("Get a resource")
    public ResponseEntity<String> getResource() {
        //Method implementation
        return ResponseEntity.ok("Resource data");
    }
}
