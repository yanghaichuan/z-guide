package com.yhc.example.zguide.auth.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meta {

    private String title;
    private String icon;
    private String url;
    private boolean noCache = true;
    private List<String> roles;
}
