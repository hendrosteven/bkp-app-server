package com.bkn.dto;

import java.io.Serializable;

public class ResponseData implements Serializable {

    private static final long serialVersionUID = 1L;

    private long totalRows;
    private Object rows;

    public ResponseData() {
    }

    public ResponseData(long total, Object rows) {
        this.totalRows = total;
        this.rows = rows;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotal(long total) {
        this.totalRows = total;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

}
