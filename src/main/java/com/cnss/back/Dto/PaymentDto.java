package com.cnss.back.Dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class PaymentDto {
    private String lpaiModepai;
    private Long lpaiMontant;
    private Long employeurId;
    private Long assureId;
}
