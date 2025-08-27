package com.test.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleados")
public class EmpleadosControlador {

    private List<EmpleadoDTO> empleados = new ArrayList<>(List.of(
        new EmpleadoDTO(1, "Jose"), 
        new EmpleadoDTO(2, "Maria"),
        new EmpleadoDTO(3, "David"),
        new EmpleadoDTO(4, "Fernando")
    ));

    @GetMapping
    public List<EmpleadoDTO> getEmpleado() {
        return empleados;
    }

    @GetMapping("/{idEmpleado}")
    public ResponseEntity<EmpleadoDTO> getEmpleadoById(@PathVariable("idEmpleado") Long idEmpleado) {
        for (EmpleadoDTO empleado : empleados) {
            if (empleado.id() == idEmpleado) {
                return ResponseEntity.ok(empleado);
            }
        }
         return ResponseEntity.notFound().build();
    } 

    @PostMapping
    public ResponseEntity<Void> postEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        empleados.add(empleadoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{idEmpleado}")
    public ResponseEntity<Void> putEmpleado(@PathVariable("idEmpleado") Long idEmpleado, @RequestBody EmpleadoDTO empleadoDTO) {
        for (int i=0; i < empleados.size(); i++) {
            EmpleadoDTO empleado = empleados.get(i);
            if (empleado.id() == idEmpleado) {
                empleados.set(i, empleadoDTO);
            }
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idEmpleado}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable("idEmpleado") Long idEmpleado) {
        return ResponseEntity.ok().build();
    }


}
