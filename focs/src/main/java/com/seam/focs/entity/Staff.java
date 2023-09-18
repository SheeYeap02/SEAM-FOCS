package com.seam.focs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long staffId;
    private String username;
    private String password;
    private String staffName;
    private String staffContact;
    private String staffEmail;
    private String staffPosition;
    private String staffRole;
    private String researchArea;
}
