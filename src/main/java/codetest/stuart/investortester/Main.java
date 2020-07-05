package codetest.stuart.investortester;

import codetest.stuart.investortester.services.*;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        int[] stockPrices = {10, 7, 5, 8, 11, 9, 3};
        var calc = new InvestmentReturnCalculator();

        var result = calc.getMaxTradeProfit(stockPrices);

        out.println(String.format("Total is %s", result));

    }
}
