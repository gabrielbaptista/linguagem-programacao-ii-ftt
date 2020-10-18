/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcreteClasses.IoC;

import designpatterns.Interfaces.IFreightTaxCalculator;

/**
 *
 * @author gabriell
 */
public abstract class FreightTaxCalculator implements IFreightTaxCalculator {

    private int from;

    private int to;

    protected abstract double getDollarPrice();

    /**
     * @return the from
     */
    protected int getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    @Override
    public void setFrom(int from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    protected int getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    @Override
    public void setTo(int to) {
        this.to = to;
    }

    @Override
    public double calculateFreight() {
        return (this.to - this.from) * getDollarPrice();
    }
}
