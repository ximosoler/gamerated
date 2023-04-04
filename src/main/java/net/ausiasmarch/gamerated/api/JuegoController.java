package net.ausiasmarch.gamerated.api;


import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.gamerated.entity.JuegoEntity;
import net.ausiasmarch.gamerated.service.JuegoService;


@RestController
@RequestMapping("/game")
public class JuegoController {

    @Autowired
    JuegoService oJuegoService;

    @GetMapping("/{id}")
    public ResponseEntity<JuegoEntity> get(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<JuegoEntity>(oJuegoService.get(id), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<Long>(oJuegoService.count(), HttpStatus.OK);
    }

    
    @GetMapping
    public ResponseEntity<Page<JuegoEntity>> getPage(
            @ParameterObject @PageableDefault(page = 0, size = 10, direction = Sort.Direction.DESC) Pageable oPageable,
            @RequestParam(name = "filter", required = false) String strFilter) {
        return new ResponseEntity<Page<JuegoEntity>>(oJuegoService.getPage(oPageable, strFilter), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody JuegoEntity oJuegoEntity) {
        return new ResponseEntity<Long>(oJuegoService.create(oJuegoEntity), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Long> update(@RequestBody JuegoEntity oJuegoEntity) {
        return new ResponseEntity<Long>(oJuegoService.update(oJuegoEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<Long>(oJuegoService.delete(id), HttpStatus.OK);
    }

    /*@PostMapping("/generate")
    public ResponseEntity<JuegoEntity> generate() {
        return new ResponseEntity<JuegoEntity>(oJuegoService.generate(), HttpStatus.OK);
    }*/


}
