package com.equal.expert.shopping.cart.modal;

public class Offer {
    final private int buyQ;
    final private int sellQ;

    public Offer(int buyQ, int sellQ) {
        this.buyQ = buyQ;
        this.sellQ = sellQ;
    }

    public int getBuyQ() {
        return buyQ;
    }

    public int getSellQ() {
        return sellQ;
    }

    public boolean isOfferAvailable() {
        return buyQ == 0 && sellQ == 0;
    }
}
