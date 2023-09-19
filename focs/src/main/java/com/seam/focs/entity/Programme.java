package com.seam.focs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Programme {
    @TableId
    private Long programmeId;
    private String programmeName;
    private String overview;
    private String levelOfStudy;
    private int duration;
    private String intake;
    private String campus;
    private String progression;
    private String career;
    private double localTotalFee;
    private double overseaTotalFee;

    // Constructors, getters, and setters

    public Programme() {
    }

    public Programme(long programmeId, String programmeName, String overview, String levelOfStudy, int duration, String intake, String campus, String progression, String career, double localFee, double internationalFee) {
        this.programmeId = programmeId;
        this.programmeName = programmeName;
        this.overview = overview;
        this.levelOfStudy = levelOfStudy;
        this.duration = duration;
        this.intake = intake;
        this.campus = campus;
        this.progression = progression;
        this.career = career;
        this.localTotalFee = localFee;
        this.overseaTotalFee = internationalFee;


    }

    public void setProgrammeId(long programmeId) {
        this.programmeId = programmeId;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setLevelOfStudy(String levelOfStudy) {
        this.levelOfStudy = levelOfStudy;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setIntake(String intake) {
        this.intake = intake;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public void setProgression(String progression) {
        this.progression = progression;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public void setLocalFee(double localFee) {
        this.localTotalFee = localFee;
    }

    public void setInternationalFee(double internationalFee) {
        this.overseaTotalFee = internationalFee;
    }
}
