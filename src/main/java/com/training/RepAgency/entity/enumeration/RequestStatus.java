package com.training.RepAgency.entity.enumeration;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum RequestStatus {
    NEW, ACCEPTED, REJECTED, IN_PROGRESS, COMPLETED;
}