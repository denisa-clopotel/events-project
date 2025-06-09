package sda.serviceaggregatingevents.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.serviceaggregatingevents.DTO.RoleRequest;
import sda.serviceaggregatingevents.DTO.RoleResponse;

import sda.serviceaggregatingevents.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Void> createRole(@RequestBody RoleRequest request) {
        roleService.createRole(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<RoleResponse> getAllRoles() {
        return roleService.getAllRoles();
    }
}