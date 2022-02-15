package com.example.cloud.serviceproduct.controllers;

import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public class ErrorMessage {

    private String code;
    private List<Map<String, String>> messages;
}
