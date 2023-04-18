package net.ausiasmarch.gamerated.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ausiasmarch.gamerated.entity.ComentariojuegoEntity;
import net.ausiasmarch.gamerated.exception.ResourceNotFoundException;
import net.ausiasmarch.gamerated.helper.RandomHelper;
import net.ausiasmarch.gamerated.repository.ComentariojuegoRepository;

@Service
public class ComentariojuegoService {

    @Autowired
    ComentariojuegoRepository oComentariojuegoRepository;

    @Autowired
    UsuarioService oUsuarioService;

    @Autowired
    JuegoService oJuegoService;

    @Autowired
    ComentariojuegoService oComentariojuegoService;

    public void validate(Long id) {
        if (!oComentariojuegoRepository.existsById(id)) {
            throw new ResourceNotFoundException("id " + id + " doesn't exist");
        }
    }

    private final String[] comentario_Random = { "Me gusta", "No me gusta", "Aburrido", "Meh", "Bomba",
            "Está bueno, comprálo", "Flojea al final", "BOOFF", "Goty de una", };

    public ComentariojuegoEntity get(Long id) {
        return oComentariojuegoRepository.findById(id).get();
    }

    public Long count() {
        return oComentariojuegoRepository.count();
    }

    public Page<ComentariojuegoEntity> getPage(Pageable oPageable, String strFilter, int id_usuario, int id_juego,
            int id_comentariojuego) {
        Page<ComentariojuegoEntity> oPage = null;
        if (strFilter == null || strFilter.isEmpty() || strFilter.trim().isEmpty()) {
            oPage = oComentariojuegoRepository.findAll(oPageable);
        } else {
            oPage = oComentariojuegoRepository.findByTextoIgnoreCaseContaining(strFilter, oPageable);
        }
        return oPage;
    }

    public Long create(ComentariojuegoEntity oNewComentariojuegoEntity) {
        oNewComentariojuegoEntity.setId(0L);
        return oComentariojuegoRepository.save(oNewComentariojuegoEntity).getId();
    }

    @Transactional
    public Long update(ComentariojuegoEntity oComentariojuegoEntity) {
        validate(oComentariojuegoEntity.getId());
        return oComentariojuegoRepository.save(oComentariojuegoEntity).getId();
    }

    public Long delete(Long id) {
        oComentariojuegoRepository.existsById(id);
        oComentariojuegoRepository.deleteById(id);
        return id;
    }

    public ComentariojuegoEntity generate() {
        return oComentariojuegoRepository.save(generateRandomComentario());
    }

    private ComentariojuegoEntity generateRandomComentario() {
        ComentariojuegoEntity oNewComentariojuegoEntity = new ComentariojuegoEntity();
        oNewComentariojuegoEntity
                .setTexto(comentario_Random[RandomHelper.getRandomInt(0, comentario_Random.length - 1)]);
        oNewComentariojuegoEntity.setFechahora(RandomHelper.getRadomDateTime());
        oNewComentariojuegoEntity.setUsuario(oUsuarioService.getOneRandom());
        oNewComentariojuegoEntity.setJuego(oJuegoService.getOneRandom());
        oNewComentariojuegoEntity.setComentariojuego(oComentariojuegoService.getOneRandomFromDatabase());
        return oNewComentariojuegoEntity;
    }

    public ComentariojuegoEntity getOneRandomFromDatabase() {
        List<ComentariojuegoEntity> comentariojuegoList = oComentariojuegoRepository.findAll();
        int iPosicion = RandomHelper.getRandomInt(0, (int) oComentariojuegoRepository.count() - 1);
        return oComentariojuegoRepository.getById(comentariojuegoList.get(iPosicion).getId());
    }

}
