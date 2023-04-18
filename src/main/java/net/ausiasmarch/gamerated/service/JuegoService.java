package net.ausiasmarch.gamerated.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ausiasmarch.gamerated.entity.JuegoEntity;
import net.ausiasmarch.gamerated.repository.JuegoRepository;
import net.ausiasmarch.gamerated.exception.ResourceNotFoundException;
import net.ausiasmarch.gamerated.helper.RandomHelper;

@Service
public class JuegoService {

    @Autowired
    JuegoRepository oJuegoRepository;

    public void validate(Long id) {
        if (!oJuegoRepository.existsById(id)) {
            throw new ResourceNotFoundException("id " + id + " not exist");
        }
    }

    private final String[]  desarrolladora_Random = { "ACTIVISION BLIZZARD", "SEGA", "ANNAPURNA INTERACTIVE", "CAPCOM", "SONY", "XBOX GAME STUDIOS", "NINTENDO", "DEVOLVER DIGITAL", "SQUARE ENIX",
            "UBISOFT", "505 GAMES", "BETHESDA SOFTWORKS", "HUMBLE", "VALVE", "ROCKSTAR", "BANDAI NAMCO", "KONAMI", "NAUGHTY DOG", "SANTA MONICA STUDIO", "GUERRILLA GAMES", "NINJA THEORY",
            "RIOT GAMES" };
            
    private final String[]  juego_Random = { "Bioshock", "Alien: Isolation", "The Elder Scrolls V: Skyrim", "Assassin's Creed Valhalla", "Blasphemous", "Borderlands 3", "Bully: Scholarship Edition", "Cyberpunk 2077", "Dark Souls 3",
            "Red Dead Redemption 2", "Dark Souls", "DOOM Eternal", "DayZ", "Fallout 3", "Grand Theft Auto V", "The Forest", "Hollow Knight", "Hotline Miami", "Mortal Kombat 11", "Papper, Please", "Portal 2",
            "Resident Evil: Village" };     
    private final String[]  plataforma_Random = { "Nintendo Switch", "Play Station 4", "Play Station 5", "Xbox One", "Xbox Series X y Series S", "Play Station 3", "Xbox 360", "PC/MAC" };    

    private final String[] fecha_Random = {"26 de octubre de 2018", "18 de mayo de 2015", "25 de febrero de 2022", "7 de febrero de 2023", " 9 de noviembre de 2022", "11 de noviembre de 2011","19 de octubre de 2010", "13 de mayo de 1998"};

    private final String[]  genero_Random = { "Acción", "Disparos", "Estrategia", "Simulación", "Rol", "Deporte", "Aventura", "Lucha", "Mundo Abierto" };


    public JuegoEntity get(Long id) {
        return oJuegoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id " + id + " not exist"));
    }

    public Long count() {
        return oJuegoRepository.count();
    }

    public Page<JuegoEntity> getPage(Pageable oPageable, String strFilter, int duracion) {
        Page<JuegoEntity> oPage = null;
        if (strFilter == null || strFilter.isEmpty() || strFilter.trim().isEmpty()) {
            oPage = oJuegoRepository.findAll(oPageable);
        } else {
            oPage = oJuegoRepository.findByTituloIgnoreCaseContaining(strFilter, oPageable);
        }
        return oPage;
    }

    public Long create(JuegoEntity oNewJuegoEntity) {
        oNewJuegoEntity.setId(0L);
        return oJuegoRepository.save(oNewJuegoEntity).getId();
    } 
    
    @Transactional
    public Long update(JuegoEntity oJuegoEntity) {
        validate(oJuegoEntity.getId());
        JuegoEntity oldJuegoEntity = oJuegoRepository.findById(oJuegoEntity.getId()).get();
        oJuegoEntity.setTitulo(oldJuegoEntity.getTitulo());
        oJuegoEntity.setDesarrolladora(oldJuegoEntity.getDesarrolladora());
        oJuegoEntity.setPlataforma(oldJuegoEntity.getPlataforma());
        oJuegoEntity.setFechasalida(oldJuegoEntity.getFechasalida());
        oJuegoEntity.setGenero(oldJuegoEntity.getGenero());
        oJuegoEntity.setDuracion(oldJuegoEntity.getDuracion());

        return updateJuegos(oJuegoEntity).getId();
    }

    @Transactional
    private JuegoEntity updateJuegos(JuegoEntity oUpdatedJuegoEntity) {
        JuegoEntity oJuegoEntity = oJuegoRepository.findById(oUpdatedJuegoEntity.getId()).get();
        oJuegoEntity.setTitulo(oUpdatedJuegoEntity.getTitulo());
        oJuegoEntity.setDesarrolladora(oUpdatedJuegoEntity.getDesarrolladora());
        oJuegoEntity.setPlataforma(oUpdatedJuegoEntity.getPlataforma());
        oJuegoEntity.setFechasalida(oUpdatedJuegoEntity.getFechasalida());
        oJuegoEntity.setGenero(oUpdatedJuegoEntity.getGenero());
        oJuegoEntity.setDuracion(oUpdatedJuegoEntity.getDuracion());     
        return oJuegoRepository.save(oJuegoEntity);
    }

    public Long delete(Long id) {
        oJuegoRepository.existsById(id);
        oJuegoRepository.deleteById(id);
        return id;
    }

    public JuegoEntity generate() {
        return oJuegoRepository.save(generateRandomJuego());
    }

    private JuegoEntity generateRandomJuego() {

        JuegoEntity oJuegoEntity = new JuegoEntity();
        oJuegoEntity.setTitulo(juego_Random);
        oJuegoEntity.setDesarrolladora(desarrolladora_Random);
        oJuegoEntity.setPlataforma(plataforma_Random);
        oJuegoEntity.setFechasalida(RandomHelper.getRadomDateTime());
        oJuegoEntity.setGenero(genero_Random);
        oJuegoEntity.setDuracion(RandomHelper.getRandomInt(2, 100));

        
        return oJuegoEntity;
    }

    public JuegoEntity getOneRandom() {        
       
        List<JuegoEntity> juegoList = oJuegoRepository.findAll();
        int iPosicion = RandomHelper.getRandomInt(0, (int) oJuegoRepository.count() - 1);
        return oJuegoRepository.getById(juegoList.get(iPosicion).getId());            
    
}
}
