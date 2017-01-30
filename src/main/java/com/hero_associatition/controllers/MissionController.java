package com.hero_associatition.controllers;

import com.hero_associatition.dto.MissionDTO;
import com.hero_associatition.dto.UserDTO;
import com.hero_associatition.models.Mission;
import com.hero_associatition.models.User;
import com.hero_associatition.repositories.MissionRepository;
import com.hero_associatition.services.MissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by markoreljic on 8.12.16..
 */
@RestController
@RequestMapping("/mission")
public class MissionController {

    @Inject
    private MissionService missionService;

    private final MissionRepository missionRepository;

    public MissionController(MissionRepository missionRepository ) {
        this.missionRepository = missionRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    Collection<Mission> getAll(){
        return this.missionRepository.findAll();
    }



    @RequestMapping(value = "/{missionId}", method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Mission> getSingle( @PathVariable Long missionId) throws Exception {
        try{
            return ResponseEntity.ok(this.missionRepository.findOne(missionId));
        }catch (Exception e){
            throw new Exception();
        }

    }

    @RequestMapping(value = "play/{missionId}", method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize("hasAuthority('ROLE_HERO')")
    public ResponseEntity<User> playMission( @PathVariable Long missionId, @ApiIgnore @AuthenticationPrincipal Long principalId) throws Exception {
        try{
            final User response = missionService.playMission(missionId, principalId);
            return ResponseEntity.ok().body(response);

        }catch (Exception e){
            throw new Exception();
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<MissionDTO> createMission( @Valid @RequestBody MissionDTO mission) throws Exception {
        try{
            final MissionDTO response = missionService.createMission(mission.getName(),mission.getDescription(), mission.getExperience(), mission.getGold(), mission.getMinLevel(), mission.getLevel());
            return ResponseEntity.ok().body(response);
        } catch(Exception e){
            throw new Exception(e);
        }

    }

    @RequestMapping(value = "/update/{missionId}", method = RequestMethod.PUT, consumes = "application/json")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Mission updateMission( @RequestBody @Valid Mission mission, @PathVariable Long missionId){
        mission.setId(missionId);
        try {
            missionService.editMission(missionId, mission.getName(),mission.getDescription(), mission.getExperience(), mission.getGold(), mission.getMinLevel(), mission.getLevel());
        }catch (Exception e){
            throw new Error();
        }
        return mission;
    }

    @RequestMapping(value = "/delete/{missionId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteMission( @PathVariable Long missionId) {
        try{
            missionService.deleteMission(missionId);
        }catch (Exception e){
            throw new Error();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
