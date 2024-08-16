package com.solvd.laba.rbekrenov.travelagency.model.contract;

import com.solvd.laba.rbekrenov.travelagency.model.person.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        return (signedDate == null && other.signedDate == null) || signedDate.equals(other);
    }

    @Override
    public int hashCode() {
        return signedDate != null ? signedDate.hashCode() : 0;
    }
}
