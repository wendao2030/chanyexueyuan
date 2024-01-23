package com.mhys.cyxy.domain.dto;

import lombok.Data;

@Data
public class PageDTO {
    private int pageNum = 1;
    private int pageSize = 10;
}
