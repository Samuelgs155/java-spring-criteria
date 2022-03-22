package com.apring.jpa.criteria.dto;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;

@Builder
@Getter
public class BookDTO {

    Long id;
    String title;
    String author;
}
