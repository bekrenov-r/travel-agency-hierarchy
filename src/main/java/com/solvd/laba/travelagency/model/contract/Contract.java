package com.solvd.laba.travelagency.model.contract;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Contract {
    private LocalDate signedDate;
    protected void sign() {
        signedDate = LocalDate.now();
    }

    public LocalDate getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(LocalDate signedDate) {
        this.signedDate = signedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contract)) return false;
        Contract other = (Contract) o;
        return Objects.equals(signedDate, other.signedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(signedDate);
    }
}
