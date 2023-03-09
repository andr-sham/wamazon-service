package com.wamazon.wamazonservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ErrorNotification {

    private List<String> errorMessages;

}
