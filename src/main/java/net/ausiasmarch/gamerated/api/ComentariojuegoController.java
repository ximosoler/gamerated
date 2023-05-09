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

import net.ausiasmarch.gamerated.entity.ComentariojuegoEntity;
import net.ausiasmarch.gamerated.service.ComentariojuegoService;


@RestController
@RequestMapping("/coment")
public class ComentariojuegoController {

    @Autowired
    ComentariojuegoService oComentariojuegoService;

    @GetMapping("/{id}")
    public ResponseEntity<ComentariojuegoEntity> get(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<ComentariojuegoEntity>(oComentariojuegoService.get(id), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<Long>(oComentariojuegoService.count(), HttpStatus.OK);
    }

    
    @GetMapping("")
    public ResponseEntity<Page<ComentariojuegoEntity>> getPage(
            @ParameterObject @PageableDefault(page = 0, size = 10, direction = Sort.Direction.DESC) Pageable oPageable,
            @RequestParam(name = "filter", required = false) String strFilter,
            @RequestParam(name = "id_usuario", required = false) int id_usuario,
            @RequestParam(name = "id_juego", required = false) int id_juego) {
        return new ResponseEntity<Page<ComentariojuegoEntity>>(oComentariojuegoService.getPage(oPageable, strFilter, id_usuario, id_juego), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody ComentariojuegoEntity oNewUserEntity) {
        return new ResponseEntity<Long>(oComentariojuegoService.create(oNewUserEntity), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Long> update(@RequestBody ComentariojuegoEntity oUserEntity) {
        return new ResponseEntity<Long>(oComentariojuegoService.update(oUserEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<Long>(oComentariojuegoService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/generate")
    public ResponseEntity<ComentariojuegoEntity> generate() {
        return new ResponseEntity<ComentariojuegoEntity>(oComentariojuegoService.generate(), HttpStatus.OK);
    } 


}
