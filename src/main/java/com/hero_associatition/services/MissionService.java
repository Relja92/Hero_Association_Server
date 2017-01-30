package com.hero_associatition.services;

import com.hero_associatition.dto.MissionDTO;
import com.hero_associatition.models.Mission;
import com.hero_associatition.models.User;
import com.hero_associatition.models.enumerations.Level;
import com.hero_associatition.repositories.MissionRepository;
import com.hero_associatition.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by markoreljic on 8.12.16..
 */
@Service
public class MissionService {
    @Inject
    UserRepository userRepository;
    @Inject
    MissionRepository missionRepository;

    public MissionDTO createMission( String name, String description, int experience, int gold, int minLevel, Level level ) throws  Exception{
        final Mission mission = new Mission();
        mission.setName(name);
        mission.setDescription(description);
        mission.setExperience(experience);
        mission.setGold(gold);
        mission.setMinLevel(minLevel);
        mission.setLevel(level);
        missionRepository.save(mission);

        return null;
    }

    public Mission editMission( Long id, String name, String description, int experience, int gold, int minLevel, Level level ) throws Exception {
        final Mission mission = missionRepository.findOne(id);

        if(mission == null){
            throw new Exception();
        }

        mission.setName(name);
        mission.setDescription(description);
        mission.setExperience(experience);
        mission.setGold(gold);
        mission.setMinLevel(minLevel);
        mission.setLevel(level);
        missionRepository.save(mission);
        return mission;
    }

    public int setLevel(int experience, int levelToGet){
        final int baseXp = 80;
        final double factor =Math.pow(1.025, levelToGet);
        final double neededXp =Math.pow( baseXp, factor);

        if(experience > neededXp){
            return levelToGet;
        } else {
            if(levelToGet>2){
                return levelToGet-1;
            }
            return 1;

        }


    }

    public void deleteMission(Long id) throws Exception{
        final Mission mission = missionRepository.findOne(id);

        if(mission == null){
            throw new Exception();
        }

        missionRepository.delete(id);
    }

    public User playMission( Long missionId, Long principalId ) {
        final User user = userRepository.findOne(principalId);
        final Mission mission = missionRepository.findOne(missionId);

        int currentLevel = user.getLevel();
        int currentXP = user.getExperience();
        int currentGold = user.getGold();

        int missionLevel = mission.getMinLevel();
        int missionXP = mission.getExperience();
        int missionGold = mission.getGold();

        if(missionLevel > currentLevel){
            throw new Error();
        }

        currentXP +=missionXP;
        currentGold += missionGold;

        user.setLevel(setLevel(currentXP, currentLevel+1));
        user.setExperience(currentXP);
        user.setGold(currentGold);

        userRepository.save(user);

        return user;
    }
}
