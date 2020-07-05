package codetest.stuart.investortester.services;

public class InvestmentReturnCalculator {

    public int getMaxTradeProfit(int[] prices) throws IllegalArgumentException {

        if (prices == null || prices.length < 2) {
            throw new IllegalArgumentException("input must contain at least 2 prices");
        }

        int buyPriceCandidate = prices[0];
        int sellPriceCandidate = prices[1];
        int bestTradeProfit = sellPriceCandidate - buyPriceCandidate;

        for (int i = 1; i < prices.length-1; i++) {
            int nextBuyPrice = prices[i];
            sellPriceCandidate = prices[i + 1];

            if (nextBuyPrice < buyPriceCandidate)
            {
                buyPriceCandidate = nextBuyPrice;
            }
            int tradeProfit = sellPriceCandidate - buyPriceCandidate;
            if( tradeProfit > bestTradeProfit)
            {
                bestTradeProfit = tradeProfit;
            }
        }
        return bestTradeProfit;
    }
}
