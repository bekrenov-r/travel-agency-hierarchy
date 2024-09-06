package com.solvd.laba.travelagency.model.finance;

import java.util.Objects;

public class FinancialReport {
    private String content;
    private boolean isApproved;

    public FinancialReport(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinancialReport)) return false;
        FinancialReport other = (FinancialReport) o;

        return isApproved != other.isApproved && Objects.equals(content, other.content);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(content);
        hash = 31 * hash + (isApproved ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FinancialReport{");
        sb.append("content='").append(content).append('\'');
        sb.append(", isApproved=").append(isApproved);
        sb.append('}');
        return sb.toString();
    }
}
