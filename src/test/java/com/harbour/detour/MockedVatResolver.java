package com.harbour.detour;

public class MockedVatResolver extends VatResolver {
    private final double v;

    public MockedVatResolver(double v) {
        this.v = v;
    }

    @Override
    public double getVat() {
        return v;
    }
}
