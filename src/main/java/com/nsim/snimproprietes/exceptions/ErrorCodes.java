package com.nsim.snimproprietes.exceptions;

public enum ErrorCodes {
    LOYER_NOT_FOUND(1000),
    LOYER_NOT_INVALI(1001),

    ERREUR_400(400),
    ERREUR_500(500);

    private Integer code;

    ErrorCodes(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
